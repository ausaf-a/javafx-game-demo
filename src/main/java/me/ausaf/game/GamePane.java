package me.ausaf.game;

import javafx.animation.AnimationTimer;
import javafx.scene.layout.Pane;

import java.util.ArrayList;
import java.util.List;

public class GamePane extends Pane {

    private AnimationTimer timer;

    public GamePane() {
        super();
        this.setWidth(World.WIDTH);
        this.setHeight(World.HEIGHT);

//        this.setBackground(new Background(new BackgroundFill(Color.ALICEBLUE, CornerRadii.EMPTY, Insets.EMPTY)));
        this.setStyle("-fx-background-color: #87ceff;");
        this.timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                World.update();
            }
        };
    }

    public void start() {
        this.timer.start();
    }

    public void stop() {
        this.timer.stop();
    }


}
