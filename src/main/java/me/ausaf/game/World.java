package me.ausaf.game;

import javafx.geometry.Point2D;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

public final class World {
    public static final int WIDTH = 500;
    public static final int HEIGHT = 500;
    public static final double SCALE = 2;

    public static List<Entity> objects = new ArrayList<>();
    public static List<Entity> objectsToCreate = new ArrayList<>();
    public static List<Entity> objectsToDestroy = new ArrayList<>();
    public static Point2D CENTER = new Point2D(WIDTH / 2, HEIGHT / 2);
    public static GamePane screen = new GamePane();

    public static void init() {
       spawn(Egg.class, new Point2D(210,210));
       screen.start();
    }

    public static void update() {
        for (Entity e : objectsToCreate) {
            objects.add(e);
            screen.getChildren().add(e.getView());
        }
        objectsToCreate.clear();
        for (Entity e: objectsToDestroy) {
            objects.remove(e);
            screen.getChildren().remove(e.getView());
        }
        objectsToDestroy.clear();
        objects.forEach(Entity::update);
    }

    public static void destroy(Entity object) {
        objectsToDestroy.add(object);
    }

    public static void spawnChicken(Point2D pos) {
        objectsToCreate.add(new Chicken(pos));
    }

    public static void spawnEgg(Point2D pos) {
        objectsToCreate.add(new Egg(pos));
    }

    public static void spawn(Class<? extends Entity> entityType, Point2D position) {
        try {
            Entity spawned = entityType.getConstructor(Point2D.class).newInstance(position);
            objectsToCreate.add(spawned);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException | InstantiationException e) {
            e.printStackTrace();
        }
    }
}
