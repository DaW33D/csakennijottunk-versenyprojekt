package hu.csanyzeg.master.Pc;

import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.OneSpriteStaticActor;

public class MonitorActor extends OneSpriteStaticActor {
    public MonitorActor(MyGame game) {
        super(game, "monitor.png");
        this.setSize(900,500);
    }
}
