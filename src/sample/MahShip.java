package sample;

import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import java.net.URL;

public class MahShip {
    public final Image image;
    public double x,y;
    private double dx,dy;
    private double speed = 5;

    public MahShip(Scene scene) {
        URL url = getClass().getResource("ship.png");
        readKeyInput(scene);
        this.image = new Image(url.toString());
    }

    private void readKeyInput(Scene scene) {
        scene.addEventHandler(KeyEvent.KEY_PRESSED, (key) -> {
            if (key.getCode() == KeyCode.UP) {
                dy -= speed;
            }
            if (key.getCode() == KeyCode.DOWN) {
                dy += speed;
            }
            if (key.getCode() == KeyCode.LEFT) {
                dx -= speed;
            }
            if (key.getCode() == KeyCode.RIGHT) {
                dx += speed;
            }
        });
        scene.addEventHandler(KeyEvent.KEY_RELEASED, (key) -> {
            if (key.getCode() == KeyCode.UP) {
                dy += speed;
            }
            if (key.getCode() == KeyCode.DOWN) {
                dy -= speed;
            }
            if (key.getCode() == KeyCode.LEFT) {
                dx += speed;
            }
            if (key.getCode() == KeyCode.RIGHT) {
                dx -= speed;
            }
        });
    }

    public void step(int time) {
        x += dx;
        y += dy;
    }


}
