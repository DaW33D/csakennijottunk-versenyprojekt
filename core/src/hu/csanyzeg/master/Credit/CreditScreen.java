package hu.csanyzeg.master.Credit;

import hu.csanyzeg.master.Menu.MenuStage;
import hu.csanyzeg.master.MyBaseClasses.Assets.AssetList;
import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.MyScreen;

public class CreditScreen extends MyScreen {
    public CreditScreen(MyGame game) {
        super(game);
    }

    @Override
    protected void afterAssetsLoaded() {
        addStage(new CreditStage(game), 0, true);
    }

    @Override
    public AssetList getAssetList() {
        AssetList assetList = new AssetList();
        assetList.add(CreditStage.assetList);
        return assetList;
    }
}
