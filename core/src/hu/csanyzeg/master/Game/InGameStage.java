package hu.csanyzeg.master.Game;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.Viewport;

import hu.csanyzeg.master.LoadingStage;
import hu.csanyzeg.master.Menu.LabelStyle;
import hu.csanyzeg.master.MyBaseClasses.Assets.AssetList;
import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.CameraTrackingToActors;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.MyStage;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.OneSpriteStaticActor;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.ResponseViewport;
import hu.csanyzeg.master.MyBaseClasses.SimpleWorld.SimpleOverlapsUtil;
import hu.csanyzeg.master.MyBaseClasses.UI.MyLabel;
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
    public boolean isLeftPressed = false;
    public boolean isRightPressed = false;
    public boolean isTopPressed = false;
    public boolean isBottomPressed = false;
    LabelStyle labelStyle;
    MyLabel secondLabel;
    MyLabel minutesLabel;
    WardrobeActor wardrobeActor;
    PCActor pcActor;
    MyLabel hoursLabel;
    int money;
    static int time = 0;
    MyLabel timeLabel;
    int day = 0;
    static AssetList assetList = new AssetList();

    static {
        assetList.addTexture("blank.png");
        assetList.addFont("alegreyaregular.otf",20);
        assetList.add(PlayerActorIdle.assetList);
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



        Level level = new Level(1, this);
        level.build();

        wardrobeActor = (WardrobeActor) getActor(WardrobeActor.class);
        pcActor = (PCActor) getActor(PCActor.class);
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

        timeC = new Time();
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
        CameraTrackingToActors cameraTrackingToActors = new CameraTrackingToActors();
        cameraTrackingToActors.addActor(playerActorIdle);

        timeLabel = new MyLabel(game, "",labelStyle);
        timeLabel.setPosition(250,100);
        addActor(timeLabel);

        controllerActor = new ControllerActor(game);
        controllerActor.setPosition(0,0);
        addActor(controllerActor);

        actor = new OneSpriteStaticActor(game, "blank.png");
        addActor(actor);
        actor.setPosition((float) ((controllerActor.getWidth() / 2) - 12.5), 10);
        actor.setSize(25,35);
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
        actor2.setSize(25,35);
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
        actor3.setSize(35,25);
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
        actor4.setSize(35,25);
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
//        time = time + 1;
//        minutesLabel.setText((time / 60) % 60);
//        if ((time / 3600) % 24 < 10){
//            hoursLabel.setText("0" + (time / 3600) % 24 + ": ");
//
//        }
//        else{
//            hoursLabel.setText((time / 3600) % 24);
//        }

        timeC.count(true);
        timeLabel.setText(timeC.toString());


        if (isBottomPressed == true){
            playerActorIdle.setPosition(playerActorIdle.getX(),playerActorIdle.getY() - 1);
        }
        if (isTopPressed == true){
            playerActorIdle.setPosition(playerActorIdle.getX(),playerActorIdle.getY() + 1);
        }
        if (isLeftPressed == true){
            playerActorIdle.setPosition(playerActorIdle.getX() - 1, playerActorIdle.getY());
        }
        if (isRightPressed == true){
            playerActorIdle.setPosition(playerActorIdle.getX() + 1,playerActorIdle.getY());
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
    }
}
