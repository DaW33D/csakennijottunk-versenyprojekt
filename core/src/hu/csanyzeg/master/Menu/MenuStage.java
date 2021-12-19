package hu.csanyzeg.master.Menu;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.Viewport;

import hu.csanyzeg.master.Game.CutSceneScreen;
import hu.csanyzeg.master.LoadingStage;
import hu.csanyzeg.master.MyBaseClasses.Assets.AssetList;
import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.MyStage;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.OneSpriteStaticActor;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.ResponseViewport;
import hu.csanyzeg.master.MyBaseClasses.UI.MyLabel;

public class MenuStage extends MyStage {
    LabelStyle labelStyle;
    MyLabel myLabel;
    MyLabel myLabel2;
    static AssetList assetList = new AssetList();
    static {
        assetList.addTexture("yellow.png").protect = true;
        assetList.addFont("alegreyaregular.otf",50);
    }
    public MenuStage(MyGame game) {
        super(new ResponseViewport(500), game);
        addActor(new OneSpriteStaticActor(game,"yellow.png"));
        labelStyle = new LabelStyle(game.getMyAssetManager().getFont("alegreyaregular.otf"), Color.WHITE );
        myLabel = new MyLabel(game,"Play",labelStyle);
        addActor(myLabel);
        myLabel.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                game.setScreenWithPreloadAssets(CutSceneScreen.class,new LoadingStage(game));
            }
        });
        myLabel2 = new MyLabel(game,"Credit",labelStyle);

        //addActor(myLabel2);
    }
}
