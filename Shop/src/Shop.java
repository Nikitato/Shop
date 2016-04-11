


import java.io.IOException;

public class Shop {
    public static void main(String[] args) throws IOException{
        Tovar tovar = new Tovar();
        Prodaz prodaz = new Prodaz();
        Menu menu = new Menu();
        menu.SHMenu(tovar, prodaz);
    }
}
