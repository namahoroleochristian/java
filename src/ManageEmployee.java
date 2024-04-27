import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Scanner;

public class ManageEmployee {
    private static HashSet<Employee> employees = new HashSet<>();
    String url="jdbc:mysql://localhost:3306/employee";
    String user="root";
    String password="";
//        String driver="com.mysql.jdbc.Driver";
//        String table="employee";


//    Employee employee = new Employee();

    public void addEmployee() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter employee name: ");
        String name = sc.nextLine();
        System.out.println("Enter employee Id: ");
        Integer id = sc.nextInt();
        System.out.println("Enter employee salary: ");
        double salary = sc.nextDouble();
        Employee employee1 = new Employee(id,name,salary);

        /*employee1.setName(name);
        employee1.setId(id);
        employee1.setSalary(salary);
        employees.add(employee1);*/
        if (employees.add(employee1)) {
            System.out.println("emp added");
        }
        else {
            System.out.println("emp not added");
        }


    }

    Scanner sc = new Scanner(System.in);
    int id;

    public void viewEmployee() {

        System.out.println("Enter the employee ID");
        this.id = sc.nextInt();
        if (!employees.isEmpty()) {
            for (Employee e : employees) {
                if (e.getId() == id) {
                    System.out.println("employee Id :"+e.getId());
                    System.out.println("employee Name :"+e.getName());
                    System.out.println("employee Salary :"+e.getSalary());
                } else {
                    System.out.println("employee not found");
                }
            }
        } else {
            System.out.println("employee is empty");
        }

    }

    public void viewAllEmployees() {
        /*if (!employees.isEmpty()) {
            for (Employee e : employees) {

                System.out.println("employee Id :"+e.getId());
                System.out.println("employee Name :"+e.getName());
                System.out.println("employee Salary :"+e.getSalary());
            }
        } else {
            System.out.println("no employee found");
        }*/
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn= DriverManager.getConnection(url,user,password);
            Statement stmt=conn.createStatement();
            ResultSet rs=stmt.executeQuery("select * from employees");
            while(rs.next()){
                System.out.println(rs.getString(1)+" "+rs.getString(2));
            }
        }
        catch (Exception error){
            System.out.println(error);
        }
    }
        public void deleteEmployee(){

            System.out.println("Enter the employee ID");
            this.id = sc.nextInt();
            if (!employees.isEmpty()) {
                for (Employee e : employees) {
                    if (e.getId() == id) {
                        employees.remove(e);
                        System.out.println("removed employee with id " + e.getId());
                    }
                    }
                }else {
                    System.out.println("employee not found");
            }
        }
    }
