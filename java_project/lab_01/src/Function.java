import java.util.Scanner;

public class Function {
    public static int checkInt(){
        do{
            try {
                Scanner sc = new Scanner(System.in);
                String check = sc.nextLine().trim().replaceAll("\\s+", "");
                int num = Integer.parseInt(check);
                return num;
            } catch ( NumberFormatException e){
                System.out.println("Please enter a valid number.");
                System.out.print("Enter again: ");
            }
        }while (true);
    }
}
