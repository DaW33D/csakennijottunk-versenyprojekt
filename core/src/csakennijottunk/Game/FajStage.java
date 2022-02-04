package csakennijottunk.Game;

import com.badlogic.gdx.utils.viewport.Viewport;

import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.MyStage;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.ResponseViewport;

public class FajStage extends MyStage {
    Feed feed;
    Water water;
    Sex sex;
    public FajStage(MyGame game, Fajok.Faj specie) {
        super(new ResponseViewport(500), game);
        feed = new Feed(game);
        feed.setPosition(getCamera().viewportWidth/2-feed.getWidth()-feed.getWidth()/2,50);
        addActor(feed);

        water = new Water(game);
        water.setPosition(getCamera().viewportWidth/2-water.getWidth()/2,50);
        addActor(water);

        sex = new Sex(game);
        sex.setPosition(getCamera().viewportWidth/2+sex.getWidth()/2,50);
        addActor(sex);
    }
}
