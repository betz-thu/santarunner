package santarunner.welt.obj;

import processing.core.PApplet;
import processing.core.PImage;
import santarunner.welt.ISpielWelt;

public class Vogel extends FlugObjekt {

    public static final int AMPLITUDE = 80;
    public static final int PERIODE = 120;


    int basisHoehe;
    int phase;

    PImage frame1 = null;
    PImage frame2 = null;

    public Vogel(int x, int y) {
        super(x, y, 50, 50);
        basisHoehe = y;
    }

    public int getPhase() {
        return phase;
    }

    public void setPhase(int phase) {
        this.phase = phase;
    }

    public void bewege() {
        x -= 1;
        if (x < -breite) {
            x = ISpielWelt.BREITE;
        }

        y = (int) (basisHoehe + AMPLITUDE * Math.sin((welt.getZyklenSeitBeginn() + phase) * 2 * Math.PI / PERIODE ));
    }

    @Override
    public void onKollisionMitSchlitten() {
        welt.wirfGeschenk();
        welt.machSchlittenUnsichtbar();
    }

    @Override
    public void zeichne(PApplet app) {
        if (frame1 == null) {
            frame1 = app.loadImage("resources/frame-1.png");
        }
        if (frame2 == null) {
            frame2 = app.loadImage("resources/frame-2.png");
        }

        if ((welt.getZyklenSeitBeginn() + phase) % 60 < 30) {
            app.image(frame1, x, y, breite, hoehe);
        } else {
            app.image(frame2, x, y, breite, hoehe);
        }

        if (welt.isDevMode()) {
            super.zeichne(app);
        }
    }
}
