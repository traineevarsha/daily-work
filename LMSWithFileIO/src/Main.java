public class Main {

    public static void main(String[] args) {

        Library lib = new Library();
        Menu menu = new Menu(lib);

        menu.start();
    }
}