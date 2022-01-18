package hu.csanyzeg.master.Game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.utils.Array;


import hu.csanyzeg.master.Pc.RandomsquareActor;

public class Shoes {

    public class ShoeFajta {
        public float price;
        public String name;
        public String picture;
        public float novekedesEselye;
        public float megjelenesEselye;
        public Array<Float> arfolyamDiagram = new Array<>();


        private ShoeFajta(String line) {
            String[] lines = line.split(";");
            name = lines[0];
            price = Float.parseFloat(lines[1]);
            novekedesEselye = Float.parseFloat(lines[2]);
            megjelenesEselye = Float.parseFloat(lines[3]);
            picture = lines[4].trim();
            arfolyamDiagram.add(price);
            //System.out.println(line);
            System.out.println(this);
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

        private void generateNewPrice(){
            // Ide jön a logika, ami alapján egy cipő megrádugul vagy...
            // Ez az összes cipőfajtára minden szimulációs lépésben lefuttatandó. (Például percenként vagy 10 mp-nként)
            // Ki kekk számolni az új árat
            price += 2;
            price = (int)(Math.random()*(400-200+1)+200);
            System.out.println("newprice");

            //A diagramon majd ábrázolni kell.
            arfolyamDiagram.add(price);
        }
    }

    private final Array<ShoeFajta> shoes = new Array<>();

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
    public int rePrice = 0;
    public void generateNewPrice(){
        for(ShoeFajta s : shoes){
            rePrice = rePrice + 1;
            if (rePrice == 300) {
                s.generateNewPrice();
                rePrice = 0;
            }

        }
    }

}
