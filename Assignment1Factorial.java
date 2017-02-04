// Abhinav Bassi
// 31327046

import java.util.InputMismatchException;
import java.util.Scanner;

public class Factorial {
    
    public static void factorial() {
        
        Scanner scan = new Scanner(System.in);
        int num = 1;
        System.out.println("1. Factorial Program");
        System.out.println("Enter 0 to quit");
        System.out.print("Enter an integer number: ");
        do {
            try {
                num = scan.nextInt();
                while (num!=0) { // ends factorial process program
                    System.out.println(num + "! = " + fact(num));
                    System.out.println();
                    System.out.print("Enter an integer number: ");
                    num = scan.nextInt();
                }
            }            
            catch (InputMismatchException e) { // validates input
                System.out.print("Invalid input. Enter an integer number: ");
                scan.next();
            }
        } while (num>0); // creates loop for user input
    }
    
    public static int fact(int b) {
   
        if (b<=1)
            return 1;
        else
            return b*fact(b-1);
    }
}
