package csakennijottunk.Question;

import com.badlogic.gdx.utils.viewport.Viewport;

import hu.csanyzeg.master.MyBaseClasses.Assets.AssetList;
import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.MyStage;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.ResponseViewport;

public class QuestionStage extends MyStage {
    public static AssetList assetList = new AssetList();
    public QuestionStage(MyGame game) {
        super(new ResponseViewport(500),game);
    }
}