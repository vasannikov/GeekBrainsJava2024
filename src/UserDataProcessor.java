import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class UserDataProcessor {

    private static final Map<String, FileWriter> fileWriters = new HashMap<>();

    public static void processUserData(String input) throws InvalidDataFormatException, IOException {
        String[] data = input.split(" ");
        if (data.length != 6) {
            throw new InvalidDataFormatException("Incorrect number of data elements provided. Expected 6, received " + data.length);
        }

        // Проверка формата данных
        String[] dateParts = data[3].split("\\.");
        if (dateParts.length != 3) {
            throw new InvalidDataFormatException("Invalid date format. Expected dd.mm.yyyy");
        }

        try {
            Long.parseLong(data[4]); // Проверка корректности номера телефона
        } catch (NumberFormatException e) {
            throw new InvalidDataFormatException("Invalid phone number. Expected an unsigned integer.");
        }

        if (!data[5].equals("f") && !data[5].equals("m")) {
            throw new InvalidDataFormatException("Invalid gender. Expected 'f' or 'm'.");
        }

        // Запись данных однофамильцев в один файл
        String fileName = data[0] + ".txt";
        FileWriter writer = fileWriters.get(fileName);
        if (writer == null) {
            writer = new FileWriter(fileName, true); // Открываем файл для добавления данных
            fileWriters.put(data[0], writer);
        }

        writer.write(String.join(" ", data) + "\n");

    }

    public static void closeWriters() {
        for (FileWriter writer : fileWriters.values()) {
            try {
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
