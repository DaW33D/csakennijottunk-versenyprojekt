package csakennijottunk.Game;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.Viewport;

import csakennijottunk.Sources.LabelStyle;
import csakennijottunk.Starter.MainGame;
import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.MyStage;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.ResponseViewport;
import sun.tools.jar.Main;
import hu.csanyzeg.master.MyBaseClasses.UI.MyLabel;

public class FajStage extends MyStage {
    Feed feed;
    Water water;
    LabelStyle labelStyle;
    MyLabel backLabel;
    public FajStage(MyGame game, Fajok.Faj specie) {
        super(new ResponseViewport(500), game);
        labelStyle = new LabelStyle(game.getMyAssetManager().getFont("alegreyaregular.otf"), Color.WHITE);
        feed = new Feed(game);
        feed.setPosition(getCamera().viewportWidth/2-feed.getWidth()-feed.getWidth()/2,50);
        addActor(feed);

        backLabel = new MyLabel(game, "Vissza", labelStyle);
        backLabel.setPosition(getCamera().viewportWidth/2 -backLabel.getWidth() * 5,50);
        addActor(backLabel);
        backLabel.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                game.setScreen(new GameScreen(game));
            }
        });

        water = new Water(game);
        water.setPosition(getCamera().viewportWidth/2-water.getWidth()/2,50);
        addActor(water);

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
                    feed.addListener(new ClickListener(){
                        @Override
                        public void clicked(InputEvent event, float x, float y) {
                            super.clicked(event, x, y);
                            int countMonkey = 0;
                            for (FajInstance f : ((MainGame)game).aliveEvolution){
                                if (f.base.name.equals("Majom") && f.isDead == false) {
                                    countMonkey += 1;
                                }
                            }
                            float plusfood = ((MainGame)game).food / countMonkey;
                            for (FajInstance f : ((MainGame)game).aliveEvolution){
                                if (f.base.name.equals("Majom") && f.isDead == false && f.hungerLvl < 1) {
                                    if(f.hungerLvl + plusfood < 1) {
                                        f.hungerLvl += plusfood;
                                        ((MainGame) game).food -= plusfood;
                                    }else{
                                        ((MainGame)game).food -= (f.hungerLvl + plusfood) - 1;
                                        f.hungerLvl = 1;
                                    }
                                }
                            }
                        }
                    });

                    water.addListener(new ClickListener(){
                        @Override
                        public void clicked(InputEvent event, float x, float y) {
                            super.clicked(event, x, y);
                            int countMonkey = 0;
                            for (FajInstance f : ((MainGame)game).aliveEvolution){
                                if (f.base.name.equals("Majom") && f.isDead == false) {
                                    countMonkey += 1;
                                }
                            }
                            for (FajInstance f : ((MainGame)game).aliveEvolution){
                                if (f.base.name.equals("Majom") && f.isDead == false && f.hungerLvl < 1) {
                                        f.thirstLvl = 1;
                                }
                            }
                        }
                    });
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
                    feed.addListener(new ClickListener(){
                        @Override
                        public void clicked(InputEvent event, float x, float y) {
                            super.clicked(event, x, y);
                            int countGyik = 0;
                            for (FajInstance f : ((MainGame)game).aliveEvolution){
                                if (f.base.name.equals("Gyik") && f.isDead == false) {
                                    countGyik += 1;
                                }
                            }
                            float plusfood = ((MainGame)game).food / countGyik;
                            for (FajInstance f : ((MainGame)game).aliveEvolution){
                                if (f.base.name.equals("Gyik") && f.isDead == false && f.thirstLvl < 1) {
                                    System.out.println("HUNGER1:" + f.hungerLvl);
                                    System.out.println("KAJA1:" + ((MainGame)game).food);
                                        f.hungerLvl += plusfood;
                                        ((MainGame) game).food -= plusfood;
                                        System.out.println("HUNGER2:" + f.hungerLvl);
                                        System.out.println("KAJA2:" + ((MainGame)game).food);
                                }
                            }
                        }
                    });

                    water.addListener(new ClickListener(){
                        @Override
                        public void clicked(InputEvent event, float x, float y) {
                            super.clicked(event, x, y);
                            for (FajInstance f : ((MainGame)game).aliveEvolution){
                                if (f.base.name.equals("Gyik") && f.isDead == false && f.thirstLvl < 1) {
                                    f.thirstLvl = 1;
                                }
                            }
                        }
                    });
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
                    feed.addListener(new ClickListener(){
                        @Override
                        public void clicked(InputEvent event, float x, float y) {
                            super.clicked(event, x, y);
                            int countHorcsog = 0;
                            for (FajInstance f : ((MainGame)game).aliveEvolution){
                                if (f.base.name.equals("Horcsog") && f.isDead == false) {
                                    countHorcsog+=1;
                                }
                            }
                            float plusfood = ((MainGame)game).food / countHorcsog;
                            for (FajInstance f : ((MainGame)game).aliveEvolution){
                                if (f.base.name.equals("Horcsog") && f.isDead == false && f.hungerLvl < 1) {
                                    if(f.hungerLvl + plusfood < 1) {
                                        f.hungerLvl += plusfood;
                                        ((MainGame) game).food -= plusfood;
                                    }else{
                                        ((MainGame)game).food -= (f.hungerLvl + plusfood) - 1;
                                        f.hungerLvl = 1;
                                    }
                                }
                            }
                        }
                    });

                    water.addListener(new ClickListener(){
                        @Override
                        public void clicked(InputEvent event, float x, float y) {
                            super.clicked(event, x, y);
                            for (FajInstance f : ((MainGame)game).aliveEvolution){
                                if (f.base.name.equals("Horcsog") && f.isDead == false && f.thirstLvl < 1) {
                                    f.thirstLvl = 1;
                                }
                            }
                        }
                    });
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
                    feed.addListener(new ClickListener(){
                        @Override
                        public void clicked(InputEvent event, float x, float y) {
                            super.clicked(event, x, y);
                            int countDino = 0;
                            for (FajInstance f : ((MainGame)game).aliveEvolution){
                                if (f.base.name.equals("Dino") && f.isDead == false) {
                                    countDino+=1;
                                }
                            }
                            float plusfood = ((MainGame)game).food / countDino;
                            for (FajInstance f : ((MainGame)game).aliveEvolution){
                                if (f.base.name.equals("Dino") && f.isDead == false && f.hungerLvl < 1) {
                                    if(f.hungerLvl + plusfood < 1) {
                                        f.hungerLvl += plusfood;
                                        ((MainGame) game).food -= plusfood;
                                    }else{
                                        ((MainGame)game).food -= (f.hungerLvl + plusfood) - 1;
                                        f.hungerLvl = 1;
                                    }
                                }
                            }
                        }
                    });

                    water.addListener(new ClickListener(){
                        @Override
                        public void clicked(InputEvent event, float x, float y) {
                            super.clicked(event, x, y);
                            for (FajInstance f : ((MainGame)game).aliveEvolution){
                                if (f.base.name.equals("Dino") && f.isDead == false && f.thirstLvl < 1) {
                                    f.thirstLvl = 1;
                                }
                            }
                        }
                    });
                }
            }
        }
    }
}
