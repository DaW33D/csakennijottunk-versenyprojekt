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
    NikeAirJordan1Actor nikeAirJordan1;
    AdidasNMDActor adidasNMDActor;
    AdidasYeezy350Actor adidasYeezy350Actor;
    AirForce1Actor airForce1Actor;
    AirMax97Actor airMax97Actor;
    AirMax270Actor airMax270Actor;
    AirMax720Actor airMax720Actor;
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
        BackLabel = new MyLabel(game, "Back", labelStyle);
        BackLabel.setSize(100, 50);
        BackLabel.setPosition(0, 0);
        addActor(BackLabel);
        nikeAirJordan1 = new NikeAirJordan1Actor(game);
        nikeAirJordan1.setPosition(200, 300);
        nikeAirJordan1.setSize(100,100);
        addActor(nikeAirJordan1);
        adidasNMDActor = new AdidasNMDActor(game);
        adidasNMDActor.setPosition(200, 300);
        adidasNMDActor.setSize(100,100);
        airForce1Actor = new AirForce1Actor(game);
        airForce1Actor.setPosition(200, 300);
        airForce1Actor.setSize(100,100);
        airMax97Actor = new AirMax97Actor(game);
        airMax97Actor.setPosition(200, 300);
        airMax97Actor.setSize(100,100);
        airMax270Actor = new AirMax270Actor(game);
        airMax270Actor.setPosition(200, 300);
        airMax270Actor.setSize(100,100);
        airMax720Actor = new AirMax720Actor(game);
        airMax720Actor.setPosition(200, 300);
        airMax720Actor.setSize(100,100);
        adidasYeezy350Actor = new AdidasYeezy350Actor(game);
        adidasYeezy350Actor.setSize(100,100);
        adidasYeezy350Actor.setPosition(200,300);
        xActor = new xActor(game);
        xActor.setPosition(0, getCamera().viewportHeight - 40);
        xActor.setSize(20,20);
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
