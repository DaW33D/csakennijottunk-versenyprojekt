package hu.csanyzeg.master.Game;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.Viewport;

import hu.csanyzeg.master.Credit.CreditScreen;
import hu.csanyzeg.master.LoadingStage;
import hu.csanyzeg.master.MainGame;
import hu.csanyzeg.master.Menu.LabelStyle;
import hu.csanyzeg.master.MyBaseClasses.Assets.AssetList;
import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.MyStage;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.OneSpriteStaticActor;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.ResponseViewport;
import hu.csanyzeg.master.MyBaseClasses.UI.MyLabel;
import hu.csanyzeg.master.Pc.BackButton;
import hu.csanyzeg.master.Pc.BrowserviewActor;
import hu.csanyzeg.master.Pc.SellActor;
import hu.csanyzeg.master.Pc.SellButton;
import hu.csanyzeg.master.Pc.SellScreen;

public class WardrobeStage extends MyStage {
    LabelStyle labelStyle;
    MyLabel BackLabel;
    ShoeActor shoeActor;
    Variables variables;
    EmptyWardrobeActor emptywardrobeActor;
    OneSpriteStaticActor actor;
    MyLabel priceLabel;
    MyLabel nameLabel;
    BackButton backButton;
    boolean onShop;
    BrowserviewActor browser2;
    SellButton sellButton;
    static AssetList assetList = new AssetList();
    static{
        assetList.add(WardrobeActor.assetList);
        assetList.addTexture("emptywardrobe.png");
        assetList.addFont("alegreyaregular.otf",30);
    }
    public WardrobeStage(MyGame game) {
        super(new ResponseViewport(500), game);
        labelStyle = new LabelStyle(game.getMyAssetManager().getFont("alegreyaregular.otf"), Color.BLACK);
        actor = new OneSpriteStaticActor(game,"badlogic.jpg");
        priceLabel = new MyLabel(game,"",labelStyle);
        nameLabel = new MyLabel(game,"",labelStyle);
        backButton = new BackButton(game);
        sellButton = new SellButton(game);
        //time = new Time(this);
        browser2 = new BrowserviewActor(game);
        browser2.setSize(900,500);
        emptywardrobeActor = new EmptyWardrobeActor(game);
        variables = new Variables();
        addActor(emptywardrobeActor);
        int counter = -1;
        int y = 0;
        for (ShoeInstance i: ((MainGame) game).aVilagOsszesCipoje){
            if (i.cipohelye == ShoeInstance.Cipohelye.SzekrenybenNemMeghirdetett || i.cipohelye == ShoeInstance.Cipohelye.JofogasonMeghirdetettSzekrenybenlevo){
                counter+=1;
                if (counter%6 == 0){
                    y += 1;
                    counter = 0;
                }
                addActor(new ShoeActor(game, i,100 + counter*100, getCamera().viewportHeight - 15 - y*100));
            }

        }
        int cipocounter = -1;
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
        BackLabel = new MyLabel(game, "Back", labelStyle);
        BackLabel.setSize(100, 50);
        BackLabel.setPosition(0, getCamera().viewportHeight-BackLabel.getHeight());
        addActor(BackLabel);
        BackLabel.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                game.setScreenBackByStackPopWithPreloadAssets(new LoadingStage(game));
            }
        });
        if (!variables.getIsFirstTime() && variables.getLang().equals("en")){
            BackLabel.setText("Back");
        }
        if (!variables.getIsFirstTime() && variables.getLang().equals("hu")){
            BackLabel.setText("Vissza");
        }
    }

    @Override
    public void act(float delta) {
        super.act(delta);
    }

    public void showSell(ShoeActor cipo){
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
        //Gombok
        backButton.setSize(cipello.getWidth(),20);
        backButton.setPosition(getCamera().viewportWidth / 2 - backButton.getWidth()/2,0 );
        addActor(backButton);
        if (cipello.shoeInstance.cipohelye != ShoeInstance.Cipohelye.JofogasonMeghirdetettSzekrenybenlevo) {
            sellButton.setSize(cipello.getWidth(), 20);
            sellButton.setPosition(getCamera().viewportWidth / 2 - sellButton.getWidth() / 2, backButton.getHeight());
            addActor(sellButton);
        }

        //listenerek
        backButton.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                game.setScreenWithPreloadAssets(WardrobeScreen.class,new LoadingStage(game));
                onShop = false;
            }
        });

        sellButton.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                cipello.shoeInstance.cipohelye = ShoeInstance.Cipohelye.JofogasonMeghirdetettSzekrenybenlevo;
                cipello.shoeInstance.sellprice = cipello.shoeInstance.price;
                game.setScreenWithPreloadAssets(SellScreen.class,new LoadingStage(game));
            }
        });

    }
}
