import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        List<String> wörter = new ArrayList<>();
        wörter.add("eins");
        wörter.add("zwei");
        wörter.add("drei");

        for (String wort : wörter) {
            if (wort.startsWith("z")) {
                wörter.remove(wort);
            }
        }

        System.out.println(wörter);
    }
}
