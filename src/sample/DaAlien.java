package sample;

import javafx.scene.image.Image;

import java.net.URL;

public class DaAlien implements Sprite {
    public final Image image;
    public double x,y;
    private double speed = 5.5;

    public DaAlien(int x, int y) {
        URL url = getClass().getResource("ufo.png");
        this.image = new Image(url.toString());
        this.x = x;
        this.y = y;
    }

    public void step(int time) {
        y += Math.sin(time/10.0)*speed;
    }

    @Override
    public double x() {
        return x;
    }

    @Override
    public double y() {
        return y;
    }

    @Override
    public Image image() {
        return image;
    }


}
