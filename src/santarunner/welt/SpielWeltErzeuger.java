package santarunner.welt;

import santarunner.welt.obj.FlugGeschenk;
import santarunner.welt.obj.Haus;
import santarunner.welt.obj.Schlitten;
import santarunner.welt.obj.Vogel;

import java.util.Random;

public class SpielWeltErzeuger {
    private final SpielWelt welt;
    private final Random random;

    public SpielWeltErzeuger(SpielWelt welt) {
        this.welt = welt;
        this.welt.setErzeuger(this);

        random = new Random();
    }

    public void initSpielWelt() {
        erzeugeSchlitten();
        erzeugeHaeuser();

        erzeugeGeschenk();
        erzeugeGeschenk();
        erzeugeVogel();
        erzeugeVogel();
        erzeugeVogel();
    }

    void erzeugeVogel() {
        int dx = random.nextInt(400);
        int dy = random.nextInt(200);
        int phase = random.nextInt(Vogel.PERIODE);

        Vogel vogel = new Vogel(ISpielWelt.BREITE + dx, 50 + dy);
        vogel.setPhase(phase);

        welt.addFlugObjekt(vogel);
    }

    void erzeugeGeschenk() {
        int dx = random.nextInt(200);
        int dy = random.nextInt(200);
        welt.addFlugObjekt(new FlugGeschenk(ISpielWelt.BREITE + dx, 50 + dy));
    }

    private void erzeugeHaeuser() {
        welt.addHaus(new Haus(100));
        welt.addHaus(new Haus(500));
    }

    private void erzeugeSchlitten() {
        welt.setSchlitten(new Schlitten(200, 200));
    }


}
