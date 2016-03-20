

import com.intellij.util.IncorrectOperationException;
import java.io.*;
import java.util.*;


public class TextDemo {
    public static void main(String[] args) throws IOException {

        FileInputStream fis= new FileInputStream("/home/nikita/IdeaProjects/Text operations/shoplist");
        BufferedReader br = new BufferedReader(new InputStreamReader(fis));
        //FileOutputStream foutS= new FileOutputStream("/home/nikita/IdeaProjects/Text operations/shoplist");
        //BufferedWriter bws = new BufferedWriter(new OutputStreamWriter(foutS));
        FileOutputStream foutR= new FileOutputStream("/home/nikita/IdeaProjects/Text operations/result",true);
        BufferedWriter bwr = new BufferedWriter(new OutputStreamWriter(foutR));
        String line;
        Tovar tovar = new Tovar();
        int n=0;
        //while(!((line=br.readLine()).endsWith("."))){
                do{
                    line=br.readLine();
                    System.out.println(line);
                    String[] parts = line.split(";");

                 tovar.IDData[n] = new Integer(parts[0]);

                 tovar.NameData[n] = parts[1];

                 tovar.PriseData[n] = new Integer(parts[2]);

                 tovar.AmntData[n] = new Integer(parts[3]);

                 n++;
                }while(!(line.endsWith(";")));

        br.close();
        //System.out.println(tovar.IDData[0]);
        //System.out.println(PriseData[2]);

        Scanner input = new Scanner(System.in);
        int IDin, Amntin, INdex;
        System.out.println("Введите ID товара:");
        IDin=input.nextInt();
        System.out.println("Введите количество товара:");
        Amntin=input.nextInt();
        INdex = tovar.findIndex(tovar.IDData,IDin);
        if (INdex == 0) System.out.println("Товар не найден!");
        if(tovar.AmntData[INdex] < Amntin ) {System.out.println("Товара не хватает!");}
        else { tovar.AmntData[INdex]= tovar.AmntData[INdex] - Amntin;
            bwr.write(tovar.NameData[INdex]+" "+Amntin*tovar.PriseData[INdex]);
            bwr.newLine();
            bwr.close();
        }

        tovar.RewriteSL(tovar.IDData,tovar.NameData,tovar.PriseData,tovar.AmntData,n);

    }
}


