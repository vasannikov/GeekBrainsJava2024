import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class WordFrequency {
    public static void main(String[] args) {
        try {
            File file = new File("input.txt");
            Scanner scanner = new Scanner(file);

            Map<String, Integer> wordFrequency = new HashMap<>();
            while (scanner.hasNext()) {
                String word = scanner.next();
                wordFrequency.put(word, wordFrequency.getOrDefault(word, 0) + 1);
            }

            System.out.println("Частота слов в файле:");
            for (Map.Entry<String, Integer> entry : wordFrequency.entrySet()) {
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }

            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден.");
        }
    }
}
