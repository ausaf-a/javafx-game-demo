package me.ausaf.game;

import javafx.geometry.Point2D;
import me.ausaf.graphics.Animation;
import me.ausaf.graphics.SpriteSheet;

public class Chicken extends MovableEntity {
    private static final SpriteSheet sprites = SpriteSheet.CHICKEN;

    private static final Animation walk = new Animation(sprites.getRow(0), 10);
    private static final Animation peck = new Animation(sprites.getRow(1), 10);
    private static final Animation sit = new Animation(sprites.getRow(2), 10).setPlayOnce(true);
    private static final Animation rise = new Animation(sprites.getRowReversed(2), 10).setPlayOnce(true);
    private static final Animation run = new Animation(sprites.getRow(3), 10);



    public static enum ChickenState {
        SITTING,
        BUSY,
        READY,
        MOVING
    };

    private ChickenState state = ChickenState.SITTING;
    private double speed = 1 + Math.random() * 3;

    public Chicken(Point2D pos) {
        super(sprites, pos);
        this.view.setFitWidth(32 * World.SCALE);
        this.view.setPreserveRatio(true);
        this.stand();
    }


    Point2D target = null;

    public void dropEgg() {
        World.spawn(Egg.class, this.getPosition());
    }

    public void sit() {
        state = ChickenState.BUSY;
        setAnimation(sit);
    }

    public void stand() {
        state = ChickenState.BUSY;
        setAnimation(rise);
    }

    @Override
    public void update() {
        super.update();

        // used for blocking animations
        if (state == ChickenState.BUSY) {
            if (activeAnimation.hasPlayedOnce()) {
                if (activeAnimation == sit) {
                    state = ChickenState.SITTING;
//                    System.out.println("Sat down");
                } else if (activeAnimation == rise) {
                    state = ChickenState.READY;
//                    System.out.println("Stood up");
                }
            }
            return;
        }

        if (state == ChickenState.SITTING) {
            // if there's work to do, get up!
            if (target != null && this.distanceFrom(target) > 10) {
                stand();
            } else {
                // 3 percent chance to stand up
                if (true) {
                    dropEgg();
                    stand();
                } else if (Math.random() < 0.3) {
                    stand();
                }
            }
        } else if (state == ChickenState.READY) {
            if (target != null) {
                state = ChickenState.MOVING;
            } else { // there is no target
                if (target == null && Math.random() < 0.05 && activeAnimation.hasPlayedOnce()) {
                    target = new Point2D(50 + Math.random()*(300), 50 + Math.random()*(300));
                } else {
                    setAnimation(peck);
                }
            }
        } else if (state == ChickenState.MOVING) {
            // take a break if we reached the target
            if (this.getPosition().distance(target) < 10) {
                target = null;
                sit();
            } else {
                this.velocity = target.subtract(this.getPosition()).normalize().multiply(this.speed);
                setAnimation(velocity.magnitude() < 2 ? walk : run);
            }
        }





//        if (Keyboard.down(KeyCode.RIGHT)) {
//
//        } else if (Keyboard.down(KeyCode.LEFT)) {
//
//        }
//
//        if (Keyboard.down(KeyCode.UP)) {
//
//        } else if (Keyboard.down(KeyCode.DOWN)) {
//
//        }
        this.view.toFront();

    }

}
