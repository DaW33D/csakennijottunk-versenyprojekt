package hu.csanyzeg.master.Game;

import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

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
import hu.csanyzeg.master.MyBaseClasses.UI.MyLabel;
import hu.csanyzeg.master.Pc.MonitorActor;
import hu.csanyzeg.master.Pc.PCActor;
import hu.csanyzeg.master.Pc.PCScreen;

public class InGameStage extends MyStage {
    PlayerActorIdle playerActorIdle;

    HitBoxActor hitBoxActor;
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
    BedActor2 bedActor2;
    Variables variables;
    public boolean LeftPressed = false;
    public boolean RightPressed = false;

    public boolean isLeftPressed() {
        return LeftPressed;
    }

    public void setLeftPressed(boolean leftPressed) {
        LeftPressed = leftPressed;
    }

    public boolean isRightPressed() {
        return RightPressed;
    }

    public void setRightPressed(boolean rightPressed) {
        RightPressed = rightPressed;
    }

    public boolean isTopPressed() {
        return TopPressed;
    }

    public void setTopPressed(boolean topPressed) {
        TopPressed = topPressed;
    }

    public boolean isBottomPressed() {
        return BottomPressed;
    }

    public void setBottomPressed(boolean bottomPressed) {
        BottomPressed = bottomPressed;
    }

    public boolean TopPressed = false;
    public boolean BottomPressed = false;
    public boolean isLeftPressed = false;
    public boolean isRightPressed = false;
    public boolean isTopPressed = false;
    public boolean isBottomPressed = false;
    int money;
    static int time = 0;
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

        variables = new Variables();


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

        //timeC = new Time(this);
        hitBoxActor = (HitBoxActor) getActor(HitBoxActor.class);

        labelStyle = new LabelStyle(game.getMyAssetManager().getFont("alegreyaregular.otf"), Color.BLACK);
        minutesLabel = new MyLabel(game, "", labelStyle);
        minutesLabel.setPosition(250,100);
        addActor(minutesLabel);
        hoursLabel = new MyLabel(game, "", labelStyle);
        hoursLabel.setPosition(210,100);
        addActor(hoursLabel);



        playerActorIdle = new PlayerActorIdle(game);
        addActor(playerActorIdle);
        playerActorIdle.setPositionCenterOfActorToCenterOfViewport();
        setCameraTracking(new CameraTrackingToActors());
        //((OrthographicCamera) getCamera()).zoom = 0.1f;
        ((OrthographicCamera)getCamera()).zoom = 0.6f;
        ((CameraTrackingToActors) getCameraTracking()).addActor(playerActorIdle);
        //((CameraTrackingToActors) getCameraTracking()).marginLeft = 0.42f;
        //((CameraTrackingToActors) getCameraTracking()).marginRight = 0.5f;
        //((CameraTrackingToActors) getCameraTracking()).zoomSpeed = 0.05f;
        ((CameraTrackingToActors) getCameraTracking()).zoomMin = 0.8f;
        ((CameraTrackingToActors) getCameraTracking()).zoomSpeed =  0.01f;




        shoesSelector = new ShoesSelector(this);

        bedActor = (BedActor) getActor(BedActor.class);
        for (Actor a : getActors()) {
            if (a instanceof BedActor) {
                a.addListener(new ClickListener(){
                    @Override
                    public void clicked(InputEvent event, float x, float y) {
                        super.clicked(event, x, y);
                        game.setScreenWithPreloadAssets(BedScreen.class, new LoadingStage(game));
                    }
                });
            }
        }
        bedActor2 = (BedActor2) getActor(BedActor2.class);
        for (Actor a : getActors()) {
            if (a instanceof BedActor2) {
                a.addListener(new ClickListener(){
                    @Override
                    public void clicked(InputEvent event, float x, float y) {
                        super.clicked(event, x, y);
                        game.setScreenWithPreloadAssets(BedScreen.class, new LoadingStage(game));
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


    }


    @Override
    public void act(float delta) {
        super.act(delta);
        //timeLabel.setText(timeC.toString());
/*
        controllerActor.setPosition(playerActorIdle.getX() - getCamera().viewportWidth * 0.42f, playerActorIdle.getY() - getCamera().viewportHeight * 0.2f);
        actor.setPosition((float) (playerActorIdle.getX() - getCamera().viewportWidth * 0.42f+((controllerActor.getWidth() / 2) - actor.getWidth()/2)), playerActorIdle.getY() - getCamera().viewportHeight * 0.2f + 10 * 1.5f);
        actor2.setPosition((float) (playerActorIdle.getX() - getCamera().viewportWidth * 0.42f+((controllerActor.getWidth() / 2) - actor2.getWidth()/2)), playerActorIdle.getY() - getCamera().viewportHeight * 0.2f +75*1.5f);
        actor3.setPosition(playerActorIdle.getX() - getCamera().viewportWidth * 0.42f+10*1.5f, playerActorIdle.getY() - getCamera().viewportHeight * 0.2f + 48*1.5f);
        actor4.setPosition(playerActorIdle.getX() - getCamera().viewportWidth * 0.42f+75*1.5f, playerActorIdle.getY() - getCamera().viewportHeight * 0.2f +48*1.5f);
*/

        if (BottomPressed == true) {
            playerActorIdle.setPosition(playerActorIdle.getX(), playerActorIdle.getY() - 1);
            playerActorIdle.setRotation(180);
        }
        if (TopPressed == true) {
            playerActorIdle.setPosition(playerActorIdle.getX(), playerActorIdle.getY() + 1);
            playerActorIdle.setRotation(180);
        }
        if (LeftPressed == true) {
            playerActorIdle.setPosition(playerActorIdle.getX() - 1, playerActorIdle.getY());
            playerActorIdle.setRotation(90);
        }
        if (RightPressed == true) {
            playerActorIdle.setPosition(playerActorIdle.getX() + 1, playerActorIdle.getY());
            playerActorIdle.setRotation(90);
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
                        if (a.getWidth() == 50 && playerActorIdle.getX() <= 185 && playerActorIdle.getY() > 200){
                                playerActorIdle.setX(playerActorIdle.getX() + 5);
                        }
                        else{
                            playerActorIdle.setY(playerActorIdle.getY() + 5);
                        }
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
