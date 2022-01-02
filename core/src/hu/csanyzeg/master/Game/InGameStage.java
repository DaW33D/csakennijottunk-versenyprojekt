package hu.csanyzeg.master.Game;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.Viewport;

import java.util.Random;

import hu.csanyzeg.master.LoadingStage;
import hu.csanyzeg.master.Menu.LabelStyle;
import hu.csanyzeg.master.MyBaseClasses.Assets.AssetList;
import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.CameraTrackingToActors;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.MyStage;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.OneSpriteStaticActor;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.ResponseViewport;
import hu.csanyzeg.master.MyBaseClasses.SimpleWorld.SimpleOverlapsUtil;
import hu.csanyzeg.master.MyBaseClasses.Timers.IntervalTimer;
import hu.csanyzeg.master.MyBaseClasses.Timers.IntervalTimerListener;
import hu.csanyzeg.master.MyBaseClasses.Timers.OneTickTimer;
import hu.csanyzeg.master.MyBaseClasses.Timers.OneTickTimerListener;
import hu.csanyzeg.master.MyBaseClasses.UI.MyLabel;
import hu.csanyzeg.master.Pc.MonitorActor;
import hu.csanyzeg.master.Pc.PCActor;
import hu.csanyzeg.master.Pc.PCScreen;

public class InGameStage extends MyStage {
    PlayerActorIdle playerActorIdle;
    OneSpriteStaticActor actor;
    OneSpriteStaticActor actor2;
    OneSpriteStaticActor actor3;
    OneSpriteStaticActor actor4;
    ControllerActor controllerActor;
    HitBoxActor hitBoxActor;
    Time timeC;
    ShoesSelector shoesSelector;

    LabelStyle labelStyle;
    MyLabel secondLabel;
    MyLabel minutesLabel;
    HitBoxActor2 hitBoxActor2;
    WardrobeActor wardrobeActor;
    PCActor pcActor;
    BedActor bedActor;
    MyLabel hoursLabel;
    SleepActor sleepActor;
    public boolean isLeftPressed = false;
    public boolean isRightPressed = false;
    public boolean isTopPressed = false;
    public boolean isBottomPressed = false;
    int money;
    static int time = 0;
    MyLabel timeLabel;
    int day = 0;
    static AssetList assetList = new AssetList();

    static {
        assetList.addTexture("blank.png");
        assetList.addTexture("testbg.png");
        assetList.addFont("alegreyaregular.otf",20);
        assetList.add(PlayerActorIdle.assetList);
        assetList.add(ControllerActor.assetList);
        assetList.add(WardrobeActor.assetList);
        assetList.add(MonitorActor.assetList);
    }

    public Actor getActor(Class c) {
        for (Actor a : getActors()) {
            if (c.isInstance(a)) {
                return a;
            }
        }
        return null;
    }

    public InGameStage(MyGame game) {
        super(new ResponseViewport(500), game);
        addBackButtonScreenBackByStackPopListenerWithPreloadedAssets(new LoadingStage(game));
        //addActor(new OneSpriteStaticActor(game,"badlogic.jpg"));


        OneSpriteStaticActor oneSpriteStaticActor = new OneSpriteStaticActor(game,"testbg.png");
        oneSpriteStaticActor.setPosition(-200,-200);
        oneSpriteStaticActor.setSize(1800,1000);
        addActor(oneSpriteStaticActor);


        Level level = new Level(1, this);
        level.build();

        wardrobeActor = (WardrobeActor) getActor(WardrobeActor.class);
        pcActor = (PCActor) getActor(PCActor.class);
        pcActor.setSize(50,50);
        pcActor.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                game.setScreenWithPreloadAssets(PCScreen.class, new LoadingStage(game));
            }
        });
        for (Actor a : getActors()) {
            if (a instanceof WardrobeActor) {
                a.addListener(new ClickListener(){
                    @Override
                    public void clicked(InputEvent event, float x, float y) {
                        super.clicked(event, x, y);
                        game.setScreenWithPreloadAssets(WardrobeScreen.class, new LoadingStage(game));
                    }
                });

            }
        }

        timeC = new Time(this);
        hitBoxActor = (HitBoxActor) getActor(HitBoxActor.class);

        labelStyle = new LabelStyle(game.getMyAssetManager().getFont("alegreyaregular.otf"), Color.BLACK);
        minutesLabel = new MyLabel(game, "", labelStyle);
        minutesLabel.setPosition(250,100);
        addActor(minutesLabel);
        hoursLabel = new MyLabel(game, "", labelStyle);
        hoursLabel.setPosition(210,100);
        addActor(hoursLabel);


        controllerActor = new ControllerActor(game);
        controllerActor.setPosition(0,0);
        controllerActor.setSize(controllerActor.getWidth() * 1.5f, controllerActor.getHeight() * 1.5f);
        addActor(controllerActor);

        playerActorIdle = new PlayerActorIdle(game);
        addActor(playerActorIdle);
        playerActorIdle.setPositionCenterOfActorToCenterOfViewport();
        setCameraTracking(new CameraTrackingToActors());
        //((OrthographicCamera) getCamera()).zoom = 0.1f;
        ((CameraTrackingToActors) getCameraTracking()).addActor(playerActorIdle);
        ((CameraTrackingToActors) getCameraTracking()).marginLeft = 0.42f;
        ((CameraTrackingToActors) getCameraTracking()).marginRight = 0.5f;
        //((CameraTrackingToActors) getCameraTracking()).zoomSpeed = 0.05f;

        timeLabel = new MyLabel(game, "",labelStyle);
        timeLabel.setPosition(250,100);
        addActor(timeLabel);


        shoesSelector = new ShoesSelector(this);

        sleepActor = new SleepActor(game);
        sleepActor.setPosition(0,0);
        sleepActor.setSize(getCamera().viewportWidth, getCamera().viewportHeight);

        bedActor = (BedActor) getActor(BedActor.class);
        for (Actor a : getActors()) {
            if (a instanceof BedActor) {
                a.addListener(new ClickListener(){
                    @Override
                    public void clicked(InputEvent event, float x, float y) {
                        super.clicked(event, x, y);
                        addActor(sleepActor);
                        addTimer(new IntervalTimer(5, new IntervalTimerListener()){

                            @Override
                            public void stop() {
                                super.stop();
                                sleepActor.remove();
                            }
                        });
                    }
                });

            }
        }

//        hitBoxActor2 = new HitBoxActor2(game);
//        hitBoxActor2.setPosition(750,350);
//        addActor(hitBoxActor2);
//        if (playerActorIdle.getX() > 650 && playerActorIdle.getY() > 300) {
//            hitBoxActor2.addListener(new ClickListener() {
//                @Override
//                public void clicked(InputEvent event, float x, float y) {
//                    super.clicked(event, x, y);
//                    game.setScreenWithPreloadAssets(PCScreen.class, new LoadingStage(game));
//                }
//
//            });
//        }

        actor = new OneSpriteStaticActor(game, "blank.png");
        addActor(actor);
        actor.setSize(25 * 1.5f,35 * 1.5f);
        actor.setPosition((float) ((controllerActor.getWidth() / 2) - actor.getWidth()/2), 10);
        actor.addListener(new ClickListener(){
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                System.out.println("KATT LE");
                isBottomPressed = true;
                return true;
            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                super.touchUp(event, x, y, pointer, button);
                isBottomPressed = false;
                System.out.println("KATT FEL");
            }
        });

        actor2 = new OneSpriteStaticActor(game, "blank.png");
        addActor(actor2);
        actor2.setPosition((float) ((controllerActor.getWidth() / 2) - 12.5), 75);
        actor2.setSize(25 * 1.5f,35 * 1.5f);
        actor2.addListener(new ClickListener(){
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                System.out.println("KATT LE");
                isTopPressed = true;
                return true;
            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                super.touchUp(event, x, y, pointer, button);
                isTopPressed = false;
                System.out.println("KATT FEL");
            }
        });

        actor3 = new OneSpriteStaticActor(game, "blank.png");
        addActor(actor3);
        actor3.setPosition(10, 48);
        actor3.setSize(35 * 1.5f,25 * 1.5f);
        actor3.addListener(new ClickListener(){
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                System.out.println("KATT LE");
                isLeftPressed = true;
                return true;
            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                super.touchUp(event, x, y, pointer, button);
                isLeftPressed = false;
                System.out.println("KATT FEL");
            }
        });

        actor4 = new OneSpriteStaticActor(game, "blank.png");
        addActor(actor4);
        actor4.setPosition(75, 48);
        actor4.setSize(35 * 1.5f,25 * 1.5f);
        actor4.addListener(new ClickListener(){
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                System.out.println("KATT LE");
                isRightPressed = true;
                return true;
            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                super.touchUp(event, x, y, pointer, button);
                isRightPressed = false;
                System.out.println("KATT FEL");
            }
        });




    }

    @Override
    public void act(float delta) {
        super.act(delta);

        timeC.count(true);
        timeLabel.setText(timeC.toString());
        controllerActor.setPosition(playerActorIdle.getX() - getCamera().viewportWidth * 0.42f, playerActorIdle.getY() - getCamera().viewportHeight * 0.2f);
        actor.setPosition((float) (playerActorIdle.getX() - getCamera().viewportWidth * 0.42f+((controllerActor.getWidth() / 2) - actor.getWidth()/2)), playerActorIdle.getY() - getCamera().viewportHeight * 0.2f + 10 * 1.5f);
        actor2.setPosition((float) (playerActorIdle.getX() - getCamera().viewportWidth * 0.42f+((controllerActor.getWidth() / 2) - actor2.getWidth()/2)), playerActorIdle.getY() - getCamera().viewportHeight * 0.2f +75*1.5f);
        actor3.setPosition(playerActorIdle.getX() - getCamera().viewportWidth * 0.42f+10*1.5f, playerActorIdle.getY() - getCamera().viewportHeight * 0.2f + 48*1.5f);
        actor4.setPosition(playerActorIdle.getX() - getCamera().viewportWidth * 0.42f+75*1.5f, playerActorIdle.getY() - getCamera().viewportHeight * 0.2f +48*1.5f);


        if (isBottomPressed == true) {
            playerActorIdle.setPosition(playerActorIdle.getX(), playerActorIdle.getY() - 1);
        }
        if (isTopPressed == true) {
            playerActorIdle.setPosition(playerActorIdle.getX(), playerActorIdle.getY() + 1);
        }
        if (isLeftPressed == true) {
            playerActorIdle.setPosition(playerActorIdle.getX() - 1, playerActorIdle.getY());
        }
        if (isRightPressed == true) {
            playerActorIdle.setPosition(playerActorIdle.getX() + 1, playerActorIdle.getY());
        }




        for (Actor a : getActors()) {
            if (a instanceof HitBoxActor) {
                if (SimpleOverlapsUtil.overlaps(a, playerActorIdle)) {
                    if (a.getWidth() == 10 && playerActorIdle.getX() <= getCamera().viewportWidth /2){
                        if (a.getWidth() == 10 && playerActorIdle.getX() > 185 &&  playerActorIdle.getX() <= 210){
                            playerActorIdle.setX(playerActorIdle.getX() - 5);
                        }else {
                            playerActorIdle.setX(playerActorIdle.getX() + 5);
                        }
                    }
                    if (a.getWidth() == 10 && playerActorIdle.getX() > getCamera().viewportWidth /2){
                        playerActorIdle.setX(playerActorIdle.getX() - 5);
                    }
                    if (a.getWidth() == 50 && playerActorIdle.getY() <= getCamera().viewportHeight /2){
                        playerActorIdle.setY(playerActorIdle.getY() + 5);
                    }
                    if (a.getWidth() == 50 && playerActorIdle.getY() > getCamera().viewportHeight/2){
                        playerActorIdle.setY(playerActorIdle.getY() - 5);
                    }
                }
            }
        }
        for (Actor a : getActors()) {
            if (a instanceof HitBoxActor2) {
                if (SimpleOverlapsUtil.overlaps(a, playerActorIdle)) {
                    if (a.getWidth() == 50 && playerActorIdle.getX() <= getCamera().viewportWidth /2){
                        if (a.getWidth() == 50 && playerActorIdle.getX() == 750){
                            playerActorIdle.setX(playerActorIdle.getX() - 5);
                        }else {
                            playerActorIdle.setX(playerActorIdle.getX() + 5);
                        }
                    }
                    if (a.getWidth() == 50 && playerActorIdle.getX() > getCamera().viewportWidth /2){
                        playerActorIdle.setX(playerActorIdle.getX() - 5);
                    }

                    if (a.getWidth() == 50 && playerActorIdle.getY() > getCamera().viewportHeight/2){
                        playerActorIdle.setY(playerActorIdle.getY() - 5);
                    }
                }
            }
        }
    }
}
