package hu.csanyzeg.master.Menu;

import hu.csanyzeg.master.MyBaseClasses.Assets.AssetList;
import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.OneSpriteStaticActor;

public class QuestionActor extends OneSpriteStaticActor {
    static AssetList assetList = new AssetList();
    static {
        assetList.addTexture("questionmark.png");
    }
    public QuestionActor(MyGame game) {
        super(game, "questionmark.png");
        this.setSize(50,50);
    }
}
