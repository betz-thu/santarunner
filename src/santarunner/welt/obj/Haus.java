package santarunner.welt.obj;

import processing.core.PApplet;
import santarunner.welt.SpielWelt;

public class Haus extends DekoObjekt {

    Kamin kamin;

    public Haus(int x) {
        super(x, 450, 100, 100);
        this.kamin = new Kamin(this);
    }

    public Kamin getKamin() {
        return kamin;
    }

    public void bewege() {
        x -= 1;
        if (x < -breite) {
            x = 600;
        }
        kamin.bewege();
    }

    @Override
    public void zeichne(PApplet app) {
        super.zeichne(app);
        kamin.zeichne(app);
    }
}
