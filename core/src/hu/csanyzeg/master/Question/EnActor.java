package hu.csanyzeg.master.Question;

import hu.csanyzeg.master.MyBaseClasses.Assets.AssetList;
import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.OneSpriteStaticActor;

public class EnActor extends OneSpriteStaticActor {
    static AssetList assetList = new AssetList();
    static{
        assetList.addTexture("englishtutorial-2.png");
    }
    public EnActor(MyGame game) {
        super(game, "englishtutorial-2.png");
    }
}
