package hu.csanyzeg.master.Game;

import hu.csanyzeg.master.MyBaseClasses.Assets.AssetList;
import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.OneSpriteAnimatedActor;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.OneSpriteStaticActor;

public class PlayerActorIdle extends OneSpriteStaticActor {
    static AssetList assetList = new AssetList();
    static {
        assetList.addTexture("Player.png");
    }
    public PlayerActorIdle(MyGame game) {
        super(game, "Player.png");
        this.setSize(50,50);
        this.setPositionCenterOfActorToCenterOfViewport();
    }
}
