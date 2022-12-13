package santarunner.welt;

import processing.core.PApplet;
import santarunner.*;

import java.util.ArrayList;
import java.util.List;




public class SpielWelt implements ISpielWelt {

    int anzahlGeschenke = 7;
    List<DekoObjekt> dekoObjekte;
    List<FlugObjekt> flugObjekte;
    List<WurfGeschenk> wurfGeschenke;

    Schlitten schlitten;

    public SpielWelt() {
        wurfGeschenke = new ArrayList<>();
        flugObjekte = new ArrayList<>();
        dekoObjekte = new ArrayList<>();
    }

    void addDekoObjekt(DekoObjekt dekoObjekt) {
        this.dekoObjekte.add(dekoObjekt);
    }

    void addWurfGeschenk(WurfGeschenk geschenk) {
        this.wurfGeschenke.add(geschenk);
    }

    void addFlugObjekt(FlugObjekt flugObjekt) {
        this.flugObjekte.add(flugObjekt);
    }

    public void bewege() {
        for (SpielObjekt objekt: this.alleObjekte()) {
            objekt.bewege();
        }
        for (FlugObjekt flugObjekt: this.flugObjekte) {
            if (this.schlitten.hasKollosionMit(flugObjekt)) {
                flugObjekt.onKollisionMitSchlitten();
            }
        }
    }

    public void zeichne(PApplet app) {
        app.background(10, 20, 100);
        for (SpielObjekt objekt: this.alleObjekte()) {
            objekt.zeichne(app);
        }
        app.textSize(20);
        app.text(anzahlGeschenke, 10, 30);
    }

    List<SpielObjekt> alleObjekte() {
        List<SpielObjekt> objekte = new ArrayList<>();
        objekte.add(schlitten);
        objekte.addAll(dekoObjekte);
        objekte.addAll(wurfGeschenke);
        objekte.addAll(flugObjekte);
        return objekte;
    }

    public void wirfGeschenk() {
        if (anzahlGeschenke > 0) {
            anzahlGeschenke -= 1;
            int x = schlitten.getX();
            int y = schlitten.getY();
            this.wurfGeschenke.add(new WurfGeschenk(this, x, y));
        }
    }

    @Override
    public void sammleGeschenkEin(Geschenk geschenk) {
        this.flugObjekte.remove(geschenk);
        anzahlGeschenke += 1;
    }

    public void bewegeSchlittenNachRechts() {
        schlitten.bewegeNachRechts();
    }

    public void bewegeSchlittenNachLinks() {
        schlitten.bewegeNachLinks();
    }


    public void bewegeSchlittenNachOben() {
        schlitten.bewegeNachOben();
    }

    public void bewegeSchlittenNachUnten() {
        schlitten.bewegeNachUnten();
    }
}
