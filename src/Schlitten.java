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
        //  Der Schlitten bewegt sich nicht von selbst.
    }


}
