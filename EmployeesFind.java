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

    public static void viewEmployees(String[] employees){

    }

    public static void editEmployees(String[] employees){

    }

    public static void findEmployees(String[] employees){
        System.out.println("How would you live to search for employees? " +
                "\n[1] By Name\n[2]By ID\n[3]By Department");
    }

    public static String[] load() {
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
        return employees;
    }

    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Employee database archive");
        String[] employees = load();

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
