package sample;

import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import java.net.URL;

public class MahShip implements Sprite {
    public final Image image;
    public double x,y;
    private double dx,dy;
    private double speed = 5;

    private boolean up,down,left,right;

    public MahShip(Scene scene) {
        URL url = getClass().getResource("ship.png");
        readKeyInput(scene);
        this.image = new Image(url.toString());
    }

    private void readKeyInput(Scene scene) {
        scene.addEventHandler(KeyEvent.KEY_PRESSED, (key) -> {
            if (key.getCode() == KeyCode.UP) {
                up = true;
            }
            if (key.getCode() == KeyCode.DOWN) {
                down = true;
            }
            if (key.getCode() == KeyCode.LEFT) {
                left = true;
            }
            if (key.getCode() == KeyCode.RIGHT) {
                right = true;
            }
        });
        scene.addEventHandler(KeyEvent.KEY_RELEASED, (key) -> {
            if (key.getCode() == KeyCode.UP) {
                up = false;
            }
            if (key.getCode() == KeyCode.DOWN) {
                down = false;
            }
            if (key.getCode() == KeyCode.LEFT) {
                left = false;
            }
            if (key.getCode() == KeyCode.RIGHT) {
                right = false;
            }
        });
    }

    public void step(int time) {
        if(up) y -= speed;
        if(down) y += speed;
        if(left) x-=speed;
        if(right) x+=speed;
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
