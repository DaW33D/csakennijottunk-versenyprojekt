package hu.csanyzeg.master.Pc;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.ScrollPane;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
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
    BackButtonHun backButtonHun;
    BuyButton buyButton;
    BuyButtonHun buyButtonHun;
    Variables variables;
    MyLabel nomoneyLabel;
    MyLabel baseprice;
    boolean onShop;
    static AssetList assetList = new AssetList();
    static{
        assetList.add(BuyActor.assetList);
        assetList.addFont("alegreyaregular.otf");
        assetList.add(BackButton.assetList);
        assetList.add(ShoeActor.assetList);
    }
    public BuyStage(MyGame game) {
        super(new ResponseViewport(500), game);
        //timeC = new Time(this);
        variables = new Variables();
        browserviewActor = new BrowserviewActor(game);
        browserviewActor.setSize(900, 500);
        //scrollPane = new ScrollPane(browserviewActor);
        browserviewActor.setSize(getCamera().viewportWidth, getCamera().viewportHeight * 2);
        browserviewActor.setPosition(0, 0 - browserviewActor.getHeight() + getCamera().viewportHeight);
        onShop = false;
        //addActor(scrollPane);
        browser2 = new BrowserviewActor(game);
        addActor(browserviewActor);
        labelStyle = new LabelStyle(game.getMyAssetManager().getFont("alegreyaregular.otf"), Color.BLACK);
        priceLabel = new MyLabel(game,"",labelStyle);
        nameLabel = new MyLabel(game,"",labelStyle);
        nomoneyLabel = new MyLabel(game,"Nincs elég pénzed!",labelStyle);
        baseprice = new MyLabel(game,"",labelStyle);
        xActor = new xActor(game);
        xActor.setPosition(getCamera().viewportWidth - 70, getCamera().viewportHeight - 70);
        xActor.setSize(50,50);
        addActor(xActor);
        xActor.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                game.setScreenWithPreloadAssets(PCScreen.class, new LoadingStage(game));
            }
        });
        backButton = new BackButton(game);
        buyButton = new BuyButton(game);
        buyButtonHun = new BuyButtonHun(game);
        int counter = -1;
        int y = 0;
        int cCounter = 0;


        final Table scrollTable = new Table();
        scrollTable.defaults().space(4f);

        for (ShoeInstance i: ((MainGame) game).aVilagOsszesCipoje){
            if (i.cipohelye == ShoeInstance.Cipohelye.JofogasonMegveheto){
                /*
                cCounter+=1;
                counter+=1;
                if (counter%8 == 0){
                    y += 1;
                    counter = 0;
                }

                 */
                //scrollTable.add(cipo = new ShoeActor(game, i,50 + counter*100, getCamera().viewportHeight - 50 - y*100));
                ShoeActor cipo;
                scrollTable.add(cipo = new ShoeActor(game, i,0,0));
                scrollTable.add(new MyLabel(game,i.base.name,labelStyle));
                MyLabel la;
                scrollTable.add(la = new MyLabel(game,"$ " + i.price,labelStyle));
                la.setWrap(false);

                cipo.addListener(new ClickListener(){
                    @Override
                    public void clicked(InputEvent event, float x, float y) {
                        super.clicked(event, x, y);
                        showBuy(cipo);
                        onShop = true;
                    }
                });

                //scrollTable.add(new xActor(game));
                scrollTable.row();
            }
        }
        scrollTable.pack();

        final ScrollPane scroller = new ScrollPane(scrollTable);

        final Table table = new Table();
        //table.setFillParent(true);
        table.add(scroller).fill().expand();
        table.setSize(600,450);
        table.setPosition(150,0);
        addActor(table);
        //table.setZIndex(100);
        //addActor(scrollPane);

        /*
        shoeActorok = new ShoeActor[cCounter];
        int szamold = 0;
        for (Actor i: getActors()){
            if  (i instanceof ShoeActor) {
                shoeActorok[szamold] = (ShoeActor) i;
                szamold+=1;
            }

        }

        for (Actor a : this.getActors()){
            if (a instanceof ShoeActor){
                a.addListener(new ClickListener(){
                    @Override
                    public void clicked(InputEvent event, float x, float y) {
                        super.clicked(event, x, y);
                        showBuy((ShoeActor)a);
                        onShop = true;
                    }
                });
            }
        }

        if (onShop == false) {
            addListener(new ClickListener() {
                @Override
                public void touchDragged(InputEvent event, float x, float y, int pointer) {
                    super.touchDragged(event, x, y, pointer);
                    if (y <= browserviewActor.getHeight() / 2 && shoeActorok[shoeActorok.length - 1].getY() <= getCamera().viewportHeight - shoeActorok[shoeActorok.length - 1].getHeight() - 50 && shoeActorok.length > 32 && shoeActorok[shoeActorok.length - 1].getY() <= 0) {
                        for (Actor a : getActors()) {
                            if (a instanceof ShoeActor) {
                                a.setPosition(a.getX(), a.getY() + 10);
                            }
                        }
                    } else if (y > browserviewActor.getHeight() / 2 && shoeActorok[0].getY() >= getCamera().viewportHeight - shoeActorok[0].getHeight() - 50 && shoeActorok.length > 32) {
                        for (Actor a : getActors()) {
                            if (a instanceof ShoeActor) {
                                a.setPosition(a.getX(), a.getY() - 10);
                            }
                        }
                    }
                    System.out.println(pointer);
                }
            });
        }

         */
    }

    @Override
    public void act(float delta) {
        super.act(delta);
        /*
        for (Actor a : getActors()){
            if (a instanceof ShoeActor) {
                if (onShop == false) {
                    if (a.getY() > getCamera().viewportHeight - a.getHeight() - 50) {
                        a.setVisible(false);
                    } else {
                        a.setVisible(true);
                    }
                }
            }
        }

         */
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
        priceLabel.setText(String.format("%s USD",cipello.shoeInstance.price));
        nameLabel.setPosition(cipello.getX() + cipello.getWidth()/2 - 110,cipello.getY() + 95);
        addActor(nameLabel);
        nameLabel.setText(cipello.shoeInstance.base.name);
        baseprice.setPosition(cipello.getX() + cipello.getWidth()/2 - 20,cipello.getY() + 45);
        addActor(baseprice);
        Float pricediff;
        String pricediffStr;
        if (cipello.shoeInstance.base.price > cipello.shoeInstance.price){
            pricediff = cipello.shoeInstance.base.price - cipello.shoeInstance.price;
            pricediffStr = "-" + pricediff;
        }else{
            pricediff = cipello.shoeInstance.price - cipello.shoeInstance.base.price;
            pricediffStr = "+" + pricediff;
        }
        baseprice.setText("Eredeti ár:" + cipello.shoeInstance.base.price + "(" + pricediffStr + ")");
        //Gombok
        backButton.setSize(cipello.getWidth(),20);
        backButton.setPosition(getCamera().viewportWidth / 2 - backButton.getWidth()/2,0 );
        backButtonHun = new BackButtonHun(game);
        backButtonHun.setSize(cipello.getWidth(),20);
        backButtonHun.setPosition(getCamera().viewportWidth / 2 - backButtonHun.getWidth()/2,0 );
        buyButton.setSize(cipello.getWidth(),20);
        buyButton.setPosition(getCamera().viewportWidth / 2 - buyButton.getWidth()/2,backButton.getY() + backButton.getHeight());
        buyButtonHun.setSize(cipello.getWidth(), 20);
        buyButtonHun.setPosition(getCamera().viewportWidth / 2 - buyButtonHun.getWidth()/2, backButton.getY() + backButton.getHeight());

        if (!variables.getIsFirstTime() && variables.getLang().equals("en")){
            addActor(buyButton);
        }
        if (!variables.getIsFirstTime() && variables.getLang().equals("hu")){
            addActor(buyButtonHun);
        }
        if (!variables.getIsFirstTime() && variables.getLang().equals("en")){
            addActor(backButton);
        }
        if (!variables.getIsFirstTime() && variables.getLang().equals("hu")){
            addActor(backButtonHun);
        }

        backButtonHun.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                game.setScreenWithPreloadAssets(BuyScreen.class, new LoadingStage(game));
                onShop = false;
            }
        });

        //listenerek
        backButton.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                game.setScreenWithPreloadAssets(BuyScreen.class,new LoadingStage(game));
                onShop = false;
            }
        });
        buyButtonHun.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                if (variables.getMoney() >= cipello.shoeInstance.price){
                    variables.setMoney((int) (variables.getMoney() - cipello.shoeInstance.base.price));
                    System.out.println(variables.getMoney());
                    cipello.shoeInstance.cipohelye = ShoeInstance.Cipohelye.SzekrenybenNemMeghirdetett;
                    game.setScreenWithPreloadAssets(WardrobeScreen.class,new LoadingStage(game));
                    onShop = false;
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


        buyButton.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                if (variables.getMoney() >= cipello.shoeInstance.base.price){
                    variables.setMoney((int) (variables.getMoney() - cipello.shoeInstance.base.price));
                    System.out.println(variables.getMoney());
                    cipello.shoeInstance.cipohelye = ShoeInstance.Cipohelye.SzekrenybenNemMeghirdetett;
                    game.setScreenWithPreloadAssets(WardrobeScreen.class,new LoadingStage(game));
                    onShop = false;
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
