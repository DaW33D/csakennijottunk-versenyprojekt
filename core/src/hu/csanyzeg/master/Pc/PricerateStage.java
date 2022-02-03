package hu.csanyzeg.master.Pc;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.ScrollPane;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
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
        browserviewActor.setPosition(0, 0);
        browserviewActor.setSize(getCamera().viewportWidth, getCamera().viewportHeight);
        addActor(browserviewActor);

        labelStyle = new LabelStyle(game.getMyAssetManager().getFont("alegreyaregular.otf"), Color.BLACK);
//        priceLabel = new MyLabel(game, "Price: ", labelStyle);
//        priceLabel.setPosition(randomsquareActor.getX() + 5, randomsquareActor.getY() + randomsquareActor.getHeight() - priceLabel.getHeight());
//        addActor(priceLabel);
        xActor = new xActor(game);
        xActor.setPosition(getCamera().viewportWidth - 70, getCamera().viewportHeight - 70);
        xActor.setSize(50,50);
        addActor(xActor);
        xActor.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                game.setScreenWithPreloadAssets(PCScreen.class, new LoadingStage(game));
            }
        });
        final Table scrollTable = new Table();
        scrollTable.defaults().space(4f);
        for (ShoeInstance i : ((MainGame) game).aVilagOsszesCipoje) {
            if (i.cipohelye == ShoeInstance.Cipohelye.JofogasonMeghirdetettSzekrenybenlevo) {
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
                scrollTable.add(cipo = new ShoeActor(game, i, 0, 0));
                scrollTable.add(new MyLabel(game, i.base.name, labelStyle));
                MyLabel la;
                scrollTable.add(la = new MyLabel(game, "$ " + i.price, labelStyle));
                la.setWrap(false);

                cipo.addListener(new ClickListener() {
                    @Override
                    public void clicked(InputEvent event, float x, float y) {
                        super.clicked(event, x, y);
                        showStat(cipo.shoeInstance);
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
        table.setSize(600, 450);
        table.setPosition(150, 0);
        addActor(table);
    }

    public void showStat(ShoeInstance c){
        onShop = true;
        xActor.setZIndex(99999999);
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
    }
}
