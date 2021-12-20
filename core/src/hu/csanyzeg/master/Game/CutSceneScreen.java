package hu.csanyzeg.master.Game;

import hu.csanyzeg.master.MyBaseClasses.Assets.AssetList;
import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.MyScreen;

public class CutSceneScreen extends MyScreen {
    public CutSceneScreen(MyGame game) {
        super(game);
    }

    @Override
    public AssetList getAssetList() {
        AssetList assetList = new AssetList();
        assetList.add(CutSceneStage.assetList);
        return assetList;
    }

    @Override
    protected void afterAssetsLoaded() {
        addStage(new CutSceneStage(game),0,true);
    }
}
