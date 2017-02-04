// Abhinav Bassi
// 31327046

import java.util.InputMismatchException;
import java.util.Scanner;

public class Power {
    
    public static void power() {
        
        Scanner scan = new Scanner(System.in);
        System.out.println();
        System.out.println("2. Power Program");
        System.out.println("Enter 0 to quit");
        int base = 1;
        int power = 1;
        System.out.print("Enter an integer base: ");
        do {
            try {
                base = scan.nextInt();
                while (base!=0) { // ends power process program
                    System.out.print("Enter an integer power: ");
                    try {
                        power = scan.nextInt();
                        long startTime1 = System.nanoTime(); // starts time for first process 
                        System.out.println(base + " to the power of " + power + " = " + rpow(base,power));
                        long endTime1 = System.nanoTime(); // ends time for first process
                        long startTime2 = System.nanoTime(); // starts time for second process
                        System.out.println(base + " to the power of " + power + " = " + rpow2(base,power));
                        long endTime2 = System.nanoTime(); // ends time for second process
                        long totalTime1 = endTime1 - startTime1; // calculates total time for first process
                        long totalTime2 = endTime2 - startTime2; // calculates total time for second process
                        System.out.println("Total runtime (rpow) = " + totalTime1 + " nanoseconds");
                        System.out.println("Total runtime (rpow2) = " + totalTime2 + " nanoseconds");
                        System.out.println();
                        System.out.print("Enter an integer base: ");
                        break;
                    }
                    catch (InputMismatchException e) { // validates power input
                        System.out.print("Invalid input. ");
                        scan.next();
                    }
                }
            }
            catch (InputMismatchException e) { // validates base input
                System.out.print("Invalid input. Enter an integer base: ");
                scan.next();
            }
        } while (base>0); // creates loop for user input
    }
    
    public static double rpow(int x, int n) {
      
        if (n==0)
            return 1.0;
        return x*rpow(x,n-1);
    }
   
    public static double rpow2(int x, int n) {
    
        if (n==0)
            return 1.0;
        if (n%2==1) {
            double y = rpow2(x,(n-1)/2);
            return x*y*y;
        }
        else {
            double y = rpow2(x,n/2);
            return y*y;  
        }  
    }
}
