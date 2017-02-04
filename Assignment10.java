// Abhinav Bassi
// 3132704

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Assignment10 {

    public static void main(String[] args) throws IOException {
        
        FileReader file1 = new FileReader("/Users/abhibassi/NetBeansProjects/Assignment10/src/inventory.txt");
        BufferedReader br1 = new BufferedReader(file1);
        String line;        
        InsertionSort insertionsort = new InsertionSort();
        MergeSort mergesort = new MergeSort();
        QuickSort quicksort = new QuickSort();
        int count = 0;
        long insertionsortstart;
        long insertionsortstop;
        long mergesortstart;
        long mergesortstop;
        long quicksortstart;
        long quicksortstop;
        while ((null != (line = br1.readLine()))) {
            count++;
        }
        file1.close();
        String[] insertionsortarray = new String[count];
        String[] mergesortarray = new String[count];
        String[] quicksortarray = new String[count];
        FileReader file2 = new FileReader("/Users/abhibassi/NetBeansProjects/Assignment10/src/inventory.txt");
        BufferedReader br2 = new BufferedReader(file2);
        while ((null != (line = br2.readLine()))) {
            for (int i = 0; i < count; i++) {
                insertionsortarray[i]=line;
                mergesortarray[i]=line;
                quicksortarray[i]=line;
            }
        }
        file2.close();
        insertionsortstart = System.nanoTime();
        insertionsort.Sort(insertionsortarray, count);
        insertionsortstop = System.nanoTime();
        mergesortstart = System.nanoTime();
        mergesort.Sort(mergesortarray);
        mergesortstop = System.nanoTime();
        quicksortstart = System.nanoTime();
        quicksort.Sort(quicksortarray);
        quicksortstop = System.nanoTime();
        System.out.println("Insertion sort for " + count + " records took " + (insertionsortstop-insertionsortstart) + " nanoseconds");
        System.out.println("Merge sort for " + count + " records took " + (mergesortstop-mergesortstart) + " nanoseconds");
        System.out.println("Quick sort for " + count + " records took " + (quicksortstop-quicksortstart) + " nanoseconds");
    }
}