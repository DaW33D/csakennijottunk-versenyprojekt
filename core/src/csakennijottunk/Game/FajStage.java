package csakennijottunk.Game;

import com.badlogic.gdx.utils.viewport.Viewport;

import csakennijottunk.Starter.MainGame;
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
        if (specie.name.equals("Majom")) {
            int counter = 0;
            int yCounter = 0;
            for (FajInstance peldanyok : ((MainGame) game).aliveEvolution) {
                if (peldanyok.base.name.equals("Majom")) {
                    if (counter <= 5) {
                        counter += 1;
                        addActor(new FajActor(game, peldanyok.base, counter * 75, getCamera().viewportHeight - 75 - yCounter * 75));
                    } else {
                        counter = 0;
                        yCounter += 1;
                    }
                }
            }
        }
        else if(specie.name.equals("Gyik")){
            int counter = 0;
            int yCounter = 0;
            for (FajInstance peldanyok : ((MainGame) game).aliveEvolution) {
                if (peldanyok.base.name.equals("Gyik")) {
                    if (counter <= 5) {
                        counter += 1;
                        addActor(new FajActor(game, peldanyok.base, counter * 75, getCamera().viewportHeight - 75 - yCounter * 75));
                    } else {
                        counter = 0;
                        yCounter += 1;
                    }
                }
            }
        }
        else if(specie.name.equals("Horcsog")){
            int counter = 0;
            int yCounter = 0;
            for (FajInstance peldanyok : ((MainGame) game).aliveEvolution) {
                if (peldanyok.base.name.equals("Horcsog")) {
                    if (counter <= 5) {
                        counter += 1;
                        addActor(new FajActor(game, peldanyok.base, counter * 75, getCamera().viewportHeight - 75 - yCounter * 75));
                    } else {
                        counter = 0;
                        yCounter += 1;
                    }
                }
            }
        }else if(specie.name.equals("Dino")){
            int counter = 0;
            int yCounter = 0;
            for (FajInstance peldanyok : ((MainGame) game).aliveEvolution) {
                if (peldanyok.base.name.equals("Dino")) {
                    if (counter <= 5) {
                        counter += 1;
                        addActor(new FajActor(game, peldanyok.base, counter * 75, getCamera().viewportHeight - 75 - yCounter * 75));
                    } else {
                        counter = 0;
                        yCounter += 1;
                    }
                }
            }
        }
        else if(specie.name.equals("Horcsog")){
            int counter = 0;
            int yCounter = 0;
            for (FajInstance peldanyok : ((MainGame) game).aliveEvolution) {
                if (peldanyok.base.name.equals("Horcsog")) {
                    if (counter <= 5) {
                        counter += 1;
                        addActor(new FajActor(game, peldanyok.base, counter * 75, getCamera().viewportHeight - 75 - yCounter * 75));
                    } else {
                        counter = 0;
                        yCounter += 1;
                    }
                }
            }
        }
    }
}
