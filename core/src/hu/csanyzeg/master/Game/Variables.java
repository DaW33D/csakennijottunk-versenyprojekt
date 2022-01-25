package hu.csanyzeg.master.Game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Variables {

    String text;
    static String money;
    static String time;
    static String isMuted;
    static String sVolume;
    static String mVolume;
    static String lang;
    static String isFirstTime;
    static int moneyInt;
    static int timeInt;
    static boolean isMutedBoolean;
    static int sVolumeInt;
    static int mVolumeInt;
    static boolean isFirstTimeBoolean;
    String oStr;
    String strLine;
    FileHandle f;



    public void Data(String parseString){
        String[]fields;
        text = parseString.trim();
        fields = text.split(";");
        for (String s : fields){
            System.out.println("FIELDS" + s + "\n");
        }
        money = fields[0];
        time = fields[1];
        isMuted = fields[2];
        mVolume = fields[3] ;
        sVolume = fields[4];
        lang = fields[5];
        isFirstTime = fields[6];

        moneyInt = Integer.parseInt(money);
        timeInt = Integer.parseInt(time);
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
                oStr = Gdx.files.local(YOUR_FILE).readString().trim();
                Gdx.files.local(YOUR_FILE).delete();
            outColF = new BufferedWriter(new OutputStreamWriter(Gdx.files.local(YOUR_FILE).write(true)));
            if (oStr.equals("0;null;false;0;0;null;false") || oStr.equals("")){
                oStr = "100;0;false;0;0;hu;true";
            }
            outColF.write(oStr);
        } catch (Throwable e) {
        } finally {
            try {
                if (outColF != null) outColF.close();

            } catch (IOException e) {
            }
        }
        f = Gdx.files.local("Settings/settings.txt");
        String parseStr = f.readString();
        System.out.println("PARSESTR:" + parseStr);
        Data(parseStr);
    }

    public void WriteIt(){
        strLine = moneyInt + ";" + time + ";" + isMutedBoolean + ";" + mVolumeInt + ";" + sVolumeInt + ";" + lang + ";" + isFirstTimeBoolean;
        f.writeString(strLine,false);
    }

    public int getMoney(){
        return moneyInt;
    }

    public int getTime(){
        return timeInt;
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
        WriteIt();
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
