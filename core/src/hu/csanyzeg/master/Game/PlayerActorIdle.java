package hu.csanyzeg.master.Game;

import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.OneSpriteAnimatedActor;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.OneSpriteStaticActor;

public class PlayerActorIdle extends OneSpriteStaticActor {
    public PlayerActorIdle(MyGame game) {
        super(game, "badlogic.jpg");
        this.setSize(50,50);
        this.setPositionCenterOfActorToCenterOfViewport();
    }
}
