import java.util.Scanner;
class func {
    Scanner sc = new Scanner(System.in);
    public int checkInt(){
        do{
            try {
                String check = sc.nextLine().trim().replaceAll("\\s+", "");
                int num = Integer.parseInt(check);
                return num;
            } catch ( NumberFormatException e){
                System.err.println("Please enter a valid number.");
            }
        }while (true);
    }
}

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it
        func f = new func();
        int a = f.checkInt();
        System.out.println(a);
    }
}