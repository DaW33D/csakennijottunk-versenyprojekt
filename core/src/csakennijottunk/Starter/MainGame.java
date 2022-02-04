package csakennijottunk.Starter;

import com.badlogic.gdx.audio.Music;

import com.badlogic.gdx.utils.Array;

import csakennijottunk.Game.FajInstance;
import csakennijottunk.Game.Fajok;
import csakennijottunk.Game.GameScreen;
import hu.csanyzeg.master.MyBaseClasses.Assets.AssetList;
import hu.csanyzeg.master.MyBaseClasses.Assets.MyAssetManager;
import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Timers.TickTimer;
import hu.csanyzeg.master.MyBaseClasses.Timers.TickTimerListener;
import hu.csanyzeg.master.MyBaseClasses.Timers.Timer;

public class MainGame extends MyGame {
    public static Music music;
    Fajok fajok;
    public Fajok.Faj majom;
    public Fajok.Faj dino;
    public Fajok.Faj gyik;
    public Fajok.Faj horcsog;
    public Fajok.Faj[] fajLista;
    public Array<FajInstance> aliveEvolution = new Array<>();
    public MainGame(boolean debug) {
        super(debug);


    }

    public MyAssetManager getMyAssetManager() {
        return super.getMyAssetManager();
    }

    @Override
    public void onCreate() {
        //Létrehozzuk a fajokat
        fajok = new Fajok();
        //Tároljuk egy listába a gamebe
        fajLista = fajok.fajok;
        gyik = fajLista[0];
        dino = fajLista[1];
        majom = fajLista[2];
        horcsog = fajLista[3];
        //Élő példányok
        aliveEvolution.add(new FajInstance(gyik));
        aliveEvolution.add(new FajInstance(majom));
        music = getMyAssetManager().getMusic("hasznaltkepek/song.mp3");
        music.play();
        this.setScreen(new GameScreen(this));
        addTimer(new TickTimer(2,true,new TickTimerListener(){
            @Override
            public void onTick(Timer sender, float correction) {
                super.onTick(sender, correction);
                for (FajInstance f : aliveEvolution){
                    f.evolution += 0.01;
                    f.hungerLvl -= 0.01;
                    f.thirstLvl -= 0.01;
                    System.out.println(f.evolution);
                }
            }
        }));
    }

}
