
/*
   разобраться с тем, что при повторном сеансе продаж, ID продаж обнуляются и поиск не производится правильно ( показывает последнюю продажу)
 */
import java.io.IOException;

public class Shop {
    public static void main(String[] args) throws IOException{
        Tovar tovar = new Tovar();
        Prodaz prodaz = new Prodaz();
        Menu menu = new Menu();
        menu.SHMenu(tovar, prodaz);
    }
}
