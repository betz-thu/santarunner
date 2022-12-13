package santarunner;

import processing.core.PApplet;
import santarunner.welt.SpielWelt;

public abstract class SpielObjekt {

    ISpielWelt welt;
    int x;
    int y;
    int breite;
    int hoehe;

    public SpielObjekt(ISpielWelt welt, int x, int y, int breite, int hoehe) {
        this.welt = welt;
        this.x = x;
        this.y = y;
        this.breite = breite;
        this.hoehe = hoehe;
    }

    public boolean hasKollosionMit(SpielObjekt that) {
        boolean kollisionX = this.getX() + this.getBreite() >= that.getX()
                && that.getX() + that.getBreite() >= this.getX();
        boolean kollisionY = this.getY() + this.getHoehe() >= that.getY()
                && that.getY() + that.getHoehe() >= this.getY();
        return kollisionX && kollisionY;
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
