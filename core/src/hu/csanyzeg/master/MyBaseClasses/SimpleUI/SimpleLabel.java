package hu.csanyzeg.master.MyBaseClasses.SimpleUI;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.Array;

import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.MyGroup;
import hu.csanyzeg.master.MyBaseClasses.SimpleWorld.ShapeType;
import hu.csanyzeg.master.MyBaseClasses.SimpleWorld.SimpleBody;
import hu.csanyzeg.master.MyBaseClasses.SimpleWorld.SimpleBodyType;
import hu.csanyzeg.master.MyBaseClasses.SimpleWorld.SimpleWorld;
import hu.csanyzeg.master.MyBaseClasses.SimpleWorld.SimpleWorldHelper;
import hu.csanyzeg.master.MyBaseClasses.UI.MyLabel;

public class SimpleLabel extends MyGroup {
    public enum ColorMode{
        byGroup, byChar
    }

    public enum FontWidthMode{
        monospace, variable
    }

    private SimpleLabelStyle simpleLabelStyle;

    public SimpleLabel(MyGame game, SimpleWorld world, CharSequence text, SimpleLabelStyle simpleLabelStyle) {
        super(game);
        this.simpleLabelStyle = simpleLabelStyle;
        Label.LabelStyle style;
        style = new com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle();
        style.font = game.getMyAssetManager().getFont(simpleLabelStyle.fontHash);
        Color color = simpleLabelStyle.fontColor;
        style.fontColor = color;
        create(world, text, simpleLabelStyle);
    }

    private void create(SimpleWorld world, CharSequence text, SimpleLabelStyle simpleLabelStyle){
        SimpleWorldHelper mainHelper = null;

        if (world != null){
            setActorWorldHelper(mainHelper = new SimpleWorldHelper(world, this, ShapeType.Rectangle, SimpleBodyType.Ghost));
        }

        if (simpleLabelStyle.fontWidthMode == FontWidthMode.monospace && simpleLabelStyle.maxFontWidth == -1){
            SimpleChar myLabel = new SimpleChar(game,null, simpleLabelStyle, 'W');
            float scale = simpleLabelStyle.fontSize / myLabel.getPrefHeight();
            myLabel.setFontScale(scale);
            myLabel.setWidthWhithAspectRatio(myLabel.getWidth() * scale);
            simpleLabelStyle.maxFontWidth = myLabel.getPrefWidth();
        }

        float position = 0f;
        int i = 0;
        for (char c : text.toString().toCharArray()) {
            SimpleChar simpleChar = new SimpleChar(game, world, simpleLabelStyle, c);
            simpleChar.setX(position);
            addActor(simpleChar);
            if (simpleLabelStyle.fontWidthMode == FontWidthMode.monospace){
                position += simpleLabelStyle.maxFontWidth + simpleLabelStyle.fontSpacing;
            }else {
                position += simpleChar.getPrefWidth() + simpleLabelStyle.fontSpacing;
            }
            if (world != null && simpleLabelStyle.simpleUIListener != null) {
                simpleLabelStyle.simpleUIListener.onCharAdd(this, simpleChar, i);
            }
            i++;
        }

        setWidth(position);
        setHeight(simpleLabelStyle.fontSize);
        if (mainHelper != null) {
            mainHelper.getBody().setPosition(getX(), getY());
            mainHelper.getBody().setSize(getWidth(), getHeight());
            mainHelper.getBody().setOriginToCenter();
        }
    }

    @Override
    protected void setStage(Stage stage) {
        super.setStage(stage);
        if (getActorWorldHelper() != null && simpleLabelStyle != null && isVisible()){
            simpleLabelStyle.simpleUIListener.onShow(this, getSimpleChars());
        }

    }

    public Array<SimpleChar> getSimpleChars(){
        Array<SimpleChar> simpleChars = new Array<>(getChildren().size);
        for(Actor actor : getChildren()){
            if (actor instanceof SimpleChar){
                simpleChars.add((SimpleChar)actor);
            }
        }
        return simpleChars;
    }

    public SimpleLabelListener getSimpleUIListener() {
        return simpleLabelStyle.simpleUIListener;
    }

    public void setSimpleUIListener(SimpleLabelListener simpleUIListener) {
        this.simpleLabelStyle.simpleUIListener = simpleUIListener;
    }

    public void removeSimpleUIListener() {
        this.simpleLabelStyle.simpleUIListener = null;
    }

    @Override
    public void setColor(Color color) {
        super.setColor(color);
        if (simpleLabelStyle.colorMode == ColorMode.byGroup) {
            for (SimpleChar helper : getSimpleChars()) {
                helper.setColor(color);
            }
        }
    }

    @Override
    public void setColor(float r, float g, float b, float a) {
        super.setColor(r, g, b, a);
        for(SimpleChar helper : getSimpleChars()){
            helper.setColor(r, g, b, a);
        }
    }

    public ColorMode getColorMode() {
        return simpleLabelStyle.colorMode;
    }

    public void setColorMode(ColorMode colorMode) {
        this.simpleLabelStyle.colorMode = colorMode;
    }

    @Override
    public boolean remove() {
        for(SimpleChar helper : getSimpleChars()){
            helper.remove();
        }
        return super.remove();
    }

    @Override
    public void setVisible(boolean visible) {
        super.setVisible(visible);
        if (simpleLabelStyle.simpleUIListener!=null) {
            if (visible) {
                simpleLabelStyle.simpleUIListener.onShow(this, getSimpleChars());
            } else {
                simpleLabelStyle.simpleUIListener.onHide(this, getSimpleChars());
            }
        }
    }

    public void hide(){
        if (simpleLabelStyle.simpleUIListener!=null) {
            if (!isVisible()) {
                simpleLabelStyle.simpleUIListener.onHide(this, getSimpleChars());
            }
        }
    }


    public FontWidthMode getFontWidthMode() {
        return simpleLabelStyle.fontWidthMode;
    }

}