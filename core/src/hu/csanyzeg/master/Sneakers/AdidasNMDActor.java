package hu.csanyzeg.master.Sneakers;

import hu.csanyzeg.master.MyBaseClasses.Assets.AssetList;
import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.OneSpriteStaticActor;

public class AdidasNMDActor extends OneSpriteStaticActor {
    public static AssetList assetList = new AssetList();
    static {
        assetList.addTexture("monitor.png");
    }
    public AdidasNMDActor(MyGame game) {
        super(game, "monitor.png");
    }
}
