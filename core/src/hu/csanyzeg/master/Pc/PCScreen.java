package hu.csanyzeg.master.Pc;

import hu.csanyzeg.master.Game.Level;
import hu.csanyzeg.master.MyBaseClasses.Assets.AssetList;
import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.MyScreen;

public class PCScreen extends MyScreen {
    public PCScreen(MyGame game) {
        super(game);
    }

    @Override
    protected void afterAssetsLoaded()  {
        addStage(new PCStage(game),0,true);
    }

    @Override
    public AssetList getAssetList() {
        AssetList assetList = new AssetList();
        assetList.add(PCStage.assetList);
        return assetList;
    }
}
