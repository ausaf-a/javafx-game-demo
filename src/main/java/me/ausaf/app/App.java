package me.ausaf.app;

import javafx.application.Application;
import javafx.stage.Stage;
import me.ausaf.game.GameScene;
import me.ausaf.game.World;

/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) throws InterruptedException {
        stage.setTitle("The Egg");
        stage.setScene(new GameScene());
        stage.show();
        World.init();
        Thread.sleep(2000);
    }

    public static void main(String[] args) {
        launch();
    }

}