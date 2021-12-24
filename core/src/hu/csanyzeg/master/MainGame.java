package hu.csanyzeg.master;

import hu.csanyzeg.master.Game.Variables;
import hu.csanyzeg.master.Menu.MenuScreen;
import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.Settings.SettingsScreen;

public class MainGame extends MyGame {
    Variables variables;
    public MainGame(boolean debug) {
        super(debug);
    }

    @Override
    public void onCreate() {
        variables = new Variables();
        setLoadingStage(new LoadingStage(this));
        if (variables.getIsFirstTime() == false) {
            setScreen(new MenuScreen(this));
        }else{
            setScreen(new SettingsScreen(this));
        }
    }
}
