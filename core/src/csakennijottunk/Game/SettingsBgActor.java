package csakennijottunk.Game;


import hu.csanyzeg.master.MyBaseClasses.Assets.AssetList;
import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.MyActor;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.OneSpriteStaticActor;

public class SettingsBgActor extends OneSpriteStaticActor {
    public static AssetList assetList = new AssetList();
    static {
        assetList.addTexture("hasznaltkepek/badlogic.jpg");
    }

    @Override
    public void act(float delta) {
        super.act(delta);
        if (this.getX() >= 700){
            this.setX(getX() - 5);
        }
    }

    public SettingsBgActor(MyGame game) {
        super(game, "hasznaltkepek/badlogic.jpg");
        this.setSize(400, 400);

    }
}
