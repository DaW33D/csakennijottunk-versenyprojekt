package hu.csanyzeg.master.Settings;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

import hu.csanyzeg.master.Game.Variables;
import hu.csanyzeg.master.Game.WardrobeActor;
import hu.csanyzeg.master.LoadingStage;
import hu.csanyzeg.master.Menu.LabelStyle;
import hu.csanyzeg.master.Menu.MenuScreen;
import hu.csanyzeg.master.Menu.SoundActor;
import hu.csanyzeg.master.Menu.SoundOffActor;
import hu.csanyzeg.master.MyBaseClasses.Assets.AssetList;
import hu.csanyzeg.master.MyBaseClasses.Box2dWorld.WorldBodyEditorLoader;
import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.MyStage;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.ResponseViewport;
import hu.csanyzeg.master.MyBaseClasses.UI.MyLabel;

public class SettingsStage extends MyStage {
    SettingsSaveButton settingsSaveButton;
    Variables variables;
    RectangleActor rectangleActor;
    RectangleActor rectangleActor2;
    RectangleBgActor rectangleBgActor;
    RectangleBgActor rectangleBgActor2;
    CircleActor circleActor;
    CircleActor circleActor2;
    SoundActor soundActor;
    SoundOffActor soundOffActor;
    LabelStyle labelStyle;
    MyLabel mainLabel;
    MyLabel welcomeLabel;
    MyLabel effectLabel;
    MyLabel mVolumeValue;
    MyLabel sVolumeValue;
    TickActor tickActor;
    TickActor tickActor2;
    TickActor2 tickActor3;
    TickActor2 tickActor4;
    SettingsBgActor settingsBgActor;
    HuActor huActor;
    EnActor enActor;
    NewPlayerActor newPlayerActor;
    public boolean isMuted = true;
    static AssetList assetList = new AssetList();
    static{
        assetList.add(SettingsSaveButton.assetList);
        assetList.add(RectangleActor.assetList);
        assetList.add(CircleActor.assetList);
        assetList.addFont("alegreyaregular.otf",5);
    }

    @Override
    public void act(float delta) {
        super.act(delta);
        isMuted = variables.getIsMuted();
    }

    public SettingsStage(MyGame game) {
        super(new ResponseViewport(500), game);
        variables = new Variables();

        labelStyle = new LabelStyle(game.getMyAssetManager().getFont("alegreyaregular.otf"), Color.WHITE);



        settingsBgActor = new SettingsBgActor(game);
        addActor(settingsBgActor);



        rectangleActor = new RectangleActor(game);
        addActor(rectangleActor);
        rectangleActor.setPositionCenter(getCamera().viewportHeight - rectangleActor.getHeight() - 105);

        rectangleBgActor = new RectangleBgActor(game);
        addActor(rectangleBgActor);
        rectangleBgActor.setPosition(rectangleActor.getX(), rectangleActor.getY());
        if (variables.getIsFirstTime() == false){
            rectangleBgActor.setWidth(3*variables.getmVolume());
        }

        circleActor = new CircleActor(game);
        addActor(circleActor);
        if (variables.getIsFirstTime() == true){
            circleActor.setPosition(rectangleActor.getX() + rectangleActor.getWidth() - circleActor.getWidth(),rectangleActor.getY());
        }else{
            circleActor.setPosition(rectangleActor.getX() + 3 * variables.getmVolume() - circleActor.getWidth(),rectangleActor.getY());
        }



        rectangleActor2 = new RectangleActor(game);
        addActor(rectangleActor2);
        rectangleActor2.setPositionCenter(rectangleActor.getY() - rectangleActor2.getHeight() - 25);

        rectangleBgActor2 = new RectangleBgActor(game);
        addActor(rectangleBgActor2);
        rectangleBgActor2.setPosition(rectangleActor2.getX(), rectangleActor2.getY());
        if (variables.getIsFirstTime() == false){
            rectangleBgActor2.setWidth(3*variables.getsVolume());
        }


        circleActor2 = new CircleActor(game);
        addActor(circleActor2);
        if (variables.getIsFirstTime() == true){
            circleActor2.setPosition(rectangleActor2.getX() + rectangleActor2.getWidth() - circleActor2.getWidth(),rectangleActor2.getY());
        }else{
            circleActor2.setPosition(rectangleActor2.getX() + 3 * variables.getsVolume() - circleActor2.getWidth(),rectangleActor2.getY());
        }


//        newPlayerActor = new NewPlayerActor(game);
//        newPlayerActor.setPosition(getCamera().viewportWidth / 2 - newPlayerActor.getWidth() / 2, getCamera().viewportHeight - newPlayerActor.getHeight());
//        addActor(newPlayerActor);

        mainLabel = new MyLabel(game, "Music Volume:", labelStyle);
        mainLabel.setPosition(rectangleActor.getX(),rectangleActor.getY() + rectangleActor.getHeight());
        mainLabel.setFontScale(0.5f);
        addActor(mainLabel);

        effectLabel = new MyLabel(game, "Effect Volume:", labelStyle);
        effectLabel.setFontScale(0.5f);
        effectLabel.setHeight(20);
        effectLabel.setPosition(rectangleActor2.getX(), rectangleActor2.getY() + rectangleActor2.getHeight() +5);
        addActor(effectLabel);

        welcomeLabel = new MyLabel(game,"",labelStyle);
        if (variables.getIsFirstTime() == true){
            welcomeLabel.setText("Úgy látszik most játszol először,kérlek"  + "\n" +  "válaszd ki a neked megfelelő beállításokat.");
        }
        welcomeLabel.setFontScale(0.7f);
        welcomeLabel.setWidth(400);
        welcomeLabel.setHeight(70);
        welcomeLabel.setPosition(getCamera().viewportWidth / 2 - welcomeLabel.getWidth() / 2, getCamera().viewportHeight - welcomeLabel.getHeight());
        addActor(welcomeLabel);

        mVolumeValue = new MyLabel(game, "", labelStyle);
        mVolumeValue.setFontScale(0.5f);
        mVolumeValue.setPosition(rectangleActor.getX() + rectangleActor.getWidth() + 10,rectangleActor.getY() + rectangleActor.getHeight() / 2 - mVolumeValue.getHeight() / 2);
        addActor(mVolumeValue);

        sVolumeValue = new MyLabel(game, "", labelStyle);
        sVolumeValue.setFontScale(0.5f);
        sVolumeValue.setPosition(rectangleActor2.getX() + rectangleActor2.getWidth() + 10, rectangleActor2.getY() + rectangleActor2.getHeight()/2 - sVolumeValue.getHeight() / 2);
        addActor(sVolumeValue);

//        rectangleActor.addListener(new ClickListener(){
//            @Override
//            public void clicked(InputEvent event, float x, float y) {
//                super.clicked(event, x, y);
//                System.out.println(x);
//                circleActor.setX(294 + x);
//            }
//        });

        rectangleActor.addListener(new ClickListener(){
            @Override
            public void touchDragged(InputEvent event, float x, float y, int pointer) {
                super.touchDragged(event, x, y, pointer);
                if (circleActor.getX() >= rectangleActor.getX() && circleActor.getX() <= rectangleActor.getX() + rectangleActor.getWidth() - circleActor.getWidth()) {
                    circleActor.setX(rectangleActor.getX() + x - circleActor.getWidth() / 2);
                    rectangleBgActor.setWidth(circleActor.getX() - rectangleActor.getX() + circleActor.getWidth());
                    mVolumeValue.setText(Math.round(circleActor.getX() + circleActor.getWidth() - rectangleActor.getX())/3);
                }
                if (circleActor.getX() < rectangleActor.getX()){
                    circleActor.setX(rectangleActor.getX());
                    rectangleBgActor.setWidth(circleActor.getWidth());
                    mVolumeValue.setText("0");
                }
                if (circleActor.getX() > rectangleActor.getX() + rectangleActor.getWidth() - circleActor.getWidth()){
                    circleActor.setX(rectangleActor.getX() + rectangleActor.getWidth() - circleActor.getWidth());
                    rectangleBgActor.setWidth(300);
                    mVolumeValue.setText("100");

                }
            }



            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                super.touchUp(event, x, y, pointer, button);
                if (circleActor.getX() <= rectangleActor.getX()){
                    circleActor.setX(rectangleActor.getX());
                }
                if (circleActor.getX() >= rectangleActor.getX() + rectangleActor.getWidth() - circleActor.getWidth()){
                    circleActor.setX(rectangleActor.getX() + rectangleActor.getWidth() - circleActor.getWidth());
                }
                //rectangleBgActor.setWidth(circleActor.getX() - 294 + circleActor.getWidth());
                //System.out.println(Math.round(circleActor.getX() + circleActor.getWidth() - 294)/3);
            }
        });

        rectangleBgActor.addListener(new ClickListener(){
            @Override
            public void touchDragged(InputEvent event, float x, float y, int pointer) {
                super.touchDragged(event, x, y, pointer);
                if (circleActor.getX() >= rectangleActor.getX() && circleActor.getX() <= rectangleActor.getX() + rectangleActor.getWidth() - circleActor.getWidth()) {
                    circleActor.setX(rectangleActor.getX() + x - circleActor.getWidth() / 2);
                    rectangleBgActor.setWidth(circleActor.getX() - rectangleActor.getX() + circleActor.getWidth());
                    mVolumeValue.setText(Math.round(circleActor.getX() + circleActor.getWidth() - rectangleBgActor.getX())/3);
                }
                if (circleActor.getX() < rectangleActor.getX()){
                    circleActor.setX(rectangleActor.getX());
                    rectangleBgActor.setWidth(circleActor.getWidth());
                    mVolumeValue.setText("0");
                }
                if (circleActor.getX() > rectangleActor.getX() + rectangleActor.getWidth() - circleActor.getWidth()){
                    circleActor.setX(rectangleActor.getX() + rectangleActor.getWidth() - circleActor.getWidth());
                    rectangleBgActor.setWidth(300);
                    mVolumeValue.setText("100");

                }
            }



            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                super.touchUp(event, x, y, pointer, button);
                if (circleActor.getX() <= rectangleActor.getX()){
                    circleActor.setX(rectangleActor.getX());
                }
                if (circleActor.getX() >=  rectangleActor.getX() + rectangleActor.getWidth() - circleActor.getWidth()){
                    circleActor.setX( rectangleActor.getX() + rectangleActor.getWidth() - circleActor.getWidth());
                }
                rectangleBgActor.setWidth(circleActor.getX() - rectangleActor.getX() + circleActor.getWidth());
            }
        });


        rectangleActor2.addListener(new ClickListener(){
            @Override
            public void touchDragged(InputEvent event, float x, float y, int pointer) {
                super.touchDragged(event, x, y, pointer);
                if (circleActor2.getX() >= rectangleActor2.getX() && circleActor2.getX() <=  rectangleActor2.getX() + rectangleActor2.getWidth() - circleActor2.getWidth()) {
                    circleActor2.setX(rectangleActor2.getX() + x - circleActor2.getWidth() / 2);
                    rectangleBgActor2.setWidth(circleActor2.getX() - rectangleActor2.getX() + circleActor2.getWidth());
                    sVolumeValue.setText(Math.round(circleActor2.getX() + circleActor2.getWidth() -rectangleActor2.getX())/3);
                }
                if (circleActor2.getX() < rectangleActor2.getX()){
                    circleActor2.setX(rectangleActor2.getX());
                    rectangleBgActor2.setWidth(circleActor2.getWidth());
                    sVolumeValue.setText("0");
                }
                if (circleActor2.getX() >  rectangleActor2.getX() + rectangleActor2.getWidth() - circleActor2.getWidth()){
                    circleActor2.setX( rectangleActor2.getX() + rectangleActor2.getWidth() - circleActor2.getWidth());
                    rectangleBgActor2.setWidth(300);
                    sVolumeValue.setText("100");

                }
            }



            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                super.touchUp(event, x, y, pointer, button);
                if (circleActor2.getX() <= rectangleActor2.getX()){
                    circleActor2.setX(rectangleActor2.getX());
                }
                if (circleActor2.getX() >=  rectangleActor2.getX() + rectangleActor2.getWidth() - circleActor2.getWidth()){
                    circleActor2.setX( rectangleActor2.getX() + rectangleActor2.getWidth() - circleActor2.getWidth());
                }
                //rectangleBgActor.setWidth(circleActor.getX() - 294 + circleActor.getWidth());
                //System.out.println(Math.round(circleActor.getX() + circleActor.getWidth() - 294)/3);
            }
        });

        rectangleBgActor2.addListener(new ClickListener(){
            @Override
            public void touchDragged(InputEvent event, float x, float y, int pointer) {
                super.touchDragged(event, x, y, pointer);
                if (circleActor2.getX() >= rectangleActor2.getX() && circleActor2.getX() <=  rectangleActor2.getX() + rectangleActor2.getWidth() - circleActor2.getWidth()) {
                    circleActor2.setX(rectangleActor2.getX() + x - circleActor2.getWidth() / 2);
                    rectangleBgActor2.setWidth(circleActor2.getX() - rectangleActor2.getX() + circleActor.getWidth());
                    sVolumeValue.setText(Math.round(circleActor2.getX() + circleActor2.getWidth() -rectangleActor2.getX())/3);
                }
                if (circleActor2.getX() < rectangleActor2.getX()){
                    circleActor2.setX(rectangleActor2.getX());
                    rectangleBgActor2.setWidth(circleActor2.getWidth());
                    sVolumeValue.setText("0");
                }
                if (circleActor2.getX() >  rectangleActor2.getX() + rectangleActor2.getWidth() - circleActor2.getWidth()){
                    circleActor2.setX( rectangleActor2.getX() + rectangleActor2.getWidth() - circleActor2.getWidth());
                    rectangleBgActor2.setWidth(300);
                    sVolumeValue.setText("100");

                }
            }



            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                super.touchUp(event, x, y, pointer, button);
                if (circleActor2.getX() <= rectangleActor2.getX()){
                    circleActor2.setX(rectangleActor2.getX());
                }
                if (circleActor2.getX() >=  rectangleActor2.getX() + rectangleActor2.getWidth() - circleActor2.getWidth()){
                    circleActor2.setX( rectangleActor2.getX() + rectangleActor2.getWidth() - circleActor2.getWidth());
                }
                rectangleBgActor2.setWidth(circleActor2.getX() - rectangleActor2.getX() + circleActor2.getWidth());
            }
        });


        soundActor = new SoundActor(game);
        soundActor.setSize(50,50);
        soundActor.setPosition(rectangleActor2.getX(), rectangleActor2.getY() - soundActor.getHeight() - 25 );
        addActor(soundActor);
        if (variables.getIsFirstTime() == false && variables.getIsMuted() == false){
            tickActor3 = new TickActor2(game,soundActor.getX(),soundActor.getY());
            addActor(tickActor3);
        }
        soundActor.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                variables.setIsMuted(false);
                for (Actor a : getActors()) {
                    if (a instanceof TickActor2) {
                        a.remove();
                    }
                }
                tickActor3 = new TickActor2(game,soundActor.getX(),soundActor.getY());
                addActor(tickActor3);
            }
        });
        soundOffActor = new SoundOffActor(game);
        soundOffActor.setSize(50,50);
        soundOffActor.setPosition(rectangleActor2.getX() + rectangleActor2.getWidth() - soundOffActor.getWidth() , rectangleActor2.getY() - soundOffActor.getHeight() - 25 );
        addActor(soundOffActor);
        if (variables.getIsFirstTime() == false && variables.getIsMuted() == true){
            tickActor4 = new TickActor2(game,soundOffActor.getX(),soundOffActor.getY());
            addActor(tickActor4);
        }
        soundOffActor.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                variables.setIsMuted(true);
                for (Actor a : getActors()) {
                    if (a instanceof TickActor2) {
                        a.remove();
                    }
                }
                tickActor4 = new TickActor2(game,soundOffActor.getX(),soundOffActor.getY());
                addActor(tickActor4);
            }
        });

        settingsSaveButton = new SettingsSaveButton(game);
        addActor(settingsSaveButton);
        settingsSaveButton.setPositionCenter(25);
        settingsSaveButton.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                variables.setFirstTime(false);
                variables.setmVolume(Math.round(circleActor.getX() + circleActor.getWidth() - rectangleActor.getX())/3);
                variables.setsVolume(Math.round(circleActor2.getX() + circleActor2.getWidth() -rectangleActor2.getX())/3);
                game.setScreenWithPreloadAssets(MenuScreen.class, new LoadingStage(game));
            }
        });
        huActor = new HuActor(game);
        huActor.setSize(50,50);
        huActor.setPosition(rectangleActor2.getX(), soundActor.getY() - huActor.getHeight() - 25);
        addActor(huActor);
        if (!variables.getIsFirstTime() && variables.getLang().equals("hu")){
            tickActor = new TickActor(game,huActor.getX(),huActor.getY());
            addActor(tickActor);
        }
        huActor.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                variables.setLang("hu");
                for (Actor a : getActors()) {
                    if (a instanceof TickActor) {
                        a.remove();
                    }
                }
                tickActor = new TickActor(game,huActor.getX(),huActor.getY());
                addActor(tickActor);

            }
        });
        enActor = new EnActor(game);
        enActor.setSize(50,50);
        enActor.setPosition(rectangleActor2.getX() + rectangleActor2.getWidth() - enActor.getWidth(),soundActor.getY() - enActor.getHeight() - 25);
        addActor(enActor);
        if (!variables.getIsFirstTime() && variables.getLang().equals("en")){
            tickActor2 = new TickActor(game,enActor.getX(),enActor.getY());
            addActor(tickActor2);
        }
        enActor.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                variables.setLang("en");
                for (Actor a : getActors()) {
                    if (a instanceof TickActor) {
                        a.remove();
                    }
                }
                tickActor2 = new TickActor(game,enActor.getX(),enActor.getY());
                addActor(tickActor2);
            }
        });


    }
}
