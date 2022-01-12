package hu.csanyzeg.master.Game;

import hu.csanyzeg.master.MyBaseClasses.Assets.AssetList;
import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.MyScreen;

public class BedScreen extends MyScreen {
    public BedScreen(MyGame game) {
        super(game);
    }

    @Override
    public AssetList getAssetList() {
        return null;
    }

    @Override
    protected void afterAssetsLoaded() {
        addStage(new BedStage(game), 0, true);
    }
}
