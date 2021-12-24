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
    static AssetList assetList = new AssetList();
    static{
        assetList.add(SettingsSaveButton.assetList);
    }
    public SettingsStage(MyGame game) {
        super(new ResponseViewport(500), game);
        variables = new Variables();
        settingsSaveButton = new SettingsSaveButton(game);
        addActor(settingsSaveButton);
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
