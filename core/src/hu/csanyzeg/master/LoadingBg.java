package hu.csanyzeg.master;

import hu.csanyzeg.master.MyBaseClasses.Assets.AssetList;
import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.OneSpriteStaticActor;

public class LoadingBg extends OneSpriteStaticActor {
    static AssetList assetList = new AssetList();
    static {
        assetList.addTexture("loading.png").protect = true;
    }
    public LoadingBg(MyGame game) {
        super(game, "loading.png");
        this.setSize(1000,500);
        this.setPosition(0,0);
    }
}
