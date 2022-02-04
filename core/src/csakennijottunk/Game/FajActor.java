package csakennijottunk.Game;

import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.OneSpriteStaticActor;

public class FajActor extends OneSpriteStaticActor {
    public FajActor(MyGame game, Fajok.Faj base,float x, float y) {
        super(game, base.image);
        setSize(75,75);
        setPosition(x,y);
    }
}
