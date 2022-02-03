package hu.csanyzeg.master.Pc;

import hu.csanyzeg.master.MyBaseClasses.Assets.AssetList;
import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.OneSpriteStaticActor;

public class PricerateActor extends OneSpriteStaticActor {
    static AssetList assetList = new AssetList();
    static{
        assetList.addTexture("iconstonks.png");
    }
    public PricerateActor(MyGame game) {
        super(game, "iconstonks.png");
    }
}
