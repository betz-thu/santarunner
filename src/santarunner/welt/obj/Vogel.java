package santarunner.welt.obj;

public class Vogel extends FlugObjekt {

    public Vogel(int x, int y) {
        super(x, y, 25, 25);
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
        welt.machSchlittenUnsichtbar();
    }

}
