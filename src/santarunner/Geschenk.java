package santarunner;

import processing.core.PApplet;

public class Geschenk extends FlugObjekt {

    public Geschenk(int x, int y) {
        super(x, y, 10, 10);
    }

    public void bewege() {
        x -= 1;
        if (x < -breite) {
            x = 600;
        }
    }

    @Override
    public void zeichne(PApplet app) {
        app.pushStyle();
        app.fill(230, 15, 15);
        app.rect(x, y, breite, hoehe);
        app.popStyle();
    }
}
