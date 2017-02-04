// Abhinav Bassi
// 3132704

import java.util.Random;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.LinkedList;

public class Assignment5 {

    public static void main(String[] args) throws IOException {
        
        FileReader file = new FileReader("/Users/abhibassi/NetBeansProjects/Assignment5/src/test.dat");
        BufferedReader br = new BufferedReader(file);
        String line;
        LQueue queue1 = new LQueue();
        LQueue queue2 = new LQueue();
        Random numberGenerator = new Random();
        int randomNumber;
        int count=0;
        randomNumber = numberGenerator.nextInt(5) + 1;
        while ((null != (line = br.readLine()))) {
            count++;
            if (count==randomNumber) {
                queue1.enqueue(line);
                queue2.enqueue(queue1.dequeue());
                randomNumber = numberGenerator.nextInt(5) + 1;
                count=0;
            }
            else {
                queue1.enqueue(line);
            }
        }
        file.close();
        System.out.println("Queue 1: " + queue1.toString());
        System.out.println("Queue 2: " + queue2.toString());
        System.out.println();
        Line bankLine = new Line();
        int customerCount;
        int tellerCount;
        int customerIdentification=0;
        String customerName;
        for (int a=0; a<10; a++) {
            customerCount = numberGenerator.nextInt(5) + 1;
            tellerCount = numberGenerator.nextInt(4) + 1;
            for (int i=0; i<customerCount; i++) {
                customerIdentification++;
                Customer customer = new Customer(customerIdentification);
                bankLine.addCustomer(customer);
                System.out.println(customer.toString() + " joins the line.");
            }
            for (int j=0; j<tellerCount; j++) {
                if (!bankLine.isEmpty()) {
                    customerName = bankLine.nextCustomer().toString();
                    System.out.println(customerName + " is being served.");
                }
            }
            if (bankLine.isEmpty()) {
                System.out.println("Teller waiting.");
            }
        }
        while (!bankLine.isEmpty()) {
            System.out.println(bankLine.nextCustomer().toString() + " is being served.");
        }
    }
}