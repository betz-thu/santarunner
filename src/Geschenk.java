public class Geschenk extends FlugObjekt {

    public Geschenk(int x, int y) {
        super(x, y, 10, 10);
    }

    public void bewege() {
        x -= 1;
        if (x < -breite) {
            x = 600;
        }
    }
}