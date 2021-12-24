package hu.csanyzeg.master.Settings;

import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.Viewport;

import hu.csanyzeg.master.Credit.CreditScreen;
import hu.csanyzeg.master.Game.InGameScreen;
import hu.csanyzeg.master.Game.Variables;
import hu.csanyzeg.master.LoadingStage;
import hu.csanyzeg.master.Menu.MenuScreen;
import hu.csanyzeg.master.Menu.SoundActor;
import hu.csanyzeg.master.Menu.SoundOffActor;
import hu.csanyzeg.master.MyBaseClasses.Assets.AssetList;
import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.MyStage;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.ResponseViewport;

public class SettingsStage extends MyStage {
    SettingsSaveButton settingsSaveButton;
    Variables variables;
    RectangleActor rectangleActor;
    RectangleBgActor rectangleBgActor;
    CircleActor circleActor;
    SoundActor soundActor;
    SoundOffActor soundOffActor;
    public boolean isMuted = true;
    static AssetList assetList = new AssetList();
    static{
        assetList.add(SettingsSaveButton.assetList);
        assetList.add(RectangleActor.assetList);
        assetList.add(CircleActor.assetList);
    }

    @Override
    public void act(float delta) {
        super.act(delta);
        System.out.println(isMuted);
    }

    public SettingsStage(MyGame game) {
        super(new ResponseViewport(500), game);
        variables = new Variables();

        isMuted = variables.getIsMuted();

        rectangleActor = new RectangleActor(game);
        addActor(rectangleActor);
        rectangleActor.setPositionCenter(getCamera().viewportHeight - rectangleActor.getHeight() - 25);

        rectangleBgActor = new RectangleBgActor(game);
        addActor(rectangleBgActor);
        rectangleBgActor.setPositionCenter(getCamera().viewportHeight - rectangleBgActor.getHeight() - 25);

        circleActor = new CircleActor(game);
        addActor(circleActor);
        circleActor.setPosition(rectangleActor.getX(),rectangleActor.getY());
        System.out.println(circleActor.getX());

        circleActor.addListener(new ClickListener(){
            @Override
            public void touchDragged(InputEvent event, float x, float y, int pointer) {
                super.touchDragged(event, x, y, pointer);
                System.out.println(294 + x);
//                if (x >= 0 && x <= 594 - circleActor.getWidth()) {
//                    circleActor.setX(240 + x);
//                }
                if (circleActor.getX() >= 294 && circleActor.getX() <= 594 - circleActor.getWidth()) {
                    for (float i = circleActor.getX(); i < 294 + x; i++) {
                        circleActor.setX(circleActor.getX() + 1);
                    }
                    for (float i = circleActor.getX(); i > 294 + x; i--) {
                        circleActor.setX(circleActor.getX() + 1);
                    }
                }
            }
        });

        settingsSaveButton = new SettingsSaveButton(game);
        addActor(settingsSaveButton);
        settingsSaveButton.setPositionCenterOfActorToCenterOfViewport();
        settingsSaveButton.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                variables.setFirstTime(false);
                game.setScreenWithPreloadAssets(MenuScreen.class, new LoadingStage(game));
                System.out.println(variables.getIsFirstTime());
            }
        });
        soundActor = new SoundActor(game);
        soundActor.setSize(50,50);
        soundActor.setPosition(getCamera().viewportWidth / 2 - soundActor.getWidth() * 2, getCamera().viewportHeight / 2 );
        addActor(soundActor);
        soundActor.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                variables.setIsMuted(false);
            }
        });
        soundOffActor = new SoundOffActor(game);
        soundOffActor.setSize(50,50);
        soundOffActor.setPosition(getCamera().viewportWidth / 2 - soundActor.getWidth() , getCamera().viewportHeight / 2 );
        addActor(soundOffActor);
        soundOffActor.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                variables.setIsMuted(true);
            }
        });

    }
}
