package com.btmonier.engine.graphics;

import java.awt.image.BufferedImage;

public class Assets {
    private static final int width = 16, height = 16;
    public static BufferedImage scout, heavy, waterLight, waterMed, grassLight, grassMed, dirtLight, dirtMed;

    public static void init() {
        SpriteSheet chars = new SpriteSheet(ImageLoader.loadImage("/textures/chars.png"));
        SpriteSheet tiles = new SpriteSheet(ImageLoader.loadImage("/textures/tiles.png"));
        scout = chars.crop(0, 0, width, height);
        heavy = chars.crop(0, 64, width, height);
        waterLight = tiles.crop(0, 0, width, height);
        waterMed = tiles.crop(width, 0, width, height);
        grassLight = tiles.crop(width * 2, 0, width, height);
        grassMed = tiles.crop(width * 3, 0, width, height);
        dirtLight = tiles.crop(width * 4, 0, width, height);
        dirtMed = tiles.crop(width * 5, 0, width, height);

    }

}
