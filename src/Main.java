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

    //Width of the board
    int width = 32;

    //Height of the board
    int height = 32;

    //Body size of the snake (probably subject to change)
    int snakeBodySize = 20;

    //Main method to run PApplet stuff
    public static void main(String[] args) {
        String[] mySketch = new String[]{"Main"};
        PApplet.main(mySketch);

    }

    //Methods from PApplet overwritten in our code to actually do graphics

    //Settings: basically makes the window that we run snake on
    public void settings(){
        size(600,600);
    }

    //Draw: makes all of the visual changes
    public void draw(){
        background(64);
        for (int i = 0; i < xPath.size(); i++) {

        }
    }

    //KeyPressed: User interface?
    public void keyPressed() {

    }
}

