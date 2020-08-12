package com.btmonier.engine.graphics;

import java.awt.image.BufferedImage;

public class Assets {
    private static final int width = 16, height = 16;
    public static BufferedImage scout, heavy, grass, water;

    public static void init() {
        SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/textures/chars.png"));
        scout = sheet.crop(0, 0, width, height);
        heavy = sheet.crop(0, 64, width, height);
        grass = sheet.crop(16, 144, width, height);
        water = sheet.crop(0, height * 9, width, height);
    }

}
