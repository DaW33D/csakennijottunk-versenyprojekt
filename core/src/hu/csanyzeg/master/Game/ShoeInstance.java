package hu.csanyzeg.master.Game;

import com.badlogic.gdx.graphics.Color;

public class ShoeInstance {

    public enum Cipohelye{
        JofogasonMegveheto, JofogasonMeghirdetettSzekrenybenlevo, SzekrenybenNemMeghirdetett
    }

    public Shoes.ShoeFajta base;
    public float price;
    public Color color = new Color();
    public Cipohelye cipohelye = Cipohelye.JofogasonMegveheto;


    public ShoeInstance(Shoes.ShoeFajta base) {
        this.base = base;
        price = base.price;
        color.rgb888(1f,1f,1f);
    }
}
