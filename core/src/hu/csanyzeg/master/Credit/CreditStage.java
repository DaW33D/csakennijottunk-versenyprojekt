package hu.csanyzeg.master.Credit;

import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.Viewport;

import hu.csanyzeg.master.Game.Variables;
import hu.csanyzeg.master.LoadingStage;
import hu.csanyzeg.master.Menu.LabelStyle;
import hu.csanyzeg.master.Menu.MenuScreen;
import hu.csanyzeg.master.MyBaseClasses.Assets.AssetList;
import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.MyStage;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.ResponseViewport;
import hu.csanyzeg.master.MyBaseClasses.UI.MyLabel;

public class CreditStage extends MyStage {
    LabelStyle labelStyle;
    MyLabel developers;
    MyLabel nev;
    MyLabel nev2;
    MyLabel nev3;
    MyLabel nev4;
    MyLabel back;
    CreditActors bg;
    static AssetList assetList = new AssetList();
    static {
        assetList.addFont("alegreyaregular.otf",50);
        assetList.addMusic("song.mp3");
        assetList.add(CreditActors.assetList);
    }
    public CreditStage(MyGame game) {
        super(new ResponseViewport(500), game);
        Variables variables = new Variables();
        bg = new CreditActors(game);
        bg.setPosition(0, 0);
        bg.setSize(getCamera().viewportWidth, getCamera().viewportHeight);
        addActor(bg);
        labelStyle = new LabelStyle(game.getMyAssetManager().getFont("alegreyaregular.otf"), Color.BLACK);
        developers = new MyLabel(game, "", labelStyle);
        if (!variables.getIsFirstTime() && variables.getLang().equals("en")){
            developers.setText("Developers:");
        }
        if (!variables.getIsFirstTime() && variables.getLang().equals("hu")){
            developers.setText("Fejlesztők:");
        }
        developers.setPosition(getCamera().viewportWidth / 3 - 50, 400);
        addActor(developers);
        nev = new MyLabel(game, "Fellner Milán", labelStyle);
        nev.setPosition(getCamera().viewportWidth / 3, 350);
        addActor(nev);
        nev2 = new MyLabel(game, "Németh Csaba Bence", labelStyle);
        nev2.setPosition(getCamera().viewportWidth / 3, 300);
        addActor(nev2);
        nev3 = new MyLabel(game, "Kancsal Máté", labelStyle);
        nev3.setPosition(getCamera().viewportWidth / 3, 250);
        addActor(nev3);
        nev4 = new MyLabel(game, "Zsebők Dávid Ferenc", labelStyle);
        nev4.setPosition(getCamera().viewportWidth / 3, 200);
        addActor(nev4);
        back = new MyLabel(game, "Back", labelStyle);
        back.setPosition(0, 0);
        addActor(back);
        back.setSize(back.getWidth(), back.getHeight());
        if (!variables.getIsFirstTime() && variables.getLang().equals("en")){
            back.setSize(back.getWidth(), back.getHeight());
            back.setText("Back");
        }
        if (!variables.getIsFirstTime() && variables.getLang().equals("hu")){
            back.setSize(back.getWidth() + 20, back.getHeight());
            back.setText("Vissza");
        }
        back.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                game.setScreenWithPreloadAssets(MenuScreen.class, new LoadingStage(game));
            }
        });
    }
}
