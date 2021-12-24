package hu.csanyzeg.master.Pc;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.utils.viewport.Viewport;

import hu.csanyzeg.master.LoadingStage;
import hu.csanyzeg.master.Menu.LabelStyle;
import hu.csanyzeg.master.MyBaseClasses.Assets.AssetList;
import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.MyStage;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.ResponseViewport;
import hu.csanyzeg.master.MyBaseClasses.UI.MyLabel;

public class BankStage extends MyStage {
    static AssetList assetList = new AssetList();
    static{
        assetList.addFont("alegreyaregular.otf", 15);
    }
    BrowserviewActor browserviewActor;
    LabelStyle labelStyle;
    MyLabel bankLabel;
    MyLabel money;
    MyLabel text1;
    public BankStage(MyGame game) {
        super(new ResponseViewport(500), game);
        addBackButtonScreenBackByStackPopListenerWithPreloadedAssets(new LoadingStage(game));
        labelStyle = new LabelStyle(game.getMyAssetManager().getFont("alegreyaregular.otf"), Color.BLACK);
        browserviewActor = new BrowserviewActor(game);
        browserviewActor.setPosition(0,0);
        browserviewActor.setSize(900,500);
        addActor(browserviewActor);
        bankLabel = new MyLabel(game, "Bank", labelStyle);
        bankLabel.setPosition(10, 470);
        bankLabel.setFontScale(0.3f);
        addActor(bankLabel);
        text1 = new MyLabel(game, "Your money: ", labelStyle);
        text1.setPosition(getCamera().viewportWidth /2 - text1.getWidth(), 250);
        addActor(text1);
    }
}
