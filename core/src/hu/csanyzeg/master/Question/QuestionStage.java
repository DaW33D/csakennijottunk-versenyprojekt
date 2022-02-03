package hu.csanyzeg.master.Question;

import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.Viewport;

import hu.csanyzeg.master.Game.Variables;
import hu.csanyzeg.master.LoadingStage;
import hu.csanyzeg.master.Menu.LabelStyle;
import hu.csanyzeg.master.Menu.MenuScreen;
import hu.csanyzeg.master.MyBaseClasses.Assets.AssetList;
import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.MyStage;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.OneSpriteStaticActor;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.ResponseViewport;
import hu.csanyzeg.master.MyBaseClasses.UI.MyLabel;

public class QuestionStage extends MyStage {
    static AssetList assetList = new AssetList();
    static {
        assetList.addFont("alegreyaregular.otf");
        assetList.addTexture("badlogic.jpg");
        assetList.addMusic("song.mp3");
        assetList.add(BgActor.assetList);
        assetList.add(EnActor.assetList);
        assetList.add(HuActor.assetList);

    }
    Variables variables;
    HuActor huActor;
    BgActor bgActor;
    LabelStyle labelStyle;
    MyLabel backLabel;
    MyLabel visszalabel;
    EnActor enActor;
    Music music = game.getMyAssetManager().getMusic("song.mp3");
    public QuestionStage(MyGame game) {
        super(new ResponseViewport(500), game);
        labelStyle = new LabelStyle(game.getMyAssetManager().getFont("alegreyaregular.otf"), Color.WHITE);
        bgActor = new BgActor(game);
        bgActor.setSize(getCamera().viewportWidth, getCamera().viewportHeight);
        addActor(bgActor);
        enActor = new EnActor(game);
        enActor.setSize(getCamera().viewportWidth, getCamera().viewportHeight);
        backLabel = new MyLabel(game, "Back", labelStyle);
        backLabel.setColor(0,0, 0, 255);
        backLabel.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                game.setScreenWithPreloadAssets(MenuScreen.class, new LoadingStage(game));
            }
        });
        visszalabel = new MyLabel(game, "Vissza", labelStyle);
        visszalabel.setSize(visszalabel.getWidth(), visszalabel.getHeight());
        visszalabel.setPosition(0, 0);
        visszalabel.setColor(0,0,0,255);
        visszalabel.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                game.setScreenWithPreloadAssets(MenuScreen.class, new LoadingStage(game));
            }
        });
        huActor = new HuActor(game);
        huActor.setSize(getCamera().viewportWidth, getCamera().viewportHeight);
        variables = new Variables();
        if (!variables.getIsFirstTime() && variables.getLang().equals("en")){
            addActor(enActor);
        }
        if (!variables.getIsFirstTime() && variables.getLang().equals("hu")) {
            addActor(huActor);
        }
        if (!variables.getIsFirstTime() && variables.getLang().equals("en")){
            addActor(backLabel);
        }
        if (!variables.getIsFirstTime() && variables.getLang().equals("hu")) {
            addActor(visszalabel);
        }
    }
}
