package hu.csanyzeg.master.Game;

import com.badlogic.gdx.utils.viewport.Viewport;

import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.MyStage;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.ResponseViewport;

public class CutSceneStage extends MyStage {
    public CutSceneStage(MyGame game) {
        super(new ResponseViewport(500), game);
    }
}
