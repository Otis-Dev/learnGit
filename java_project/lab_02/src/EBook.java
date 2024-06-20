public class EBook extends Book {
    private String URL;
    private int size;

    public String getURL() {
        return URL;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    @Override
    public void input(){
        super.input();
        System.out.print("Input URL: ");
        this.URL = function.checkStr();
        System.out.print("Input Size (kilobyte): ");
        this.size = function.checkInt();
    }

    @Override
    public void output(){
        super.output();
        System.out.println(" -- " + URL + " -- " + size + " --");
    }
}
