package hu.csanyzeg.master.Game;

import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.OneSpriteStaticActor;

public class WallBottomActor extends OneSpriteStaticActor {
    public WallBottomActor(MyGame game) {
        super(game, "wall-bottom.png");
        this.setSize(50,50);
    }
}
