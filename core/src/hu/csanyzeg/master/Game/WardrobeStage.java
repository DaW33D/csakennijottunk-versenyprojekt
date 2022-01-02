package hu.csanyzeg.master.Game;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.Viewport;

import hu.csanyzeg.master.Credit.CreditScreen;
import hu.csanyzeg.master.LoadingStage;
import hu.csanyzeg.master.Menu.LabelStyle;
import hu.csanyzeg.master.MyBaseClasses.Assets.AssetList;
import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.MyStage;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.ResponseViewport;
import hu.csanyzeg.master.MyBaseClasses.UI.MyLabel;

public class WardrobeStage extends MyStage {
    LabelStyle labelStyle;
    MyLabel BackLabel;
    EmptyWardrobeActor emptywardrobeActor;
    Time time;
    static AssetList assetList = new AssetList();
    static{
        assetList.add(WardrobeActor.assetList);
        assetList.addFont("alegreyaregular.otf",30);
    }
    public WardrobeStage(MyGame game) {
        super(new ResponseViewport(500), game);
        addBackButtonScreenBackByStackPopListenerWithPreloadedAssets(new LoadingStage(game));

        time = new Time(this);

        emptywardrobeActor = new EmptyWardrobeActor(game);
        addActor(emptywardrobeActor);
        labelStyle = new LabelStyle(game.getMyAssetManager().getFont("alegreyaregular.otf"), Color.BLACK);
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

    @Override
    public void act(float delta) {
        super.act(delta);
        time.count(true);
    }
}
