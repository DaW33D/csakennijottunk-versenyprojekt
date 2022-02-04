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
    boolean creditonstage = false;
    boolean infoonstage = false;
    public SettingsStage(MyGame game) {
        super(new ResponseViewport(500), game);
        settingsBgActor = new SettingsBgActor(game);
        settingsBgActor.setPosition(getCamera().viewportWidth, getCamera().viewportHeight / 2);
        addActor(settingsBgActor);

        soundActor = new SoundActor(game);
        addActor(soundActor);

        soundOffActor = new SoundOffActor(game);

        questionActor = new QuestionActor(game);
        questionActor.setPosition(getCamera().viewportWidth, getCamera().viewportHeight - questionActor.getHeight() * 2);
        if (infoonstage == false) {
            questionActor.addListener(new ClickListener() {
                @Override
                public void clicked(InputEvent event, float x, float y) {
                    super.clicked(event, x, y);
                    getScreen().addStage(new QuestionStage(game), 1, true);
                    infoonstage = true;
                }
            });
        }
        addActor(questionActor);
        creditButtonActor = new CreditButtonActor(game);
        creditButtonActor.setPosition(getCamera().viewportWidth, getCamera().viewportHeight - creditButtonActor.getHeight());
        creditButtonActor.addListener(new ClickListener() {
                @Override
                public void clicked(InputEvent event, float x, float y) {
                    if (creditonstage == false) {
                        super.clicked(event, x, y);
                        getScreen().addStage(new CreditStage(game), 1, true);
                        creditonstage = true;
                        creditonstage = true;
                    }
                }
            });
        exitActor = new ExitActor(game);
        exitActor.setPosition(getCamera().viewportWidth,getCamera().viewportHeight - exitActor.getHeight() * 3);
        addActor(exitActor);
        addActor(creditButtonActor);

    }

    @Override
    public void act(float delta) {
        super.act(delta);
        if (creditButtonActor.getX() >= getCamera().viewportWidth - 200){
            creditButtonActor.setX(creditButtonActor.getX() - 5);
        }
        if (questionActor.getX() >= getCamera().viewportWidth - 200){
            questionActor.setX(questionActor.getX() - 5);
        }
        if (exitActor.getX() >= getCamera().viewportWidth - 200){
            exitActor.setX(exitActor.getX() - 5);
        }
        if (settingsBgActor.getX() >= getCamera().viewportWidth - 200){
            settingsBgActor.setX(settingsBgActor.getX() - 5);
        }
    }
}
