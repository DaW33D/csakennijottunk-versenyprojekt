package hu.csanyzeg.master.Pc;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

import hu.csanyzeg.master.Game.ShoesSelector;
import hu.csanyzeg.master.Game.Time;
import java.util.Random;

import hu.csanyzeg.master.Game.InGameStage;
import hu.csanyzeg.master.LoadingStage;
import hu.csanyzeg.master.Menu.LabelStyle;
import hu.csanyzeg.master.MyBaseClasses.Assets.AssetList;
import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.MyStage;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.ResponseViewport;
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
    ShoesSelector shoesSelector;
    Time timeC;
    static AssetList assetList = new AssetList();
    static{
        assetList.add(BuyActor.assetList);
        assetList.addFont("alegreyaregular.otf");
    }
    public BuyStage(MyGame game) {
        super(new ResponseViewport(500), game);
        addBackButtonScreenBackByStackPopListenerWithPreloadedAssets(new LoadingStage(game));

        timeC = new Time(this);


        browserviewActor = new BrowserviewActor(game);
        browserviewActor.setSize(900, 500);
        addActor(browserviewActor);
        labelStyle = new LabelStyle(game.getMyAssetManager().getFont("alegreyaregular.otf"), Color.BLACK);
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

        shoesSelector = new ShoesSelector(this);
        shoesSelector.addActor(this);
    }

    @Override
    public void act(float delta) {
        super.act(delta);

        timeC.count(true);
    }
}
