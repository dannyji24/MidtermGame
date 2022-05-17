import processing.core.*;

import java.util.ArrayList;

/**
 * Main Class for Snake Game
 */
public class Main extends PApplet {

    //Array List for the x movements of the snake
    ArrayList<Integer> xPath = new ArrayList<>();

    //Array List for the y movements of the snake
    ArrayList<Integer> yPath = new ArrayList<>();

    //Last two allow for left right movement
    int[] xMovement = {0, 0, 1, -1};

    //First two allow for up down movement
    int[] yMovement = {1, -1, 0, 0};

    //Width of the board
    int width = 30;

    //Height of the board
    int height = 30;

    //Direction of snake
    int direction = 0;

    //Body size of the snake and apple(probably subject to change)
    int blockSize = 20;

    //x value for apple
    int appleX = (int) random(0, width);

    //y value for apple
    int appleY = (int) random(0, height);

    //boolean control for winning/losing
    boolean youLose = false;

    int speed = 8;

    //Main method to run PApplet stuff
    public static void main(String[] args) {
        String[] mySketch = new String[]{"Main"};
        PApplet.main(mySketch);

    }

    //Methods from PApplet overwritten in our code to actually do graphics

    //Settings: basically makes the window that we run snake on
    public void settings(){
        size(600,600);
        xPath.add(0);
        yPath.add(15);
    }

    //Draw: makes all of the visual changes
    public void draw(){
        background(0);
        fill(102, 255, 0);
        for (int i = 0; i < xPath.size(); i++) {
            rect(xPath.get(i)*blockSize, yPath.get(i)*blockSize, blockSize,blockSize);
        }
        if (!youLose) {
            fill(255,0,0);
            rect(appleX*blockSize, appleY*blockSize, blockSize, blockSize);
            textAlign(LEFT);
            textSize(25);
            fill(0,0,255);
            text("Score: " + xPath.size(), 10, 10, width + 100, 50);
            if (frameCount%speed == 0) {
                xPath.add(0, xPath.get(0) + xMovement[direction]);
                yPath.add(0, yPath.get(0) + yMovement[direction]);
                if (xPath.get(0) < 0 || yPath.get(0) < 0|| xPath.get(0) >= width || yPath.get(0) >= height) {
                    youLose = true;
                }
                for (int i = 1; i < xPath.size(); i++) {
                    if (xPath.get(0) == xPath.get(i) && yPath.get(0) == yPath.get(i)) {
                        youLose = true;
                    }
                }
                if (xPath.get(0) == appleX && yPath.get(0) == appleY) {
                    if (xPath.size()%5==0 && speed >= 2) {
                        speed--;
                    }
                    appleX = (int) random(0,width);
                    appleY = (int) random(0, height);
                }
                else {
                    xPath.remove(xPath.size()-1);
                    yPath.remove(yPath.size()-1);
                }
            }
        }
        else {
            fill(0,255,0);
            textSize(30);
            textAlign(CENTER);
            text("GAME OVER \n Your Score is: " + xPath.size() + "\n Press ENTER", width + 275, height+75);
            if (keyCode == ENTER) {
                xPath.clear();
                yPath.clear();
                xPath.add(15);
                yPath.add(15);
                direction = 2;
                speed = 8;
                youLose = false;
            }
        }
    }

    //KeyPressed: User interface
    public void keyPressed() {
        int newDirection;
        if (keyCode == DOWN) {
            newDirection = 0;
        }
        else if (keyCode == UP) {
            newDirection = 1;
        }
        else if (keyCode == RIGHT) {
            newDirection = 2;
        }
        else if (keyCode == LEFT) {
            newDirection = 3;
        }
        else {
            newDirection = -1;
        }
        if (newDirection != -1) {
            direction = newDirection;
        }
    }
}

