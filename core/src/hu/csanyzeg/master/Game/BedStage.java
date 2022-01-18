package hu.csanyzeg.master.Game;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.EventListener;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.DelayedRemovalArray;
import com.badlogic.gdx.utils.viewport.Viewport;

import hu.csanyzeg.master.LoadingStage;
import hu.csanyzeg.master.MainGame;
import hu.csanyzeg.master.Menu.LabelStyle;
import hu.csanyzeg.master.MyBaseClasses.Assets.AssetList;
import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.MyStage;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.ResponseViewport;
import hu.csanyzeg.master.MyBaseClasses.Timers.IntervalTimer;
import hu.csanyzeg.master.MyBaseClasses.Timers.IntervalTimerListener;
import hu.csanyzeg.master.MyBaseClasses.UI.MyLabel;
import sun.rmi.rmic.Main;

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
    MyLabel timeLabel;
    MyLabel sleepLabel2;

    @Override
    public void act(float delta) {
        super.act(delta);
    }

    public BedStage(MyGame game) {
        super(new ResponseViewport(500), game);
        //timeC = new Time(this);
        //timeStage = new Time(this);
        labelStyle = new LabelStyle(game.getMyAssetManager().getFont("alegreyaregular.otf"), Color.WHITE);
        sleepLabel2 = new MyLabel(game, "You're sleeping now", labelStyle);
        sleepLabel2.setPosition(getCamera().viewportWidth / 2 - sleepLabel2.getWidth() / 2, getCamera().viewportHeight / 2);
        sleepLabel = new MyLabel(game, "How many hours do you want to sleep?", labelStyle);
        sleepLabel.setPosition(getCamera().viewportWidth /2 - sleepLabel.getWidth() / 2.2f, getCamera().viewportHeight / 2 + sleepLabel.getHeight());
        addActor(sleepLabel);
        onehourLabel = new MyLabel(game, "1 hour", labelStyle);
        onehourLabel.setPosition(getCamera().viewportWidth / 4.5f - onehourLabel.getWidth(), getCamera().viewportHeight / 2);
        addActor(onehourLabel);
        onehourLabel.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                ((MainGame)game).gameTime.sleep(3600);
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
        fourhourLabel.setPosition(getCamera().viewportWidth / 3, getCamera().viewportHeight / 2);
        addActor(fourhourLabel);
        fourhourLabel.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                ((MainGame)game).gameTime.sleep(3600 * 4);
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
        sevenhourLabel.setPosition(getCamera().viewportWidth / 1.5f - sevenhourLabel.getWidth(), getCamera().viewportHeight / 2);
        addActor(sevenhourLabel);
        sevenhourLabel.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                ((MainGame)game).gameTime.sleep(3600 * 7);
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
        ninehourLabel.setPosition(getCamera().viewportWidth / 1.2f, getCamera().viewportHeight / 2
        );
        addActor(ninehourLabel);
        ninehourLabel.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                ((MainGame)game).gameTime.sleep(3600 * 9);
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
