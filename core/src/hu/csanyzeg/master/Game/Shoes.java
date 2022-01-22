package hu.csanyzeg.master.Game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.utils.Array;


import java.util.Random;

import hu.csanyzeg.master.Pc.RandomsquareActor;

import hu.csanyzeg.master.MainGame;

public class Shoes {

    public static class ShoeFajta {
        public float price;
        public String name;
        public String picture;
        public float novekedesEselye;
        public float megjelenesEselye;
        public float eladaseselye;
        public static float osszesesely = 0;
        public float eselyindex;
        public Array<Float> arfolyamDiagram = new Array<>();


        private ShoeFajta(String line) {
            String[] lines = line.split(";");
            name = lines[0];
            price = Float.parseFloat(lines[1]);
            novekedesEselye = Float.parseFloat(lines[2]);
            megjelenesEselye = Float.parseFloat(lines[3]);
            eladaseselye = Float.parseFloat(lines[4]);
            picture = lines[5].trim();
            arfolyamDiagram.add(price);
            //System.out.println(line);
            osszesesely += megjelenesEselye;
            eselyindex = osszesesely;
        }

        @Override
        public String toString() {
            return "Shoe{" +
                    "price=" + price +
                    ", name='" + name + '\'' +
                    ", picture='" + picture + '\'' +
                    ", novekedesEselye=" + novekedesEselye +
                    ", megjelenesEselye=" + megjelenesEselye +
                    ", arfolyam=" + arfolyamDiagram +
                    '}';
        }
        public float getEsely(){
            return megjelenesEselye / osszesesely;
        }
        public float geteselyindex(){
            return eselyindex / osszesesely;
        }
    }

    public final Array<ShoeFajta> shoes = new Array<>();

    public ShoeFajta getShoeFajta(int index){
        return shoes.get(index);
    }

    public int getCountOfShoeFajta(){
        return shoes.size;
    }

    public Shoes() {

        FileHandle f = Gdx.files.internal("Shoes/shoes.txt");
        String[] lines = f.readString().split("\n");
        int c = 0;
        for(String s : lines){
            if (c != 0){
                shoes.add(new ShoeFajta(s));
            }
            c++;
        }

    }
    public void generateNewPrice(int s){
        if (s%60 == 0){
            int osszesesely = 0;
            for (ShoeFajta a : shoes){
                osszesesely = (int) a.novekedesEselye;
            }
            Random random = new Random();
            for (ShoeFajta a : shoes){
                int chanceN = (int) ((1/a.novekedesEselye)*100);
                boolean chance = true;
                if(a.price >= 500){
                   chance = random.nextInt(100) <= chanceN/10;
                }else{
                    chance = random.nextInt(100) <= chanceN;
                }
                if (chance){
                    a.price+=random.nextInt(100);
                    System.out.println(a.name + "ára növekedett, ennyire" + a.price);
                }else{
                    a.price -= random.nextInt(50);
                    System.out.println(a.name + "ára csökkent, ennyire" + a.price);
                }
            }
        }
    }

}
