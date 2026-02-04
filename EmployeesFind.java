import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
Departments:
B = Backend
C = Customer Service
D = Development
E = Engineering
I = IT
L = Logistics
M = Maintenance
S = Sales
 */

public class EmployeesFind {

    public static void viewEmployees(List<Employee> employees){

    }

    public static void editEmployees(List<Employee> employees){
        System.out.println("How would you like to edit?\n[1] Add employee\n[2]Remove Employee\n[3]Replace Employee");
    }

    public static void findEmployees(List<Employee> employees){
        System.out.println("How would you live to search for employees? " +
                "\n[1] By Name\n[2]By ID\n[3]By Department");
    }

    public static List<Employee> load() {
        List<String> data = new ArrayList();
        try {
            File f = new File("Employees.txt");
            Scanner fileInput = new Scanner(f);
            while (fileInput.hasNext()){
                data.add(fileInput.nextLine());
            }
        }catch(FileNotFoundException e) {
            System.out.println("That file does not exist!");
        }
        String[] employees = new String[data.size()];
        data.toArray(employees);

        List<Employee> Employees = new ArrayList<>();
        for(String curr : data){
            String[] temp = curr.split(",");
            Employees.add(new Employee(temp[0], temp[1],temp[2]));
        }
        return Employees;
    }

    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Employee database archive");
        List<Employee> employees = new ArrayList<>();


        System.out.println("Choose an option:");
        System.out.println("[1] Find employee\n[2] Edit Employees.txt"); //user chooses option
        System.out.println("[3] View employees");

        int option = keyboard.nextInt();
        if (option == 1){
            findEmployees(employees);
        }else if (option == 2){
            editEmployees(employees);
        }else if (option == 3){
            viewEmployees(employees);
        }
    }

}
