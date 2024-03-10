import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Выберите операцию:");
        System.out.println("1. Подсчет слов в файле");
        System.out.println("2. Поиск самого длинного слова в файле");
        System.out.println("3. Вычисление частоты слов в файле");
        int choice = input.nextInt();

        switch (choice) {
            case 1:
                WordCount wordCount = new WordCount();
                wordCount.main(args);
                break;
            case 2:
                LongestWord longestWord = new LongestWord();
                longestWord.main(args);
                break;
            case 3:
                WordFrequency wordFrequency = new WordFrequency();
                wordFrequency.main(args);
                break;
            default:
                System.out.println("Некорректный выбор операции.");
                break;
        }

        input.close();
    }
}
