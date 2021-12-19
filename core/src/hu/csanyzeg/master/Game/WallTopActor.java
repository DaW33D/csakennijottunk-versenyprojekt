package hu.csanyzeg.master.Game;

import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.OneSpriteStaticActor;

public class WallTopActor extends OneSpriteStaticActor {
    public WallTopActor(MyGame game) {
        super(game, "wall-top.png");
        this.setSize(50,50);
    }
}
