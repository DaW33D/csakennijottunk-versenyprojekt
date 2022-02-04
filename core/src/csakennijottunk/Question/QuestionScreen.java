package csakennijottunk.Question;

import csakennijottunk.Question.QuestionStage;
import hu.csanyzeg.master.MyBaseClasses.Assets.AssetList;
import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.MyScreen;

public class QuestionScreen extends MyScreen {
    public QuestionScreen(MyGame game) {
        super(game);
    }

    @Override
    public AssetList getAssetList() {
        AssetList assetList = new AssetList();
        assetList.add(QuestionStage.assetList);
        return assetList;
    }

    @Override
    protected void afterAssetsLoaded() {
        addStage(new QuestionStage(game),0,true);
    }
}
