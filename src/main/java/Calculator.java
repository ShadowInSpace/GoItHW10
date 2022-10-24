import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

public class Calculator {
    public void calculate() {
        try (InputStream inputStream = new FileInputStream("words.txt");
             Scanner scanner = new Scanner(inputStream);) {

            Map<String, Integer> result = new HashMap<>();
            while (scanner.hasNext()) {
                String line = scanner.nextLine();
                String[] words = line.split(" ");
                for (String word : words) {
                    if (!result.containsKey(word)) {
                        result.put(word, 1);
                    } else {
                        result.put(word, result.get(word) + 1);
                    }

                }
            }

            Comparator<String> comparator = new Comparator<>() {
                @Override
                public int compare(String o1, String o2) {
                    return result.get(o1) < result.get(o2) ? 1 : -1;
                }
            };
            Map<String, Integer> sortedRes = new TreeMap<>(comparator);
            sortedRes.putAll(result);
            System.out.println(sortedRes);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
