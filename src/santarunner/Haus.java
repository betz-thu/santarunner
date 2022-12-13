package santarunner;

import processing.core.PApplet;
import santarunner.welt.SpielWelt;

public class Haus extends DekoObjekt {

    Kamin kamin;

    public Haus(SpielWelt welt, int x) {
        super(welt, x, 450, 100, 100);
        this.kamin = new Kamin(welt,this);
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
