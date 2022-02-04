package csakennijottunk.Game;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.MyStage;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.ResponseViewport;

public class SettingsButtonStage extends MyStage {
    SettingsButtonActor settingsButtonActor;
    boolean settingonstage = false;
    public SettingsButtonStage(MyGame game) {
        super(new ResponseViewport(500), game);

        settingsButtonActor = new SettingsButtonActor(game);
        settingsButtonActor.setPosition(getCamera().viewportWidth - settingsButtonActor.getWidth(), getCamera().viewportHeight - settingsButtonActor.getHeight());
        settingsButtonActor.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                if (settingonstage == false) {
                    getScreen().addStage(new SettingsStage(game), 1, true);
                    settingonstage = true;
                    settingsButtonActor.remove();
                }
            }
        });

        addActor(settingsButtonActor);

    }
}
