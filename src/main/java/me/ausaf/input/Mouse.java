package me.ausaf.input;

import javafx.geometry.Point2D;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class Mouse {
    public static Queue<Point2D> clicks = new ArrayDeque<>();
    public static Point2D last = Point2D.ZERO;

    public static void addClick(Point2D clickPos) {
        clicks.add(clickPos);
    }

    public static boolean hasClicks() {
        return !clicks.isEmpty();
    }

    public static Point2D getClick() {
        return clicks.remove();
    }
}
