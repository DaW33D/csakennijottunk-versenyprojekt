package csakennijottunk.Game;

import hu.csanyzeg.master.MyBaseClasses.Assets.AssetList;
import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.OneSpriteStaticActor;

public class Sex extends OneSpriteStaticActor {
    static AssetList assetList = new AssetList();
    static {
        assetList.addTexture("hasznaltkepek/badlogic.jpg");
    }
    public Sex(MyGame game) {
        super(game, "hasznaltkepek/badlogic.jpg");
        setSize(50,50);
    }
}
