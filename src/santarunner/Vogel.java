package santarunner;

import santarunner.welt.SpielWelt;

public class Vogel extends FlugObjekt {

    public Vogel(ISpielWelt welt, int x, int y) {
        super(welt, x, y, 10, 10);
    }

    public void bewege() {
        x -= 1;
        if (x < -breite) {
            x = 600;
        }
    }

    @Override
    public void onKollisionMitSchlitten() {
        welt.wirfGeschenk();
    }
}
