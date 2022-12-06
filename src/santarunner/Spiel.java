package santarunner;

import processing.core.PApplet;
import santarunner.welt.SpielWelt;
import santarunner.welt.SpielWeltErzeuger;

public class Spiel extends PApplet {

    SpielWelt welt;
    SpielWeltErzeuger erzeuger;

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
            }

            if (key == 's' || keyCode == DOWN) {
                welt.bewegeSchlittenNachUnten();
            }
        }
    }


}
