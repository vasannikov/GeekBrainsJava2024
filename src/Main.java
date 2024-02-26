import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean continueCalculations = true;
        ComplexNumber result = null;

        System.out.println("Добро пожаловать в калькулятор комплексных чисел!");

        while (continueCalculations) {
            ComplexNumber num1 = result != null ? result : readComplexNumber(scanner);

            System.out.println("Выберите операцию:");
            System.out.println("1. Сложение");
            System.out.println("2. Умножение");
            System.out.println("3. Деление");

            int choice = scanner.nextInt();
            ComplexNumber num2 = readComplexNumber(scanner);

            ComplexCalculator calculator = null;
            switch (choice) {
                case 1:
                    calculator = new AdditionOperation();
                    break;
                case 2:
                    calculator = new MultiplicationOperation();
                    break;
                case 3:
                    calculator = new DivisionOperation();
                    break;
                default:
                    System.out.println("Неверный выбор операции.");
                    break;
            }

            if (calculator != null) {
                result = calculator.calculate(num1, num2);
                LogUtil.log("Результат операции: " + result);

                System.out.println("1. Продолжить работу с полученным результатом");
                System.out.println("2. Начать новую операцию");
                System.out.println("3. Выйти из программы");

                int continueChoice = scanner.nextInt();
                scanner.nextLine(); // Добавлено для сброса оставшегося ввода

                switch (continueChoice) {
                    case 1:
                        break;
                    case 2:
                        result = null;
                        break;
                    case 3:
                        continueCalculations = false;
                        break;
                }
            }
        }

        scanner.close();
    }

    private static ComplexNumber readComplexNumber(Scanner scanner) {
        System.out.print("Введите комплексное число (в формате a+bi): ");
        String input = scanner.next();
        String[] parts = input.split("\\+|i");

        double real = Double.parseDouble(parts[0]);
        double imaginary = Double.parseDouble(parts[1]);

        return new ComplexNumber(real, imaginary);
    }
}
