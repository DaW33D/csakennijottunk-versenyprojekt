package hu.csanyzeg.master.Game;

import com.badlogic.gdx.scenes.scene2d.Actor;

import java.util.Random;

import hu.csanyzeg.master.MyBaseClasses.Assets.AssetList;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.MyStage;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.OneSpriteStaticActor;
import hu.csanyzeg.master.Sneakers.AdidasNMDActor;
import hu.csanyzeg.master.Sneakers.AdidasYeezy350Actor;
import hu.csanyzeg.master.Sneakers.AirForce1Actor;
import hu.csanyzeg.master.Sneakers.AirMax270Actor;
import hu.csanyzeg.master.Sneakers.AirMax720Actor;
import hu.csanyzeg.master.Sneakers.AirMax97Actor;
import hu.csanyzeg.master.Sneakers.NikeAirJordan1Actor;

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
    NikeAirJordan1Actor nikeAirJordan1;
    AdidasNMDActor adidasNMDActor;
    AdidasYeezy350Actor adidasYeezy350Actor;
    AirForce1Actor airForce1Actor;
    AirMax97Actor airMax97Actor;
    AirMax270Actor airMax270Actor;
    AirMax720Actor airMax720Actor;
//    static boolean isOnScreen = false;

    public static AssetList assetList = new AssetList();
    static {
        assetList.addTexture("badlogic.jpg");
        assetList.addTexture("yellow.png");
    }
    public ShoesSelector(MyStage stage) {
        nikeAirJordan1 = new NikeAirJordan1Actor(stage.game);
        adidasNMDActor = new AdidasNMDActor(stage.game);
        adidasYeezy350Actor = new AdidasYeezy350Actor(stage.game);
        airForce1Actor = new AirForce1Actor(stage.game);
        airMax97Actor = new AirMax97Actor(stage.game);
        airMax270Actor = new AirMax270Actor(stage.game);
        airMax720Actor = new AirMax720Actor(stage.game);
        actor2 = new OneSpriteStaticActor(stage.game, "yellow.png");
        shoes = new Actor[]{nikeAirJordan1,adidasNMDActor,adidasYeezy350Actor,airForce1Actor,airMax97Actor,airMax270Actor,airMax720Actor};
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
