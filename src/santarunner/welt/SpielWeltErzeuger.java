package santarunner.welt;

import santarunner.*;

public class SpielWeltErzeuger {
    private final SpielWelt welt;

    public SpielWeltErzeuger(SpielWelt welt) {
        this.welt = welt;
    }

    public void initSpielWelt() {
        welt.schlitten = new Schlitten(200, 200);
        welt.dekoObjekte.add(new Haus(100));
        welt.kamine.add(new Kamin(170));
        welt.dekoObjekte.add(new Haus(500));
        welt.kamine.add(new Kamin(170));

        welt.flugObjekte.add(new Geschenk(400, 100));
        welt.flugObjekte.add(new Vogel(450, 150));
    }
}
