package csakennijottunk.Starter;

import csakennijottunk.Menu.MenuScreen;
import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;

public class MainGame extends MyGame {
    public MainGame(boolean debug) {
        super(debug);
    }

    @Override
    public void onCreate() {
        this.setScreen(new MenuScreen(this));
    }


}
