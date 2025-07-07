import java.util.LinkedList;
import java.util.List;


/*
분류 후 팀소트
O(n) + O(n log n) = O(n log n)
 */
public class Main {
    private static String[] input = {
            "id1 8 1 5 1",
            "id2 art can",
            "id3 3 6",
            "id4 own kit dig",
            "id5 art zero",
    };

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        List<String> strings = new LinkedList<>();
        List<String> numbers = new LinkedList<>();

        for (String s : input) {
            if (Character.isDigit(s.split(" ")[1].charAt(0))) {
                numbers.add(s);
            } else {
                strings.add(s);
            }
        }

        strings.sort((o1, o2) -> {
            String log1 = o1.replaceAll("^[A-z0-9]+ ", "");
            String log2 = o2.replaceAll("^[A-z0-9]+ ", "");
            if (log1.compareTo(log2) == 0) {
                return o1.split(" ")[0].compareTo(o2.split(" ")[0]);
            } else {
                return log1.compareTo(log2);
            }
        });

        strings.addAll(numbers);

        System.out.println("answers = " + strings);
        System.out.println("실행 시간: " + (System.currentTimeMillis() - startTime) + " ms");
    }
}
