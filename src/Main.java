import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите данные (Фамилия Имя Отчество дата_рождения номер_телефона пол):");
        String input = scanner.nextLine();

        try {
            UserDataProcessor.processUserData(input);
            System.out.println("Данные успешно обработаны и записаны в файл.");
        } catch (InvalidDataFormatException e) {
            System.err.println("Ошибка: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Ошибка при чтении/записи файла:");
            e.printStackTrace();
        } finally {
            UserDataProcessor.closeWriters();
        }
    }
}
