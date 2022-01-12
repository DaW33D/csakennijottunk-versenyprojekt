package hu.csanyzeg.master.Game;

import hu.csanyzeg.master.MyBaseClasses.Scene2D.MyStage;

public class Time{
    static int s;
    int hour;
    int minute;
    boolean counting;
    String hourStr;
    String minuteStr;
    ShoesSelector shoesSelector;

    public Time(MyStage stage) {
        hour = (s/3600) % 24;
        minute = (s/60) % 60;
        shoesSelector = new ShoesSelector(stage);
    }

    @Override
    public String toString() {
        hour = (s/3600) % 24;
        minute = (s/60) % 60;
        if (hour < 10){
            hourStr = "0" + hour;
        }else{
            hourStr = String.valueOf(hour);
        }
        if (minute < 10){
            minuteStr = "0" + minute;
        }else{
            minuteStr = String.valueOf(minute);
        }
        return hourStr + " : " + minuteStr;
    }

    public int getSec(){
        return s;
    }

    public int getMinute(){
        return minute;
    }

    public int getHour(){
        return hour;
    }

    public void setSec(int sec){
        s = sec;
    }

    public void count(boolean counting){
        this.counting = counting;
        if (counting == true) {
            s += 1;
            shoesSelector.checkValues(getSec());
        }
    }

    public void resetTime(){
        s = 0;
        hour = 0;
        minute = 0;
    }
}
