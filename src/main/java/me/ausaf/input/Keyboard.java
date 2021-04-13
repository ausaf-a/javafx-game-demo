package me.ausaf.input;

import javafx.scene.input.KeyCode;

public class Keyboard {
    public static final boolean down[] = new boolean[256];

    public static boolean down(KeyCode code) {
        return down[code.getCode()];
    }
}
