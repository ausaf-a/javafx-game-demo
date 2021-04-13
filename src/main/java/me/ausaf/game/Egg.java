package me.ausaf.game;

import javafx.geometry.Point2D;
import me.ausaf.graphics.SpriteSheet;

public class Egg extends Entity {

    private int age = 0;

    public Egg(Point2D pos) {
        super(SpriteSheet.EGG, pos);
        this.view.setFitWidth(10 * World.SCALE);
        this.view.setPreserveRatio(true);
    }

    @Override
    public void update() {
        super.update();
        age++;
        if (age > 200) {
            this.hatch();
        }
    }

    public void hatch() {
        World.destroy(this);
        World.spawn(Chicken.class, this.getPosition());
    }
}
