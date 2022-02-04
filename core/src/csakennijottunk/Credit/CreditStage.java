package csakennijottunk.Credit;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.Viewport;

import csakennijottunk.Game.GameScreen;
import csakennijottunk.Sources.LabelStyle;
import hu.csanyzeg.master.MyBaseClasses.Assets.AssetList;
import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.MyStage;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.ResponseViewport;
import hu.csanyzeg.master.MyBaseClasses.UI.MyLabel;

public class CreditStage extends MyStage {
    static AssetList assetList = new AssetList();
    static {
        assetList.addFont("alegreyaregular.otf");
    }
    LabelStyle labelStyle;
    MyLabel backLabel;
    CreditActors creditActors;
    public CreditStage(MyGame game) {
        super(new ResponseViewport(500), game);
        labelStyle = new LabelStyle(game.getMyAssetManager().getFont("alegreyaregular.otf"), Color.WHITE);
        creditActors = new CreditActors(game);
        creditActors.setSize(getCamera().viewportWidth, getCamera().viewportHeight);
        creditActors.setPosition(0,0);
        addActor(creditActors);
        backLabel = new MyLabel(game, "Vissza", labelStyle);
        addActor(backLabel);
        backLabel.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                game.setScreen(new GameScreen(game));
            }
        });
    }
}
