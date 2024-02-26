public class DivisionOperation implements ComplexCalculator {
    @Override
    public ComplexNumber calculate(ComplexNumber num1, ComplexNumber num2) {
        double divisor = num2.getReal() * num2.getReal() + num2.getImaginary() * num2.getImaginary();
        double real = (num1.getReal() * num2.getReal() + num1.getImaginary() * num2.getImaginary()) / divisor;
        double imaginary = (num1.getImaginary() * num2.getReal() - num1.getReal() * num2.getImaginary()) / divisor;
        return new ComplexNumber(real, imaginary);
    }
}
