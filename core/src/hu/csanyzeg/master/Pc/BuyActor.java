package hu.csanyzeg.master.Pc;

import hu.csanyzeg.master.MyBaseClasses.Assets.AssetList;
import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.OneSpriteStaticActor;

public class BuyActor extends OneSpriteStaticActor {
    static AssetList assetList = new AssetList();
    static{
        assetList.addTexture("green.png");
    }
    public BuyActor(MyGame game) {
        super(game, "green.png");
    }

}
