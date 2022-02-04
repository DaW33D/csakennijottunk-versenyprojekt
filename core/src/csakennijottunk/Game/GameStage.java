package csakennijottunk.Game;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

import csakennijottunk.Sources.LabelStyle;
import csakennijottunk.Starter.MainGame;
import hu.csanyzeg.master.MyBaseClasses.Assets.AssetList;
import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.CameraTrackingToActors;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.MyStage;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.OneSpriteStaticActor;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.ResponseViewport;
import hu.csanyzeg.master.MyBaseClasses.UI.MyLabel;

public class GameStage extends MyStage {
    static AssetList assetList = new AssetList();

    static {
        assetList.add(GameActors.assetList);
        assetList.add(Majom.assetList);
        assetList.add(Island.assetList);
    }

    Gyik gyik;
    GameActors gameActors;
    SettingsButtonActor settingsButtonActor;
    SettingsStage settingsStage;
    Majom majom;
    Horcsog horcsog;
    Island island;
    MyLabel majomHunger;
    MyLabel majomThirst;
    MyLabel majomAmount;
    MyLabel gyikHunger;
    MyLabel gyikThirst;
    MyLabel horcsogHunger;
    MyLabel horcsogThirst;
    MyLabel horcsogAmount;
    boolean settingonstage;
    LabelStyle labelStyle;
    MyLabel gyikAmount;
    MyLabel backLabel;
    MyLabel dinoHunger;
    MyLabel dinoThirst;
    MyLabel dinoAmount;
    MyLabel foodamount;
    OneSpriteStaticActor kajakosar;
    Dino dino;
    int katt = 0;
    @Override
    public void act(float delta) {
        super.act(delta);
        int countgyik = 0;
        int countdino = 0;
        int countmajom = 0;
        int counthorcsog = 0;
        for (FajInstance f : ((MainGame) game).aliveEvolution) {
            if (f.base.name.equals("Majom")) {
                countmajom += 1;
            } else if (f.base.name.equals("Dino")) {
                countdino += 1;
            } else if (f.base.name.equals("Gyik")) {
                countgyik += 1;
            } else if (f.base.name.equals("Horcsog")) {
                counthorcsog += 1;
            }
        }
    }



    public GameStage(MyGame game) {
        super(new ResponseViewport(500), game);
        labelStyle = new LabelStyle(game.getMyAssetManager().getFont("alegreyaregular.otf"), Color.WHITE);
        gameActors = new GameActors(game);
        settingonstage = false;
        addActor(gameActors);

        kajakosar = new OneSpriteStaticActor(game,"hasznaltkepek/kosar.png");
        kajakosar.setSize(50,50);

        foodamount = new MyLabel(game,"",labelStyle);

//        gameActors = new GameActors(game);
//        addActor(gameActors);


        island = new Island(game);
        island.setPosition(0, 0);
        island.setSize(getCamera().viewportWidth, getCamera().viewportHeight);
        addActor(island);



        //Majom
        int countmonkey = 0;
        for (FajInstance f : ((MainGame) game).aliveEvolution) {
            if (f.base.name.equals("Majom") && f.isDead == false) {
                countmonkey += 1;
            }
        }
        if (countmonkey > 0) {
            majom = new Majom(game);
            majom.setSize(50, 50);
            majom.setPosition(getCamera().viewportWidth - getCamera().viewportWidth / 4 - majom.getWidth() / 2, getCamera().viewportHeight / 2 + majom.getHeight() / 2);
            addActor(majom);

            majomHunger = new MyLabel(game, "", labelStyle);
            majomHunger.setPosition(majom.getX(), majom.getY() + majom.getHeight());
            int atlaghunger = 0;
            for (FajInstance f : ((MainGame) game).aliveEvolution) {
                if (f.base.name.equals("Majom") && f.isDead == false) {
                    atlaghunger += f.base.hunger;
                }
            }
            int hunger = (atlaghunger / countmonkey) * 100;
            majomHunger.setText(hunger + "%");
            addActor(majomHunger);

            majomThirst = new MyLabel(game, "", labelStyle);
            majomThirst.setPosition(majomHunger.getX(), majomHunger.getY() + majomHunger.getHeight() + 30);
            int atlaghungerb = 0;

            for (FajInstance f : ((MainGame) game).aliveEvolution) {
                if (f.base.name.equals("Majom") && f.isDead == false) {
                    atlaghungerb += f.base.thirst;
                }
            }
            int thirst = (atlaghungerb / countmonkey) * 100;
            majomThirst.setText(thirst + "%");
            addActor(majomThirst);

            majomAmount = new MyLabel(game, "", labelStyle);
            majomAmount.setPosition(majomThirst.getX(), majomThirst.getY() + majomThirst.getHeight() + 30);
            majomAmount.setText(countmonkey);
            addActor(majomAmount);


            majom.addListener(new ClickListener() {
                @Override
                public void clicked(InputEvent event, float x, float y) {
                    super.clicked(event, x, y);
                    getScreen().addStage(new FajStage(game, ((MainGame) game).majom), 1, true);
                    setCameraTracking(new CameraTrackingToActors());
                    ((CameraTrackingToActors) getCameraTracking()).addActor(majom);
                    ((CameraTrackingToActors) getCameraTracking()).zoomMin = 0.4f;
                    ((CameraTrackingToActors) getCameraTracking()).marginTop = 0.3f;
                    ((CameraTrackingToActors) getCameraTracking()).marginLeft = 0;
                    ((CameraTrackingToActors) getCameraTracking()).marginRight = 0.8f;
                    foodamount.setPosition(majom.getX(),majom.getY());
                    foodamount.setText((int) ((MainGame)game).food);
                    addActor(foodamount);
                    majom.remove();
                    majomHunger.remove();
                    majomThirst.remove();
                    majomAmount.remove();
                }
            });
        }
        //GYIK
        int countgyik = 0;
        for (FajInstance f : ((MainGame) game).aliveEvolution) {
            if (f.base.name.equals("Gyik") && f.isDead == false) {
                countgyik += 1;
            }
        }


        if (countgyik > 0) {
            gyik = new Gyik(game);
            gyik.setSize(50, 50);
            gyik.setPosition(getCamera().viewportWidth - getCamera().viewportWidth / 4, getCamera().viewportHeight / 2 + getCamera().viewportHeight/4 - gyik.getHeight() / 2);
            addActor(gyik);

            gyikHunger = new MyLabel(game, "", labelStyle);
            gyikHunger.setPosition(gyik.getX(), gyik.getY() + gyik.getHeight());
            int gyikatlaghunger = 0;
            for (FajInstance f : ((MainGame) game).aliveEvolution) {
                if (f.base.name.equals("Gyik") && f.isDead == false) {
                    gyikatlaghunger += f.base.hunger;
                }
            }
            int gyikhunger = (gyikatlaghunger / countgyik) * 100;
            gyikHunger.setText(gyikhunger + "%");
            addActor(gyikHunger);

            gyikThirst = new MyLabel(game, "", labelStyle);
            gyikThirst.setPosition(gyikHunger.getX(), gyikHunger.getY() + gyikHunger.getHeight() + 30);
            int gyikatlaghungerb = 0;

            for (FajInstance f : ((MainGame) game).aliveEvolution) {
                if (f.base.name.equals("Gyik") && f.isDead == false) {
                    gyikatlaghungerb += f.base.thirst;
                }
            }
            int gyikthirst = (gyikatlaghungerb / countgyik) * 100;
            gyikThirst.setText(gyikthirst + "%");
            addActor(gyikThirst);


            gyikAmount = new MyLabel(game, "", labelStyle);
            gyikAmount.setPosition(gyikThirst.getX(), gyikThirst.getY() + gyikThirst.getHeight() + 30);
            gyikAmount.setText(countgyik);
            addActor(gyikAmount);


        gyik.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                getScreen().addStage(new FajStage(game, ((MainGame) game).gyik), 1, true);
                setCameraTracking(new CameraTrackingToActors());
                ((CameraTrackingToActors) getCameraTracking()).addActor(gyik);
                ((CameraTrackingToActors) getCameraTracking()).zoomMin = 0.6f;
                ((CameraTrackingToActors) getCameraTracking()).marginTop = 0.3f;
                ((CameraTrackingToActors) getCameraTracking()).marginLeft = 0;
                ((CameraTrackingToActors) getCameraTracking()).marginRight = 0.4f;
                ((CameraTrackingToActors) getCameraTracking()).marginBottom = 0.2f;
                foodamount.setPosition(gyik.getX(),gyik.getY());
                foodamount.setText((int) ((MainGame)game).food);
                addActor(foodamount);
                kajakosar.setPosition(foodamount.getX() + 30,foodamount.getY() - 30);
                addActor(kajakosar);
                gyik.remove();
                gyikHunger.remove();
                gyikThirst.remove();
                gyikAmount.remove();
            }
        });
        }
        //HORCSOG

        int counthorcsog = 0;
        for (FajInstance f : ((MainGame) game).aliveEvolution) {
            if (f.base.name.equals("Horcsog") && f.isDead == false) {
                counthorcsog += 1;
            }
        }
        System.out.println("COUNT" + counthorcsog);


        if (counthorcsog > 0) {
            horcsog = new Horcsog(game);
            horcsog.setSize(50, 50);
            horcsog.setPosition(getCamera().viewportWidth / 4 - horcsog.getWidth() / 2, getCamera().viewportHeight / 4 - horcsog.getHeight() / 2);
            addActor(horcsog);

            horcsogHunger = new MyLabel(game, "", labelStyle);
            horcsogHunger.setPosition(horcsog.getX(), horcsog.getY() + horcsog.getHeight());
            int horcsogatlaghunger = 0;
            for (FajInstance f : ((MainGame) game).aliveEvolution) {
                if (f.base.name.equals("Horcsog") && f.isDead == false) {
                    horcsogatlaghunger += f.base.hunger;
                }
            }
            int horcsoghunger = (horcsogatlaghunger / countgyik) * 100;
            horcsogHunger.setText(horcsoghunger + "%");
            addActor(horcsogHunger);

            horcsogThirst = new MyLabel(game, "", labelStyle);
            horcsogThirst.setPosition(horcsogHunger.getX(), horcsogHunger.getY() + horcsogHunger.getHeight() + 30);
            int horcsogatlaghungerb = 0;

            for (FajInstance f : ((MainGame) game).aliveEvolution) {
                if (f.base.name.equals("Horcsog") && f.isDead == false) {
                    horcsogatlaghungerb += f.base.thirst;
                }
            }
            int horcsogthirst = (horcsogatlaghungerb / countgyik) * 100;
            horcsogThirst.setText(horcsogthirst + "%");
            addActor(horcsogThirst);


            horcsogAmount = new MyLabel(game, "", labelStyle);
            horcsogAmount.setPosition(horcsogThirst.getX(), horcsogThirst.getY() + horcsogThirst.getHeight() + 30);
            horcsogAmount.setText(counthorcsog);
            addActor(horcsogAmount);


            horcsog.addListener(new ClickListener() {
                @Override
                public void clicked(InputEvent event, float x, float y) {
                    super.clicked(event, x, y);
                    getScreen().addStage(new FajStage(game, ((MainGame) game).horcsog), 1, true);
                    setCameraTracking(new CameraTrackingToActors());
                    ((CameraTrackingToActors) getCameraTracking()).addActor(horcsog);
                    ((CameraTrackingToActors) getCameraTracking()).zoomMin = 0.6f;
                    ((CameraTrackingToActors) getCameraTracking()).marginTop = 0.1f;
                    ((CameraTrackingToActors) getCameraTracking()).marginLeft = 0;
                    ((CameraTrackingToActors) getCameraTracking()).marginRight = 0.5f;
                    ((CameraTrackingToActors) getCameraTracking()).marginBottom = 0.4f;
                    horcsog.remove();
                    horcsogHunger.remove();
                    horcsogThirst.remove();
                    horcsogAmount.remove();
                }
            });

            gyik.addListener(new ClickListener() {
                @Override
                public void clicked(InputEvent event, float x, float y) {
                    super.clicked(event, x, y);
                    getScreen().addStage(new FajStage(game, ((MainGame) game).gyik), 1, true);
                    setCameraTracking(new CameraTrackingToActors());
                    ((CameraTrackingToActors) getCameraTracking()).addActor(gyik);
                    ((CameraTrackingToActors) getCameraTracking()).zoomMin = 0.5f;
                    ((CameraTrackingToActors) getCameraTracking()).marginTop = 0.1f;
                    ((CameraTrackingToActors) getCameraTracking()).marginLeft = 0;
                    ((CameraTrackingToActors) getCameraTracking()).marginRight = 0.3f;
                    ((CameraTrackingToActors) getCameraTracking()).marginBottom = 0.4f;
                    gyik.remove();
                    gyikHunger.remove();
                    gyikThirst.remove();
                    gyikAmount.remove();
                }
            });

            //Dino

            int countdino = 0;
            for (FajInstance f : ((MainGame) game).aliveEvolution) {
                if (f.base.name.equals("dino") && f.isDead == false) {
                    countdino += 1;
                }
                System.out.println("COUNTDINO" + countdino);
            }


            if (countdino > 0) {
                dino = new Dino(game);
                dino.setSize(50, 50);
                dino.setPosition(getCamera().viewportWidth / 4 - dino.getWidth() / 2, getCamera().viewportHeight / 2 + getCamera().viewportHeight/4 - dino.getHeight() / 2);
                addActor(dino);
                System.out.println("STAGEN VAN?" + dino.getStage());

                dinoHunger = new MyLabel(game, "", labelStyle);
                dinoHunger.setPosition(dino.getX(), dino.getY() + dino.getHeight());
                int dinoatlaghunger = 0;
                for (FajInstance f : ((MainGame) game).aliveEvolution) {
                    if (f.base.name.equals("Dino") && f.isDead == false) {
                        dinoatlaghunger += f.base.hunger;
                    }
                }
                int dinohunger = (dinoatlaghunger / countdino) * 100;
                dinoHunger.setText(dinohunger + "%");
                addActor(dinoHunger);

                dinoThirst = new MyLabel(game, "", labelStyle);
                dinoThirst.setPosition(dinoHunger.getX(), dinoHunger.getY() + dinoHunger.getHeight() + 30);
                int dinoAtlagHungerB = 0;

                for (FajInstance f : ((MainGame) game).aliveEvolution) {
                    if (f.base.name.equals("Dino") && f.isDead == false) {
                        dinoAtlagHungerB += f.base.thirst;
                    }
                }
                int dinothirst = (dinoAtlagHungerB / countdino) * 100;
                dinoThirst.setText(dinothirst + "%");
                addActor(dinoThirst);


                dinoAmount = new MyLabel(game, "", labelStyle);
                dinoAmount.setPosition(dinoThirst.getX(), dinoThirst.getY() + dinoThirst.getHeight() + 30);
                dinoAmount.setText(countdino);
                addActor(dinoAmount);


                dino.addListener(new ClickListener() {
                    @Override
                    public void clicked(InputEvent event, float x, float y) {
                        super.clicked(event, x, y);
                        getScreen().addStage(new FajStage(game, ((MainGame) game).dino), 1, true);
                        setCameraTracking(new CameraTrackingToActors());
                        ((CameraTrackingToActors) getCameraTracking()).addActor(dino);
                        ((CameraTrackingToActors) getCameraTracking()).zoomMin = 0.5f;
                        ((CameraTrackingToActors) getCameraTracking()).marginTop = 0.2f;
                        ((CameraTrackingToActors) getCameraTracking()).marginLeft = 0.2f;
                        ((CameraTrackingToActors) getCameraTracking()).marginRight = 0;
                        ((CameraTrackingToActors) getCameraTracking()).marginBottom = 0f;
                        dino.remove();
                        dinoHunger.remove();
                        dinoThirst.remove();
                        dinoAmount.remove();
                    }
                });


            }
        }
    }
}
