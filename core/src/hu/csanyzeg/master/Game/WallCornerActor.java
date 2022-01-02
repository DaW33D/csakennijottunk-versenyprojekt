package hu.csanyzeg.master.Game;

import hu.csanyzeg.master.MyBaseClasses.Assets.AssetList;
import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.OneSpriteStaticActor;

public class WallCornerActor extends OneSpriteStaticActor {
    static AssetList assetList = new AssetList();
    static {
        assetList.addTexture("wall-corner.png");
    }
    public WallCornerActor(MyGame game) {
        super(game, "wall-corner.png");
        this.setSize(50,50);
    }
}
