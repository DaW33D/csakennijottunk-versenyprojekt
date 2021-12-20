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
    static AssetList assetList = new AssetList();

    static {
        assetList.addTexture("badlogic.jpg");
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
        CameraTrackingToActors cameraTrackingToActors = new CameraTrackingToActors();
        cameraTrackingToActors.addActor(playerActorIdle);
        actor = new OneSpriteStaticActor(game, "badlogic.jpg");
        addActor(actor);
        actor.setSize(50, 50);
        actor.setPosition(60, 0);


        OneSpriteStaticActor actor2 = new OneSpriteStaticActor(game, "badlogic.jpg");
        addActor(actor2);
        actor2.setSize(50, 50);
        actor2.setPosition(60, 120);

        OneSpriteStaticActor actor3 = new OneSpriteStaticActor(game, "badlogic.jpg");
        addActor(actor3);
        actor3.setSize(50, 50);
        actor3.setPosition(0, 60);

        OneSpriteStaticActor actor4 = new OneSpriteStaticActor(game, "badlogic.jpg");
        addActor(actor4);
        actor4.setSize(50, 50);
        actor4.setPosition(120, 60);


    }

    @Override
    public void act(float delta) {
        super.act(delta);

    }
}
