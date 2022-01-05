package hu.csanyzeg.master.Game;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.Viewport;

import hu.csanyzeg.master.LoadingStage;
import hu.csanyzeg.master.Menu.LabelStyle;
import hu.csanyzeg.master.MyBaseClasses.Assets.AssetList;
import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.MyStage;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.ResponseViewport;
import hu.csanyzeg.master.MyBaseClasses.Timers.IntervalTimer;
import hu.csanyzeg.master.MyBaseClasses.Timers.IntervalTimerListener;
import hu.csanyzeg.master.MyBaseClasses.UI.MyLabel;

public class BedStage<timeC> extends MyStage {
    static AssetList assetList = new AssetList();
    static{
        assetList.addFont("alegreyaregular.otf",30);
    }
    LabelStyle labelStyle;
    MyLabel sleepLabel;
    MyLabel onehourLabel;
    MyLabel fourhourLabel;
    MyLabel sevenhourLabel;
    MyLabel ninehourLabel;
    MyLabel sleepLabel2;
    Time timeStage;
    int time;
    Time timeC;

    @Override
    public void act(float delta) {
        super.act(delta);
        time = timeStage.getSec();
        timeC.count(true);
        System.out.println(time);
    }

    public BedStage(MyGame game) {
        super(new ResponseViewport(500), game);
        timeC = new Time(this);
        timeStage = new Time(this);
        labelStyle = new LabelStyle(game.getMyAssetManager().getFont("alegreyaregular.otf"), Color.WHITE);
        sleepLabel2 = new MyLabel(game, "You're sleeping now", labelStyle);
        sleepLabel2.setPosition(getCamera().viewportWidth / 2, getCamera().viewportHeight / 2);
        sleepLabel = new MyLabel(game, "How many hours do you want to sleep?", labelStyle);
        sleepLabel.setPosition(getCamera().viewportWidth /2 - sleepLabel.getWidth(), getCamera().viewportHeight / 2 - sleepLabel.getHeight());
        addActor(sleepLabel);
        onehourLabel = new MyLabel(game, "1 hour", labelStyle);
        onehourLabel.setPosition(450,250);
        addActor(onehourLabel);
        onehourLabel.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                onehourLabel.remove();
                fourhourLabel.remove();
                sevenhourLabel.remove();
                ninehourLabel.remove();
                sleepLabel.remove();
                addActor(sleepLabel2);
                addTimer(new IntervalTimer(1, new IntervalTimerListener()){

                    @Override
                    public void stop() {
                        super.stop();
                        game.setScreenWithPreloadAssets(InGameScreen.class, new LoadingStage(game));
                    }
                });
            }
        });
        fourhourLabel = new MyLabel(game, "4 hour", labelStyle);
        addActor(fourhourLabel);
        fourhourLabel.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                onehourLabel.remove();
                fourhourLabel.remove();
                sevenhourLabel.remove();
                ninehourLabel.remove();
                sleepLabel.remove();
                addActor(sleepLabel2);
                addTimer(new IntervalTimer(4, new IntervalTimerListener()){

                    @Override
                    public void stop() {
                        super.stop();
                        game.setScreenWithPreloadAssets(InGameScreen.class, new LoadingStage(game));
                    }
                });
            }
        });
        sevenhourLabel = new MyLabel(game, "7 hour", labelStyle);
        addActor(sevenhourLabel);
        sevenhourLabel.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                onehourLabel.remove();
                fourhourLabel.remove();
                sevenhourLabel.remove();
                ninehourLabel.remove();
                sleepLabel.remove();
                addActor(sleepLabel2);
                addTimer(new IntervalTimer(7, new IntervalTimerListener()){

                    @Override
                    public void stop() {
                        super.stop();
                        game.setScreenWithPreloadAssets(InGameScreen.class, new LoadingStage(game));
                    }
                });
            }
        });
        ninehourLabel = new MyLabel(game, "9 hour", labelStyle);
        addActor(ninehourLabel);
        ninehourLabel.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                onehourLabel.remove();
                fourhourLabel.remove();
                sevenhourLabel.remove();
                ninehourLabel.remove();
                sleepLabel.remove();
                addActor(sleepLabel2);
                addTimer(new IntervalTimer(9, new IntervalTimerListener()){

                    @Override
                    public void stop() {
                        super.stop();
                        game.setScreenWithPreloadAssets(InGameScreen.class, new LoadingStage(game));
                    }
                });
            }
        });
    }
}
