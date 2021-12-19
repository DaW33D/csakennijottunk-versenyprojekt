package hu.csanyzeg.master.Game;

import hu.csanyzeg.master.MyBaseClasses.Assets.AssetList;
import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.MyScreen;

public class WardrobeScreen extends MyScreen {
    public WardrobeScreen(MyGame game) {
        super(game);

    }

    @Override
    protected void afterAssetsLoaded() {
        addStage(new WardrobeStage(game),0,true);
    }

    @Override
    public AssetList getAssetList() {
        AssetList assetList = new AssetList();
        assetList.add(WardrobeStage.assetList);
        assetList.add(Level.assetList);
        return assetList;
    }
}
