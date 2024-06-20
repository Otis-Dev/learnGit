import java.util.ArrayList;
import java.util.List;

class Menu{
    List<EBook> ebooks = new ArrayList<EBook>();
    public void menu(){
        do {
            System.out.println("----- EBOOK MANAGEMENT -----");
            System.out.println("1. Add new ebook");
            System.out.println("2. Show all ebook");
            System.out.println("3. The biggest size ebook.");
            System.out.println("4. Quit");
            System.out.println("Please select a function: ");
            int choice = function.checkInt();
            switch(choice){
                case 1:
                    EBook ebook = new EBook();
                    ebook.input();
                    ebooks.add(ebook);
                    System.out.println("Ebook created and added to list of ebooks successful!");
                    break;
                case 2:
                    System.out.println("----- List of ebooks -----");
                    System.out.println("-- ID -- Ebook name -- Year – Authors -- URL -- Size --");
                    for (int i = 0; i < ebooks.size(); i++) {
                        System.out.print("- " + (i + 1));
                        ebooks.get(i).output();
                    }
                    break;
                case 3:
                    System.out.println("nothing");
                    break;
                case 4:
                    System.out.println("THANK YOU FOR USING OUR APPLICATION!");
                    System.out.println("SEE YOU AGAIN!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice!");
            }
        } while(true);
    }
}

public class JavaApplication {
    public static void main(String[] args) {
        Menu menu = new Menu();
        menu.menu();
    }
}
