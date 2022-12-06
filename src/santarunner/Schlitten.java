package santarunner;

public class Schlitten extends SpielObjekt {

    public Schlitten(int x, int y) {
        super(x, y, 60, 30);
    }

    public void auf() {
        y -= 1;
    }

    public void ab() {
        y += 1;
    }

    @Override
    public void bewege() {
        //  Der santarunner.Schlitten bewegt sich nicht von selbst.
    }


    public void bewegeNachOben() {
        y -= 1;
    }

    public void bewegeNachUnten() {
        y += 1;
    }
}
