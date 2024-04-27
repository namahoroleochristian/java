import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        ManageEmployee manageEmployee = new ManageEmployee();
        while (true) {
            System.out.println("====================");
            System.out.println("1 View All Employees");
            System.out.println("2 delete employee");
            System.out.println("3 view employee");
            System.out.println("4 add employee");
            System.out.println("5 update employee");

            System.out.println("0 to Exit");
            System.out.println("enter your choice");
            System.out.println("==================");

            Scanner scanner = new Scanner(System.in);
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    manageEmployee.viewAllEmployees();
                    break;
                case 2:
                    manageEmployee.deleteEmployee();
                    break;
                case 3:
                    manageEmployee.viewEmployee();
                    break;
                case 4:
                    manageEmployee.addEmployee();
                    break;
                case 0:
                    System.out.println("Thank you");
                    System.exit(0);
            }
        }
    }
}