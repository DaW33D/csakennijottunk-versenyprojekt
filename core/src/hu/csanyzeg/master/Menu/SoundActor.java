package hu.csanyzeg.master.Menu;

import hu.csanyzeg.master.MyBaseClasses.Assets.AssetList;
import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.OneSpriteStaticActor;

public class SoundActor extends OneSpriteStaticActor {
    static AssetList assetList = new AssetList();
    static {
        assetList.addTexture("SoundON.png");
    }
    public SoundActor(MyGame game) {
        super(game, "SoundON.png");
        this.setSize(50,50);
    }
}
