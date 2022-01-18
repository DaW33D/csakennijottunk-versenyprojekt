package hu.csanyzeg.master.Game;

import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.MyActor;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.OneSpriteStaticActor;

public class ShoeActor extends OneSpriteStaticActor {
    public ShoeInstance shoeInstance;

    public ShoeActor(MyGame game, ShoeInstance shoeInstance) {
        super(game, shoeInstance.base.picture);
        this.shoeInstance = shoeInstance;
        //setColor(shoeInstance.color);
    }

}
