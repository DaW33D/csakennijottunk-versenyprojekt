package csakennijottunk.Game;

import hu.csanyzeg.master.MyBaseClasses.Assets.AssetList;
import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.MyStage;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.ResponseViewport;

public class GameStage extends MyStage {
    static AssetList assetList = new AssetList();
    static {
        assetList.add(AllActor.assetList);
    }
    AllActor allActor;
    public GameStage(MyGame game) {
        super(new ResponseViewport(500), game);
        allActor = new AllActor(game);
        addActor(allActor);

    }
}
