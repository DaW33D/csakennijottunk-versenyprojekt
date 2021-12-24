package hu.csanyzeg.master.Pc;

import com.badlogic.gdx.graphics.Color;

import hu.csanyzeg.master.LoadingStage;
import hu.csanyzeg.master.Menu.LabelStyle;
import hu.csanyzeg.master.MyBaseClasses.Assets.AssetList;
import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.MyStage;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.ResponseViewport;
import hu.csanyzeg.master.MyBaseClasses.UI.MyLabel;
import hu.csanyzeg.master.Sneakers.NikeAirJordan1;

public class BuyStage extends MyStage {
    NikeAirJordan1 nikeAirJordan1;
    BrowserviewActor browserviewActor;
    LabelStyle labelStyle;
    MyLabel BackLabel;
    MyLabel moneyLabel;
    static AssetList assetList = new AssetList();
    static{
        assetList.add(BuyActor.assetList);
        assetList.addFont("alegreyaregular.otf");
    }
    public BuyStage(MyGame game) {
        super(new ResponseViewport(500), game);
        addBackButtonScreenBackByStackPopListenerWithPreloadedAssets(new LoadingStage(game));
        browserviewActor = new BrowserviewActor(game);
        browserviewActor.setSize(900, 500);
        addActor(browserviewActor);
        labelStyle = new LabelStyle(game.getMyAssetManager().getFont("alegreyaregular.otf"), Color.BLACK);
        BackLabel = new MyLabel(game, "Back", labelStyle);
        BackLabel.setSize(100, 50);
        BackLabel.setPosition(0, 0);
        addActor(BackLabel);
        moneyLabel = new MyLabel(game, "Money:", labelStyle);
        moneyLabel.setPosition(700, 400);
        addActor(moneyLabel);
        nikeAirJordan1 = new NikeAirJordan1(game);
        nikeAirJordan1.setPosition(200, 300);
        nikeAirJordan1.setSize(100,100);
        addActor(nikeAirJordan1);
    }
}
