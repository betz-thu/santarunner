package santarunner;

public class Haus extends DekoObjekt {

    public Haus(int x) {
        super(x, 450, 100, 100);
    }

    public void bewege() {
        x -= 1;
        if (x < -breite) {
            x = 600;
        }
    }
}
