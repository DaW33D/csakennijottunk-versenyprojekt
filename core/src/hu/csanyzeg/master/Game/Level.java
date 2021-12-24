package hu.csanyzeg.master.Game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;

import hu.csanyzeg.master.MyBaseClasses.Assets.AssetList;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.MyActor;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.MyStage;
import hu.csanyzeg.master.Pc.PCActor;

public class Level {
    static AssetList assetList = new AssetList();
    static {
        assetList.addTexture("badlogic.jpg");
        assetList.addTexture("yellow.png");
        assetList.add(HitBoxActor.assetList);
    }
    char[][] levelarray;
    int width;
    int height;
    MyStage stage;

    public Level(int id, MyStage stage) {


        this.stage = stage;
        FileHandle f = Gdx.files.local("Levels/" + id + ".txt");
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
                    case 'p':
                        MyActor pcActor = new PCActor(stage.game);
                        pcActor.setPosition(x * 50, y * 50);
                        stage.addActor(pcActor);
                        break;
                    case 'g':
                        MyActor grassActor = new GrassActor(stage.game);
                        grassActor.setPosition(x * 50, y * 50);
                        stage.addActor(grassActor);
                        break;
                    case 'z':
                        MyActor wardrobeactor = new WardrobeActor(stage.game);
                        wardrobeactor.setPosition(x * 50, y * 50);
                        stage.addActor(wardrobeactor);
                        break;
                    case 'w':
                        MyActor wallActorTop = new WallTopActor(stage.game);
                        wallActorTop.setPosition(x*50,y*50);
                        stage.addActor(wallActorTop);
                        MyActor hitboxActor2 = new HitBoxActor(stage.game);
                        //hitboxActor2.setRotation(90);
                        hitboxActor2.setSize(50,10);
                        hitboxActor2.setPosition(x*50,y*50 + 40);
                        stage.addActor(hitboxActor2);
                        break;
                    case 'a':
                        MyActor wallActorLeft = new WallLeftActor(stage.game);
                        wallActorLeft.setPosition(x*50,y*50);
                        stage.addActor(wallActorLeft);
                        MyActor hitboxActor3 = new HitBoxActor(stage.game);
                        hitboxActor3.setPosition(x*50,y*50);
                        stage.addActor(hitboxActor3);
                        break;
                    case 's':
                        MyActor wallActorBottom = new WallBottomActor(stage.game);
                        wallActorBottom.setPosition(x*50,y*50);
                        stage.addActor(wallActorBottom);
                        MyActor hitboxActor4 = new HitBoxActor(stage.game);
                        //hitboxActor4.setRotation(90);
                        hitboxActor4.setSize(50,10);
                        hitboxActor4.setPosition(x*50,y*50);
                        stage.addActor(hitboxActor4);
                        break;
                    case 'd':
                        MyActor wallActorright = new WallRightActor(stage.game);
                        wallActorright.setPosition(x*50,y*50);
                        stage.addActor(wallActorright);
                        MyActor hitboxActor = new HitBoxActor(stage.game);
                        hitboxActor.setPosition(x*50 + 40,y*50);
                        stage.addActor(hitboxActor);
                        break;
                    case 'q':
                        MyActor wallCornerActorLeftTop = new WallCornerActor(stage.game);
                        wallCornerActorLeftTop.setPosition(x*50,y*50);
                        wallCornerActorLeftTop.setRotation(-90);
                        stage.addActor(wallCornerActorLeftTop);
                        MyActor hitboxActor5 = new HitBoxActor(stage.game);
                        hitboxActor5.setPosition(x*50 + 40,y*50);
                        stage.addActor(hitboxActor5);
                        MyActor hitboxActor6 = new HitBoxActor(stage.game);
                        hitboxActor6.setSize(50,10);
                        hitboxActor6.setPosition(x*50,y*50 + 40);
                        stage.addActor(hitboxActor6);
                        break;
                    case 'e':
                        MyActor wallCornerActorRightTop = new WallCornerActor(stage.game);
                        wallCornerActorRightTop.setPosition(x*50,y*50);
                        stage.addActor(wallCornerActorRightTop);
                        MyActor hitboxActor7 = new HitBoxActor(stage.game);
                        hitboxActor7.setSize(50,10);
                        hitboxActor7.setPosition(x*50,y*50 + 40);
                        stage.addActor(hitboxActor7);
                        MyActor hitboxActor8 = new HitBoxActor(stage.game);
                        hitboxActor8.setPosition(x*50,y*50);
                        stage.addActor(hitboxActor8);
                        break;
                    case 'f':
                        MyActor wallCornerActorRightBottom = new WallCornerActor(stage.game);
                        wallCornerActorRightBottom.setPosition(x*50,y*50);
                        wallCornerActorRightBottom.setRotation(90);
                        stage.addActor(wallCornerActorRightBottom);
                        MyActor hitboxActor9 = new HitBoxActor(stage.game);
                        hitboxActor9.setPosition(x*50,y*50);
                        stage.addActor(hitboxActor9);
                        MyActor hitboxActor10 = new HitBoxActor(stage.game);
                        hitboxActor10.setSize(50,10);
                        hitboxActor10.setPosition(x*50,y*50);
                        stage.addActor(hitboxActor10);
                        break;
                    case 'y':
                        MyActor wallCornerActorLeftBottom = new WallCornerActor(stage.game);
                        wallCornerActorLeftBottom.setPosition(x*50,y*50);
                        wallCornerActorLeftBottom.setRotation(180);
                        stage.addActor(wallCornerActorLeftBottom);
                        MyActor hitboxActor11 = new HitBoxActor(stage.game);
                        hitboxActor11.setSize(50,10);
                        hitboxActor11.setPosition(x*50,y*50);
                        stage.addActor(hitboxActor11);
                        MyActor hitboxActor12 = new HitBoxActor(stage.game);
                        hitboxActor12.setPosition(x*50 + 40,y*50);
                        stage.addActor(hitboxActor12);
                        break;
                }
            }
        }
    }


}

