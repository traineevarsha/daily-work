public class Main {

    public static void main(String[] args) {

        Library lib = new Library();

        lib.addbook(new books(1, "ABC", "auth1", 50.5f));
        lib.addbook(new books(2, "BCD", "auth2", 75.5f));
        lib.addbook(new books(3, "DEF", "auth3", 222.5f));

        Menu menu = new Menu(lib);

        menu.start();
    }
}