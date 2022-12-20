package santarunner.welt.obj;

import processing.core.PApplet;
import processing.core.PImage;
import santarunner.welt.ISpielWelt;

public abstract class SpielObjekt {

    ISpielWelt welt;
    int x;
    int y;
    int breite;
    int hoehe;
    int phase;

    public SpielObjekt(int x, int y, int breite, int hoehe) {
        this.x = x;
        this.y = y;
        this.breite = breite;
        this.hoehe = hoehe;
    }

    protected ISpielWelt getWelt() {
        return welt;
    }

    public void setWelt(ISpielWelt welt) {
        this.welt = welt;
    }

    public int getPhase() {
        return phase;
    }

    public void setPhase(int phase) {
        this.phase = phase;
    }

    protected int globaleZeit() {
        return welt.getZyklenSeitBeginn();
    }

    protected int interneZeit() {
        return globaleZeit() + getPhase();
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
        app.pushStyle();
        app.fill(255, 255, 255, 64);
        app.stroke(255, 255, 255);
        app.rect(x, y, breite, hoehe);
        app.popStyle();
    }

    protected PImage[] loadFrames(PApplet app, String template, int n) {
        PImage[] frames = new PImage[n];
        for (int i = 0; i < n; i++) {
            String filename = String.format(template, i + 1);
            frames[i] = app.loadImage(filename);
        }
        return frames;
    }
}
