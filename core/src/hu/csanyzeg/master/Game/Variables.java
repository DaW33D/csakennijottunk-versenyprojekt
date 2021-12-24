package hu.csanyzeg.master.Game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;

import org.graalvm.compiler.lir.Variable;

public class Variables {
    String[]fields;
    static String money;
    static String time;
    static String isMuted;
    static String sVolume;
    static String mVolume;
    static String lang;
    static String isFirstTime;
    static int moneyInt;
    static boolean isMutedBoolean;
    static int sVolumeInt;
    static int mVolumeInt;
    static boolean isFirstTimeBoolean;
    String strLine;
    FileHandle f;



    public void Data(String parseString){
        fields = parseString.split("\t");
        money = fields[0];
        time = fields[1];
        isMuted = fields[2];
        mVolume = fields[3] ;
        sVolume = fields[4];
        lang = fields[5];
        isFirstTime = fields[6];

        moneyInt = Integer.parseInt(money);
        isMutedBoolean = Boolean.parseBoolean(isMuted);
        sVolumeInt = Integer.parseInt(sVolume);
        mVolumeInt = Integer.parseInt(mVolume);
        isFirstTimeBoolean = Boolean.parseBoolean(isFirstTime);


    }
    public Variables() {
        f = Gdx.files.local("Settings/settings.txt");
        String parseStr = f.readString();
        Data(parseStr);
    }

    public void WriteIt(){
        strLine = moneyInt + "\t" + time + "\t" + isMutedBoolean + "\t" + mVolumeInt + "\t" + sVolumeInt + "\t" + lang + "\t" + isFirstTimeBoolean;
        f.writeString(strLine,false);
    }

    public int getMoney(){
        return moneyInt;
    }

    public String getTime(){
        return time;
    }

    public boolean getIsMuted(){
        return isMutedBoolean;
    }

    public int getsVolume(){
        return sVolumeInt;
    }

    public int getmVolume(){
        return mVolumeInt;
    }

    public String getLang(){
        return lang;
    }

    public boolean getIsFirstTime(){
        return isFirstTimeBoolean;
    }

    public void setFirstTime(boolean value){
        isFirstTimeBoolean = value;
        WriteIt();
    }

}
