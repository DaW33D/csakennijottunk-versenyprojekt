package hu.csanyzeg.master.Sneakers;

import hu.csanyzeg.master.MyBaseClasses.Assets.AssetList;
import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.OneSpriteStaticActor;

public class AirForce1Actor extends OneSpriteStaticActor {
    public static AssetList assetList = new AssetList();
    static {
        assetList.addTexture("walk.png");
    }
    public AirForce1Actor(MyGame game) {
        super(game, "walk.png");
    }
}
