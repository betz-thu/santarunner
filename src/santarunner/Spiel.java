package santarunner;

import processing.core.PApplet;
import processing.event.KeyEvent;
import santarunner.welt.ISpielWelt;
import santarunner.welt.SpielWelt;
import santarunner.welt.SpielWeltErzeuger;

public class Spiel extends PApplet {

    SpielWelt welt;
    SpielWeltErzeuger erzeuger;
    long timestampLetzterAbwurf = -1;

    boolean wGedrueckt = false;
    boolean aGedrueckt = false;
    boolean sGedrueckt = false;
    boolean dGedrueckt = false;

    public Spiel() {
        welt = new SpielWelt();
        erzeuger = new SpielWeltErzeuger(welt);
        erzeuger.initSpielWelt();
    }

    @Override
    public void settings() {
        width = ISpielWelt.BREITE;
        height = ISpielWelt.HOEHE;
    }

    @Override
    public void draw() {
        verarbeiteEingabe();
        welt.bewege();
        welt.zeichne(this);
    }

    private void verarbeiteEingabe() {
        if (aGedrueckt && !dGedrueckt) {
            welt.bewegeSchlittenNachLinks();
        } else if (!aGedrueckt && dGedrueckt) {
            welt.bewegeSchlittenNachRechts();
        }

        if (wGedrueckt && !sGedrueckt) {
            welt.bewegeSchlittenNachOben();
        } else if (!wGedrueckt && sGedrueckt) {
            welt.bewegeSchlittenNachUnten();
        }
    }

    @Override
    public void keyPressed(KeyEvent event) {
        super.keyPressed(event);
        if (event.getKey() == ' ' && zeitSeitLetztemAbwurf() > 1000) {
            this.timestampLetzterAbwurf = System.currentTimeMillis();
            welt.wirfGeschenk();
        }

        if (event.getKey() == 'w') {
            wGedrueckt = true;
        } else if (event.getKey() == 'a') {
            aGedrueckt = true;
        } else if (event.getKey() == 's') {
            sGedrueckt = true;
        } else if (event.getKey() == 'd') {
            dGedrueckt = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent event) {
        super.keyReleased();

        if (event.getKey() == 'w') {
            wGedrueckt = false;
        } else if (event.getKey() == 'a') {
            aGedrueckt = false;
        } else if (event.getKey() == 's') {
            sGedrueckt = false;
        } else if (event.getKey() == 'd') {
            dGedrueckt = false;
        }
    }

    private long zeitSeitLetztemAbwurf() {
        return System.currentTimeMillis() - timestampLetzterAbwurf;
    }
}
