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

public class WardrobeStage extends MyStage {
    LabelStyle labelStyle;
    MyLabel BackLabel;
    ShoeActor shoeActor;
    Variables variables;
    EmptyWardrobeActor emptywardrobeActor;
    OneSpriteStaticActor actor;
    static AssetList assetList = new AssetList();
    static{
        assetList.add(WardrobeActor.assetList);
        assetList.addFont("alegreyaregular.otf",30);
    }
    public WardrobeStage(MyGame game) {
        super(new ResponseViewport(500), game);
        addBackButtonScreenBackByStackPopListenerWithPreloadedAssets(new LoadingStage(game));
        actor = new OneSpriteStaticActor(game,"badlogic.jpg");

        //time = new Time(this);

        emptywardrobeActor = new EmptyWardrobeActor(game);
        variables = new Variables();
        addActor(emptywardrobeActor);
        labelStyle = new LabelStyle(game.getMyAssetManager().getFont("alegreyaregular.otf"), Color.BLACK);
        int counter = -1;
        int y = 0;
        for (ShoeInstance i: ((MainGame) game).aVilagOsszesCipoje){
            if (i.cipohelye == ShoeInstance.Cipohelye.SzekrenybenNemMeghirdetett || i.cipohelye == ShoeInstance.Cipohelye.JofogasonMeghirdetettSzekrenybenlevo){
                counter+=1;
                if (counter%5 == 0){
                    y += 1;
                    counter = 0;
                }
                addActor(new ShoeActor(game, i,counter*100,y*100));
            }

        }
        int cipocounter = -1;
        for (Actor a : this.getActors()){
            if (a instanceof ShoeActor){
                a.addListener(new ClickListener(){
                    @Override
                    public void clicked(InputEvent event, float x, float y) {
                        super.clicked(event, x, y);
                        showSell(a);
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

    public void showSell(Actor cipo){
        if (actor.getX() == cipo.getX() && actor.getY() == cipo.getY() - actor.getHeight()){
            actor.setPosition(0,0);
            actor.remove();
        }else if (((ShoeActor)cipo).shoeInstance.sellprice == 0){
            addActor(actor);
            actor.setSize(50,10);
            actor.setPosition(cipo.getX(),cipo.getY() - actor.getHeight());
            actor.addListener(new ClickListener(){
                @Override
                public void clicked(InputEvent event, float x, float y) {
                    super.clicked(event, x, y);
                    ((ShoeActor)cipo).shoeInstance.cipohelye = ShoeInstance.Cipohelye.JofogasonMeghirdetettSzekrenybenlevo;
                    ((ShoeActor)cipo).shoeInstance.sellprice = ((ShoeActor)cipo).shoeInstance.base.price;
                    actor.remove();
                }
            });
        }


    }
}
