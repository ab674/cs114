// Abhinav Bassi
// 3132704

import java.util.Scanner;

public class Part1 {
    
    public static void numberlist() {
        
        Scanner scan = new Scanner(System.in);
        int[] a = new int[] {11,4,15,20};
        int[] b = new int[] {9,3,7,22,13};
        AList x = new AList();
        boolean flag;
        for (int i=0; i<a.length; i++) {
            x.append(a[i]);
        }
        x.moveToPos(2);
        for (int j=b.length-1; j>=0; j--) {
            x.insert(b[j]);
        }
        System.out.println("1. ");
        System.out.println();
        for (int k=0; k<x.length(); k++) {
            x.moveToPos(k);
            System.out.print(x.getValue() + " ");
        }
        System.out.println();
        System.out.println("Length: " + x.length());
        System.out.println();
        System.out.println("Enter 0 to quit.");
        System.out.print("Enter a number to remove: ");
        int usernum = scan.nextInt();
        x.moveToStart();
        flag=false;
        while (usernum!=0){ 
            if (x.length()==0) {
                break;
            }
            for (int l=0; l<x.length(); l++) {
                if (flag) {
                    l=0;
                    flag=false;
                }
                x.moveToPos(l);
                if (usernum==(int)x.getValue()) {
                    flag=true;
                    x.remove();
                    x.moveToStart();
                    for (int k=0; k<x.length(); k++) {
                        x.moveToPos(k);
                        System.out.print(x.getValue() + " ");
                    }
                    System.out.println();
                    System.out.println("Length: " + x.length());
                    if (x.length()==0) {
                        System.out.println("End of list.");
                        break;
                    }
                    System.out.println();
                    System.out.print("Enter a number to remove: ");
                    usernum = scan.nextInt();
                    x.moveToStart();
                }
                else if (usernum!=(int)x.getValue() && x.currPos()==(x.length()-1)){
                    System.out.println();
                    System.out.println("Number not found.");
                    System.out.println();
                    System.out.print("Enter a number to remove: ");
                    usernum = scan.nextInt();
                    x.moveToStart();
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
        for (int k=0; k<x.length(); k++) {
            x.moveToPos(k);
            System.out.print(x.getValue() + " ");
        }
        System.out.println();
        System.out.println("Length: " + x.length());
        System.out.println();
        System.out.println("Enter 0 to quit.");
        System.out.print("Enter a number to add: ");
        usernum = scan.nextInt();
        x.moveToStart();
        flag=false;
        while (usernum!=0){ 
            x.moveToStart();
            x.insert(usernum);
            for (int k=0; k<x.length(); k++) {
                x.moveToPos(k);
                System.out.print(x.getValue() + " ");
            }
            System.out.println();
            System.out.println("Length: " + x.length());
            if (x.length()==9) {
                System.out.println("List full.");
                break;
            }
            System.out.println();
            System.out.print("Enter a number to add: ");
            usernum = scan.nextInt();
            x.moveToStart();
        }
        System.out.println();
        for (int k=0; k<x.length(); k++) {
            x.moveToPos(k);
            System.out.print(x.getValue() + " ");
        }
        System.out.println();
        System.out.println("Length: " + x.length());
    }
}
