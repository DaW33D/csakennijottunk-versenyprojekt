package hu.csanyzeg.master.Settings;

import hu.csanyzeg.master.MyBaseClasses.Assets.AssetList;
import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.OneSpriteStaticActor;

public class SettingsSaveButton extends OneSpriteStaticActor {
    static AssetList assetList = new AssetList();
    static {
        assetList.addTexture("badlogic.jpg");
    }
    public SettingsSaveButton(MyGame game) {
        super(game, "badlogic.jpg");
        this.setSize(200,50);
    }
}
