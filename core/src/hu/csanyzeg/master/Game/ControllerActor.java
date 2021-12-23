package hu.csanyzeg.master.Game;

import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.OneSpriteStaticActor;

public class ControllerActor extends OneSpriteStaticActor {
    public ControllerActor(MyGame game) {
        super(game, "controller.png");
        this.setSize(120,120);
    }
}
