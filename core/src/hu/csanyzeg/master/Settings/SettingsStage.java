package hu.csanyzeg.master.Settings;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.Viewport;

import hu.csanyzeg.master.Game.Variables;
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
    static AssetList assetList = new AssetList();
    static{
        assetList.add(SettingsSaveButton.assetList);
        assetList.add(RectangleActor.assetList);
        assetList.add(CircleActor.assetList);
    }
    public SettingsStage(MyGame game) {
        super(new ResponseViewport(500), game);
        variables = new Variables();

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
                rectangleBgActor.setWidth(circleActor.getX() - 294);
                circleActor.setX(294 + x);
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
                System.out.println(variables.getIsFirstTime());
            }
        });
    }
}
