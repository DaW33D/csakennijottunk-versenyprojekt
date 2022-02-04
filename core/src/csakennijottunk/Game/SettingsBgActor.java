package csakennijottunk.Game;


import hu.csanyzeg.master.MyBaseClasses.Assets.AssetList;
import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.MyActor;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.OneSpriteStaticActor;

public class SettingsBgActor extends OneSpriteStaticActor {
    public static AssetList assetList = new AssetList();
    static {
        assetList.addTexture("hasznaltkepek/menubg.png");
    }

    public SettingsBgActor(MyGame game) {
        super(game, "hasznaltkepek/menubg.png");
        this.setSize(400, 400);

    }
}
