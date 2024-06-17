import java.time.Year;
import java.util.Scanner;

public class Employee {
    private String id;
    private String fullName;
    private int yearOfBirth;
    private int salary;

    public Employee(){
        this.id = "";
        this.fullName = "";
        this.yearOfBirth = 0;
        this.salary = 0;
    }

    public String getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }

    public int getSalary() {
        return salary;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setYearOfBirth(int yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getAge() {
        int currentYear = Year.now().getValue();
        return currentYear - yearOfBirth;
    }


    public int checkInt(){
        do{
            try {
                Scanner sc = new Scanner(System.in);
                String check = sc.nextLine().trim().replaceAll("\\s+", "");
                int num = Integer.parseInt(check);
                return num;
            } catch ( NumberFormatException e){
                System.err.println("Please enter a valid number.");
            }
        }while (true);
    }

    public void input(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Employee ID: ");
        id = sc.nextLine();
        System.out.print("Enter Employee Full Name: ");
        fullName = sc.nextLine();
        System.out.print("Enter Employee Year Of Birth: ");
        yearOfBirth = checkInt();
        System.out.print("Enter Employee Salary: ");
        salary = checkInt();
    }

    public void output(){
        System.out.println("- " + id + " -- " + fullName + " -- " + yearOfBirth + " -- " + salary +" -");
    }
}
