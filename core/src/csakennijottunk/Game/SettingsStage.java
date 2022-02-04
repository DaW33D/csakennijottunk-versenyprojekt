package csakennijottunk.Game;

import hu.csanyzeg.master.MyBaseClasses.Assets.AssetList;
import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.MyStage;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.ResponseViewport;

public class SettingsStage extends MyStage {
    static AssetList assetList = new AssetList();
    SoundActor soundActor;
    SoundOffActor soundOffActor;
    SettingsBgActor settingsBgActor;

    @Override
    public void act(float delta) {
        super.act(delta);
    }

    public SettingsStage(MyGame game) {
        super(new ResponseViewport(500), game);
        settingsBgActor = new SettingsBgActor(game);
        addActor(settingsBgActor);
        soundActor = new SoundActor(game);
        addActor(soundActor);
        soundOffActor = new SoundOffActor(game);
        settingsBgActor = new SettingsBgActor(game);







    }
}
