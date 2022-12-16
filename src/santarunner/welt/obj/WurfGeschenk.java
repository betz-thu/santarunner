package santarunner.welt.obj;

import santarunner.welt.ISpielWelt;

public class WurfGeschenk extends SpielObjekt {
    public WurfGeschenk(int x, int y) {
        super(x, y, 10, 10);
    }

    @Override
    public void bewege() {
        y += 2;
        x -= 1;
    }

    public void onTreffer() {
        welt.erhoeheZeit();
        welt.entferneWurfGeschenk(this);
    }
}
