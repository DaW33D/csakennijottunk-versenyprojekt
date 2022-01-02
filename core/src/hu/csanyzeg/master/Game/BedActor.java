package hu.csanyzeg.master.Game;

import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.OneSpriteStaticActor;

public class BedActor extends OneSpriteStaticActor {
    public BedActor(MyGame game) {
        super(game, "green.png");
        this.setSize(50,50);
    }
}
