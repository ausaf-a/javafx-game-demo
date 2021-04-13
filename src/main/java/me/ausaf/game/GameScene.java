package me.ausaf.game;

import javafx.geometry.Dimension2D;
import javafx.geometry.Point2D;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import me.ausaf.input.Keyboard;
import me.ausaf.input.Mouse;

public class GameScene extends Scene {
    private static final Dimension2D SIZE = new Dimension2D(500, 500);

    public GameScene() {
        super(World.screen, World.WIDTH, World.HEIGHT);
        this.addEventFilter(KeyEvent.KEY_PRESSED, (e) -> {
            Keyboard.down[e.getCode().getCode()] = true;
        });
        this.addEventFilter(KeyEvent.KEY_RELEASED, (e) -> {
            Keyboard.down[e.getCode().getCode()] = false;
        });

        this.addEventFilter(MouseEvent.MOUSE_RELEASED, (e) -> {
            Mouse.addClick(new Point2D(e.getSceneX(), e.getSceneY()));
        });

        this.addEventFilter(MouseEvent.MOUSE_MOVED, e -> {
            Mouse.last = new Point2D(e.getSceneX(), e.getSceneY());
        });
    }
}
