package hu.csanyzeg.master.Pc;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.Viewport;

import hu.csanyzeg.master.Game.ShoeActor;
import hu.csanyzeg.master.Game.ShoeInstance;
import hu.csanyzeg.master.Game.StatActor;
import hu.csanyzeg.master.LoadingStage;
import hu.csanyzeg.master.MainGame;
import hu.csanyzeg.master.Menu.LabelStyle;
import hu.csanyzeg.master.MyBaseClasses.Assets.AssetList;
import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.MyStage;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.ResponseViewport;
import hu.csanyzeg.master.MyBaseClasses.UI.MyLabel;

public class PricerateStage extends MyStage {
    LabelStyle labelStyle;
    MyLabel priceLabel;
    BrowserviewActor browserviewActor;
    BrowserviewActor browserviewActor2;
    xActor xActor;
    RandomsquareActor randomsquareActor;
    StatActor statActor;
    ShoeActor[] shoeActorok;
    boolean onShop = false;
    static AssetList assetList = new AssetList();
    static{
        assetList.add(PricerateActor.assetList);
        assetList.addFont("alegreyaregular.otf", 10);
        assetList.addTexture("Browser.png");
        assetList.addTexture("x.png");
    }
    public PricerateStage(MyGame game) {
        super(new ResponseViewport(500), game);
        browserviewActor = new BrowserviewActor(game);
        browserviewActor.setPosition(0,0);
        browserviewActor.setSize(getCamera().viewportWidth, getCamera().viewportHeight);
        addActor(browserviewActor);

        labelStyle = new LabelStyle(game.getMyAssetManager().getFont("alegreyaregular.otf"), Color.BLACK);
//        priceLabel = new MyLabel(game, "Price: ", labelStyle);
//        priceLabel.setPosition(randomsquareActor.getX() + 5, randomsquareActor.getY() + randomsquareActor.getHeight() - priceLabel.getHeight());
//        addActor(priceLabel);
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
            if (i.cipohelye == ShoeInstance.Cipohelye.SzekrenybenNemMeghirdetett || i.cipohelye == ShoeInstance.Cipohelye.JofogasonMeghirdetettSzekrenybenlevo){
                counter+=1;
                cCounter+=1;
                if (counter%8 == 0){
                    y += 1;
                    counter = 0;
                }
                addActor(new ShoeActor(game, i,50 + counter*100, getCamera().viewportHeight - 50 - y*100));
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
                        showStat(((ShoeActor) a).shoeInstance);
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

    public void showStat(ShoeInstance c){
        onShop = true;
        browserviewActor2 = new BrowserviewActor(game);
        browserviewActor2.setPosition(0,0);
        browserviewActor2.setSize(getCamera().viewportWidth, getCamera().viewportHeight);
        addActor(browserviewActor2);
        randomsquareActor = new RandomsquareActor(game);
        randomsquareActor.setPosition(getCamera().viewportWidth / 2 - randomsquareActor.getWidth() / 2, getCamera().viewportHeight / 2 -randomsquareActor.getHeight() / 2);
        addActor(randomsquareActor);
        statActor = new StatActor(game,c,10);
        addActor(statActor);
        statActor.setPosition(randomsquareActor.getX(),randomsquareActor.getY() + 5);
        statActor.setSize(randomsquareActor.getWidth(),randomsquareActor.getHeight() - 10);
        statActor.buy.setWidth(randomsquareActor.getWidth());
        statActor.nowgreen.setWidth(randomsquareActor.getWidth());
        statActor.nowred.setWidth(randomsquareActor.getWidth());
    }

    @Override
    public void act(float delta) {
        super.act(delta);
        for (Actor a : getActors()){
            if (a instanceof ShoeActor) {
                    if (a.getY() > getCamera().viewportHeight - a.getHeight() - 50) {
                        a.setVisible(false);
                    } else {
                        a.setVisible(true);
                    }
            }
        }
    }
}
