public class WurfGeschenk extends SpielObjekt {
    public WurfGeschenk(int x, int y) {
        super(x, y, 10, 10);
    }

    @Override
    public void bewege() {
        y += 2;
        x -= 1;
    }

}
