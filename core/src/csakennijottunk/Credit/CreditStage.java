package csakennijottunk.Credit;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.utils.viewport.Viewport;

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
    MyLabel fejlesztok;
    MyLabel nev1;
    MyLabel nev2;
    MyLabel nev3;
    MyLabel nev4;
    CreditActors creditActors;
    public CreditStage(MyGame game) {
        super(new ResponseViewport(500), game);
        labelStyle = new LabelStyle(game.getMyAssetManager().getFont("alegreyaregular.otf"), Color.WHITE);
        creditActors = new CreditActors(game);
        addActor(creditActors);
        fejlesztok = new MyLabel(game, "Fejlesztők:", labelStyle);
        fejlesztok.setPosition(getCamera().viewportWidth / 2 - fejlesztok.getWidth() - 20, getCamera().viewportHeight  / 1.6f);
        addActor(fejlesztok);
        nev1 = new MyLabel(game, "Fellner Milán", labelStyle);
        nev1.setPosition(getCamera().viewportWidth / 2 - nev1.getWidth() / 2, getCamera().viewportHeight / 1.9f);
        addActor(nev1);
        nev2 = new MyLabel(game, "Kancsal Máté", labelStyle);
        nev2.setPosition(getCamera().viewportWidth / 2 - nev2.getWidth() / 2, getCamera().viewportHeight / 2.1f);
        addActor(nev2);
        nev3 = new MyLabel(game, "Zsebők Dávid Ferenc", labelStyle);
        nev3.setPosition(getCamera().viewportWidth / 2 - nev1.getWidth() / 2, getCamera().viewportHeight / 2.4f);
        addActor(nev3);
        nev4 = new MyLabel(game, "Németh Csaba Bence", labelStyle);
        nev4.setPosition(getCamera().viewportWidth / 2 - nev1.getWidth() / 2, getCamera().viewportHeight / 2.8f);
        addActor(nev4);

    }
}
