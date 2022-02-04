package csakennijottunk.Game;

import hu.csanyzeg.master.MyBaseClasses.Assets.AssetList;
import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.OneSpriteStaticActor;

public class Feed extends OneSpriteStaticActor {
    static AssetList assetList = new AssetList();
    static {
        assetList.addTexture("hasznaltkepek/kaja.png");
    }
    public Feed(MyGame game) {
        super(game, "hasznaltkepek/kaja.png");
        setSize(50,50);
    }
}
