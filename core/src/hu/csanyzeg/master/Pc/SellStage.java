package hu.csanyzeg.master.Pc;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

import hu.csanyzeg.master.Game.ShoeActor;
import hu.csanyzeg.master.Game.ShoeInstance;
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

public class SellStage extends MyStage {
    xActor xActor;
    BrowserviewActor browserviewActor;
    BrowserviewActor browser2;
    LabelStyle labelStyle;
    MyLabel sellLabel;
    BuyActor buyActor;
    MyLabel priceLabel;
    MyLabel nameLabel;
    BackButton backButton;
    ShoeActor[] shoeActorok;
    boolean onShop;
    static AssetList assetList = new AssetList();
    static{
        assetList.add(BuyActor.assetList);
        assetList.addFont("alegreyaregular.otf");
        assetList.addTexture("Browser.png");
        assetList.addTexture("x.png");
        assetList.addTexture("BackButton.png");
    }
    public SellStage(MyGame game) {
        super(new ResponseViewport(500), game);
        labelStyle = new LabelStyle(game.getMyAssetManager().getFont("alegreyaregular.otf"), Color.BLACK);
        priceLabel = new MyLabel(game,"",labelStyle);
        nameLabel = new MyLabel(game,"",labelStyle);
        backButton = new BackButton(game);
        browserviewActor = new BrowserviewActor(game);
        browserviewActor.setSize(getCamera().viewportWidth, getCamera().viewportHeight);
        browserviewActor.setPosition(0,0);
        addActor(browserviewActor);
        browser2 = new BrowserviewActor(game);
        browser2.setSize(getCamera().viewportWidth,getCamera().viewportHeight);
        browser2.setPosition(0,0);
        addActor(browser2);
        xActor = new xActor(game);
        xActor.setPosition(getCamera().viewportWidth - 15, getCamera().viewportHeight - 15);
        xActor.setSize(15,15);
        addActor(xActor);
        xActor.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                game.setScreenWithPreloadAssets(PCScreen.class, new LoadingStage(game));
            }
        });
        int counter = -1;
        int y = 0;
        int cCounter = 0;
        for (ShoeInstance i: ((MainGame) game).aVilagOsszesCipoje){
            if (i.cipohelye == ShoeInstance.Cipohelye.JofogasonMeghirdetettSzekrenybenlevo){
                counter+=1;
                cCounter+=1;
                if (counter%8 == 0){
                    y += 1;
                    counter = 0;
                }
                addActor(new ShoeActor(game, i,50 + counter*100,getCamera().viewportHeight - 50 - y*100));
            }

        }
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
                        showSell((ShoeActor)a);
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
    }

    public void showSell(ShoeActor a){
        addActor(browser2);
        ShoeActor cipello = new ShoeActor(game, a.shoeInstance, 0,0);
        cipello.setSize(getCamera().viewportWidth / 2,getCamera().viewportWidth / 2);
        cipello.setPosition(getCamera().viewportWidth/2 - cipello.getWidth()/2, getCamera().viewportHeight/2 - cipello.getHeight()/2 );
        addActor(cipello);

        //Labelek
        priceLabel.setPosition(cipello.getX() + cipello.getWidth()/2 - 20,cipello.getY() + 65);
        addActor(priceLabel);
        priceLabel.setText(String.format("%s USD",cipello.shoeInstance.sellprice));
        nameLabel.setPosition(cipello.getX() + cipello.getWidth()/2 - 110,cipello.getY() + 95);
        addActor(nameLabel);
        nameLabel.setText(cipello.shoeInstance.base.name);
        //Gombok
        backButton.setSize(cipello.getWidth(),20);
        backButton.setPosition(getCamera().viewportWidth / 2 - backButton.getWidth()/2,0 );
        addActor(backButton);

        //listenerek
        backButton.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                game.setScreenBackByStackPopWithPreloadAssets(new LoadingStage(game));
                onShop = false;
            }
        });
    }

    @Override
    public void act(float delta) {
        super.act(delta);
        for (Actor a : getActors()){
            if (a instanceof ShoeActor) {
                if (!onShop) {
                    if (a.getY() > getCamera().viewportHeight - a.getHeight() - 50) {
                        a.setVisible(false);
                    } else {
                        a.setVisible(true);
                    }
                }
            }
        }
    }
}
