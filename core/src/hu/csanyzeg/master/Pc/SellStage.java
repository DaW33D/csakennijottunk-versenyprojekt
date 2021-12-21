package hu.csanyzeg.master.Pc;

import com.badlogic.gdx.utils.viewport.Viewport;

import hu.csanyzeg.master.MyBaseClasses.Assets.AssetList;
import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.MyStage;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.ResponseViewport;

public class SellStage extends MyStage {
    static AssetList assetList = new AssetList();
    static{
        assetList.add(BrowserActor.assetList);
        assetList.addFont("alegreyaregular.otf");
    }
    public SellStage(MyGame game) {
        super(new ResponseViewport(500), game);

    }
}
