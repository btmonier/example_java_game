package com.btmonier.engine.entities;

public abstract class Mob extends Entity {
    public static final int DEFAULT_HEALTH = 10;
    public static final float DEFAULT_SPEED = 3.0f;
    public static final int DEFAULT_MOB_WIDTH = 32;
    public static final int DEFAULT_MOB_HEIGHT = 32;
    protected int health;
    protected float speed;
    protected float xMove;
    protected float yMove;

    public Mob(float x, float y, int width, int height) {
        super(x, y, width, height);
        health = DEFAULT_HEALTH;
        speed = DEFAULT_SPEED;
        xMove = 0;
        yMove = 0;
    }

    public void move() {
        x += xMove;
        y += yMove;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public float getSpeed() {
        return speed;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }

    public float getxMove() {
        return xMove;
    }

    public void setxMove(float xMove) {
        this.xMove = xMove;
    }

    public float getyMove() {
        return yMove;
    }

    public void setyMove(float yMove) {
        this.yMove = yMove;
    }
}
