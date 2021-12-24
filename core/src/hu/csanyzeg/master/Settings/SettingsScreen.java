package hu.csanyzeg.master.Settings;

import hu.csanyzeg.master.MyBaseClasses.Assets.AssetList;
import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.MyScreen;

public class SettingsScreen extends MyScreen {
    public SettingsScreen(MyGame game) {
        super(game);
    }

    @Override
    public AssetList getAssetList() {
        AssetList assetList = new AssetList();
        return assetList;
    }

    @Override
    protected void afterAssetsLoaded() {
        addStage(new SettingsStage(game),0,true);
    }
}
