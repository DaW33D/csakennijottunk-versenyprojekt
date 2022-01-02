package hu.csanyzeg.master.Game;

import com.badlogic.gdx.scenes.scene2d.Actor;

import java.util.Random;

import hu.csanyzeg.master.MyBaseClasses.Assets.AssetList;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.MyStage;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.OneSpriteStaticActor;

public class ShoesSelector {
    static Actor[] shoes;
    static Actor actor;
    static OneSpriteStaticActor actor2;
    OneSpriteStaticActor jordan;
    Random random;
    int rInt;
    static int buyPrice;
    static int sellPrice;
    static int appearTime;
    static boolean isCounting = true;
//    static boolean isOnScreen = false;

    public static AssetList assetList = new AssetList();
    static {
        assetList.addTexture("badlogic.jpg");
        assetList.addTexture("yellow.png");
    }
    public ShoesSelector(MyStage stage) {
        jordan = new OneSpriteStaticActor(stage.game,"badlogic.jpg");
        actor2 = new OneSpriteStaticActor(stage.game, "yellow.png");
        shoes = new Actor[]{jordan};
        random = new Random();
    }

    public Actor getActor(int c){
        return shoes[c];
    }


    public void addActor(MyStage stage){
        if (isCounting == true) {
            stage.addActor(actor);
        }else{
            System.out.println("Most kéne a yellow.png");
            stage.addActor(actor2);
        }
        actor.setPosition(200,100);
        actor.setSize(100,100);
    }

    public void startCounting(int secToCount,int s){
        if(secToCount + 1200 == s){
            isCounting = false;
        }
    }


    public void checkValues(int s){
        if (appearTime != 0){
            startCounting(appearTime,s);
        }
        switch (s){
            case 1:
                rInt = random.nextInt(shoes.length);
                actor = getActor(rInt);
                buyPrice = (rInt + 1) * random.nextInt(501);
                sellPrice = (rInt + 1) * random.nextInt(1001);
                appearTime = s;
                break;
        }
    }


    public Actor getActor(){
        return actor;
    }

    public int getBuyPrice(){
        return buyPrice;
    }

    public int getSellPrice(){
        return sellPrice;
    }

    public boolean getIsCounting(){
        return isCounting;
    }
}
