package santarunner.welt;

import santarunner.*;

public class SpielWeltErzeuger {
    private final SpielWelt welt;

    public SpielWeltErzeuger(SpielWelt welt) {
        this.welt = welt;
    }

    public void initSpielWelt() {
        welt.schlitten = new Schlitten(200, 200);
        {
            Haus haus = new Haus(100);
            welt.dekoObjekte.add(haus);
            welt.kamine.add(haus.getKamin());
        }
        {
            Haus haus = new Haus(500);
            welt.dekoObjekte.add(haus);
            welt.kamine.add(haus.getKamin());
        }

        welt.flugObjekte.add(new Geschenk(400, 100));
        welt.flugObjekte.add(new Vogel(450, 150));
    }
}
