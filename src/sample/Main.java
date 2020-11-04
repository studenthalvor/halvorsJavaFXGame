package sample;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.File;
import java.net.URL;

public class Main extends Application {

    private GraphicsContext gc;
    private Timeline gameLoop;
    private Image ship;

    @Override
    public void start(Stage primaryStage) throws Exception{
        primaryStage.setTitle("Drawing Operations Test");
        Group root = new Group();
        Canvas canvas = new Canvas(300, 250);
        this.gc = canvas.getGraphicsContext2D();
        drawShapes(gc);
        root.getChildren().add(canvas);
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
        startLoop();
    }

    private void startLoop() {
        URL url = getClass().getResource("ship.png");
        this.ship = new Image(url.toString());

        final Duration dur = Duration.millis(1000/60);
        final KeyFrame frame = new KeyFrame(dur, evt -> {
            Platform.runLater(()->drawShapes(this.gc));
        });

        this.gameLoop = new Timeline();
        gameLoop.setCycleCount(Animation.INDEFINITE);
        gameLoop.getKeyFrames().add(frame);
        gameLoop.playFromStart();


    }

    int time = 0;
    private void drawShapes(GraphicsContext gc) {
        gc.clearRect(0,0,300,250);
        gc.drawImage(this.ship,0,Math.sin(time/100.0)*50 + 50,50,50);

        time++;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
