import javax.swing.*;
import java.io.IOException;


public class Menu {

    public static void SHMenu(Tovar tovar, Prodaz prodaz) throws IOException{

    String str1, str2, str3, title="Интернет магазин";
    int type= JOptionPane.WARNING_MESSAGE;
    str1="1. Продажа товара";
    str2="2. Поставка товара";
    str3="3. Данные по продажам";
    int chose = Integer.parseInt(JOptionPane.showInputDialog(null,"Меню магазина\n"+str1+"\n"+str2+"\n"+str3,title,type));


    tovar = tovar.GetList();
    int n = tovar.GetN();
    int IDs =prodaz.GetIDs(prodaz) ;

        switch (chose){
        case 1:
            tovar.WriteList();
            tovar.Sale(tovar,n, IDs, prodaz);
            SHMenu(tovar, prodaz);
            break;
        case 2:
            tovar.AddTovar(tovar,prodaz,n);
            break;
        case 3:

            tovar.WriteResutl();
            prodaz.ShowProdaz(tovar,prodaz);
            SHMenu(tovar,prodaz);
            break;
    }
    }
}
