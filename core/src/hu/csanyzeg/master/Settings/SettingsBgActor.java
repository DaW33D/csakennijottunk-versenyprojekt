package hu.csanyzeg.master.Settings;

import hu.csanyzeg.master.MyBaseClasses.Assets.AssetList;
import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.OneSpriteStaticActor;

public class SettingsBgActor extends OneSpriteStaticActor {
    static AssetList assetList = new AssetList();
    static {
        assetList.addTexture("cserebg.png");
    }

    public SettingsBgActor(MyGame game) {
        super(game, "cserebg.png");
        this.setSize(900,500);
    }
}
