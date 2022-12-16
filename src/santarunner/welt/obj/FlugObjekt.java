package santarunner.welt.obj;

import santarunner.welt.ISpielWelt;

public abstract class FlugObjekt extends SpielObjekt {



    public FlugObjekt(int x, int y, int breite, int hoehe) {
        super(x, y, breite, hoehe);
    }



    public abstract void onKollisionMitSchlitten();
}
