package csakennijottunk.Game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;

public class Fajok {
    String[] lines;
    public Faj[] fajok;
    public static class Faj {
        public String name;
        public Integer evPoint;
        public Integer hunger;
        public Integer thirst;
        public Integer place;
        public String image;


        private Faj(String line) {
            String[] lines = line.split(";");
            name = lines[0];
            evPoint = Integer.parseInt(lines[1].trim());
            hunger = Integer.parseInt(lines[2].trim());
            thirst = Integer.parseInt(lines[3].trim());
            place = Integer.parseInt(lines[4].trim());
            image = lines[5].trim();
        }
    }

    public Fajok() {
        fajok = new Faj[4];
        FileHandle f = Gdx.files.internal("Faj/Faj.txt");
        lines = f.readString().split("\n");
        for(int i=1;i<5;i++){
            fajok[i-1] = new Faj(lines[i]);
        }
    }
}