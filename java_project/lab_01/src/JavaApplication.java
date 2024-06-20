import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Menu {
    List<Employee> employees = new ArrayList<>();
    public void menu() {
            do{
                try{
                    System.out.println("----- EMPLOYEE MANAGEMENT -----");
                    System.out.println("1. Adds new employee.");
                    System.out.print("2. Shows all employees. \n3. Quit. \nPlease select a function: ");
                    int choice = Function.checkInt();
                    switch (choice) {
                        case 1:
                            Employee emp = new Employee();
                            System.out.println("\n----- Add new employee -----");
                            emp.input();
                            employees.add(emp);
                            System.out.println("Employee created and added to list of employees successfully!");
                            break;
                        case 2:
                            System.out.println("\n----- List of employees -----");
                            System.out.println("- No. -- ID -- Employee name -- Year Of Birth -- Salary -");
                            for (int i = 0; i < employees.size(); i++) {
                                System.out.print("- " + (i + 1) + " -- ");
                                employees.get(i).output();
                            }

                            // Find employee with highest salary (if any)
                            if (!employees.isEmpty()) {
                                Employee highestPaid = employees.get(0);
                                for (Employee empl : employees) {
                                    if (empl.getSalary() > highestPaid.getSalary()) {
                                        highestPaid = empl;
                                    }
                                }
                                System.out.println("*The employee who has the highest salary: " + highestPaid.getFullName() +
                                        " (Age: " + highestPaid.getAge() + ", Salary: " + highestPaid.getSalary() + "$)");
                            }
                            break;
                        case 3:
                            System.out.println("THANK YOU FOR USING OUR APPLICATION!");
                            System.out.println("SEE YOU AGAIN!");
                            System.exit(0);
                        default:
                            System.err.println("Invalid choice");
                            Thread.sleep(500);
                    }
                }catch (Exception e) {
                    System.err.println("NGU");
                }
            }while(true);
        }
}
public class JavaApplication {
        public static void main(String[] args) {

            Menu m = new Menu();
            m.menu();
        }
    }






