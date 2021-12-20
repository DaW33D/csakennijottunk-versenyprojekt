package hu.csanyzeg.master.Game;

import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.OneSpriteStaticActor;

public class EmptyWardrobeActor extends OneSpriteStaticActor {
    public EmptyWardrobeActor(MyGame game) {
        super(game, "emptywardrobe.jpg");
        this.setSize(900, 500);
    }
}
