package csakennijottunk.Game;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

import com.badlogic.gdx.Game;

import hu.csanyzeg.master.MyBaseClasses.Assets.AssetList;
import csakennijottunk.Game.GameActors;
import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.MyScreen;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.MyStage;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.ResponseViewport;

public class GameStage extends MyStage {
    static AssetList assetList = new AssetList();
    static {
        assetList.add(GameActors.assetList);
    }
    Gyik gyik;
    GameActors gameActors;
    SettingsButtonActor settingsButtonActor;
    public GameStage(MyGame game) {
        super(new ResponseViewport(500), game);
        gameActors = new GameActors(game);
        addActor(gameActors);
        gyik = new Gyik(game);
        gyik.setPosition(getCamera().viewportWidth / 2, getCamera().viewportHeight / 2);
        gyik.setSize(40,40);
        addActor(gyik);
        gyik.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                getScreen().addStage(new GyikStage(game), 1, true);
                System.out.println("mukodiiiikk");
            }
        });
        settingsButtonActor = new SettingsButtonActor(game);
        settingsButtonActor.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                getScreen().addStage(new SettingsStage(game), 1, true);
            }
        });
        addActor(settingsButtonActor);

    }
}
