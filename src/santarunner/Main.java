package santarunner;

import processing.core.PApplet;
import santarunner.welt.SpielWelt;
import santarunner.welt.SpielWeltErzeuger;

public class Main {
    public static void main(String[] args) {
        String[] arguments = {"Spiel"};
        PApplet.runSketch(arguments, new Spiel());
    }
}