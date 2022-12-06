package santarunner.welt;

import processing.core.PApplet;
import santarunner.*;

import java.util.ArrayList;
import java.util.List;




public class SpielWelt {

    List<DekoObjekt> dekoObjekte;
    List<FlugObjekt> flugObjekte;
    List<WurfGeschenk> wurfGeschenke;
    List<Kamin> kamine;

    Schlitten schlitten;

    public SpielWelt() {
        wurfGeschenke = new ArrayList<>();
        flugObjekte = new ArrayList<>();
        kamine = new ArrayList<>();
        dekoObjekte = new ArrayList<>();
    }

    void addDekoObjekt(DekoObjekt dekoObjekt) {
        this.dekoObjekte.add(dekoObjekt);
    }

    void addWurfGeschenk(WurfGeschenk geschenk) {
        this.wurfGeschenke.add(geschenk);
    }

    void addKamin(Kamin kamin) {
        this.kamine.add(kamin);
    }

    void addFlugObjekt(FlugObjekt flugObjekt) {
        this.flugObjekte.add(flugObjekt);
    }

    public void bewege() {
        for (SpielObjekt objekt: this.alleObjekte()) {
            objekt.bewege();
        }
    }

    public void zeichne(PApplet app) {
        app.background(10, 20, 100);
        for (SpielObjekt objekt: this.alleObjekte()) {
            objekt.zeichne(app);
        }
    }

    List<SpielObjekt> alleObjekte() {
        List<SpielObjekt> objekte = new ArrayList<>();
        objekte.add(schlitten);
        objekte.addAll(dekoObjekte);
        objekte.addAll(wurfGeschenke);
        objekte.addAll(flugObjekte);
        objekte.addAll(kamine);
        return objekte;
    }

    public void schlittenAuf() {
        this.schlitten.auf();
    }

    public void schlittenAb() {
        this.schlitten.ab();
    }

    public void wirfGeschenk() {
        this.wurfGeschenke.add(new WurfGeschenk(schlitten.getX(), schlitten.getY()));
    }


    public void bewegeSchlittenNachOben() {
        schlitten.bewegeNachOben();
    }

    public void bewegeSchlittenNachUnten() {
        schlitten.bewegeNachUnten();
    }
}
