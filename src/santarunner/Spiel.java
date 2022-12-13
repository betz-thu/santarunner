package santarunner;

import processing.core.PApplet;
import processing.event.KeyEvent;
import santarunner.welt.SpielWelt;
import santarunner.welt.SpielWeltErzeuger;

public class Spiel extends PApplet {

    SpielWelt welt;
    SpielWeltErzeuger erzeuger;
    long timestampLetzterAbwurf = -1;

    public Spiel() {
        welt = new SpielWelt();
        erzeuger = new SpielWeltErzeuger(welt);
        erzeuger.initSpielWelt();
    }

    @Override
    public void settings() {
        width = 600;
        height = 600;
    }

    @Override
    public void draw() {
        verarbeiteEingabe();
        welt.bewege();
        welt.zeichne(this);
    }

    private void verarbeiteEingabe() {
        if (keyPressed) {
            if (key == 'w' || keyCode == UP) {
                welt.bewegeSchlittenNachOben();
            } else if (key == 'a' || keyCode == LEFT) {
                welt.bewegeSchlittenNachLinks();
            } else if (key == 's' || keyCode == DOWN) {
                welt.bewegeSchlittenNachUnten();
            } else if (key == 'd' || keyCode == RIGHT) {
                welt.bewegeSchlittenNachRechts();
            }
        }
    }

    @Override
    public void keyPressed(KeyEvent event) {
        super.keyPressed(event);
        if (event.getKey() == ' ' && zeitSeitLetztemAbwurf() > 1000) {
            this.timestampLetzterAbwurf = System.currentTimeMillis();
            welt.wirfGeschenk();
        }
    }

    private long zeitSeitLetztemAbwurf() {
        return System.currentTimeMillis() - timestampLetzterAbwurf;
    }
}
