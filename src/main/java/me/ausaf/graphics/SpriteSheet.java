package me.ausaf.graphics;

import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;

public class SpriteSheet {

    public static final SpriteSheet CHICKEN = new SpriteSheet("chicken.png", 32, 32);
    public static final SpriteSheet EGG = new SpriteSheet("egg.png");

    private Image image;


    private int spriteWidth;
    private int spriteHeight;

    private int rows;
    private int cols;

    public SpriteSheet(String path, int spriteWidth, int spriteHeight) {
        image = new Image(getClass().getResource(path).toExternalForm());
        this.spriteWidth = spriteWidth;
        this.spriteHeight = spriteHeight;

        this.rows = (int)image.getHeight() / spriteHeight;
        this.cols = (int)image.getWidth() / spriteWidth;
    }

    public SpriteSheet(String path) {
        image = new Image(getClass().getResource(path).toExternalForm());
        this.spriteWidth = (int)image.getWidth();
        this.spriteHeight = (int)image.getHeight();

        this.rows = (int)image.getHeight() / spriteHeight;
        this.cols = (int)image.getWidth() / spriteWidth;
    }

    public Image getImage() { return this.image; }

    public Rectangle2D get(int x, int y) {
        return new Rectangle2D(x*spriteWidth, y*spriteHeight, spriteWidth, spriteHeight);
    }

    public int getWidth() {
        return spriteWidth;
    }

    public int getHeight() {
        return spriteHeight;
    }

    public Rectangle2D[] getRow(int y) {
        Rectangle2D[] row = new Rectangle2D[this.cols];
        for (int x = 0; x < row.length; x++) {
            row[x] = new Rectangle2D(x*spriteWidth, y*spriteHeight, spriteWidth, spriteHeight);
        }
        return row;
    }

    public Rectangle2D[] getRowReversed(int y) {
        Rectangle2D[] row = new Rectangle2D[this.cols];
        for (int x = 0; x < row.length; x++) {
            row[x] = new Rectangle2D((row.length - x - 1)*spriteWidth, y*spriteHeight, spriteWidth, spriteHeight);
        }
        return row;
    }
}
