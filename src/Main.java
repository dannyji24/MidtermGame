import processing.core.*;

public class Main extends PApplet {
    public static void main(String[] args) {
        String[] mySketch = new String[]{"Main"};
        PApplet.main(mySketch);
    }
    public void settings(){
        size(600,600);
    }
    public void draw(){
        //background(64);
        ellipse(mouseX, mouseY,10, 10);
    }
    public void keyPressed() {

    }
}

