package hu.csanyzeg.master.Game;

import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.viewport.Viewport;

import java.io.FileNotFoundException;

import hu.csanyzeg.master.MyBaseClasses.Assets.AssetList;
import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.MyStage;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.ResponseViewport;

public class CutSceneStage extends MyStage {
    CutScenePlayer cutScenePlayer;
    static AssetList assetList = new AssetList();
    static {
        assetList.add(CutScenePlayer.assetList);
    }
    public CutSceneStage(MyGame game) {
        super(new ResponseViewport(500), game);
        cutScenePlayer = new CutScenePlayer(game);
        addActor(cutScenePlayer);
    }
}
