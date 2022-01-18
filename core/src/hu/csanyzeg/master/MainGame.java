package hu.csanyzeg.master;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.utils.Array;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

import hu.csanyzeg.master.Game.ShoeActor;
import hu.csanyzeg.master.Game.ShoeInstance;
import hu.csanyzeg.master.Game.Shoes;
import hu.csanyzeg.master.Game.Time;
import hu.csanyzeg.master.Game.Variables;
import hu.csanyzeg.master.Menu.MenuScreen;
import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Timers.TickTimer;
import hu.csanyzeg.master.MyBaseClasses.Timers.TickTimerListener;
import hu.csanyzeg.master.MyBaseClasses.Timers.Timer;
import hu.csanyzeg.master.Settings.SettingsScreen;

public class MainGame extends MyGame {
    Variables variables;
    public Shoes shoes;
    public final Array<ShoeInstance> aVilagOsszesCipoje = new Array<>();

    public Time gameTime;

    private TickTimer megyazidoTimer = new TickTimer(0.1f, true, gameTime = new Time(this));


    public void stopTime(){
        megyazidoTimer.stop();
    }

    public void startTime(){
        megyazidoTimer.start();
    }

    public MainGame(boolean debug) {
        super(debug);
    }

    @Override
    public void onCreate() {
        variables = new Variables();

        //Betöltjük a legyártható cipőket. Ez ide való!
        shoes = new Shoes();

        addTimer(megyazidoTimer);


        // Ezek meg a játék folyamatába valók...

        //Meggyártunk egy cipőt.
        for(int i = 0; i< 10; i++){
            aVilagOsszesCipoje.add(new ShoeInstance(shoes.getShoeFajta(i % shoes.getCountOfShoeFajta()), ShoeInstance.Cipohelye.JofogasonMegveheto));

        }

        aVilagOsszesCipoje.get(3).cipohelye = ShoeInstance.Cipohelye.SzekrenybenNemMeghirdetett;
        //new ShoeActor(this, aVilagOsszesCipoje.get(2));


        //aVilagOsszesCipoje.get(5).cipohelye = ShoeInstance.Cipohelye.SzekrenybenNemMeghirdetett;
        aVilagOsszesCipoje.get(5).cipohelye = ShoeInstance.Cipohelye.JofogasonMeghirdetettSzekrenybenlevo;


        // Vásárlás idején ennyibe került - átlagár
        System.out.println(aVilagOsszesCipoje.get(5).price - aVilagOsszesCipoje.get(5).base.price);

        shoes.generateNewPrice();
        shoes.generateNewPrice();
        shoes.generateNewPrice();

        // Vásárlás idején ennyibe került - átlagár
        System.out.println(aVilagOsszesCipoje.get(5).price - aVilagOsszesCipoje.get(5).base.price);

        // Később legyártunk egy új cipőt. Ennek a megváltozatott átlagárat kapja.
        aVilagOsszesCipoje.add(new ShoeInstance(shoes.getShoeFajta(2), ShoeInstance.Cipohelye.SzekrenybenNemMeghirdetett));

        //System.out.println(aVilagOsszesCipoje);

        if (variables.getIsFirstTime() == false) {
            setLoadingStage(new LoadingStage(this));
            setScreen(new MenuScreen(this));

        }else{
            setLoadingStage(new LoadingStage(this));
            setScreen(new SettingsScreen(this));
        }
    }
}
