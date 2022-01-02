package hu.csanyzeg.master.Game;

import hu.csanyzeg.master.MyBaseClasses.Assets.AssetList;
import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.OneSpriteStaticActor;

public class WallLeftActor extends OneSpriteStaticActor {
    static AssetList assetList = new AssetList();
    static {
        assetList.addTexture("wall-left.png");
    }
    public WallLeftActor(MyGame game) {
        super(game, "wall-left.png");
        this.setSize(50,50);
    }
}
