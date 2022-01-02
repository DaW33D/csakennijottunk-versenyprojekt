package hu.csanyzeg.master.Sneakers;

import hu.csanyzeg.master.MyBaseClasses.Assets.AssetList;
import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.OneSpriteStaticActor;

public class AirMax270Actor extends OneSpriteStaticActor {
    public static AssetList assetList = new AssetList();
    static {
        assetList.addTexture("star.png");
    }
    public AirMax270Actor(MyGame game) {
        super(game, "star.png");
    }
}
