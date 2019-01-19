package Calculator;

public class Calculator {

    public int add(int i, int j) {
        return i+j;
    }

    public int substract(int i, int j) {
        return i-j;
    }

    public int multiply(int i, int j) {
        return i*j;
    }

    public int divide(int i, int j) {
        return i/j;
    }


    public static void main(String[] args) {
        System.out.println("start");
        Calculator calculator = new Calculator();
        System.out.println("1+2=" + calculator.add(1,2));
        System.out.println("2-1=" + calculator.substract(2,1));
        System.out.println("2*1=" + calculator.multiply(2,1));
        System.out.println("2/1=" + calculator.divide(2,1));
    }
}
