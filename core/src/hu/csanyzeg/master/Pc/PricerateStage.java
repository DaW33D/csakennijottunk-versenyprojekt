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
        browserviewActor.setSize(900,500);
        addActor(browserviewActor);
        randomsquareActor = new RandomsquareActor(game);
        randomsquareActor.setPosition(getCamera().viewportWidth / 2 - randomsquareActor.getWidth() / 2, getCamera().viewportHeight / 2 -randomsquareActor.getHeight() / 2);
        addActor(randomsquareActor);
        labelStyle = new LabelStyle(game.getMyAssetManager().getFont("alegreyaregular.otf"), Color.BLACK);
        priceLabel = new MyLabel(game, "Price: ", labelStyle);
        priceLabel.setPosition(getCamera().viewportWidth /2 - priceLabel.getWidth() - priceLabel.getWidth() * 2, getCamera().viewportHeight / 2 + priceLabel.getHeight());
        addActor(priceLabel);
        xActor = new xActor(game);
        xActor.setSize(20,20);
        xActor.setPosition(getCamera().viewportWidth - xActor.getWidth(), getCamera().viewportHeight - xActor.getHeight());
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
