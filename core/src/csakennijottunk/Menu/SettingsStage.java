package csakennijottunk.Menu;

import hu.csanyzeg.master.MyBaseClasses.Assets.AssetList;
import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.MyStage;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.ResponseViewport;

public class SettingsStage extends MyStage {
    static AssetList assetList = new AssetList();
    SoundActor soundActor;
    SoundOffActor soundOffActor;
    public SettingsStage(MyGame game) {
        super(new ResponseViewport(500), game);
        soundActor = new SoundActor(game);
        soundOffActor = new SoundOffActor(game);



    }
}
