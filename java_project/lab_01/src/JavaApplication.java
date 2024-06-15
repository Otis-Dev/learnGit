import java.util.Scanner;
public class JavaApplication {
    public static void main(String[] args) {
        Employee emp = new Employee();
        Scanner sc = new Scanner(System.in);
        System.out.println("1. Adds new employee.");
        System.out.println("2. Show all employees.");
        System.out.println("3. Quit");
        System.out.print("Please choice your option: ");
        int choice = sc.nextInt();
        switch (choice) {
            case 1:
                emp.input();
                break;
            case 2:
                emp.output();
                break;
            case 3:
                System.exit(0);
            default:
                System.out.println("Invalid choice.");
        }
    }
}
