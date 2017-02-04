// Abhinav Bassi
// 3132704

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Assignment6 {

    public static void main(String[] args) throws IOException {
        
        FileReader file = new FileReader("/Users/abhibassi/NetBeansProjects/Assignment6/src/test.txt");
        BufferedReader br = new BufferedReader(file);
        String line;
        String newLine;
        Boolean flag;
        int count=0;
        String[] keys = new String[8];
        Scanner scan = new Scanner(System.in);
        UALdictionary records = new UALdictionary();
        while ((null != (line = br.readLine()))) {
            count++;
            newLine="";
            String[] section = line.split(",");
            newLine += (section[0] + "\t" + section[1] + "\t" + section[2] + "\t" + section[3] + "\t" + section[4]);
            records.insert(section[3], newLine);
            keys[count-1]=(section[3]);
        }
        file.close();
        System.out.println(records.toString());
        System.out.println("Enter END to quit.");
        System.out.println("Number of records: " + records.size());
        System.out.print("Enter a SSN to remove: ");
        String userSSN = scan.next();
        flag=false;
        while (!userSSN.equals("END")){ 
            if (records.size()==0) {
                break;
            }
            for (int l=0; l<keys.length; l++) {
                if (flag) {
                    l=0;
                    flag=false;
                }
                if (userSSN.equals(keys[l])) {
                    records.remove(keys[l]);
                    keys[l]="";
                    System.out.println();
                    System.out.println("SSN removed.");
                    if (records.size()==0) {
                        System.out.println("End of records.");
                        break;
                    }
                    System.out.println();
                    System.out.println(records.toString());
                    System.out.println("Number of records: " + records.size());
                    System.out.print("Enter a SSN to remove: ");
                    userSSN = scan.next();
                    flag=true;
                }
                else if (!userSSN.equals(keys[l]) && l==(keys.length-1)){
                    System.out.println();
                    System.out.println("SSN not found.");
                    System.out.println();
                    System.out.println(records.toString());
                    System.out.println("Number of records: " + records.size());
                    System.out.print("Enter a SSN to remove: ");
                    userSSN = scan.next();
                    flag=true;
                }
                else if (userSSN.equals("END")) {
                    break;
                }
            }
            if (userSSN.equals("END")) {
                break;
            }
        }
        System.out.println();
        System.out.println(records.toString());
        System.out.println("Number of records: " + records.size());
    }
}