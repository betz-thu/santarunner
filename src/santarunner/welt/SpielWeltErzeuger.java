package santarunner.welt;

import santarunner.*;

public class SpielWeltErzeuger {
    private final SpielWelt welt;

    public SpielWeltErzeuger(SpielWelt welt) {
        this.welt = welt;
    }

    public void initSpielWelt() {
        welt.schlitten = new Schlitten(welt, 200, 200);
        welt.dekoObjekte.add(new Haus(welt,100));
        welt.dekoObjekte.add(new Haus(welt,500));

        welt.flugObjekte.add(new Geschenk(welt,400, 100));
        welt.flugObjekte.add(new Vogel(welt,450, 150));
    }
}
