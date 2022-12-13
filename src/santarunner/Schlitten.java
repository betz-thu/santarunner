package santarunner;

public class Schlitten extends SpielObjekt {

    public Schlitten(int x, int y) {
        super(x, y, 60, 30);
    }

    @Override
    public void bewege() {
        //  Der santarunner.Schlitten bewegt sich nicht von selbst.
    }


    public void bewegeNachOben() {
        y -= 2;
    }

    public void bewegeNachUnten() {
        y += 2;
    }

    public void bewegeNachRechts() {
        x += 2;
    }

    public void bewegeNachLinks() {
        x -= 2;
    }
}
