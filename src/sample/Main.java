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
import javafx.scene.paint.Paint;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.List;


public class Main extends Application {

    public static final int SCREEN_WIDTH = 1024;
    public static final int SCREEN_HEIGHT = 768;
    private GraphicsContext gc;
    private Timeline gameLoop;
    private List<Sprite> sprites = new ArrayList<>();

    @Override
    public void start(Stage primaryStage) throws Exception {

        //JavaFX standard setup stuff
        primaryStage.setTitle("Drawing Operations Test");
        Group root = new Group();
        //Creating a canvas to draw stuff on
        Canvas canvas = new Canvas(SCREEN_WIDTH, SCREEN_HEIGHT);
        this.gc = canvas.getGraphicsContext2D();
        root.getChildren().add(canvas);
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();


        //Create ship and aliens
        sprites.add(new MahShip(scene));
        sprites.add(new DaAlien(600,170));
        sprites.add(new DaAlien(250,200));
        sprites.add(new DaAlien(100,340));
        sprites.add(new DaAlien(70,400));
        sprites.add(new DaAlien(450,600));

        startLoop();
    }

    /**
     * Creates a game loop that runs the step() and paint() methods every 1/60th seconf (60fps)
     */

    private void startLoop() {
        final Duration dur = Duration.millis(1000 / 60.0);
        final KeyFrame frame = new KeyFrame(dur, evt -> {
            Platform.runLater(() -> {
                step();
                paint(this.gc);
            });
        });

        this.gameLoop = new Timeline();
        gameLoop.setCycleCount(Animation.INDEFINITE);
        gameLoop.getKeyFrames().add(frame);
        gameLoop.playFromStart();
    }



    private void paint(GraphicsContext gc) {
        //Clears the screen with a dark blue color
        gc.setFill(Paint.valueOf("#000033"));
        gc.fillRect(0, 0, SCREEN_WIDTH, SCREEN_HEIGHT);

        //Draws each sprite by looping through them
        for (Sprite sprite : sprites) {
            gc.drawImage(sprite.image(), sprite.x(), sprite.y(), 50, 50);
        }
    }

    int time = 0;

    private void step() {
        //Makes each sprite run its logic for a single time step
        for (Sprite sprite : sprites) {
            sprite.step(time);
        }

        time++;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
