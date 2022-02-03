package hu.csanyzeg.master.Pc;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.ScrollPane;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
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
        final Table scrollTable = new Table();
        scrollTable.defaults().space(4f);
        for (ShoeInstance i: ((MainGame) game).aVilagOsszesCipoje){
            if (i.cipohelye == ShoeInstance.Cipohelye.JofogasonMeghirdetettSzekrenybenlevo){
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
                        showSell(cipo);
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
    }
}
