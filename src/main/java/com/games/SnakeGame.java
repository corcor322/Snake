package com.games;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.*;


import static javax.swing.text.StyleConstants.setBackground;

public class SnakeGame extends JPanel implements ActionListener{

    private class Tile {
        int x;
        int y;

        public Tile(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    int boardWidth;
    int boardHeight;
    int tileSize = 25;

    //snake
    Tile snakeHead;

    //food
    Tile food;
    Random random;

    //game logic

    Timer gameLoop;

    SnakeGame(int boardWidth, int boardHeight) {
        this.boardWidth = boardWidth;
        this.boardHeight = boardHeight;
        setPreferredSize(new Dimension(this.boardWidth, this.boardHeight));
        setBackground(Color.pink);

        //snake
        snakeHead = new Tile(5,5);

        //food
        food = new Tile(10,10);
        random = new Random();
        placeFood();

        //game loop
        gameLoop = new Timer(100, this);
        gameLoop.start();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        draw(g);
    }


    public void draw(Graphics g) {

        //food
        g.setColor(Color.white);
        g.fillRect(food.x * tileSize, food.y * tileSize, tileSize, tileSize );

        //snake
        g.setColor(Color.black);
        g.fillRect(snakeHead.x * tileSize, snakeHead.y * tileSize, tileSize, tileSize);
    }
    public void placeFood() {
        food.x = random.nextInt(boardWidth/tileSize); // 600x25 = 24
        food.y = random.nextInt(boardHeight/tileSize);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
    }
}
