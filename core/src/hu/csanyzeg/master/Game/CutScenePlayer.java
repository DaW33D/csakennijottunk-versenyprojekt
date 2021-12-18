package hu.csanyzeg.master.Game;

import hu.csanyzeg.master.MyBaseClasses.Assets.AssetList;
import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.OneSpriteStaticActor;

public class CutScenePlayer extends OneSpriteStaticActor {
    static AssetList assetList = new AssetList();
    static {
        assetList.addTexture("badlogic.jpg");
    }
    public CutScenePlayer(MyGame game) {
        super(game, "badlogic.jpg");
    }

    @Override
    public void act(float delta) {
        super.act(delta);
        this.setX(this.getX() + 1);
    }
}
