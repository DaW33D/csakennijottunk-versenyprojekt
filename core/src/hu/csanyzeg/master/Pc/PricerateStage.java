package hu.csanyzeg.master.Pc;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.Viewport;

import hu.csanyzeg.master.LoadingStage;
import hu.csanyzeg.master.Menu.LabelStyle;
import hu.csanyzeg.master.MyBaseClasses.Assets.AssetList;
import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.MyStage;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.ResponseViewport;
import hu.csanyzeg.master.MyBaseClasses.UI.MyLabel;

public class PricerateStage extends MyStage {
    LabelStyle labelStyle;
    MyLabel priceLabel;
    BrowserviewActor browserviewActor;
    xActor xActor;
    RandomsquareActor randomsquareActor;
    static AssetList assetList = new AssetList();
    static{
        assetList.add(PricerateActor.assetList);
        assetList.addFont("alegreyaregular.otf", 10);
    }
    public PricerateStage(MyGame game) {
        super(new ResponseViewport(500), game);
        addBackButtonScreenBackByStackPopListenerWithPreloadedAssets(new LoadingStage(game));
        browserviewActor = new BrowserviewActor(game);
        browserviewActor.setPosition(0,0);
        browserviewActor.setSize(getCamera().viewportWidth, getCamera().viewportHeight);
        addActor(browserviewActor);
        randomsquareActor = new RandomsquareActor(game);
        randomsquareActor.setPosition(getCamera().viewportWidth / 2 - randomsquareActor.getWidth() / 2, getCamera().viewportHeight / 2 -randomsquareActor.getHeight() / 2);
        addActor(randomsquareActor);
        labelStyle = new LabelStyle(game.getMyAssetManager().getFont("alegreyaregular.otf"), Color.BLACK);
        priceLabel = new MyLabel(game, "Price: ", labelStyle);
        priceLabel.setPosition(randomsquareActor.getX() + 5, randomsquareActor.getY() + randomsquareActor.getHeight() - priceLabel.getHeight());
        addActor(priceLabel);
        xActor = new xActor(game);
        xActor.setPosition(getCamera().viewportWidth - 15, getCamera().viewportHeight - 15);
        xActor.setSize(15,15);
        addActor(xActor);
        xActor.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                game.setScreenBackByStackPopWithPreloadAssets(new LoadingStage(game));
            }
        });
    }
}
