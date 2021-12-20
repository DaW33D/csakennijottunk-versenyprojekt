package hu.csanyzeg.master;

import hu.csanyzeg.master.MyBaseClasses.Assets.AssetList;
import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.OneSpriteStaticActor;

public class LoadingRound extends OneSpriteStaticActor {
    static AssetList assetList = new AssetList();
    static {
        assetList.addTexture("loadinground.png").protect = true;
    }
    public LoadingRound(MyGame game) {
        super(game, "loadinground.png");
        this.setSize(50,50);
        this.setPosition(25,0);

    }

    @Override
    public void act(float delta) {
        super.act(delta);
        this.setRotation(this.getRotation() - 1);
    }
}
