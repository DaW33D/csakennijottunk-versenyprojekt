package hu.csanyzeg.master.Game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.FileHandler;

import hu.csanyzeg.master.MyBaseClasses.Scene2D.OneSpriteStaticActor;
import jdk.internal.org.jline.utils.Colors;

public class Shoes {
    FileHandle f;
    String[] lines;
    String[] field;
    public Shoes() throws IOException {
        File file = new File("Shoes/shoes.txt");
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        int content = 0;
        while ((content=bufferedReader.read())!=-1){
            System.out.println((char)content);
        }
    }

    public static void main(String[] args) throws IOException {
        Shoes s = new Shoes();
    }
}
