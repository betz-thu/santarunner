package santarunner.welt.obj;

import processing.core.PApplet;
import processing.core.PImage;
import santarunner.welt.ISpielWelt;

public class Vogel extends FlugObjekt {

    public static final int AMPLITUDE = 80;
    public static final int PERIODE = 120;
    public static final int BREITE = 50;
    public static final int HOEHE = 50;


    int basisHoehe;

    PImage[] frames = null;

    public Vogel(int x, int y) {
        super(x, y, BREITE, HOEHE);
        basisHoehe = y;
    }

    public void bewege() {
        x -= 1;
        if (x < -breite) {
            x = ISpielWelt.BREITE;
        }

        y = (int) (basisHoehe + AMPLITUDE * Math.sin(interneZeit() * 2 * Math.PI / PERIODE ));
    }

    @Override
    public void onKollisionMitSchlitten() {
        welt.wirfGeschenk();
        welt.machSchlittenUnsichtbar();
    }

    @Override
    public void zeichne(PApplet app) {
        loadFrames(app);

        if (interneZeit() % 60 < 30) {
            app.image(frames[0], x, y, breite, hoehe);
        } else {
            app.image(frames[1], x, y, breite, hoehe);
        }

        if (welt.isDevMode()) {
            super.zeichne(app);
        }
    }

    private void loadFrames(PApplet app) {
        if (frames == null) {
            this.frames = loadFrames(app,"resources/vogel/frame-%d.png", 2);
        }
    }


}
