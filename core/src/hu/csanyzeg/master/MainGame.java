package hu.csanyzeg.master;

import com.badlogic.gdx.Gdx;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

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

        BufferedWriter outColF = null;
        String DIR = "Settings";
        String YOUR_FILE = "Settings/settings.txt";
        try {
            if(!Gdx.files.local(DIR).exists())
                Gdx.files.local(DIR).mkdirs();
            if(Gdx.files.local(YOUR_FILE).exists())
                Gdx.files.local(YOUR_FILE).delete();
            outColF = new BufferedWriter(new OutputStreamWriter(Gdx.files.local(YOUR_FILE).write(true)));
            outColF.write(variables.getStrLine());
        } catch (Throwable e) {
        } finally {
            try {
                if (outColF != null) outColF.close();

            } catch (IOException e) {
            }
        }

        if (variables.getIsFirstTime() == false) {
            setLoadingStage(new LoadingStage(this));
            setScreen(new MenuScreen(this));

        }else{
            setLoadingStage(new LoadingStage(this));
            setScreen(new SettingsScreen(this));
        }
    }
}
