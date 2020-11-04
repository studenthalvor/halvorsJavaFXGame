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


public class Main extends Application {

    public static final int SCREEN_WIDTH = 1024;
    public static final int SCREEN_HEIGHT = 768;
    private GraphicsContext gc;
    private Timeline gameLoop;
    private MahShip ship;
    private DaAlien alien;

    @Override
    public void start(Stage primaryStage) throws Exception {


        primaryStage.setTitle("Drawing Operations Test");
        Group root = new Group();
        Canvas canvas = new Canvas(SCREEN_WIDTH, SCREEN_HEIGHT);
        this.gc = canvas.getGraphicsContext2D();
        root.getChildren().add(canvas);
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();


        this.ship = new MahShip(scene);
        this.alien = new DaAlien();
        startLoop();
    }

    private void startLoop() {
        final Duration dur = Duration.millis(1000 / 60);
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
        gc.clearRect(0, 0, SCREEN_WIDTH, SCREEN_HEIGHT);
        gc.setFill(Paint.valueOf("#000033"));
        gc.fillRect(0, 0, SCREEN_WIDTH, SCREEN_HEIGHT);
        gc.drawImage(this.ship.image, ship.x, ship.y, 50, 50);
        gc.drawImage(this.alien.image, alien.x, alien.y, 50, 50);
    }

    int time = 0;

    private void step() {
        this.ship.step(time);
        this.alien.step(time);
        time++;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
