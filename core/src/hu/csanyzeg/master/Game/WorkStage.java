package hu.csanyzeg.master.Game;

import com.badlogic.gdx.utils.viewport.Viewport;

import hu.csanyzeg.master.Menu.QuestionActor;
import hu.csanyzeg.master.Menu.SoundActor;
import hu.csanyzeg.master.Menu.SoundOffActor;
import hu.csanyzeg.master.MyBaseClasses.Assets.AssetList;
import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.MyStage;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.ResponseViewport;

public class WorkStage extends MyStage {
    static AssetList assetList = new AssetList();
    static {
        assetList.addFont("alegreyaregular.otf",30);
    }
    public WorkStage(MyGame game) {
        super(new ResponseViewport(500), game);

    }
}
