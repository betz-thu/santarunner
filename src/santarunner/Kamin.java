package santarunner;

import santarunner.welt.SpielWelt;

public class Kamin extends SpielObjekt {

    Haus haus;

    public Kamin(ISpielWelt welt, Haus haus) {
        super(welt, haus.x, 450, 20, 20);
        this.haus = haus;
    }

    public void bewege() {
        this.x = haus.getX() + 70;
    }
}
