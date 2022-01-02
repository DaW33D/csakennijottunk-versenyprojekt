package hu.csanyzeg.master.Game;

import hu.csanyzeg.master.MyBaseClasses.Assets.AssetList;
import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.MyScreen;

public class InGameScreen extends MyScreen {
    public InGameScreen(MyGame game) {
        super(game);
    }

    @Override
    public AssetList getAssetList() {
        AssetList assetList = new AssetList();
        assetList.add(InGameStage.assetList);
        assetList.add(Level.assetList);
        assetList.add(ShoesSelector.assetList);
        return assetList;
    }

    @Override
    protected void afterAssetsLoaded() {
        addStage(new InGameStage(game),0,true);
    }
}
