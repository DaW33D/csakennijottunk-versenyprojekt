package hu.csanyzeg.master.Game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;

import hu.csanyzeg.master.MyBaseClasses.Assets.AssetList;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.MyActor;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.MyStage;

public class Level {
    static AssetList assetList = new AssetList();
    static {
        assetList.addTexture("badlogic.jpg");
        assetList.addTexture("yellow.png");
    }
    char[][] levelarray;
    int width;
    int height;
    MyStage stage;

    public Level(int id, MyStage stage) {


        this.stage = stage;
        FileHandle f = Gdx.files.internal("Levels/" + id + ".txt");
        String[] lines = f.readString().split("\n");
        int max = 0;
        for (String s : lines) {
            if (s.length() > max) {
                max = s.trim().length();
            }
        }
        //levelarray = new char[vízszintes][függőleges];
        width = max;
        height = lines.length;
        levelarray = new char[width][height];

        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                levelarray[x][y] = ' ';
            }
        }

        for (int y = 0; y < lines.length; y++) {
            for (int x = 0; x < lines[y].trim().length(); x++) {
                levelarray[x][y] = lines[y].charAt(x);
            }
        }

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                System.out.print((char) (levelarray[x][y]));
            }
            System.out.println();
        }

    }


    public void build() {
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                switch (levelarray[x][y]) {
                    case 'x':
                        MyActor p = new FloorActor(stage.game);
                        p.setPosition(x * 50, y*50);
                        stage.addActor(p);
                        break;
                    case 'g':
                        MyActor grassActor = new GrassActor(stage.game);
                        grassActor.setPosition(x * 50, y * 50);
                        stage.addActor(grassActor);
                        break;
                    case 'w':
                        MyActor wallActor = new WallRightActor(stage.game);
                        wallActor.setPosition(x*50,y*50);
                        stage.addActor(wallActor);
                        MyActor hitboxActor = new HitBoxActor(stage.game);
                        hitboxActor.setPosition(x*50 + 35,y*50);
                        stage.addActor(hitboxActor);

                        break;

                }
            }
        }
    }

}

