package Kinito;

import java.util.Scanner;

public class Calculator {

    public  void  CalculatorMain() {
        double result;
        Scanner reader = new Scanner(System.in);
        try {
            System.out.println("---------------------------");
            System.out.println("| |      CALCULATOR     | |");
            System.out.println("---------------------------");
            System.out.print("Enter first number: ");

            double first = reader.nextDouble();
            System.out.print("Enter second number: ");
            double second = reader.nextDouble();

            System.out.print("Enter an operator (+, -, *, /): ");
            char operator = reader.next().charAt(0);


            switch (operator) {
                case '+':
                    result = first + second;
                    break;

                case '-':
                    result = first - second;
                    break;

                case '*':
                    result = first * second;
                    break;

                case '/':
                    result = first / second;
                    break;

                // operator doesn't match any case constant (+, -, *, /)
                default:
                    System.out.println("Error! operator is not correct");
                    return;
            }

            System.out.printf("%.1f %c %.1f = %.1f", first, operator, second, result);
            System.out.println();
        }catch (Exception e){
            System.out.println("You can put only numbers!");
        }
    }
}