package hu.csanyzeg.master.Game;

import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.OneSpriteStaticActor;

public class BedActor2 extends OneSpriteStaticActor {
    public BedActor2(MyGame game) {
        super(game, "bed2.png");
        this.setSize(50,50);
        this.setRotation(180);
    }
}
