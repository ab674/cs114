// Abhinav Bassi
// 3132704

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Assignment7 {

    public static void main(String[] args) throws IOException {
        
        FileReader file = new FileReader("/Users/abhibassi/NetBeansProjects/Assignment7/src/inventory.txt");
        BufferedReader br = new BufferedReader(file);
        Scanner scan = new Scanner(System.in);
        String line;
        BST binarytree = new BST();
        while ((null != (line = br.readLine()))) {
            binarytree.insert(line, line);
        }
        file.close();
        System.out.println("Enter END to quit.");
        System.out.print("Enter a part number to search: ");
        String usersearch = scan.next();
        while (!usersearch.equals("END")) { 
            if (binarytree.find(usersearch)!=null) {
                System.out.println("Part number " + binarytree.find(usersearch) + " found.");
                System.out.println("Enter END to quit.");
                System.out.print("Enter a part number to search: ");
                usersearch = scan.next();
            }
            else {
                System.out.println("Part number not found.");
                System.out.println("Enter END to quit.");
                System.out.print("Enter a part number to search: ");
                usersearch = scan.next();
            }
            if (usersearch.equals("END")) {
                break;
            }
        }
        System.out.println();
        System.out.println("INORDER:\n\n" + binarytree.toString());
        System.out.println("PREORDER:\n\n" + binarytree.printpreOrder());
        System.out.println("POSTORDER:\n\n" + binarytree.printpostOrder());
        System.out.println("Enter END to quit.");
        System.out.print("Enter a part number to remove: ");
        usersearch = scan.next();
        while (!usersearch.equals("END")) { 
            if (binarytree.size()==0) {
                break;
            }
            if (binarytree.find(usersearch)!=null) {
                System.out.println("Part number " + binarytree.find(usersearch) + " removed.");
                binarytree.remove(usersearch);
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
        System.out.println("INORDER:\n\n" + binarytree.toString());
        System.out.println("PREORDER:\n\n" + binarytree.printpreOrder());
        System.out.println("POSTORDER:\n\n" + binarytree.printpostOrder());
        System.out.println("Enter END to quit.");
        System.out.print("Enter a part number to add: ");
        usersearch = scan.next();
        while (!usersearch.equals("END")){ 
            if (binarytree.find(usersearch)==null) {
                System.out.println("Part number " + usersearch + " added.");
                binarytree.insert(usersearch, usersearch);
                System.out.println("Enter END to quit.");
                System.out.print("Enter a part number to add: ");
                usersearch = scan.next();
            }
            else {
                System.out.println("Part number already exists.");
                System.out.println("Enter END to quit.");
                System.out.print("Enter a part number to add: ");
                usersearch = scan.next();
            }
            if (usersearch.equals("END")) {
                break;
            }
        }
        System.out.println();
        System.out.println("INORDER:\n\n" + binarytree.toString());
        System.out.println("PREORDER:\n\n" + binarytree.printpreOrder());
        System.out.println("POSTORDER:\n\n" + binarytree.printpostOrder());
    }
}