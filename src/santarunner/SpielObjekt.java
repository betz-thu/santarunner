package santarunner;

import processing.core.PApplet;

public abstract class SpielObjekt {

    int x;
    int y;
    int breite;
    int hoehe;

    public SpielObjekt(int x, int y, int breite, int hoehe) {
        this.x = x;
        this.y = y;
        this.breite = breite;
        this.hoehe = hoehe;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getBreite() {
        return breite;
    }

    public int getHoehe() {
        return hoehe;
    }

    public abstract void bewege();

    public void zeichne(PApplet app) {
        app.rect(x, y, breite, hoehe);
    }
}
