package santarunner;

import processing.core.PApplet;
import santarunner.welt.SpielWelt;

public class Geschenk extends FlugObjekt {

    public Geschenk(SpielWelt welt, int x, int y) {
        super(welt, x, y, 10, 10);
    }
    @Override
    public void onKollisionMitSchlitten() {
        welt.sammleGeschenkEin(this);
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
