package hu.csanyzeg.master.Menu;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.sun.java.swing.action.ExitAction;

import hu.csanyzeg.master.Credit.CreditScreen;
import hu.csanyzeg.master.Game.CutSceneScreen;
import hu.csanyzeg.master.LoadingStage;
import hu.csanyzeg.master.MyBaseClasses.Assets.AssetList;
import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.MyStage;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.OneSpriteStaticActor;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.ResponseViewport;
import hu.csanyzeg.master.MyBaseClasses.UI.MyLabel;

public class MenuStage extends MyStage {
    LabelStyle labelStyle;
    MyLabel PlayLabel;
    MyLabel CreditLabel;
    MyLabel ExitLabel;
    static AssetList assetList = new AssetList();
    static {
        assetList.addTexture("yellow.png").protect = true;
        assetList.addFont("alegreyaregular.otf",30);
    }
    public MenuStage(MyGame game) {
        super(new ResponseViewport(500), game);
        addActor(new OneSpriteStaticActor(game, "yellow.png"));
        labelStyle = new LabelStyle(game.getMyAssetManager().getFont("alegreyaregular.otf"), Color.WHITE);
        PlayLabel = new MyLabel(game, "Play", labelStyle);
        PlayLabel.setSize(100, 50);
        PlayLabel.setPosition(400, 350);
        addActor(PlayLabel);
        PlayLabel.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                game.setScreenWithPreloadAssets(CutSceneScreen.class,new LoadingStage(game));
            }
        });
        CreditLabel = new MyLabel(game, "Credit", labelStyle);
        CreditLabel.setSize(140, 50);
        CreditLabel.setPosition(375, 275);
        addActor(CreditLabel);
        CreditLabel.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                game.setScreen(new CreditScreen(game));
            }
        });
        ExitLabel = new MyLabel(game, "Exit", labelStyle);
        ExitLabel.setSize(100, 50);
        ExitLabel.setPosition(400, 200);
        addActor(ExitLabel);
        ExitLabel.addListener(new ClickListener() {
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                game.setScreenBackByStackPop();
            }
        });
    }
}