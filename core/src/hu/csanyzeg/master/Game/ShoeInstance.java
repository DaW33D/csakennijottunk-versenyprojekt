package hu.csanyzeg.master.Game;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.RandomXS128;

import java.io.Serializable;

public class ShoeInstance {
    private static RandomXS128 random = new RandomXS128();

    public enum Cipohelye{
        JofogasonMegveheto, JofogasonMeghirdetettSzekrenybenlevo, SzekrenybenNemMeghirdetett,NemBirtokoltEsNemElado
    }

    public Shoes.ShoeFajta base;
    public float price;
    public float sellprice;
    public Color color = new Color();
    public Cipohelye cipohelye = Cipohelye.JofogasonMegveheto;


    public ShoeInstance(Shoes.ShoeFajta base, Cipohelye cipohelye) {
        this.cipohelye = cipohelye;
        this.base = base;
        price = base.price;
        sellprice = 0;
        color.set(random.nextInt(4) * 0.3333f , random.nextInt(4) * 0.3333f, random.nextInt(4) * 0.3333f, 1f);
    }

    public ShoeInstance(Shoes.ShoeFajta base, float price, float sellprice, Color color, Cipohelye cipohelye) {
        this.base = base;
        this.price = price;
        this.sellprice = sellprice;
        this.color = color;
        this.cipohelye = cipohelye;
    }

    @Override
    public String toString() {
        return  "base=" + base.name +
                ", price=" + price +
                ", sellprice=" + sellprice +
                ", color=" + color +
                ", cipohelye=" + cipohelye;
    }
}
