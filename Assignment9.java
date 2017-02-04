// Abhinav Bassi
// 3132704

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Scanner;

public class Assignment9 {

    public static void main(String[] args) throws IOException {
        
        FileReader file = new FileReader("/Users/abhibassi/NetBeansProjects/Assignment9/src/inventory.txt");
        BufferedReader br = new BufferedReader(file);
        String line;
        HashMap hashmap = new HashMap();
        Scanner scan = new Scanner(System.in);
        while ((null != (line = br.readLine()))) {
            hashmap.put(line, line);
        }
        file.close();
        System.out.println("Enter END to quit.");
        System.out.print("Enter a part number to remove: ");
        String usersearch = scan.next();
        while (!usersearch.equals("END")) { 
            if (hashmap.isEmpty()) {
                break;
            }
            if (hashmap.get(usersearch) != null) {
                System.out.println("Part number " + hashmap.get(usersearch) + " removed.");
                hashmap.remove(usersearch);
                System.out.println("Enter END to quit.");
                System.out.print("Enter a part number to remove: ");
                usersearch = scan.next();
            }
            else {
                System.out.println("Part number not found.");
                System.out.println("Enter END to quit.");
                System.out.print("Enter a part number to remove: ");
                usersearch = scan.next();
            }
            if (usersearch.equals("END")) {
                break;
            }
        }
        System.out.println();
        System.out.println("Inventory table: ");
        System.out.println();
        Set set = hashmap.entrySet();
        Iterator iterator = set.iterator();
        while(iterator.hasNext()) {
            Map.Entry mapentry = (Map.Entry)iterator.next();
            System.out.print(mapentry.getKey() + ": ");
            System.out.println(mapentry.getValue());
        }
        System.out.println();
    }
}