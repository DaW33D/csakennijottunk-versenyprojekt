package hu.csanyzeg.master;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.utils.Array;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.io.StringBufferInputStream;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import hu.csanyzeg.master.Game.ShoeActor;
import hu.csanyzeg.master.Game.ShoeInstance;
import hu.csanyzeg.master.Game.Shoes;
import hu.csanyzeg.master.Game.Time;
import hu.csanyzeg.master.Game.Variables;
import hu.csanyzeg.master.Menu.MenuScreen;
import hu.csanyzeg.master.MyBaseClasses.Assets.MyAssetManager;
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
    public static Music music;

    @Override
    public MyAssetManager getMyAssetManager() {
        return super.getMyAssetManager();
    }

    private TickTimer megyazidoTimer = new TickTimer(1, true, gameTime = new Time(this));


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
        music = getMyAssetManager().getMusic("song.mp3");
        addTimer(megyazidoTimer);



        // Ezek meg a játék folyamatába valók...

        //Meggyártunk egy cipőt.
//        for(int i = 0; i< 10; i++){
//            aVilagOsszesCipoje.add(new ShoeInstance(shoes.getShoeFajta(i % shoes.getCountOfShoeFajta()), ShoeInstance.Cipohelye.JofogasonMegveheto));
//
//        }

//        aVilagOsszesCipoje.get(3).cipohelye = ShoeInstance.Cipohelye.SzekrenybenNemMeghirdetett;
//        //new ShoeActor(this, aVilagOsszesCipoje.get(2));
//
//
//        //aVilagOsszesCipoje.get(5).cipohelye = ShoeInstance.Cipohelye.SzekrenybenNemMeghirdetett;
//        aVilagOsszesCipoje.get(5).cipohelye = ShoeInstance.Cipohelye.JofogasonMeghirdetettSzekrenybenlevo;
//
//
//        // Vásárlás idején ennyibe került - átlagár
//        System.out.println(aVilagOsszesCipoje.get(5).price - aVilagOsszesCipoje.get(5).base.price);
//
//        // Vásárlás idején ennyibe került - átlagár
//        System.out.println(aVilagOsszesCipoje.get(5).price - aVilagOsszesCipoje.get(5).base.price);

        // Később legyártunk egy új cipőt. Ennek a megváltozatott átlagárat kapja.
        // aVilagOsszesCipoje.add(new ShoeInstance(shoes.getShoeFajta(2), ShoeInstance.Cipohelye.SzekrenybenNemMeghirdetett));

        //System.out.println(aVilagOsszesCipoje);

        if (variables.getIsFirstTime() == false) {
            setLoadingStage(new LoadingStage(this));
            setScreen(new MenuScreen(this));

        }else{
            setLoadingStage(new LoadingStage(this));
            setScreen(new SettingsScreen(this));
        }

        //A betöltött legyártható cípőket beállítja a mentés alapján, és feltölti a világ összes cipőjét.
        load();
    }


    public static String PREFS = "hu.csanyzeg.master.sneakers";

    public void save() {
        System.out.println("SAVE SAVE SAVE SAVE SAVE");
        Preferences p = Gdx.app.getPreferences(PREFS);
        p.clear();
        int x = 0;
        for (ShoeInstance s : aVilagOsszesCipoje){
            p.putString("avilagosszescipoje_" + x, s.toString());
            x++;
        }

        x = 0;
        for(Shoes.ShoeFajta s : shoes.shoes){
            p.putString("shoes_" + x, s.toString());
            x++;
        }

        p.flush();
    }

    public void load(){
        System.out.println("LOAD LOAD LOAD LOAD LOAD LOAD LOAD");
        Preferences p = Gdx.app.getPreferences(PREFS);
        try {
            int x = 0;
            while (p.get().containsKey("shoes_" + x)) {
                HashMap<String, String> m = new HashMap<>();
                for (String s : p.getString("shoes_" + x).split("; ")) {
                    m.put(s.split("=")[0].trim(), s.split("=")[1].trim().replace("'", ""));
                }
                Shoes.ShoeFajta shoeFajta = shoes.getShoeFajta(m.get("name"));
                if (shoeFajta != null) {
                    shoeFajta.price = Float.parseFloat(m.get("price"));
                    shoeFajta.arfolyamDiagram.clear();
                    String[] arfolyam = m.get("arfolyam").substring(1, m.get("arfolyam").length() - 2).split(",");
                    for (String s : arfolyam) {
                        shoeFajta.arfolyamDiagram.add(Float.parseFloat(s.trim()));
                    }
                }
                System.out.println("   LOAD: " + m);
                x++;
            }
            x = 0;
            while (p.get().containsKey("avilagosszescipoje_" + x)) {
                HashMap<String, String> m = new HashMap<>();
                for (String s : p.getString("avilagosszescipoje_" + x).split("; ")) {
                    m.put(s.split("=")[0].trim(), s.split("=")[1].trim().replace("'", ""));
                }

                aVilagOsszesCipoje.add(new ShoeInstance(
                        shoes.getShoeFajta(m.get("base")),
                        Float.parseFloat(m.get("price")),
                        Float.parseFloat(m.get("sellprice")),
                        Color.valueOf(m.get("color")),
                        ShoeInstance.Cipohelye.valueOf(m.get("cipohelye"))));

                //public ShoeInstance(Shoes.ShoeFajta base, float price, float sellprice, Color color, Cipohelye cipohelye) {
                System.out.println("   LOAD: " + m);
                x++;
            }
        }
        catch (Exception e){
            System.out.println("-------------- LOAD ERROR ---------------");
            System.out.println(" hu.csanyzeg.master.sneakers clear()");
            System.out.println("-------------- LOAD ERROR ---------------");
            p.clear();
        }
        if (aVilagOsszesCipoje.size == 0){
            System.out.println("-------------- Kezdeti Random értékek generálása ---------------");
            gameTime.sleep(2000);
        }
    }

    public Music getMusic(){
        return music;
    }

    @Override
    public void dispose() {
        super.dispose();
        save();
    }
}
