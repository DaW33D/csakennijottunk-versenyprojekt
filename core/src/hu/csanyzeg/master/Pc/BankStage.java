package hu.csanyzeg.master.Pc;

import com.badlogic.gdx.utils.viewport.Viewport;

import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.MyStage;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.ResponseViewport;

public class BankStage extends MyStage {
    int money = 0;
    public BankStage(MyGame game) {
        super(new ResponseViewport(500), game);
        money = money + 1;
    }
}
