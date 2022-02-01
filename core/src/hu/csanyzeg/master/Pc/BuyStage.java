package hu.csanyzeg.master.Pc;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

import hu.csanyzeg.master.Game.ShoeActor;
import hu.csanyzeg.master.Game.ShoeInstance;
import hu.csanyzeg.master.Game.ShoesSelector;
import hu.csanyzeg.master.Game.Time;
import java.util.Random;

import hu.csanyzeg.master.Game.InGameStage;
import hu.csanyzeg.master.Game.Variables;
import hu.csanyzeg.master.Game.WardrobeScreen;
import hu.csanyzeg.master.LoadingStage;
import hu.csanyzeg.master.MainGame;
import hu.csanyzeg.master.Menu.LabelStyle;
import hu.csanyzeg.master.MyBaseClasses.Assets.AssetList;
import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.MyStage;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.ResponseViewport;
import hu.csanyzeg.master.MyBaseClasses.Timers.IntervalTimer;
import hu.csanyzeg.master.MyBaseClasses.Timers.IntervalTimerListener;
import hu.csanyzeg.master.MyBaseClasses.UI.MyLabel;
import hu.csanyzeg.master.Sneakers.AdidasNMDActor;
import hu.csanyzeg.master.Sneakers.AdidasYeezy350Actor;
import hu.csanyzeg.master.Sneakers.AirForce1Actor;
import hu.csanyzeg.master.Sneakers.AirMax270Actor;
import hu.csanyzeg.master.Sneakers.AirMax720Actor;
import hu.csanyzeg.master.Sneakers.AirMax97Actor;
import hu.csanyzeg.master.Sneakers.NikeAirJordan1Actor;

public class BuyStage extends MyStage {

    BrowserviewActor browserviewActor;
    LabelStyle labelStyle;
    MyLabel BackLabel;
    MyLabel moneyLabel;
    InGameStage inGameStage;
    xActor xActor;
    BrowserviewActor browser2;
    ShoesSelector shoesSelector;
    MyLabel priceLabel;
    MyLabel nameLabel;
    BackButton backButton;
    BuyButton buyButton;
    Variables variables;
    MyLabel nomoneyLabel;
    MyLabel baseprice;
    static AssetList assetList = new AssetList();
    static{
        assetList.add(BuyActor.assetList);
        assetList.addFont("alegreyaregular.otf");
        assetList.add(BackButton.assetList);
        assetList.add(ShoeActor.assetList);
    }
    public BuyStage(MyGame game) {
        super(new ResponseViewport(500), game);
        addBackButtonScreenBackByStackPopListenerWithPreloadedAssets(new LoadingStage(game));

        //timeC = new Time(this);

        variables = new Variables();
        browserviewActor = new BrowserviewActor(game);
        browserviewActor.setSize(900, 500);
        addActor(browserviewActor);
        browser2 = new BrowserviewActor(game);
        browserviewActor.setSize(900,500);
        addActor(browserviewActor);
        labelStyle = new LabelStyle(game.getMyAssetManager().getFont("alegreyaregular.otf"), Color.BLACK);
        priceLabel = new MyLabel(game,"",labelStyle);
        nameLabel = new MyLabel(game,"",labelStyle);
        nomoneyLabel = new MyLabel(game,"Nincs elég pénzed!",labelStyle);
        baseprice = new MyLabel(game,"",labelStyle);
        xActor = new xActor(game);
        xActor.setPosition(getCamera().viewportWidth - 15, getCamera().viewportHeight - 15);
        xActor.setSize(15,15);
        addActor(xActor);
        xActor.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                game.setScreenBackByStackPopWithPreloadAssets(new LoadingStage(game));
            }
        });
        backButton = new BackButton(game);
        buyButton = new BuyButton(game);
        int counter = -1;
        int y = 0;
        for (ShoeInstance i: ((MainGame) game).aVilagOsszesCipoje){
            if (i.cipohelye == ShoeInstance.Cipohelye.JofogasonMegveheto){
                counter+=1;
                if (counter%5 == 0){
                    y += 1;
                    counter = 0;
                }
                addActor(new ShoeActor(game, i,counter*100, getCamera().viewportHeight - y*100));
            }

        }

        for (Actor a : this.getActors()){
            if (a instanceof ShoeActor){
                a.addListener(new ClickListener(){
                    @Override
                    public void clicked(InputEvent event, float x, float y) {
                        super.clicked(event, x, y);
                        showBuy((ShoeActor)a);
                    }
                });
            }
        }
    }

    @Override
    public void act(float delta) {
        super.act(delta);

    }

    public void showBuy(ShoeActor cipo){
        for (Actor a : getActors()){
            if (a instanceof ShoeActor){
                if (a.getWidth() == getCamera().viewportWidth / 2){
                    a.remove();
                    browser2.remove();
                }
            }
        }
        addActor(browser2);
        ShoeActor cipello = new ShoeActor(game, cipo.shoeInstance, 0,0);
        cipello.setSize(getCamera().viewportWidth / 2,getCamera().viewportWidth / 2);
        cipello.setPosition(getCamera().viewportWidth/2 - cipello.getWidth()/2, getCamera().viewportHeight/2 - cipello.getHeight()/2 );
        addActor(cipello);

        //Labelek
        priceLabel.setPosition(cipello.getX() + cipello.getWidth()/2 - 20,cipello.getY() + 65);
        addActor(priceLabel);
        priceLabel.setText(String.format("%s USD",cipello.shoeInstance.base.price));
        nameLabel.setPosition(cipello.getX() + cipello.getWidth()/2 - 110,cipello.getY() + 95);
        addActor(nameLabel);
        nameLabel.setText(cipello.shoeInstance.base.name);
        baseprice.setPosition(cipello.getX() + cipello.getWidth()/2 - 20,cipello.getY() + 45);
        addActor(baseprice);
        float pricediff = cipello.shoeInstance.base.price - cipello.shoeInstance.price;
        String pricediffStr;
        if (pricediff > 0){
            pricediffStr = "+" + (cipello.shoeInstance.base.price - cipello.shoeInstance.price);
        }else
            pricediffStr = Float.toString(cipello.shoeInstance.base.price - cipello.shoeInstance.price);
        baseprice.setText("Eredeti ár:" + cipello.shoeInstance.price + "(" + pricediffStr + ")");
        //Gombok
        backButton.setSize(cipello.getWidth(),20);
        backButton.setPosition(getCamera().viewportWidth / 2 - backButton.getWidth()/2,0 );
        addActor(backButton);
        buyButton.setSize(cipello.getWidth(),20);
        buyButton.setPosition(getCamera().viewportWidth / 2 - buyButton.getWidth()/2,backButton.getY() + backButton.getHeight());
        addActor(buyButton);


        //listenerek
        backButton.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                game.setScreenWithPreloadAssets(BuyScreen.class,new LoadingStage(game));
            }
        });

        buyButton.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                if (variables.getMoney() >= cipello.shoeInstance.base.price){
                    variables.setMoney((int) (variables.getMoney() - cipello.shoeInstance.base.price));
                    System.out.println(variables.getMoney());
                    cipello.shoeInstance.cipohelye = ShoeInstance.Cipohelye.SzekrenybenNemMeghirdetett;
                    game.setScreenWithPreloadAssets(WardrobeScreen.class,new LoadingStage(game));
                }else{
                    nomoneyLabel.setSize(100,100);
                    nomoneyLabel.setPositionCenterOfActorToCenterOfViewport();
                    addActor(nomoneyLabel);
                    addTimer(new IntervalTimer(1,3,new IntervalTimerListener(){
                        @Override
                        public void onStop(IntervalTimer sender) {
                            super.onStop(sender);
                            nomoneyLabel.remove();
                        }
                    }));
                }
            }
        });

    }
}
