// Abhinav Bassi
// 3132704

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.Collections;
import java.util.PriorityQueue;

public class Assignment8 {

    public static void main(String[] args) throws IOException {
        
        FileReader file1 = new FileReader("/Users/abhibassi/NetBeansProjects/Assignment8/src/inventory.txt");
        BufferedReader br1 = new BufferedReader(file1);
        String line;
        int num1=0;
        int num2=20;
        int count=0;
        PriorityQueue<String> priorityqueue = new PriorityQueue(9, Collections.reverseOrder());
        String[] inventory = new String[20];
        MaxHeap<String> maxheap = new MaxHeap(inventory, num1, num2);
        while ((null != (line = br1.readLine()))) {
            System.out.println("Record being inseted: " + line);
            maxheap.insert(line);
            for (int i=0; i<maxheap.heapsize(); i++) {
                System.out.println((i + 1) + ": " + inventory[i]);
            }
            System.out.println();
        }
        file1.close();
        System.out.println("Root record removed.");
        System.out.println();
        maxheap.removemax();
        for (int i=0; i<maxheap.heapsize(); i++) {
            System.out.println((i + 1) + ": " + inventory[i]);
        }
        System.out.println();
        FileReader file2 = new FileReader("/Users/abhibassi/NetBeansProjects/Assignment8/src/inventory.txt");
        BufferedReader br2 = new BufferedReader(file2);
        while ((null != (line = br2.readLine()))) {
            priorityqueue.offer(line);
            count++;
        }
        Iterator iterator = priorityqueue.iterator();
        System.out.println("Priority queue using Comparator:");
        while (iterator.hasNext()) {
            for (int i=0; i<count; i++)
            System.out.println((i + 1) + ": " + iterator.next());
        }
    }
}