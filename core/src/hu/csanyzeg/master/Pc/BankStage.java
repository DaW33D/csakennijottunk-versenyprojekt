package hu.csanyzeg.master.Pc;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.Viewport;

import hu.csanyzeg.master.Game.Variables;
import hu.csanyzeg.master.LoadingStage;
import hu.csanyzeg.master.Menu.LabelStyle;
import hu.csanyzeg.master.MyBaseClasses.Assets.AssetList;
import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.MyStage;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.ResponseViewport;
import hu.csanyzeg.master.MyBaseClasses.UI.MyLabel;

public class BankStage extends MyStage {
    static AssetList assetList = new AssetList();
    static{
        assetList.addFont("alegreyaregular.otf", 15);
    }
    Variables variables;
    BrowserviewActor browserviewActor;
    LabelStyle labelStyle;
    MyLabel bankLabel;
    int money;
    MyLabel moneyLabel;
    MyLabel text1;
    MyLabel hitelLabel;
    RandomsquareActor randomsquareActor;
    xActor xActor;
    @Override
    public void act(float delta) {
        super.act(delta);
        money = variables.getMoney();
        System.out.println(variables.getMoney());
    }

    public BankStage(MyGame game) {
        super(new ResponseViewport(500), game);
        addBackButtonScreenBackByStackPopListenerWithPreloadedAssets(new LoadingStage(game));
        variables = new Variables();
        labelStyle = new LabelStyle(game.getMyAssetManager().getFont("alegreyaregular.otf"), Color.BLACK);
        hitelLabel = new MyLabel(game, "1milko", labelStyle);
        hitelLabel.setPosition(550,250);
        addActor(hitelLabel);
        hitelLabel.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                money = variables.getMoney() + 1000000;
                System.out.println("1 milko");
            }
        });
        moneyLabel = new MyLabel(game, "", labelStyle);
        browserviewActor = new BrowserviewActor(game);
        browserviewActor.setPosition(0,0);
        browserviewActor.setSize(900,500);
        addActor(browserviewActor);
        randomsquareActor = new RandomsquareActor(game);
        randomsquareActor.setPosition(200,250);
        randomsquareActor.setSize(250,50);
        addActor(randomsquareActor);
        bankLabel = new MyLabel(game, "Bank", labelStyle);
        bankLabel.setPosition(10, 470);
        bankLabel.setFontScale(0.3f);
        addActor(bankLabel);
        text1 = new MyLabel(game, "Your money: ", labelStyle);
        text1.setPosition(getCamera().viewportWidth /2 - text1.getWidth() * 1.5f + 5, 250);
        addActor(text1);
        addActor(moneyLabel);
        moneyLabel.setText(variables.getMoney());
        moneyLabel.setPosition(380,275);

        xActor = new xActor(game);
        xActor.setPosition(getCamera().viewportWidth - 15, getCamera().viewportHeight - 15);
        xActor.setSize(15,15);
        addActor(xActor);
        xActor.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                game.setScreenWithPreloadAssets(PCScreen.class, new LoadingStage(game));
            }
        });
    }
}
