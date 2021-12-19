package hu.csanyzeg.master.Game;

import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.OneSpriteStaticActor;

public class WallLeftActor extends OneSpriteStaticActor {
    public WallLeftActor(MyGame game) {
        super(game, "wall-left.png");
        this.setSize(50,50);
    }
}
