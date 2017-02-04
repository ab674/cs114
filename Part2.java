// Abhinav Bassi
// 3132704

import java.util.Scanner;

public class Part2 {
    
    public static void employeeList() {
        
        Scanner scan = new Scanner(System.in);
        Staff employees = new Staff();
        AList employeelist = new AList();
        AList employeename = new AList();
        boolean flag;
        boolean flag2;
        boolean flag3;
        String name="";
        String newaddress="0";
        String uname;
        String uaddress;
        String uphone;
        for (int i=0; i<employees.getSize(); i++) {
            employeelist.append(employees.getStaff(i));
        }
        for (int i=0; i<employees.getSize(); i++) {
            employeename.append(employees.getStaff(i).name);
        }
        System.out.println("2. ");
        System.out.println();
        for (int k=0; k<employeelist.length(); k++) {
            employeelist.moveToPos(k);
            System.out.print(employeelist.getValue());
            System.out.println();
            System.out.println("Type: " + employeelist.getValue().getClass().getSimpleName());
            System.out.println("Pay Rate: " + employees.getStaff(k).pay());
            System.out.println();
        }
        System.out.println("Length: " + employeelist.length());
        System.out.println();
        System.out.println("Enter END to quit.");
        System.out.print("Enter a name to remove: ");
        String username = scan.next();
        employeelist.moveToStart();
        flag=false;
        flag2=false;
        while (!username.equals("END")){ 
            if (employeelist.length()==0) {
                break;
            }
            for (int l=0; l<employees.getSize(); l++) {
                if (flag) {
                    l=0;
                    flag=false;
                }
                if (flag2) {
                    l=0;
                    flag2=false;
                }
                employeelist.moveToPos(l);
                employeename.moveToPos(l);
                if (username.equals(employeename.getValue())) {
                    if ((employeelist.getValue().getClass().getSimpleName()).equals("Executive")) {
                        System.out.println();
                        System.out.println("Cannot delete Executive.");
                        System.out.println();
                        flag2=true;
                    }
                    if (!flag2) {
                        employeelist.remove();
                        employeename.remove();
                        employeelist.moveToStart();
                        System.out.println();
                        System.out.println("Name deleted.");
                        System.out.println();
                        flag=true;
                    }
                    for (int k=0; k<employeelist.length(); k++) {
                        employeelist.moveToPos(k);
                        System.out.print(employeelist.getValue());
                        System.out.println();
                        System.out.println("Type: " + employeelist.getValue().getClass().getSimpleName());
                        System.out.println("Pay Rate: " + employees.getStaff(k).pay());
                        System.out.println();
                    }
                    System.out.println("Length: " + employeelist.length());
                    System.out.println();
                    if (employeelist.length()==0) {
                        System.out.println("End of list.");
                        break;
                    }
                    System.out.print("Enter a name to remove: ");
                    username = scan.next();
                    employeelist.moveToStart();
                    flag=true;
                }
                else if (!username.equals(employeename.getValue()) && employeelist.currPos()==(employees.getSize()-1)){
                    System.out.println();
                    System.out.println("Name not found.");
                    System.out.println();
                    System.out.print("Enter a name to remove: ");
                    username = scan.next();
                    employeelist.moveToStart();
                    flag=true;
                }
                else if (username.equals("END")) {
                    break;
                }
            }
            if (username.equals("END")) {
                break;
            }
        }
        System.out.println();
        for (int k=0; k<employeelist.length(); k++) {
            employeelist.moveToPos(k);
            System.out.println(employeelist.getValue() + " ");
            System.out.println("Type: " + employeelist.getValue().getClass().getSimpleName());
            System.out.println("Pay Rate: " + employees.getStaff(k).pay());
            System.out.println();
        }
        System.out.println("Length: " + employeelist.length());
        System.out.println();
        System.out.println("Enter END to quit.");
        System.out.print("Enter a name to modify: ");
        username=scan.next();
        employeelist.moveToStart();
        flag=false;
        while (!username.equals("END")) { 
            for (int m=0; m<employees.getSize(); m++) {
                if (flag) {
                    m=0;
                    flag=false;
                }
                name=employees.getStaff(m).name;
                if (username.equals(name)) {
                    System.out.println("Enter new address: ");
                    scan.nextLine();
                    newaddress=scan.nextLine();
                    System.out.println();
                    employees.getStaff(m).address=newaddress;
                    employeelist.moveToStart();
                    for (int k=0; k<employeelist.length(); k++) {
                        employeelist.moveToPos(k);
                        System.out.println(employeelist.getValue() + " ");
                        System.out.println("Type: " + employeelist.getValue().getClass().getSimpleName());
                        System.out.println("Pay Rate: " + employees.getStaff(k).pay());
                        System.out.println();
                    }
                    System.out.println("Length: " + employeelist.length());
                    System.out.println();
                    System.out.print("Enter a name to modify: ");
                    username=scan.next();
                    employeelist.moveToStart();
                }
                else if (username.equals("END")) {
                    break;
                }
                else if (!username.equals(name) && m==(employees.getSize()-1)){
                    System.out.println();
                    System.out.println("Name not found.");
                    System.out.println();
                    System.out.print("Enter a name to modify: ");
                    username=scan.next();
                    employeelist.moveToStart();
                    flag=true;
                }
            }
            if (username.equals("END")) {
                break;
            }
        }
        System.out.println();
        for (int k=0; k<employeelist.length(); k++) {
            employeelist.moveToPos(k);
            System.out.println(employeelist.getValue() + " ");
            System.out.println("Type: " + employeelist.getValue().getClass().getSimpleName());
            System.out.println("Pay Rate: " + employees.getStaff(k).pay());
            System.out.println();
        }
        System.out.println("Length: " + employeelist.length());
        System.out.println();
        System.out.println("Enter END to quit.");
        System.out.println("Enter name to add as volunteer: ");
        username=scan.next();
        employeelist.moveToStart();
        employeename.moveToStart();
        flag3=false;
        while (!username.equals("END")) {
            for (int m=0; m<employees.getSize(); m++) {
                if (flag3) {
                    m=0;
                    flag3=false;
                }
                if (employeelist.length()==9) {
                    System.out.println("List full.");
                    break;
                }
                employeelist.moveToPos(m);
                employeename.moveToPos(m);
                if (!username.equals(employeename.getValue())) {
                    uname=username;
                    System.out.println("Enter address: ");
                    scan.nextLine();
                    uaddress=scan.nextLine();
                    System.out.println("Enter phone: ");
                    uphone=scan.next();
                    Volunteer newStaff = new Volunteer(uname, uaddress, uphone);
                    employeelist.append(newStaff);
                    employeename.append(username);
                    System.out.println();
                    System.out.println();
                    for (int k=0; k<employeelist.length(); k++) {
                        employeelist.moveToPos(k);
                        System.out.println(employeelist.getValue() + " ");
                        System.out.println("Type: " + employeelist.getValue().getClass().getSimpleName());
                        System.out.println();
                    }
                    System.out.println("Length: " + employeelist.length());
                    System.out.println();
                    System.out.println("Enter a name to add as volunteer: ");
                    username=scan.next();
                    employeelist.moveToStart();
                    employeename.moveToStart();
                    flag3=true;
                    continue;
                }
                else if (username.equals(employeename.getValue()) && m==(employeename.length()-1)){
                    System.out.println();
                    System.out.println("Name already exists.");
                    System.out.println();
                    System.out.println("Enter a name to add as volunteer: ");
                    username=scan.next();
                    employeelist.moveToStart();
                    employeename.moveToStart();
                    flag3=true;
                }
                else if (username.equals("END")) {
                    break;
                }
            }
            if (username.equals("END")) {
                break;
            }
        }
        System.out.println();
        for (int k=0; k<employeelist.length(); k++) {
            employeelist.moveToPos(k);
            System.out.println(employeelist.getValue() + " ");
            System.out.println("Type: " + employeelist.getValue().getClass().getSimpleName());
            System.out.println();
        }
        System.out.println("Length: " + employeelist.length());
    }
}
