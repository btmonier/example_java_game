package com.btmonier.engine;

public class GameContainer {

    public static void main(String[] args) {
        String title = "MonierEngine v0.1";
        System.out.println("Launching " + title + "...");

        Game game = new Game(title, 400, 400);
        game.start();
    }

}

