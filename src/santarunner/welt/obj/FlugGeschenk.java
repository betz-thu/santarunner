package santarunner.welt.obj;

import processing.core.PApplet;

public class FlugGeschenk extends FlugObjekt {

    public FlugGeschenk(int x, int y) {
        super(x, y, 25, 25);
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
