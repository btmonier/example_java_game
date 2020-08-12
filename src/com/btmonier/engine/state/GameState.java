package com.btmonier.engine.state;

import com.btmonier.engine.Game;
import com.btmonier.engine.entities.Player;
import com.btmonier.engine.tiles.Tile;

import java.awt.*;

public class GameState extends State {
    private Player player;
    public GameState(Game game) {
        super(game);
        player = new Player(game, 100, 100);
    }

    @Override
    public void tick() {
        player.tick();
    }

    @Override
    public void render(Graphics g) {
        Tile.tiles[0].render(g, 0, 0);
        Tile.tiles[1].render(g, 32, 0);
        player.render(g);
    }
}
