package hu.csanyzeg.master.Game;

import hu.csanyzeg.master.MyBaseClasses.Assets.AssetList;
import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.OneSpriteStaticActor;

public class FloorActor extends OneSpriteStaticActor {
    static AssetList assetList = new AssetList();
    static {
        assetList.addTexture("floor.png");
    }
    public FloorActor(MyGame game) {
        super(game, "floor.png");
        this.setSize(50,50);
    }
}
