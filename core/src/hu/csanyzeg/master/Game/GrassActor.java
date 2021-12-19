package hu.csanyzeg.master.Game;

import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.OneSpriteStaticActor;

public class GrassActor extends OneSpriteStaticActor {
    public GrassActor(MyGame game) {
        super(game, "grass.png");
        this.setSize(50,50);
    }
}
