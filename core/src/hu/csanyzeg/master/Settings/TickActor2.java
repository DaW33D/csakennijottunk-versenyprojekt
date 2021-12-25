package hu.csanyzeg.master.Settings;

import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.OneSpriteStaticActor;

public class TickActor2 extends OneSpriteStaticActor {
    public TickActor2(MyGame game,float x, float y) {
        super(game, "tick.png");
        this.setSize(50,50);
        this.setPosition(x,y);
    }
}
