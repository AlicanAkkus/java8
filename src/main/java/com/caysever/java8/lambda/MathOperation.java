package com.caysever.java8.lambda;

public class MathOperation {

    public static void main(String args[]) {
        MathOperation mathOperation = new MathOperation();

        // with type declaration
        IMathOperation addition = (int a, int b) -> a + b;

        // with out type declaration
        IMathOperation subtraction = (a, b) -> a - b;

        // with return statement along with curly braces
        IMathOperation multiplication = (int a, int b) -> {
            return a * b;
        };

        // without return statement and without curly braces
        IMathOperation division = (int a, int b) -> a / b;

        System.out.println("10 + 5 = " + mathOperation.operate(10, 5, addition));
        System.out.println("10 - 5 = " + mathOperation.operate(10, 5, subtraction));
        System.out.println("10 x 5 = " + mathOperation.operate(10, 5, multiplication));
        System.out.println("10 / 5 = " + mathOperation.operate(10, 5, division));

        // with parenthesis
        IGreetingService greetServiceForEnglishUser = message -> System.out.println("Hello " + message);

        // without parenthesis
        IGreetingService greetServiceForTurkishUser = (message) -> System.out.println("Merhaba " + message);

        greetServiceForEnglishUser.sayMessage("Mahesh");
        greetServiceForTurkishUser.sayMessage("Alican");
    }

    // functional interface, have a single method
    interface IMathOperation {
        int operation(int a, int b);
    }

    // functional interface, have a single method
    interface IGreetingService {
        void sayMessage(String message);
    }

    private int operate(int a, int b, IMathOperation mathOperation) {
        return mathOperation.operation(a, b);
    }
}