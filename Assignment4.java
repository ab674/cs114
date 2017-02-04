// Abhinav Bassi
// 3132704

import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Scanner;

public class Assignment4 {

    public static void main(String[] args) throws IOException {
        
        FileReader file1 = new FileReader("/Users/abhibassi/NetBeansProjects/Assignment4/src/test.dat");
        BufferedReader br1 = new BufferedReader(file1);
        String line;
        LStack stack1 = new LStack();
        while ((null != (line = br1.readLine()))) {
            if (line.equals("")) {
                continue;
            }
            stack1.push(line);
        }
        file1.close();
        System.out.println(stack1.toString());
        System.out.println();
        System.out.println("Length: " + stack1.length());
        System.out.println();
        StackTokenTest.performTest(stack1);
        System.out.println();
        FileReader file2 = new FileReader("/Users/abhibassi/NetBeansProjects/Assignment4/src/testAll.dat");
        BufferedReader br2 = new BufferedReader(file2);
        LStack stack2 = new LStack();
        while ((null != (line = br2.readLine()))) {
            if (line.equals("")) {
                continue;
            }
            stack2.push(line);
        }
        file2.close();
        System.out.println(stack2.toString());
        System.out.println();
        System.out.println("Length: " + stack2.length());
        System.out.println();
        StackTokenTest.performTest(stack2);
        System.out.println();
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter END to quit.");
        System.out.println("Enter an equation: ");
        String userequation = scan.nextLine();
        while (!userequation.equals("END")) {
            System.out.println(userequation + " = " + Bonus.calculate(userequation));
            System.out.println();
            System.out.println("Enter an equation: ");
            userequation = scan.nextLine();
        }
    }
}
