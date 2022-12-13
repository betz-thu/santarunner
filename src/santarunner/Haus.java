package santarunner;

public class Haus extends DekoObjekt {

    Kamin kamin;

    public Haus(int x) {
        super(x, 450, 100, 100);
        this.kamin = new Kamin(this);
    }

    public Kamin getKamin() {
        return kamin;
    }

    public void bewege() {
        x -= 1;
        if (x < -breite) {
            x = 600;
        }
    }
}
