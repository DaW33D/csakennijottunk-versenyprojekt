package hu.csanyzeg.master.Game;

import hu.csanyzeg.master.MyBaseClasses.Assets.AssetList;
import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.MyActor;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.OneSpriteStaticActor;

public class ShoeActor extends OneSpriteStaticActor {
    public ShoeInstance shoeInstance;
    public static AssetList assetList = new AssetList();
    public ShoeActor(MyGame game, ShoeInstance shoeInstance,float x, float y) {
        super(game, shoeInstance.base.picture);
        this.shoeInstance = shoeInstance;
        this.setPosition(x,y);
        this.setSize(100,100);
        setColor(shoeInstance.color);
        assetList.addTexture(shoeInstance.base.picture);
    }

}
