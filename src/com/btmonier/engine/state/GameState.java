package com.btmonier.engine.state;

import com.btmonier.engine.Game;
import com.btmonier.engine.entities.Player;
import com.btmonier.engine.tiles.Tile;
import com.btmonier.engine.worlds.World;

import java.awt.*;

public class GameState extends State {
    private Player player;
    private World world;

    public GameState(Game game) {
        super(game);
        player = new Player(game, 100, 100);
        world = new World("res/worlds/world_01.txt");
    }

    @Override
    public void tick() {
        world.tick();
        player.tick();
    }

    @Override
    public void render(Graphics g) {
        world.render(g);
        player.render(g);
    }
}
