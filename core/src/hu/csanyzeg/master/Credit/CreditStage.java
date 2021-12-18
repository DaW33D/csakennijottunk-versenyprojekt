package hu.csanyzeg.master.Credit;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.utils.viewport.Viewport;

import hu.csanyzeg.master.Menu.LabelStyle;
import hu.csanyzeg.master.MyBaseClasses.Assets.AssetList;
import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.MyStage;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.ResponseViewport;
import hu.csanyzeg.master.MyBaseClasses.UI.MyLabel;

public class CreditStage extends MyStage {
    LabelStyle labelStyle;
    MyLabel Developers;
    static AssetList assetList = new AssetList();
    static {
        assetList.addFont("alegreyaregular.otf",50);
    }
    public CreditStage(MyGame game) {
        super(new ResponseViewport(500), game);
        setCameraResetToCenterOfScreen();
        addBackButtonScreenBackByStackPopListener();
        labelStyle = new LabelStyle(game.getMyAssetManager().getFont("alegreyaregular.otf"), Color.WHITE);
        Developers = new MyLabel(game, "Developers:", labelStyle);
        Developers.setPosition(0, 0);
        Developers.setSize(50, 50);
        addActor(Developers);
    }
}
