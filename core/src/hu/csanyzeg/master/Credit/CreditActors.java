package hu.csanyzeg.master.Credit;

import hu.csanyzeg.master.MyBaseClasses.Assets.AssetList;
import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.OneSpriteStaticActor;

class CreditActors extends OneSpriteStaticActor {
    static AssetList assetList = new AssetList();
    static {
        assetList.addTexture("creditsbg.png");
    }
    public CreditActors(MyGame game) {
        super(game, "creditsbg.png");

    }
}
