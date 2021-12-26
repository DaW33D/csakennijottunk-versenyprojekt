package hu.csanyzeg.master.Game;

import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.OneSpriteStaticActor;

public class HitBoxActor2 extends OneSpriteStaticActor {
    public HitBoxActor2(MyGame game) {
        super(game, "blank.png");
        this.setSize(50,50);
    }
}
