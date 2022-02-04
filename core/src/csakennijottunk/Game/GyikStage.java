package csakennijottunk.Game;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.Viewport;

import java.awt.Label;

import csakennijottunk.Sources.LabelStyle;
import hu.csanyzeg.master.MyBaseClasses.Assets.AssetList;
import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.MyStage;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.ResponseViewport;
import hu.csanyzeg.master.MyBaseClasses.UI.MyLabel;

public class GyikStage extends MyStage {
    static AssetList assetList = new AssetList();
    static {
        assetList.add(Gyik.assetList);
    }
    LabelStyle labelStyle;
    MyLabel backlabel;
    public GyikStage( MyGame game) {
        super(new ResponseViewport(500), game);
        labelStyle = new LabelStyle(game.getMyAssetManager().getFont("alegreyaregular.otf"), Color.WHITE);
        backlabel = new MyLabel(game, "Vissza", labelStyle);
        backlabel.setPosition(getCamera().viewportWidth - backlabel.getWidth(), getCamera().viewportHeight - backlabel.getHeight());
        addActor(backlabel);
        backlabel.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                getScreen().addStage(new GameStage(game), 1, true);
            }
        });
    }
}
