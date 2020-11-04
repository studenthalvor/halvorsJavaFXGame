package sample;

import javafx.scene.image.Image;

public interface Sprite {

    void step(int time);
    double x();
    double y();
    Image image();

}
