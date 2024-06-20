import java.util.Scanner;

public class function {

    public static int checkInt(){
        do{
            try {
                String check = checkStr();
                check = check.replaceAll("\\s+","");
                int num = Integer.parseInt(check);
                return num;
            } catch ( NumberFormatException e){
                System.out.println("Please enter a valid number.");
                System.out.print("Enter again: ");
            }
        }while (true);
    }

    public static String checkStr(){
        Scanner sc = new Scanner(System.in);
        String check;
        do{
            check = sc.nextLine().trim();
            if(check.isEmpty()){
                System.out.println("Error: Input cannot be empty. Please try again.");
            }
        }while(check.isEmpty());
        return check;
    }
}



