package hu.csanyzeg.master.Game;

import com.badlogic.gdx.utils.viewport.Viewport;

import hu.csanyzeg.master.LoadingStage;
import hu.csanyzeg.master.MyBaseClasses.Assets.AssetList;
import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.MyStage;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.OneSpriteStaticActor;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.ResponseViewport;

public class InGameStage extends MyStage {
    static AssetList assetList = new AssetList();
    static{
        assetList.addTexture("badlogic.jpg");
    }
    public InGameStage(MyGame game) {
        super(new ResponseViewport(500), game);
        addBackButtonScreenBackByStackPopListenerWithPreloadedAssets(new LoadingStage(game));
        //addActor(new OneSpriteStaticActor(game,"badlogic.jpg"));

        Level level = new Level(1,this);
        level.build();
    }
}
