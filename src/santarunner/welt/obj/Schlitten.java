package santarunner.welt.obj;

import processing.core.PApplet;
import processing.core.PImage;
import santarunner.welt.ISpielWelt;

public class Schlitten extends SpielObjekt {

    public static final int ZYKLEN_UNSICHTBARKEIT = 60;
    public static final int BREITE = 96;
    public static final int HOEHE = 40;

    public static final int BEWEGUNG_DELTA = 3;

    private int unsichtbar = 0;

    PImage[] frames = null;

    public Schlitten(int x, int y) {
        super(x, y, BREITE, HOEHE);
    }

    @Override
    public void bewege() {
        //  Der Schlitten bewegt sich nicht von selbst.
    }


    public void bewegeNachOben() {
        y -= BEWEGUNG_DELTA;
    }

    public void bewegeNachUnten() {
        y += BEWEGUNG_DELTA;
    }

    public void bewegeNachRechts() {
        x += BEWEGUNG_DELTA;
    }

    public void bewegeNachLinks() {
        x -= BEWEGUNG_DELTA;
    }

    public void machUnsichtbar() {
        this.unsichtbar = Math.max(this.unsichtbar, ZYKLEN_UNSICHTBARKEIT);
    }

    @Override
    public boolean hasKollosionMit(SpielObjekt that) {
        if (this.unsichtbar > 0) {
            return false;
        }
        return super.hasKollosionMit(that);
    }

    @Override
    public void zeichne(PApplet app) {
        loadFrames(app);

        this.unsichtbar -= 1;
        if (this.unsichtbar % 2 == 1) {
            return;
        }

        int frameIndex = interneZeit() % 40 / 5;
        app.image(frames[frameIndex], x, y, breite ,hoehe);

        super.zeichne(app);
    }

    private void loadFrames(PApplet app) {
        if (frames == null) {
            this.frames = loadFrames(app,"resources/schlitten/frame-%d.png", 8);
        }
    }
}
