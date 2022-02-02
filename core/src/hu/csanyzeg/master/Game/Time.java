package hu.csanyzeg.master.Game;

import com.badlogic.gdx.math.RandomXS128;
import com.badlogic.gdx.utils.Array;


import hu.csanyzeg.master.Credit.CreditScreen;
import hu.csanyzeg.master.MainGame;
import hu.csanyzeg.master.Menu.MenuScreen;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.MyStage;
import hu.csanyzeg.master.MyBaseClasses.Timers.TickTimerListener;
import hu.csanyzeg.master.MyBaseClasses.Timers.Timer;
import hu.csanyzeg.master.Question.QuestionScreen;
import hu.csanyzeg.master.Settings.SettingsScreen;

public class Time extends TickTimerListener {
    int s;
    boolean counting;
    String hourStr;
    String minuteStr;
    ShoesSelector shoesSelector;
    MainGame game;
    Variables variables;
    Array<ShoeInstance> shoeInstances;
    private static RandomXS128 random = new RandomXS128();

    public Time(MainGame game) {
        this.game = game;

    }

    @Override
    public void onTick(Timer sender, float correction) {
        super.onTick(sender, correction);
        if(!(game.getScreen() instanceof MenuScreen || game.getScreen() instanceof SettingsScreen || game.getScreen() instanceof QuestionScreen || game.getScreen() instanceof CreditScreen)) {
            game.shoes.generateNewPrice(s,false);
            s++;
            variables = new Variables();
            Cipoadd(false);
            Ciposell(false);
            //System.out.println("Árkülönbség: " + (game.aVilagOsszesCipoje.get(0).base.price - game.aVilagOsszesCipoje.get(0).price));
        }
    }

    public void Cipoadd(boolean timeSkip){
        if (s % 30 == 0 || timeSkip){
            float r = random.nextFloat();
            Shoes.ShoeFajta Ezlegyen =  game.shoes.shoes.get(0);
            for (Shoes.ShoeFajta i : game.shoes.shoes){
                if (r >= i.geteselyindex()){
                    Ezlegyen = i;
                }
                else{
                    break;
                }
            }
            game.aVilagOsszesCipoje.add(new ShoeInstance(Ezlegyen, ShoeInstance.Cipohelye.JofogasonMegveheto));
        }
    }

    public void Ciposell(boolean timeSkip){
        shoeInstances = new Array<>();
        if (s % 30 == 0 || timeSkip){
            System.out.println("sell lefut");
            for (ShoeInstance s : game.aVilagOsszesCipoje){
                if (s.cipohelye == ShoeInstance.Cipohelye.JofogasonMeghirdetettSzekrenybenlevo){
                    int chanceN = (int) ((1/s.base.eladaseselye)*100);
                    boolean chance = true;
                    chance = random.nextInt(100) <= chanceN;
                    if (chance){
                        variables.setMoney((int) (variables.getMoney() + s.sellprice));
                        shoeInstances.add(s);
                    }
                }else if (s.cipohelye == ShoeInstance.Cipohelye.JofogasonMegveheto){
                    int chanceN = (int) ((1/s.base.eladaseselye)*100);
                    boolean chance = true;
                    chance = random.nextInt(100) <= chanceN;
                    if (chance){
                        shoeInstances.add(s);
                    }
                }
            }

            for (ShoeInstance s : shoeInstances){
                game.aVilagOsszesCipoje.removeValue(s,true);
                System.out.println("Megvettek egy jófogáson lévő cipőt!");
            }
        }
    }

    @Override
    public String toString() {
        if (getHour() < 10){
            hourStr = "0" + getHour();
        }else{
            hourStr = String.valueOf(getHour());
        }
        if (getMinute() < 10){
            minuteStr = "0" + getMinute();
        }else{
            minuteStr = String.valueOf(getMinute());
        }
        return hourStr + " : " + minuteStr;
    }

    public int getSec(){
        return s;
    }

    public int getMinute(){
        return (s/60) % 60;
    }

    public int getHour(){
        return  (s/3600) % 24;
    }

    public void setSec(int sec){
        s = sec;
    }

    public void resetTime(){
        s = 0;
    }

    public void sleep(int sec){
        int minute = sec / 60;
        for (int i = 0; i<minute;i++){
            game.shoes.generateNewPrice(s,true);
            s+=60;
            variables = new Variables();
            Cipoadd(true);
            System.out.println(i);
        }
        variables.setMoney(variables.getMoney() + minute*2);
        Ciposell(true);
    }
}