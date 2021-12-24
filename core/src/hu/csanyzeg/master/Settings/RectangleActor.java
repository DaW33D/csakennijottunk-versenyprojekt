package hu.csanyzeg.master.Settings;

import hu.csanyzeg.master.MyBaseClasses.Assets.AssetList;
import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.OneSpriteStaticActor;

public class RectangleActor extends OneSpriteStaticActor {
    static AssetList assetList = new AssetList();
    static {
        assetList.addTexture("rectangle.png");
    }

    public RectangleActor(MyGame game) {
        super(game, "rectangle.png");
        this.setSize(300,50);
    }
}
