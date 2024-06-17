import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

//class func {
//    Scanner sc = new Scanner(System.in);
//
//    public int checkInt() {
//        do {
//            try {
//                String check = sc.nextLine().trim().replaceAll("\\s+", "");
//                int num = Integer.parseInt(check);
//                return num;
//            } catch (NumberFormatException e) {
//                System.err.println("Please enter a valid number.");
//            }
//        } while (true);
//    }
//
//
//}

class infor{
    Scanner sc=new Scanner(System.in);
    String name;
    int id;

    public void  input(){

        System.out.print("Enter Name: ");
        name=sc.nextLine();
        System.out.print("Enter ID: ");
        id = sc.nextInt();
    }

    public void output(){

    }
}//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

    }
}