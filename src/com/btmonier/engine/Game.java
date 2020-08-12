package com.btmonier.engine;

import com.btmonier.engine.display.Display;
import com.btmonier.engine.graphics.Assets;
import com.btmonier.engine.input.KeyManager;
import com.btmonier.engine.state.GameState;
import com.btmonier.engine.state.State;

import java.awt.*;
import java.awt.image.BufferStrategy;

public class Game implements Runnable {
    private Display display;
    public int width, height;
    private Thread thread;
    private boolean running = false;
    public String title;
    private BufferStrategy bs;
    private Graphics g;

    //  States
    private State gameState;
    private State menuState;

    // Input
    private KeyManager keyManager;

    public Game(String title, int width, int height) {
        this.width = width;
        this.height = height;
        this.title = title;
        keyManager = new KeyManager();
    }

    // Initialize thread
    private void init() {
        display = new Display(title, width, height);
        display.getFrame().addKeyListener(keyManager);
        Assets.init();
        gameState = new GameState(this);
        State.setState(gameState);
    }

    // Game loop (1) - update (e.g. tick()) AND...
    private void tick() {
        keyManager.tick();
        if (State.getState() != null) {
            State.getState().tick();
        }
    }
    // Game Loop (2) - draw stuff to screen (e.g. render())
    // Buffer - a "hidden" computer screen within your computer...
    // Buffer - a memory set that holds data similar to your computer display
    // Buffering allows us to prevent "screen flickering"
    private void render() {
        bs = display.getCanvas().getBufferStrategy();
        if (bs == null) {
            display.getCanvas().createBufferStrategy(3);
            return;
        }
        g = bs.getDrawGraphics();
        // Clear screen
        g.clearRect(0, 0, width, height);

        // Draw some stuff...
        if (State.getState() != null) {
            State.getState().render(g);
        }
        // End draw

        // Return display
        bs.show();
        g.dispose();
    }

    @Override
    public void run() {
        init();

        int fps = 60;
        double timePerTick = 1000000000.0 / fps;
        double delta = 0;
        long now;
        long lastTime = System.nanoTime();
        long timer = 0;
        int ticks = 0;

        while(running) {
            now = System.nanoTime();
            delta += (now - lastTime) / timePerTick;
            timer += now - lastTime;
            lastTime = now;

            if (delta >= 1) {
                tick();
                render();
                ticks ++;
                delta --;
            }

            if (timer >= 1000000000) {
                System.out.println("FPS: " + ticks);
                ticks = 0;
                timer = 0;
            }
        }

        stop();
    }

    public KeyManager getKeyManager() {
        return keyManager;
    }

    // synchronized - working with threads DIRECTLY
    public synchronized void start() {
        if (running) {
            return;
        } else {
            running = true;
            thread = new Thread(this);
            thread.start();
        }
    }

    public synchronized void stop() {
        if (!running) {
            return;
        } else {
            running = false;
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
