package hu.csanyzeg.master.Pc;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

import hu.csanyzeg.master.Game.InGameScreen;
import hu.csanyzeg.master.Game.InGameStage;
import hu.csanyzeg.master.Game.ShoesSelector;
import hu.csanyzeg.master.Game.Time;
import hu.csanyzeg.master.LoadingStage;
import hu.csanyzeg.master.MainGame;
import hu.csanyzeg.master.Menu.LabelStyle;
import hu.csanyzeg.master.MyBaseClasses.Assets.AssetList;
import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.MyStage;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.ResponseViewport;
import hu.csanyzeg.master.MyBaseClasses.UI.MyLabel;

public class PCStage extends MyStage {
    MonitorActor monitorActor;
    LabelStyle labelStyle;
    MyLabel BackLabel;
    MyLabel BuyLabel;
    MyLabel SellLabel;
    MyLabel PricerateLabel;
    MyLabel timeLabel;
    MyLabel bankLabel;
    BuyActor buyActor;
    SellActor sellActor;
    BankActor bankActor;
    ShoesSelector shoesSelector;
    PricerateActor pricerateActor;
    static AssetList assetList = new AssetList();
    static{
        assetList.add(PCActor.assetList);
        assetList.addFont("alegreyaregular.otf", 15);
    }
    public PCStage(MyGame game) {
        super(new ResponseViewport(500), game);
        addBackButtonScreenBackByStackPopListenerWithPreloadedAssets(new LoadingStage(game));
        labelStyle = new LabelStyle(game.getMyAssetManager().getFont("alegreyaregular.otf"), Color.WHITE);
        //time = new Time(this);
        monitorActor = new MonitorActor(game);
        monitorActor.setZIndex(1);
        monitorActor.setPosition(0,0);
        monitorActor.setSize(getCamera().viewportWidth, getCamera().viewportHeight);
        addActor(monitorActor);
        timeLabel = new MyLabel(game, "", labelStyle);
        addActor(timeLabel);
        timeLabel.setSize(50,25);
        timeLabel.setFontScale(0.5f);
        timeLabel.setPosition(getCamera().viewportWidth - timeLabel.getWidth()- 30, 135);
        BackLabel = new MyLabel(game, "Back", labelStyle);
        BackLabel.setSize(100, 50);
        BackLabel.setPosition(0, 0);
        addActor(BackLabel);
        BackLabel.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                game.setScreenWithPreloadAssets(InGameScreen.class, new LoadingStage(game));
            }
        });
        bankActor = new BankActor(game);
        bankActor.setSize(40,40);
        bankActor.setPosition(40, getCamera().viewportHeight-bankActor.getHeight() * 2 - 180);
        addActor(bankActor);
        bankActor.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                game.setScreenWithPreloadAssets(BankScreen.class, new LoadingStage(game));
            }
        });
        bankLabel = new MyLabel(game, "Bank", labelStyle);
        bankLabel.setPosition(45, getCamera().viewportHeight-bankLabel.getHeight() * 2 - 185);
        bankLabel.setFontScale(0.4f);
        bankLabel.setSize(30,10);
        addActor(bankLabel);
        pricerateActor = new PricerateActor(game);
        pricerateActor.setSize(40,40);
        pricerateActor.setPosition(40, getCamera().viewportHeight-pricerateActor.getHeight() * 2 - 120);
        addActor(pricerateActor);
        pricerateActor.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                game.setScreenWithPreloadAssets(PricerateScreen.class, new LoadingStage(game));
            }
        });
        sellActor = new SellActor(game);
        sellActor.setSize(40,40);
        sellActor.setPosition(40, getCamera().viewportHeight-sellActor.getHeight() * 2 - 60);
        addActor(sellActor);
        sellActor.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                game.setScreenWithPreloadAssets(SellScreen.class, new LoadingStage(game));
            }
        });
        BuyLabel = new MyLabel(game, "Buy", labelStyle);
        BuyLabel.setPosition(50, getCamera().viewportHeight-BuyLabel.getHeight() * 2 - 5);
        BuyLabel.setFontScale(0.4f);
        BuyLabel.setSize(30,10);
        addActor(BuyLabel);
        SellLabel = new MyLabel(game, "Sell", labelStyle);
        SellLabel.setPosition(50, getCamera().viewportHeight-BuyLabel.getHeight() * 2 - 135);
        SellLabel.setFontScale(0.4f);
        SellLabel.setSize(30, 10);
        addActor(SellLabel);
        buyActor = new BuyActor(game);
        buyActor.setSize(40,40);
        buyActor.setPosition(40,getCamera().viewportHeight-buyActor.getHeight() * 2);
        addActor(buyActor);
        buyActor.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                game.setScreenWithPreloadAssets(BuyScreen.class, new LoadingStage(game));
            }
        });
        PricerateLabel = new MyLabel(game, "Price Rate", labelStyle);
        PricerateLabel.setPosition(35, getCamera().viewportHeight-sellActor.getHeight() * 2 - 135);
        PricerateLabel.setFontScale(0.4f);
        PricerateLabel.setSize(60,10);
        addActor(PricerateLabel);

        shoesSelector = new ShoesSelector(this);

    }

    @Override
    public void act(float delta) {
        super.act(delta);
        timeLabel.setText(((MainGame)game).gameTime.toString());
    }
}
