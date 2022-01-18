package hu.csanyzeg.master.Question;

import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.utils.viewport.Viewport;

import hu.csanyzeg.master.Game.Variables;
import hu.csanyzeg.master.LoadingStage;
import hu.csanyzeg.master.MyBaseClasses.Assets.AssetList;
import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.MyStage;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.OneSpriteStaticActor;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.ResponseViewport;

public class QuestionStage extends MyStage {
    static AssetList assetList = new AssetList();
    static {
        assetList.addTexture("badlogic.jpg");
        assetList.addMusic("song.mp3");
    }
    Variables variables;
    Music music = game.getMyAssetManager().getMusic("song.mp3");
    public QuestionStage(MyGame game) {
        super(new ResponseViewport(500), game);
        addActor(new OneSpriteStaticActor(game,"badlogic.jpg"));
        addBackButtonScreenBackByStackPopListenerWithPreloadedAssets(new LoadingStage(game));

        variables = new Variables();
        if (variables.getIsMuted() == false){
            music.play();
        }
    }
}
