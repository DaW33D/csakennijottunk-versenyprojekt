package hu.csanyzeg.master.Pc;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

import hu.csanyzeg.master.LoadingStage;
import hu.csanyzeg.master.Menu.LabelStyle;
import hu.csanyzeg.master.MyBaseClasses.Assets.AssetList;
import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.MyStage;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.ResponseViewport;
import hu.csanyzeg.master.MyBaseClasses.UI.MyLabel;

public class PCStage extends MyStage {
    MonitorActor monitorActor;
    LabelStyle labelStyle;
    MyLabel BackLabel;
    static AssetList assetList = new AssetList();
    static{
        assetList.addTexture("monitor.png");
        assetList.addTexture("green.png");
        assetList.addTexture("blue.png");
    }
    public PCStage(MyGame game) {
        super(new ResponseViewport(500), game);
        monitorActor = new MonitorActor(game);
        addActor(monitorActor);
        labelStyle = new LabelStyle(game.getMyAssetManager().getFont("alegreyaregular.otf"), Color.YELLOW);
        BackLabel = new MyLabel(game, "Back", labelStyle);
        BackLabel.setSize(100, 50);
        BackLabel.setPosition(0, getCamera().viewportHeight-BackLabel.getHeight());
        addActor(BackLabel);
        BackLabel.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                game.setScreenBackByStackPopWithPreloadAssets(new LoadingStage(game));
            }
        });
    }
}