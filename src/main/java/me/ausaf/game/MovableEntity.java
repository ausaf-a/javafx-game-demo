package me.ausaf.game;

import javafx.geometry.Point2D;
import me.ausaf.graphics.SpriteSheet;

public abstract class MovableEntity extends Entity {

    public MovableEntity(SpriteSheet sprites, Point2D position) {
        super(sprites, position);
    }

    protected Point2D velocity = Point2D.ZERO;

    public void setVelocity(Point2D vel) {
        this.velocity = vel;
    }

    public void setVelocity(double x, double y) {
        this.velocity = new Point2D(x, y);
    }

    @Override
    public void update() {
        this.setPosition(this.getPosition().add(velocity));
        this.setVelocity(Point2D.ZERO);
        super.update();
    }
}
