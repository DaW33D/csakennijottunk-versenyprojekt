package hu.csanyzeg.master.Game;

import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.Viewport;

import java.io.FileNotFoundException;

import hu.csanyzeg.master.LoadingStage;
import hu.csanyzeg.master.Menu.LabelStyle;
import hu.csanyzeg.master.MyBaseClasses.Assets.AssetList;
import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.MyStage;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.ResponseViewport;

public class CutSceneStage extends MyStage {
    CutScenePlayer cutScenePlayer;
    LabelStyle labelStyle;
    CutSceneSkipLabel cutSceneSkipLabel;
    static AssetList assetList = new AssetList();
    static {
        assetList.add(CutScenePlayer.assetList);
        assetList.addFont("alegreyaregular.otf",50);
    }
    public CutSceneStage(MyGame game) {
        super(new ResponseViewport(500), game);
        addBackButtonScreenBackByStackPopListenerWithPreloadedAssets(new LoadingStage(game));
        cutScenePlayer = new CutScenePlayer(game);
        addActor(cutScenePlayer);
        labelStyle = new LabelStyle(game.getMyAssetManager().getFont("alegreyaregular.otf"), Color.WHITE);
        cutSceneSkipLabel = new CutSceneSkipLabel(game,"Kihagyás",labelStyle);
        cutSceneSkipLabel.setPosition(getCamera().viewportWidth - cutSceneSkipLabel.getWidth(), getCamera().viewportHeight - cutSceneSkipLabel.getHeight());
        addActor(cutSceneSkipLabel);

        cutSceneSkipLabel.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                game.setScreenWithPreloadAssets(InGameScreen.class,new LoadingStage(game));
            }
        });
    }
}
