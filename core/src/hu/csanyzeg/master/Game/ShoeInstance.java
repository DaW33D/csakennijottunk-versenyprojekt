package hu.csanyzeg.master.Game;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.RandomXS128;

public class ShoeInstance {
    private static RandomXS128 random = new RandomXS128();

    public enum Cipohelye{
        JofogasonMegveheto, JofogasonMeghirdetettSzekrenybenlevo, SzekrenybenNemMeghirdetett
    }

    public Shoes.ShoeFajta base;
    public float price;
    public Color color = new Color();
    public Cipohelye cipohelye = Cipohelye.JofogasonMegveheto;


    public ShoeInstance(Shoes.ShoeFajta base, Cipohelye cipohelye) {
        this.cipohelye = cipohelye;
        this.base = base;
        price = base.price;
        color.set(random.nextInt(4) * 0.3333f , random.nextInt(4) * 0.3333f, random.nextInt(4) * 0.3333f, 1f);
    }
}
