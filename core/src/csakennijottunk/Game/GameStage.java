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
    Island island;
    MyLabel majomHunger;
    MyLabel majomThirst;
    MyLabel majomAmount;
    MyLabel gyikHunger;
    MyLabel gyikThirst;
    boolean settingonstage;
    LabelStyle labelStyle;
    MyLabel gyikAmount;
    int katt = 0;
    public GameStage(MyGame game) {
        super(new ResponseViewport(500), game);
        labelStyle = new LabelStyle(game.getMyAssetManager().getFont("alegreyaregular.otf"), Color.WHITE);
        gameActors = new GameActors(game);
        settingonstage = false;
        addActor(gameActors);

//        gameActors = new GameActors(game);
//        addActor(gameActors);


        island = new Island(game);
        island.setPosition(0, 0);
        island.setSize(getCamera().viewportWidth, getCamera().viewportHeight);
        addActor(island);


        settingsButtonActor = new SettingsButtonActor(game);
        settingsButtonActor.setPosition(getCamera().viewportWidth - settingsButtonActor.getWidth(), getCamera().viewportHeight - settingsButtonActor.getHeight());
        settingsButtonActor.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                if (settingonstage == false) {
                    getScreen().addStage(new SettingsStage(game), 1, true);
                    settingonstage = true;
                    katt = 0;
                    settingsButtonActor.remove();
                }
            }
        });

        addActor(settingsButtonActor);

        //Majom
        int countmonkey = 0;
        for (FajInstance f : ((MainGame) game).aliveEvolution) {
            if (f.base.name.equals("Majom")) {
                countmonkey += 1;
            }
        }
        if (countmonkey > 0) {
            majom = new Majom(game);
            majom.setPosition(getCamera().viewportWidth - getCamera().viewportWidth / 4 - majom.getWidth() / 2, getCamera().viewportHeight / 2 + majom.getHeight() / 2);
            majom.setSize(50, 50);
            addActor(majom);

            majomHunger = new MyLabel(game, "", labelStyle);
            majomHunger.setPosition(majom.getX(), majom.getY() + majom.getHeight());
            int atlaghunger = 0;
            for (FajInstance f : ((MainGame) game).aliveEvolution) {
                if (f.base.name.equals("Majom")) {
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
                if (f.base.name.equals("Majom")) {
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
                    ((CameraTrackingToActors) getCameraTracking()).zoomMin = 0.3f;
                    ((CameraTrackingToActors) getCameraTracking()).marginTop = 0.4f;
                    ((CameraTrackingToActors) getCameraTracking()).marginLeft = 0;
                    ((CameraTrackingToActors) getCameraTracking()).marginRight = 0.8f;
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
            if (f.base.name.equals("Gyik")) {
                countgyik += 1;
            }
        }


        if (countgyik > 0) {
            gyik = new Gyik(game);
            gyik.setPosition(getCamera().viewportWidth - getCamera().viewportWidth / 4 - gyik.getWidth() / 2, getCamera().viewportHeight / 2 - gyik.getHeight() / 2);
            gyik.setSize(50, 50);
            addActor(gyik);

            gyikHunger = new MyLabel(game, "", labelStyle);
            gyikHunger.setPosition(gyik.getX(), gyik.getY() + majom.getHeight());
            int gyikatlaghunger = 0;
            for (FajInstance f : ((MainGame) game).aliveEvolution) {
                if (f.base.name.equals("Gyik")) {
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
                if (f.base.name.equals("Gyik")) {
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
                ((CameraTrackingToActors) getCameraTracking()).marginTop = 0.1f;
                ((CameraTrackingToActors) getCameraTracking()).marginLeft = 0;
                ((CameraTrackingToActors) getCameraTracking()).marginRight = 0.5f;
                ((CameraTrackingToActors) getCameraTracking()).marginBottom = 0.4f;
                gyik.remove();
                gyikHunger.remove();
                gyikThirst.remove();
                gyikAmount.remove();
            }
        });
    }
    }

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
}

