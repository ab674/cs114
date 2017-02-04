// Abhinav Bassi
// 3132704

import java.util.Scanner;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;

public class Assignment3 {

    public static void main(String[] args) throws IOException {
        
        FileReader file = new FileReader("/Users/abhibassi/NetBeansProjects/Assignment3/src/test.dat");
        BufferedReader br = new BufferedReader(file);
        Scanner scan = new Scanner(System.in);
        String line;
        boolean flag;
        boolean flag2;
        LList list = new LList();
        while ((line = br.readLine()) != null) {
            list.append(line);
        }
        file.close();
        for (int a=0; a<list.length(); a++) {
            list.moveToPos(a);
            System.out.println(list.getValue());
        }
        System.out.println();
        System.out.println("Length: " + list.length());
        System.out.println();
        list.moveToPos(4);
        System.out.println("5th record on list: " + list.getValue());
        System.out.println();
        System.out.println("Enter 0 to quit.");
        System.out.print("Enter a number to remove: ");
        Integer usernum = scan.nextInt();
        list.moveToStart();
        flag=false;
        while (usernum!=0){ 
            if (list.length()==0) {
                break;
            }
            for (int b=0; b<list.length(); b++) {
                if (flag) {
                    b=0;
                    flag=false;
                }
                list.moveToPos(b);
                if (usernum==Integer.parseInt((String)list.getValue())) {
                    flag=true;
                    list.remove();
                    list.moveToStart();
                    for (int a=0; a<list.length(); a++) {
                        list.moveToPos(a);
                        System.out.println(list.getValue());
                    }
                    System.out.println();
                    System.out.println("Length: " + list.length());
                    if (list.length()==0) {
                        System.out.println("End of list.");
                        break;
                    }
                    System.out.println();
                    System.out.print("Enter a number to remove: ");
                    usernum = scan.nextInt();
                    list.moveToStart();
                }
                else if (usernum!=Integer.parseInt((String)list.getValue()) && list.currPos()==(list.length()-1)){
                    System.out.println();
                    System.out.println("Number not found.");
                    System.out.println();
                    System.out.print("Enter a number to remove: ");
                    usernum = scan.nextInt();
                    list.moveToStart();
                    flag=true;
                }
                else if (usernum==0) {
                    break;
                }
            }
            if (usernum==0) {
                break;
            }
        }
        System.out.println();
        for (int a=0; a<list.length(); a++) {
            list.moveToPos(a);
            System.out.println(list.getValue());
        }
        System.out.println();
        System.out.println("Length: " + list.length());
        System.out.println();
        System.out.println("Enter 0 to quit.");
        System.out.print("Enter a number to add: ");
        usernum = scan.nextInt();
        list.moveToStart();
        flag=false;
        flag2=false;
        while (usernum!=0){ 
            flag2=false;
            list.moveToStart();
            for (int b=0; b<list.length(); b++) {
                list.moveToPos(b);
                if (usernum==Integer.parseInt((String)list.getValue())) {
                    flag2=true;
                    System.out.println("Number already exists.");
                    System.out.println();
                    System.out.print("Enter a number to add: ");
                    usernum=scan.nextInt();
                }
            }
            if (!flag2) {
                list.moveToStart();
                list.insert(String.valueOf(usernum));
                for (int a=0; a<list.length(); a++) {
                    list.moveToPos(a);
                    System.out.println(list.getValue());
                }
                System.out.println();
                System.out.println("Length: " + list.length());
                if (list.length()==10) {
                    System.out.println("List full.");
                    break;
                }
                System.out.println();
                System.out.print("Enter a number to add: ");
                usernum = scan.nextInt();
            }
        }
        System.out.println();
        for (int a=0; a<list.length(); a++) {
            list.moveToPos(a);
            System.out.println(list.getValue());
        }
        System.out.println();
        System.out.println("Length: " + list.length());
        System.out.println();
        list.reverse();
        for (int a=0; a<list.length(); a++) {
            list.moveToPos(a);
            System.out.println(list.getValue());
        }
        System.out.println();
        System.out.println("Length: " + list.length());
    }
}