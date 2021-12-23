package hu.csanyzeg.master.Sneakers;

import hu.csanyzeg.master.MyBaseClasses.Assets.AssetList;
import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.OneSpriteStaticActor;

public class NikeAirJordan1 extends OneSpriteStaticActor {
    static AssetList assetList = new AssetList();
    static{
        assetList.addTexture("blue.png");
    }
    public NikeAirJordan1(MyGame game) {
        super(game, "blue.png");
    }
}
