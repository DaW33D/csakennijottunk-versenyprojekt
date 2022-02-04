package csakennijottunk.Starter;

import com.badlogic.gdx.audio.Music;

import com.badlogic.gdx.utils.Array;

import csakennijottunk.Game.FajInstance;
import csakennijottunk.Game.Fajok;
import csakennijottunk.Game.GameScreen;
import hu.csanyzeg.master.MyBaseClasses.Assets.AssetList;
import hu.csanyzeg.master.MyBaseClasses.Assets.MyAssetManager;
import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;

public class MainGame extends MyGame {
    static Music music;
    static boolean isPlaying = true;
    Fajok fajok;
    public Fajok.Faj majom;
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
        fajLista[0] = majom;
        //Élő példányok
        aliveEvolution.add(new FajInstance(majom));
        this.setScreen(new GameScreen(this));
        music = getMyAssetManager().getMusic("hasznaltkepek/song.mp3");
        music.play();
    }

}
