package csakennijottunk.Game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

import csakennijottunk.Credit.CreditStage;
import csakennijottunk.Question.QuestionStage;
import csakennijottunk.Starter.MainGame;
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
    xActor xActor;
    SettingsButtonActor settingsButtonActor;
    QuestionActor questionActor;
    boolean creditonstage = false;
    boolean infoonstage = false;
    boolean xActoron = false;
    int katt = 0;
    public SettingsStage(MyGame game) {
        super(new ResponseViewport(500), game);
        settingsBgActor = new SettingsBgActor(game);
        settingsBgActor.setPosition(getCamera().viewportWidth,0);
        settingsBgActor.setHeight(getCamera().viewportHeight);
        addActor(settingsBgActor);
        soundActor = new SoundActor(game);
        soundOffActor = new SoundOffActor(game);
        xActor = new xActor(game);
        xActor.setPosition(getCamera().viewportWidth, getCamera().viewportHeight - xActor.getHeight());
        addActor(xActor);
        xActor.setZIndex(3);
        xActor.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                xActoron = true;
                katt = 1;
            }
        });
        settingsButtonActor = new SettingsButtonActor(game);
        settingsButtonActor.setZIndex(2);
        settingsButtonActor.setPosition(getCamera().viewportWidth - settingsButtonActor.getWidth(), getCamera().viewportHeight - settingsButtonActor.getHeight());
        settingsButtonActor.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                    katt = 0;
                }
        });
        addActor(settingsButtonActor);

        if (((MainGame)game).music.isPlaying() == true){
            soundActor.addListener(new ClickListener(){
                @Override
                public void clicked(InputEvent event, float x, float y) {
                    super.clicked(event, x, y);
                    musicOff();
                }
            });
            addActor(soundActor);
            soundActor.setPosition(getCamera().viewportWidth + 10, getCamera().viewportHeight - soundOffActor.getHeight() * 4);
        }
        else {
            soundOffActor.addListener(new ClickListener(){
                @Override
                public void clicked(InputEvent event, float x, float y) {
                    super.clicked(event, x, y);
                    musicOn();
                }
            });
            addActor(soundOffActor);
            soundOffActor.setPosition(getCamera().viewportWidth + 30, getCamera().viewportHeight - soundOffActor.getHeight() * 4);
        }



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
                    }
                }
            });
        exitActor = new ExitActor(game);
        exitActor.setPosition(getCamera().viewportWidth,getCamera().viewportHeight - exitActor.getHeight() * 3);
        addActor(exitActor);
        addActor(creditButtonActor);
        exitActor.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                Gdx.app.exit();
            }
        });

    }

    public void musicOn(){
        soundOffActor.remove();
        ((MainGame)game).music.play();
        soundActor.setPosition(getCamera().viewportWidth - 170, getCamera().viewportHeight - soundActor.getHeight() * 4);
        addActor(soundActor);
        soundActor.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                musicOff();

            }
        });
    }

    public void musicOff(){
        soundActor.remove();
        ((MainGame)game).music.stop();
        soundOffActor.setPosition(getCamera().viewportWidth - 170, getCamera().viewportHeight - soundOffActor.getHeight() * 4);
        addActor(soundOffActor);
        soundOffActor.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                musicOn();

            }
        });
    }

    @Override
    public void act(float delta) {
        super.act(delta);
        if(xActoron == false){
            if (katt == 0){
                if (creditButtonActor.getX() >= getCamera().viewportWidth - 200) {
                    creditButtonActor.setX(creditButtonActor.getX() - 10);
                }
            }
        }
        if (xActoron == false) {
            if (katt == 0){
                if (questionActor.getX() >= getCamera().viewportWidth - 200) {
                    questionActor.setX(questionActor.getX() - 10);
                }
            }
        }
        if (xActoron == false) {
            if (katt == 0){
                if (exitActor.getX() >= getCamera().viewportWidth - 200) {
                    exitActor.setX(exitActor.getX() - 10);
                }
            }
        }
        if (xActoron == false) {
            if (katt == 0){
                if (settingsBgActor.getX() >= getCamera().viewportWidth - 200) {
                    settingsBgActor.setX(settingsBgActor.getX() - 10);
                }
            }
        }
        if (xActoron == false) {
            if (katt == 0){
                if (xActor.getX() >= getCamera().viewportWidth - 250) {
                    xActor.setX(xActor.getX() - 10);
                }
            }
        }
        if (xActoron == false){
            if (katt == 0){
                if (soundActor.getStage() != null) {
                    if (soundActor.getX() >= getCamera().viewportWidth - 170) {
                        soundActor.setX(soundActor.getX() - 10);
                    }
                }
            }
        }
        if (xActoron == false){
            if (katt == 0){
                if (soundOffActor.getStage() != null) {
                    if (soundOffActor.getX() >= getCamera().viewportWidth - 170) {
                        soundOffActor.setX(soundOffActor.getX() - 10);
                    }
                }
            }
        }
        if (xActoron == true) {
            if (creditButtonActor.getX() <= getCamera().viewportWidth + 200) {
                creditButtonActor.setX(creditButtonActor.getX() + 10);
            }
            if (creditButtonActor.getX() == getCamera().viewportWidth + 200) {
                xActoron = false;
                katt = 1;
            }
        }
        if (xActoron == true){
            if (questionActor.getX() <= getCamera().viewportWidth + 200) {
                questionActor.setX(questionActor.getX() + 10);
            }
            if (creditButtonActor.getX() == getCamera().viewportWidth + 200) {
                xActoron = false;
                katt = 1;
            }
        }
        if (xActoron == true){
            if (exitActor.getX() <= getCamera().viewportWidth + 200) {
                exitActor.setX(exitActor.getX() + 10);
            }
            if (creditButtonActor.getX() == getCamera().viewportWidth + 200) {
                xActoron = false;
                katt = 1;
            }
        }
        if (xActoron == true){
            settingsBgActor.setX(settingsBgActor.getX() + 10);
            if (creditButtonActor.getX() == getCamera().viewportWidth + 200) {
                xActoron = false;
                katt = 1;
            }
        }
        if (xActoron == true){
            if (xActor.getX() <= getCamera().viewportWidth + 200) {
                xActor.setX(xActor.getX() + 10);
            }
            if (creditButtonActor.getX() == getCamera().viewportWidth + 200) {
                xActoron = false;
                katt = 1;
            }
        }
        if (xActoron == true){
            if (soundActor.getStage() != null) {
                if (soundActor.getX() <= getCamera().viewportWidth + 200) {
                    soundActor.setX(soundActor.getX() + 10);
                }
            }
            if (creditButtonActor.getX() == getCamera().viewportWidth + 200) {
                xActoron = false;
                katt = 1;
            }
        }
        if (xActoron == true){
            if (soundOffActor.getStage() != null) {
                if (soundOffActor.getX() <= getCamera().viewportWidth + 200) {
                    soundOffActor.setX(soundOffActor.getX() + 10);
                }
            }
            if (creditButtonActor.getX() == getCamera().viewportWidth + 200) {
                xActoron = false;
                katt = 1;
            }
        }
    }
}
