public class Main {
    public static void main(String[] args) {
        SpielWelt welt = new SpielWelt();
        SpielWeltErzeuger erzeuger = new SpielWeltErzeuger(welt);
        erzeuger.initSpielWelt();

        System.out.println(welt.schlitten.getX()); // 200
        System.out.println(welt.wurfGeschenke.size()); // 0
        System.out.println(welt.dekoObjekte.size()); // 2
        System.out.println(welt.kamine.size()); // 2
        System.out.println(welt.flugObjekte.size()); // 2
    }
}