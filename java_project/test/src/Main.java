import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it
        Scanner sc = new Scanner(System.in);
        try{
            String a = sc.nextLine();
            String c = a.replaceAll("\\s","");
            System.out.println(c);
            int b = Integer.parseInt(c);
            System.out.println(b);
        }catch(NumberFormatException e){
            System.out.println("Invalid input");
        }
    }
}