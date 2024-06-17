
class Menu {
    Employee emp = new Employee();

    public Menu() {
        do{
            try{
                System.out.println("----- EMPLOYEE MANAGEMENT -----");
                System.out.println("1. Adds new employee.");
                System.out.print("2. Shows all employees. \n3. Quit. \nPlease select a function: ");
                int choice = emp.checkInt();
                switch (choice) {
                    case 1:
                        emp.input();
                        break;
                    case 2:
                        emp.output();
                        break;
                    case 3:
                        System.out.println("BYE");
                        System.exit(0);
                    default:
                        System.err.println("Invalid choice");
                }
            }catch (Exception e) {
                System.err.println("NGU");
            }
        }while(true);
    }

    public void menu() {}}
public class JavaApplication {
        public static void main(String[] args) {
            Menu m = new Menu();
            m.menu();
        }
    }






