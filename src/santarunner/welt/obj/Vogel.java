package santarunner.welt.obj;

import santarunner.welt.ISpielWelt;

public class Vogel extends FlugObjekt {

    public static final int PERIODE = 60;
    public static final int AMPLITUDE = 30;

    int zyklen = 0;
    int mittlereHoehe;
    int periode = PERIODE;
    int amplitude = AMPLITUDE;

    public Vogel(int x, int y) {
        super(x, y, 10, 10);
        this.mittlereHoehe = y;
    }

    public void setZyklen(int zyklen) {
        this.zyklen = zyklen;
    }

    public void bewege() {
        zyklen += 1;

        x -= 1;
        if (x < -breite) {
            x = 600;
        }

        double dy = amplitude * Math.sin(zyklen * 2 * Math.PI / periode);
        y = mittlereHoehe + (int) dy;
    }

    @Override
    public void onKollisionMitSchlitten() {
        welt.wirfGeschenk();
        welt.machSchlittenUnsichtbar();
    }
}
