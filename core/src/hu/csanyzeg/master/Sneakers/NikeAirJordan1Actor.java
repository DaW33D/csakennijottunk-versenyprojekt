package hu.csanyzeg.master.Sneakers;

import hu.csanyzeg.master.MyBaseClasses.Assets.AssetList;
import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.OneSpriteStaticActor;

public class NikeAirJordan1Actor extends OneSpriteStaticActor {
    public static AssetList assetList = new AssetList();
    static{
        assetList.addTexture("blue.png");
    }
    public NikeAirJordan1Actor(MyGame game) {
        super(game, "blue.png");
    }
}
