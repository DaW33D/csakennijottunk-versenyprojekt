package hu.csanyzeg.master.Game;

import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.OneSpriteStaticActor;

public class HitBoxActor extends OneSpriteStaticActor {
    public HitBoxActor(MyGame game) {
        super(game, "badlogic.jpg");
        this.setSize(15,50);
        this.setVisible(false);
    }
}
