package hu.csanyzeg.master.Game;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

import hu.csanyzeg.master.LoadingStage;
import hu.csanyzeg.master.MyBaseClasses.Assets.AssetList;
import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.OneSpriteStaticActor;

public class WardrobeActor extends OneSpriteStaticActor {
    static AssetList assetList = new AssetList();
    static {
        assetList.addTexture("wardrobe.png");
    }
    public WardrobeActor(MyGame game) {
        super(game, "wardrobe.png");
    this.setSize(50,50);
    this.addListener(new ClickListener(){
        @Override
        public void clicked(InputEvent event, float x, float y) {
            super.clicked(event, x, y);
            game.setScreenWithPreloadAssets(WardrobeScreen.class, new LoadingStage(game));
        }
    });
    }
}
