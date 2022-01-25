package hu.csanyzeg.master.Game;

import hu.csanyzeg.master.MainGame;
import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.MyGroup;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.OneSpriteActor;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.OneSpriteStaticActor;
import hu.csanyzeg.master.MyBaseClasses.Timers.TickTimer;
import hu.csanyzeg.master.MyBaseClasses.Timers.TickTimerListener;
import hu.csanyzeg.master.MyBaseClasses.Timers.Timer;

public class StatActor extends MyGroup {
    public ShoeInstance shoeInstance;

    public OneSpriteActor[] data;
    public OneSpriteActor buy;
    public OneSpriteActor nowgreen;
    public OneSpriteActor nowred;

    public StatActor(MyGame game, ShoeInstance shoeInstance, int count) {
        super(game);
        data = new OneSpriteActor[count];
/*        for (int i = 0; i< 10; i++) {
            ((MainGame) game).shoes.generateNewPrice(0);
        }*/
        setSize(200, 100);
        this.shoeInstance = shoeInstance;
        for (int i=0; i<data.length; i++) {
            addActor(data[i] = new OneSpriteStaticActor(game, "statpoint.png"));
            data[i].setSize(10, 10);
            data[i].setVisible(false);
            data[i].setAlpha(0.4f);
        }
        buy = new OneSpriteStaticActor(game, "statbuy.png");
        buy.setSize(200,10);
        nowgreen = new OneSpriteStaticActor(game, "statnowgreen.png");
        nowgreen.setSize(200,10);
        nowred = new OneSpriteStaticActor(game, "statnowred.png");
        nowred.setSize(200,10);
        addActor(buy);
        addActor(nowgreen);
        addActor(nowred);
        addTimer(new TickTimer(1, true, new TickTimerListener(){
            @Override
            public void onTick(Timer sender, float correction) {
                super.onTick(sender, correction);
                update();
            }
        }));
        update();
    }

    public void update(){
        System.out.println(shoeInstance.base.arfolyamDiagram.size);
        int end = shoeInstance.base.arfolyamDiagram.size;
        int start = Math.max(0, shoeInstance.base.arfolyamDiagram.size - data.length);
        float max = shoeInstance.base.arfolyamDiagram.get(start);
        float min = shoeInstance.base.arfolyamDiagram.get(start);
        for (int i = start + 1; i<end; i++){
            if (max < shoeInstance.base.arfolyamDiagram.get(i)){
                max = shoeInstance.base.arfolyamDiagram.get(i);
            }
            if (min > shoeInstance.base.arfolyamDiagram.get(i)){
                min = shoeInstance.base.arfolyamDiagram.get(i);
            }
        }
        if (min > shoeInstance.price){
            min = shoeInstance.price;
        }
        if (max < shoeInstance.price){
            max = shoeInstance.price;
        }
        for (int i=0; i<data.length; i++) {
            data[i].setVisible(false);
        }
        int x = data.length - 1;
        for (int i=end - 1; i>=start; i--) {
            data[x].setVisible(true);
            data[x].setPosition(x * getWidth() / data.length, ((shoeInstance.base.arfolyamDiagram.get(i) - min) / (max - min)) * (getHeight() - data[x].getHeight()) );
            x--;
        }
        buy.setPosition(0, ((shoeInstance.price - min) / (max - min)) * (getHeight() - buy.getHeight()) );
        nowred.setPosition(0, ((shoeInstance.base.arfolyamDiagram.get(shoeInstance.base.arfolyamDiagram.size-1) - min) / (max - min)) * (getHeight() - nowred.getHeight()));
        nowgreen.setPosition(0, ((shoeInstance.base.arfolyamDiagram.get(shoeInstance.base.arfolyamDiagram.size-1) - min) / (max - min)) * (getHeight() - nowgreen.getHeight()));
        if (shoeInstance.base.arfolyamDiagram.get(shoeInstance.base.arfolyamDiagram.size-1) < shoeInstance.price){
            nowred.setVisible(true);
            nowgreen.setVisible(false);
        }else{
            nowred.setVisible(false);
            nowgreen.setVisible(true);
        }
    }
}
