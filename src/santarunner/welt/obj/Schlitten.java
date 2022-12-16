package santarunner.welt.obj;

import processing.core.PApplet;
import santarunner.welt.ISpielWelt;

public class Schlitten extends SpielObjekt {

    public static final int ZYKLEN_UNSICHTBARKEIT = 60;

    private int unsichtbar = 0;

    public Schlitten(int x, int y) {
        super(x, y, 60, 30);
    }

    @Override
    public void bewege() {
        //  Der Schlitten bewegt sich nicht von selbst.
    }


    public void bewegeNachOben() {
        y -= 2;
    }

    public void bewegeNachUnten() {
        y += 2;
    }

    public void bewegeNachRechts() {
        x += 2;
    }

    public void bewegeNachLinks() {
        x -= 2;
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
        this.unsichtbar -= 1;
        if (this.unsichtbar % 2 == 1) {
            return;
        }
        super.zeichne(app);
    }
}
