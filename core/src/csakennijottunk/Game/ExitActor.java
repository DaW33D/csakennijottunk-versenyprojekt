package csakennijottunk.Game;

import hu.csanyzeg.master.MyBaseClasses.Assets.AssetList;
import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.OneSpriteStaticActor;

public class ExitActor extends OneSpriteStaticActor {
    static AssetList assetList = new AssetList();
    static {
        assetList.addTexture("hasznaltkepek/exitbutton.png");
    }
    public ExitActor(MyGame game) {
        super(game, "hasznaltkepek/exitbutton.png");
        this.setSize(210,50);
    }

}
