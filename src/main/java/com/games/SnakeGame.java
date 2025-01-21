package com.games;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.*;


import static javax.swing.text.StyleConstants.setBackground;

public class SnakeGame extends JPanel implements ActionListener, KeyListener{

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
    int velocityX;
    int velocityY;

    SnakeGame(int boardWidth, int boardHeight) {
        this.boardWidth = boardWidth;
        this.boardHeight = boardHeight;
        setPreferredSize(new Dimension(this.boardWidth, this.boardHeight));
        setBackground(Color.pink);
        addKeyListener(this);
        setFocusable(true);

        //snake
        snakeHead = new Tile(5,5);

        //food
        food = new Tile(10,10);
        random = new Random();
        placeFood();

        velocityX = 0;
        velocityY = 0;

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

    public void move() {
        //snake head
        snakeHead.x += velocityX;
        snakeHead.y += velocityY;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        move();
        repaint();
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_UP && velocityY != 1) {
            velocityX = 0;
            velocityY = -1;
        } else if (e.getKeyCode() == KeyEvent.VK_DOWN && velocityY != -1) {
            velocityX = 0;
            velocityY = 1;
        } else if (e.getKeyCode() == KeyEvent.VK_LEFT && velocityX != 1) {
            velocityX = -1;
            velocityY = 0;
        } else if (e.getKeyCode() == KeyEvent.VK_RIGHT && velocityX != -1) {
            velocityX = 1;
            velocityY = 0;
        }

    }
        

    //VVV DO NOT NEED VVV
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
    //^^^ DO NOT NEED ^^^
}
