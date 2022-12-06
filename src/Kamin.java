public class Kamin extends SpielObjekt {

    public Kamin(int x) {
        super(x, 450, 20, 20);
    }

    public void bewege() {
        x -= 1;
        if (x < -breite) {
            x = 600;
        }
    }
}
