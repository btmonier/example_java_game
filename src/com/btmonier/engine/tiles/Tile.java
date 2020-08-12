package com.btmonier.engine.tiles;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Tile {
    // statics...
    public static Tile[] tiles = new Tile[256];
    public static Tile grassTile = new GrassTile(0);
    public static Tile waterTile = new WaterTile(1);


    protected BufferedImage texture;
    protected final int id;
    public static final int TILEWIDTH = 32;
    public static final int TILEHEIGHT = 32;

    public Tile(BufferedImage texture, int id) {
        this.texture = texture;
        this.id = id;
        tiles[id] = this;
    }

    public void tick() {

    }

    public void render(Graphics g, int x, int y) {
         g.drawImage(texture, x, y, TILEWIDTH, TILEHEIGHT, null);
    }

    public boolean isSolid () {
        return false;
    }

    public int getId() {
        return id;
    }
}
