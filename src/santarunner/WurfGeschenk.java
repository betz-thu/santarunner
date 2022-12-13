package santarunner;

import santarunner.welt.SpielWelt;

public class WurfGeschenk extends SpielObjekt {
    public WurfGeschenk(ISpielWelt welt, int x, int y) {
        super(welt, x, y, 10, 10);
    }

    @Override
    public void bewege() {
        y += 2;
        x -= 1;
    }

}
