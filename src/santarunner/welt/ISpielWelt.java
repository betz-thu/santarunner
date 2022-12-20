package santarunner.welt;

import santarunner.welt.obj.*;

public interface ISpielWelt {

    public static final int BREITE = 600;
    public static final int HOEHE = 600;

    int getZyklenSeitBeginn();

    void wirfGeschenk();

    void sammleGeschenkEin(FlugGeschenk flugGeschenk);

    void machSchlittenUnsichtbar();

    void addHaus(Haus haus);

    void addWurfGeschenk(WurfGeschenk wurfGeschenk);

    void addFlugObjekt(FlugObjekt flugObjekt);

    void setSchlitten(Schlitten schlitten);

    void erhoeheZeit();

    void entferneWurfGeschenk(WurfGeschenk wurfGeschenk);

    boolean isDevMode();
}
