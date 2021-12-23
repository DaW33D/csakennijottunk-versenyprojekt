package hu.csanyzeg.master.Game;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.Viewport;

import hu.csanyzeg.master.LoadingStage;
import hu.csanyzeg.master.MyBaseClasses.Assets.AssetList;
import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.CameraTrackingToActors;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.MyStage;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.OneSpriteStaticActor;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.ResponseViewport;

public class InGameStage extends MyStage {
    PlayerActorIdle playerActorIdle;
    OneSpriteStaticActor actor;
    OneSpriteStaticActor actor2;
    OneSpriteStaticActor actor3;
    OneSpriteStaticActor actor4;
    ControllerActor controllerActor;
    public boolean isLeftPressed = false;
    public boolean isRightPressed = false;
    public boolean isTopPressed = false;
    public boolean isBottomPressed = false;
    static AssetList assetList = new AssetList();

    static {
        assetList.addTexture("blank.png");
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

        playerActorIdle = new PlayerActorIdle(game);
        addActor(playerActorIdle);
        playerActorIdle.setPositionCenterOfActorToCenterOfViewport();
        CameraTrackingToActors cameraTrackingToActors = new CameraTrackingToActors();
        cameraTrackingToActors.addActor(playerActorIdle);

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
    }
}
