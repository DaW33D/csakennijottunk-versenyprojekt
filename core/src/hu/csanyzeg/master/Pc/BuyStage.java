package hu.csanyzeg.master.Pc;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.utils.viewport.Viewport;

import hu.csanyzeg.master.Menu.LabelStyle;
import hu.csanyzeg.master.MyBaseClasses.Assets.AssetList;
import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.MyStage;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.ResponseViewport;
import hu.csanyzeg.master.MyBaseClasses.UI.MyLabel;

public class BuyStage extends MyStage {
    BrowserviewActor browserviewActor;
    LabelStyle labelStyle;
    MyLabel BackLabel;
    MyLabel sellLabel;
    MyLabel buyLabel;
    MyLabel pricerateLabel;
    MyLabel moneyLabel;
    MyLabel moneyL;
    int money = 0;
    static AssetList assetList = new AssetList();
    static{
        assetList.add(BrowserActor.assetList);
        assetList.addFont("alegreyaregular.otf");
    }
    public BuyStage(MyGame game) {
        super(new ResponseViewport(500), game);
        browserviewActor = new BrowserviewActor(game);
        browserviewActor.setSize(900, 500);
        addActor(browserviewActor);
        labelStyle = new LabelStyle(game.getMyAssetManager().getFont("alegreyaregular.otf"), Color.BLACK);
        BackLabel = new MyLabel(game, "Back", labelStyle);
        BackLabel.setSize(100, 50);
        BackLabel.setPosition(0, 0);
        addActor(BackLabel);
        buyLabel = new MyLabel(game, "Buy", labelStyle);
        buyLabel.setPosition(200, 400);
        addActor(buyLabel);
        sellLabel = new MyLabel(game, "Sell", labelStyle);
        sellLabel.setPosition(400, 400);
        addActor(sellLabel);
        pricerateLabel = new MyLabel(game, "Price Rate", labelStyle);
        pricerateLabel.setPosition(600, 400);
        addActor(pricerateLabel);
        moneyLabel = new MyLabel(game, "Money:", labelStyle);
        moneyLabel.setPosition(800, 400);
        addActor(moneyLabel);
        //moneyL = new MyLabel(game, money, labelStyle);
        //addActor(moneyL);
    }
}
