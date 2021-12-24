package hu.csanyzeg.master.Pc;

import hu.csanyzeg.master.MyBaseClasses.Assets.AssetList;
import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.MyScreen;

public class BankScreen extends MyScreen {
    public BankScreen(MyGame game) {
        super(game);
    }

    @Override
    public AssetList getAssetList(){
        AssetList assetList = new AssetList();
        assetList.add(BankStage.assetList);
        return assetList;
    }

    @Override
    protected void afterAssetsLoaded() {
        addStage(new BankStage(game),0,true);
    }
}
