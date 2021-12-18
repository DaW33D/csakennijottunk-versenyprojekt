package hu.csanyzeg.master.Menu;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.utils.viewport.Viewport;

import hu.csanyzeg.master.MyBaseClasses.Assets.AssetList;
import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.MyStage;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.OneSpriteStaticActor;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.ResponseViewport;
import hu.csanyzeg.master.MyBaseClasses.UI.MyLabel;

public class MenuStage extends MyStage {
    LabelStyle labelStyle;
    MyLabel myLabel;
    static AssetList assetList = new AssetList();
    static {
        assetList.addTexture("yellow.png").protect = true;
        assetList.addFont("alegreyaregular.otf",50);
    }
    public MenuStage(MyGame game) {
        super(new ResponseViewport(500), game);
        addActor(new OneSpriteStaticActor(game,"yellow.png"));
        labelStyle = new LabelStyle(game.getMyAssetManager().getFont("alegreyaregular.otf"), Color.WHITE );
        myLabel = new MyLabel(game,"Csabi",labelStyle);
        addActor(myLabel);
    }
}
