package hu.csanyzeg.master.Game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;

import org.graalvm.compiler.lir.Variable;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

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
        BufferedWriter outColF = null;
        String DIR = "Settings";
        String YOUR_FILE = "Settings/settings.txt";
        try {
            if(!Gdx.files.local(DIR).exists())
                Gdx.files.local(DIR).mkdirs();
            if(Gdx.files.local(YOUR_FILE).exists())
                Gdx.files.local(YOUR_FILE).delete();
            outColF = new BufferedWriter(new OutputStreamWriter(Gdx.files.local(YOUR_FILE).write(true)));
            outColF.write(getStrLine());
        } catch (Throwable e) {
        } finally {
            try {
                if (outColF != null) outColF.close();

            } catch (IOException e) {
            }
        }
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

    public String getStrLine(){
        strLine = moneyInt + "\t" + time + "\t" + isMutedBoolean + "\t" + mVolumeInt + "\t" + sVolumeInt + "\t" + lang + "\t" + isFirstTimeBoolean;
        return strLine;
    }

    public void setMoney(int value){
        moneyInt = value;
    }

    public void setTime(String value){
        time = value;
    }

    public void setIsMuted(boolean value){
        isMutedBoolean = value;
    }

    public void setsVolume(int value){
        sVolumeInt = value;
        WriteIt();
    }

    public void setmVolume(int value){
        mVolumeInt = value;
        WriteIt();
    }

    public void setLang(String value){
        lang = value;
        WriteIt();
    }

    public void setFirstTime(boolean value){
        isFirstTimeBoolean = value;
        WriteIt();
    }

}
