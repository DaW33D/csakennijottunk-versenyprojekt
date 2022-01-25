package hu.csanyzeg.master.Pc;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

import hu.csanyzeg.master.LoadingStage;
import hu.csanyzeg.master.MyBaseClasses.Assets.AssetList;
import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.OneSpriteStaticActor;

public class PCActor extends OneSpriteStaticActor {
    static AssetList assetList = new AssetList();
    static{
        assetList.addTexture("computer.png");
    }
    public PCActor(MyGame game) {
        super(game, "computer.png");

    }
}
