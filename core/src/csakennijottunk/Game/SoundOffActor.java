package csakennijottunk.Game;

import hu.csanyzeg.master.MyBaseClasses.Assets.AssetList;
import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.OneSpriteStaticActor;

public class SoundOffActor extends OneSpriteStaticActor {
    public static AssetList assetList = new AssetList();
    static {
        assetList.addTexture("hasznaltkepek/SoundOFF.png");
    }
    public SoundOffActor(MyGame game) {
        super(game, "hasznaltkepek/SoundOFF.png");
        this.setSize(50,50);
    }
}
