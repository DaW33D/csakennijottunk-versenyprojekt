package hu.csanyzeg.master;

import hu.csanyzeg.master.Menu.MenuScreen;
import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;

public class MainGame extends MyGame {
    public MainGame(boolean debug) {
        super(debug);
    }

    @Override
    public void onCreate() {
        setLoadingStage(new LoadingStage(this));
        setScreen(new MenuScreen(this));
    }
}
