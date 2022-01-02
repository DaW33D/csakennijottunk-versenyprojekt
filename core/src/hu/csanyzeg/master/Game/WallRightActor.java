package hu.csanyzeg.master.Game;

import hu.csanyzeg.master.MyBaseClasses.Assets.AssetList;
import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.OneSpriteStaticActor;

public class WallRightActor extends OneSpriteStaticActor {
    static AssetList assetList = new AssetList();
    static {
        assetList.addTexture("wall-right.png");
    }
    public WallRightActor(MyGame game) {
        super(game, "wall-right.png");
        this.setSize(50,50);
    }
}
