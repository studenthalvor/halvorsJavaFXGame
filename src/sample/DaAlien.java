package sample;

import javafx.scene.Scene;
import javafx.scene.image.Image;

import java.net.URL;

public class DaAlien {
    public final Image image;
    public double x,y;
    private double speed = 5;

    public DaAlien() {
        URL url = getClass().getResource("ufo.png");
        this.image = new Image(url.toString());
    }

    public void step(int time) {
        y = Math.sin(time/76.0)*50 + 50;
        x = 200;
    }


}
