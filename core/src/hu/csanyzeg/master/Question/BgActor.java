package hu.csanyzeg.master.Question;

import hu.csanyzeg.master.Game.ShoeInstance;
import hu.csanyzeg.master.MyBaseClasses.Assets.AssetList;
import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.OneSpriteStaticActor;

public class BgActor extends OneSpriteStaticActor {
    static AssetList assetList = new AssetList();
    static {
        assetList.addTexture("Questionbg.png");
    }
    public BgActor(MyGame game) {
        super(game, "Questionbg.png");
    }
}
