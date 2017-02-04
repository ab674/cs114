// Abhinav Bassi
// 31327046

import java.util.InputMismatchException;
import java.util.Scanner;

public class OddEven {
    
    public static void oddeven() {
      
        Scanner scan = new Scanner(System.in);
        System.out.println();
        System.out.println("4. Odd-Even Factorial Program");
        System.out.println("Enter 0 to quit");
        int number = 1;
        System.out.print("Enter an integer number: ");
        do {
            try {
                number = scan.nextInt();
                while (number!=0) { // ends factorial process program
                    System.out.println(number + "!! = " + oddevenfact(number));
                    System.out.println();
                    System.out.print("Enter an integer number: ");
                    number = scan.nextInt();
                }
            }            
            catch (InputMismatchException e) { // validates input
                System.out.print("Invalid input. Enter an integer number: ");
                scan.next();
            }
        } while (number>0); // creates loop for user input
    }
    
    public static long oddevenfact(int k) {
        
        if (k<=1) {
            return 1;
        }
        else {
            return k*oddevenfact(k-2);
        }
    }
}
