package me.ausaf.graphics;

import javafx.geometry.Rectangle2D;

public class Animation {

    private final Rectangle2D[] frames;
    private final int delay;

    private int ticks = 0;
    private int index = 0;
    private int playCount = 0;
    private boolean playing = true;
    private boolean playOnce = false;

    public Animation(Rectangle2D[] frames, int delay) {
        this.frames = frames;
        this.delay = delay;
    }

    public Animation(Rectangle2D frame) {
        this.frames = new Rectangle2D[]{frame};
        this.delay = 1;
        this.playing = false;
    }

    public Animation and(Animation other) {
        Rectangle2D[] combo = new Rectangle2D[this.frames.length + other.frames.length];
        for (int i = 0; i < this.frames.length; i++) {
            combo[i] = this.frames[i];
        }
        for (int i = 0; i < other.frames.length; i++) {
            combo[i + this.frames.length] = other.frames[i];
        }

        return new Animation(combo, this.delay);
    }

    public void animate() {
        if (!playing) return;

        ticks++;
        if (ticks % delay == 0) {
            ticks = 0;
            index++;
            if (index == frames.length) {
                if (playOnce) {
                    playing = false;
                    index--;
                } else {
                    index = 0;
                }
                playCount++;

            }
        }
    }

    public Animation setPlayOnce(boolean status) {
        this.playOnce = status;
        return this;
    }

    public boolean hasPlayedOnce() {
        return playCount > 0;
    }


    public Animation setPlaying(boolean status) {
        this.playing = status;
        return this;
    }

    public Animation restart() {
        this.ticks = 0;
        this.playCount = 0;
        this.index = 0;
        this.playing = true;
        return this;
    }

    public Rectangle2D getFrame(){
        return frames[this.index];
    }

    public int getPlayCount() { return this.playCount; }
}
