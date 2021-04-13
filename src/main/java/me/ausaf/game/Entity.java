package me.ausaf.game;

import javafx.geometry.Point2D;
import javafx.scene.Node;
import javafx.scene.image.ImageView;
import me.ausaf.graphics.Animation;
import me.ausaf.graphics.SpriteSheet;

public abstract class Entity {

    protected ImageView view;
    protected SpriteSheet sprites;
    protected Animation activeAnimation;

    public Entity(SpriteSheet sprites, Point2D position) {
        if (sprites == null) {
            throw new IllegalArgumentException("Entity received null sprite sheet");
        }
        if (sprites.getImage() == null) {
            throw new IllegalArgumentException("Entity sprite sheet has null image");
        }

        this.sprites = sprites;
        this.activeAnimation = new Animation(sprites.get(0,0)); // static animation
        this.view = new ImageView(sprites.getImage());
//        this.view.setTranslateX(-sprites.getWidth() / 2);
//        this.view.setTranslateY(-sprites.getHeight() / 2);
        this.setPosition(position);
        this.getView().setOnMouseClicked(e -> {World.destroy(this);});
    }

    public void update() {
        this.view.setViewport(activeAnimation.getFrame());
        activeAnimation.animate();
    }

    public void setAnimation(Animation animation) {
        if (activeAnimation != animation) {
            animation.restart();
            this.activeAnimation = animation;
        }
    }

    public void setPosition(Point2D pos) {
        setPosition(pos.getX(), pos.getY());
    }

    public void setPosition(double x, double y) {
        this.view.setLayoutX(x);
        this.view.setLayoutY(y);
    }

    public Point2D getPosition() {
        return new Point2D(this.view.getLayoutX(), this.view.getLayoutY());
    }

    public boolean intersects(Entity other) {
        return this.view.getBoundsInParent().intersects(other.getView().getBoundsInParent());
    }

    public double distanceFrom(Point2D target) {
        return this.getPosition().distance(target);
    }

    public Node getView() {
        return this.view;
    }
}
