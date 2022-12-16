package santarunner.welt;

import processing.core.PApplet;
import santarunner.welt.obj.*;

import java.util.ArrayList;
import java.util.List;




public class SpielWelt implements ISpielWelt {


    private static final int ZYKLEN_PRO_SEKUNDE = 60;
    private static final int VERBLEIBENDE_ZEIT_ZU_BEGINN = 60 * ZYKLEN_PRO_SEKUNDE;
    private static final int ANZAHL_GESCHENKE_ZU_BEGINN = 7;
    private static final int BONUSZEIT_PRO_TREFFER = 10 * ZYKLEN_PRO_SEKUNDE;
    private static final int PERIODE_NEUES_GESCHENK = 11 * ZYKLEN_PRO_SEKUNDE;
    private static final int PERIODE_NEUER_VOGEL = 30 * ZYKLEN_PRO_SEKUNDE;

    int anzahlGeschenke = 7;
    int verbleibendeZeit = 60* 60;
    int zyklenSeitBeginn = 0;
    List<DekoObjekt> dekoObjekte;
    List<FlugObjekt> flugObjekte;
    List<WurfGeschenk> wurfGeschenke;

    Schlitten schlitten;
    private List<Kamin> kamine;


    private SpielWeltErzeuger erzeuger;
    private List<SpielObjekt> zuLoeschen;

    public SpielWelt() {
        anzahlGeschenke = ANZAHL_GESCHENKE_ZU_BEGINN;
        zyklenSeitBeginn = 0;
        verbleibendeZeit = VERBLEIBENDE_ZEIT_ZU_BEGINN;

        wurfGeschenke = new ArrayList<>();
        flugObjekte = new ArrayList<>();
        dekoObjekte = new ArrayList<>();
        kamine = new ArrayList<>();

        zuLoeschen = new ArrayList<>();
    }

    public void setErzeuger(SpielWeltErzeuger erzeuger) {
        this.erzeuger = erzeuger;
    }

    @Override
    public void addWurfGeschenk(WurfGeschenk wurfGeschenk) {
        wurfGeschenk.setWelt(this);
        this.wurfGeschenke.add(wurfGeschenk);
    }

    @Override
    public void addHaus(Haus haus) {
        haus.setWelt(this);
        this.dekoObjekte.add(haus);
        this.kamine.add(haus.getKamin());
    }

    @Override
    public void addFlugObjekt(FlugObjekt flugObjekt) {
        flugObjekt.setWelt(this);
        this.flugObjekte.add(flugObjekt);
    }

    public void bewege() {
        aktualisiereZeit();
        erzeugeGeschenk();
        erzeugeVogel();
        bewegeObjekte();
        verarbeiteKollisionen();
        verarbeiteTreffer();
        aufraeumen();
    }


    public void zeichne(PApplet app) {
        app.background(10, 20, 100);
        for (SpielObjekt objekt: this.alleObjekte()) {
            objekt.zeichne(app);
        }
        app.textSize(20);
        app.text(anzahlGeschenke, 10, 30);

        app.textSize(20);
        app.text(getAngezeigteZeit(), 500, 30);

    }

    private String getAngezeigteZeit() {
        return String.format("%2d:%02d:%02d",
                verbleibendeZeit / 3600,
                verbleibendeZeit % 3600 / 60,
                (int) (100. / 60.) * (verbleibendeZeit % 60));
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
            this.addWurfGeschenk(new WurfGeschenk(x, y));
        }
    }

    @Override
    public void sammleGeschenkEin(FlugGeschenk flugGeschenk) {
        this.zuLoeschen.add(flugGeschenk);
        anzahlGeschenke += 1;
    }

    @Override
    public void machSchlittenUnsichtbar() {
        this.schlitten.machUnsichtbar();
    }

    @Override
    public void setSchlitten(Schlitten schlitten) {
        schlitten.setWelt(this);
        this.schlitten = schlitten;
    }

    @Override
    public void erhoeheZeit() {
        this.verbleibendeZeit += BONUSZEIT_PRO_TREFFER;
    }

    @Override
    public void entferneWurfGeschenk(WurfGeschenk wurfGeschenk) {
        this.zuLoeschen.add(wurfGeschenk);
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

    private void aktualisiereZeit() {
        verbleibendeZeit -= 1;
        zyklenSeitBeginn += 1;
    }

    private void erzeugeGeschenk() {
        if (zyklenSeitBeginn % PERIODE_NEUES_GESCHENK == 0) {
            erzeuger.erzeugeGeschenk();
        }
    }

    private void erzeugeVogel() {
        if (zyklenSeitBeginn % PERIODE_NEUER_VOGEL == 0) {
            erzeuger.erzeugeVogel();
        }
    }



    private void bewegeObjekte() {
        for (SpielObjekt objekt: this.alleObjekte()) {
            objekt.bewege();
        }
    }



    private void verarbeiteKollisionen() {
        for (FlugObjekt flugObjekt: this.flugObjekte) {
            if (this.schlitten.hasKollosionMit(flugObjekt)) {
                flugObjekt.onKollisionMitSchlitten();
            }
        }
    }

    private void verarbeiteTreffer() {
        for (WurfGeschenk geschenk: this.wurfGeschenke) {
            for (Kamin kamin: this.kamine) {
                if (geschenk.hasKollosionMit(kamin)) {
                    geschenk.onTreffer();
                }
            }
        }
    }

    private void aufraeumen() {
        for (SpielObjekt objekt : zuLoeschen) {
            wurfGeschenke.remove(objekt);
            flugObjekte.remove(objekt);
        }
        zuLoeschen.clear();
    }


}
