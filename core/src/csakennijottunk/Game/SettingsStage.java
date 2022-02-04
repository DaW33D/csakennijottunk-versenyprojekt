package csakennijottunk.Game;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

import csakennijottunk.Credit.CreditStage;
import csakennijottunk.Question.QuestionStage;
import hu.csanyzeg.master.MyBaseClasses.Assets.AssetList;
import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.MyStage;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.ResponseViewport;

public class SettingsStage extends MyStage {
    static AssetList assetList = new AssetList();
    static {
        assetList.add(SoundActor.assetList);
        assetList.add(SoundOffActor.assetList);
        assetList.add(SettingsBgActor.assetList);
        assetList.add(CreditButtonActor.assetList);
        assetList.add(ExitActor.assetList);
        assetList.add(QuestionActor.assetList);
    }
    SoundActor soundActor;
    SoundOffActor soundOffActor;
    SettingsBgActor settingsBgActor;
    CreditButtonActor creditButtonActor;
    ExitActor exitActor;
    QuestionActor questionActor;

    public SettingsStage(MyGame game) {
        super(new ResponseViewport(500), game);
        settingsBgActor = new SettingsBgActor(game);
        settingsBgActor.setPosition(getCamera().viewportWidth, getCamera().viewportHeight / 2);
        addActor(settingsBgActor);

        soundActor = new SoundActor(game);
        addActor(soundActor);

        soundOffActor = new SoundOffActor(game);

        questionActor = new QuestionActor(game);
        questionActor.setPosition(140, 0);
        questionActor.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                getScreen().addStage(new QuestionStage(game), 1, true);
            }
        });
        addActor(questionActor);

        creditButtonActor = new CreditButtonActor(game);
        creditButtonActor.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                getScreen().addStage(new CreditStage(game), 1, true);
            }
        });
        creditButtonActor.setPosition(70, 0);
        addActor(creditButtonActor);









    }
}
