import processing.core.PApplet;

public class MyApplet extends PApplet {

    int y = 0;

    @Override
    public void settings() {
        width = 600;
        height = 600;
    }

    @Override
    public void draw() {

        if (keyPressed && key == ' ') {
            y = mouseY;
        }

        if (keyPressed && keyCode == UP) {
            y -= 10;
        }

        background(255, 255, 255);
        rect(100, y, 100, 100);
    }

    private void bewegeAlles() {

    }

    private void zeichneAlles() {

    }

    public static void main(String[] args) {
        String[] arguments = {"santarunner"};
        PApplet.runSketch(arguments, new MyApplet());
    }
}
