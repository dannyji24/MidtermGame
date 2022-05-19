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
    int direction = 2;

    //Body size of the snake and apple(probably subject to change)
    int blockSize = 20;

    //x value for apple
    int appleX = 20;

    //y value for apple
    int appleY = 15;

    //boolean control for winning/losing
    boolean youLose = false;

    int speed = 8;

    boolean youWin = false;

    boolean update;

    //Main method to run PApplet stuff
    public static void main(String[] args) {
        String[] mySketch = new String[]{"Main"};
        PApplet.main(mySketch);

    }

    //Methods from PApplet overwritten in our code to actually do graphics

    //Settings: basically makes the window that we run snake on
    public void settings(){
        size(600,600);
        xPath.add(10);
        yPath.add(15);
    }

    //Draw: makes all of the visual changes
    public void draw(){
        boolean flag;
        background(0);
        fill(102, 255, 0);
        for (int i = 0; i < xPath.size(); i++) {
            rect(xPath.get(i)*blockSize, yPath.get(i)*blockSize, blockSize,blockSize);
        }

        // score of the game
        int score = xPath.size()-1;

        if (!youLose) {
            fill(255,0,0);

            rect(appleX*blockSize, appleY*blockSize, blockSize, blockSize);
            textAlign(LEFT);
            textSize(25);
            fill(173,216,230);


            text("Score: " + score, 10, 10, width + 100, 50);
            if (frameCount%speed == 0) {
                update = true;
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
                        speed -= 1;
                    }

                    //while loop to ensure apple does not spawn in snake
                    flag = false;
                    while(!flag){
                        int count=0;
                        appleX = (int) random(0, width);
                        appleY = (int) random(0, height);
                        for (int i = 1; i < xPath.size(); i++) {
                            if (xPath.get(i) == appleX && yPath.get(i) == appleY) {
                                count++;
                            }
                        }
                        if(count==0){
                            flag=true;
                        }
                    }

                }
                else {
                    xPath.remove(xPath.size()-1);
                    yPath.remove(yPath.size()-1);
                }
            }
        }
        //Settings: Sets up Game Over Screen and Play Again
        else {
            fill(173,216,230);
            textSize(30);
            textAlign(CENTER);
            text("GAME OVER \n Your Score is: " + score + "\n Press ENTER to Play Again", width + 275, height+75);
            if (keyCode == ENTER) {
                xPath.clear();
                yPath.clear();
                xPath.add(10);
                yPath.add(15);
                appleX = 20;
                appleY = 15;
                direction = 2;
                speed = 8;
                youLose = false;
            }
        }
        //
    }

    //KeyPressed: User interface
    public void keyPressed() {
        int newDirection;
        if (keyCode == DOWN && direction!=1 && update == true) {
            newDirection = 0;
            update = false;
        }
        else if (keyCode == UP && direction!=0 && update == true) {
            newDirection = 1;
            update = false;
        }
        else if (keyCode == RIGHT && direction!=3 && update == true) {
            newDirection = 2;
            update = false;
        }
        else if (keyCode == LEFT && direction!=2 && update == true) {
            newDirection = 3;
            update = false;
        }
        else {
            newDirection = -1;
        }
        if (newDirection != -1) {
            direction = newDirection;
        }
    }
}

