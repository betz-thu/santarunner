package santarunner;

import santarunner.welt.SpielWelt;

public abstract class DekoObjekt extends SpielObjekt {
    public DekoObjekt(SpielWelt welt, int x, int y, int breite, int hoehe) {
        super(welt, x,y,breite,hoehe);
    }
}
