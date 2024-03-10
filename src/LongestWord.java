import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class LongestWord {
    public static void main(String[] args) {
        try {
            File file = new File("input.txt");
            Scanner scanner = new Scanner(file);

            String longestWord = "";
            while (scanner.hasNext()) {
                String word = scanner.next();
                if (word.length() > longestWord.length()) {
                    longestWord = word;
                }
            }

            System.out.println("Самое длинное слово в файле: " + longestWord);

            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден.");
        }
    }
}
