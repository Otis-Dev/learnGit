

public class Book {
    private String ID;
    private String name;
    private int year;
    private String author;

    public Book() {
        this.ID = "";
        this.name = "";
        this.year = 0;
        this.author = "";
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void input(){
        System.out.print("Input ID: ");
        this.ID = function.checkStr();
        System.out.print("Input Name: ");
        this.name = function.checkStr();
        System.out.print("Input Year: ");
        this.year = function.checkInt();
        System.out.print("Input Author: ");
        this.author = function.checkStr();
    }

    public void output(){
        System.out.printf("-- " + ID + " -- " + name + " -- " + year + " - " + author);
    }
}


