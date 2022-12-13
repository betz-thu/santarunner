package santarunner;

public class Kamin extends SpielObjekt {

    Haus haus;

    public Kamin(Haus haus) {
        super(haus.x, 450, 20, 20);
        this.haus = haus;
    }

    public void bewege() {
        this.x = haus.getX() + 70;
    }
}
