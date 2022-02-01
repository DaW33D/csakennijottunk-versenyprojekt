package hu.csanyzeg.master.Game;

import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.OneSpriteStaticActor;

public class LineActor extends OneSpriteStaticActor {
    public LineActor(MyGame game, float x,float  y) {
        super(game, "badlogic.jpg");
        setPosition(x,y);
        setSize(5,5);
    }
}
