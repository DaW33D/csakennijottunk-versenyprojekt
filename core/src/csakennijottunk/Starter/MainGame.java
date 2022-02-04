package csakennijottunk.Starter;

import csakennijottunk.Menu.GameScreen;
import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import csakennijottunk.Credit.CreditScreen;

public class MainGame extends MyGame {
    public MainGame(boolean debug) {
        super(debug);
    }

    @Override
    public void onCreate() {
        this.setScreen(new CreditScreen(this));
    }


}
