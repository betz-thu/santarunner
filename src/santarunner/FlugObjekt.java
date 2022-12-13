package santarunner;

import santarunner.welt.SpielWelt;

public abstract class FlugObjekt extends SpielObjekt {

    public FlugObjekt(ISpielWelt welt, int x, int y, int breite, int hoehe) {
        super(welt, x, y, breite, hoehe);
    }

    public abstract void onKollisionMitSchlitten();
}
