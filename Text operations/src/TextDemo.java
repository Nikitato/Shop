

import com.intellij.util.IncorrectOperationException;
import java.io.*;
import java.util.*;


public class TextDemo {
    public static void main(String[] args) throws IOException {

        /*FileInputStream fis= new FileInputStream("/home/nikita/IdeaProjects/Text operations/shoplist");
        BufferedReader br = new BufferedReader(new InputStreamReader(fis));

        FileOutputStream foutR= new FileOutputStream("/home/nikita/IdeaProjects/Text operations/result",true);
        BufferedWriter bwr = new BufferedWriter(new OutputStreamWriter(foutR));
*/
        Tovar tovar = new Tovar();
        tovar = tovar.GetList();
        int n = tovar.GetN(tovar);

        tovar.Sale(tovar,n);
        tovar.RewriteSL(tovar.IDData,tovar.NameData,tovar.PriseData,tovar.AmntData,n);
        tovar.WriteList();


    }
}


