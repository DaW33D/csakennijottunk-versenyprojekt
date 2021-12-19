package hu.csanyzeg.master;

import com.badlogic.gdx.utils.viewport.Viewport;

import hu.csanyzeg.master.MyBaseClasses.Assets.AssetList;
import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.OneSpriteStaticActor;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.ResponseViewport;

public class LoadingStage extends hu.csanyzeg.master.MyBaseClasses.Assets.LoadingStage {
    LoadingBg loadingBg;
    LoadingRound loadingRound;
    static AssetList assetList = new AssetList();
    public LoadingStage(MyGame game) {
        super(new ResponseViewport(500), game);
        loadingBg = new LoadingBg(game);
        loadingRound = new LoadingRound(game);
        addActor(loadingBg);
        addActor(loadingRound);
    }

    @Override
    public AssetList getAssetList() {
        assetList.add(LoadingBg.assetList);
        assetList.add(LoadingRound.assetList);
        return assetList;
    }
}
