
import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.io.*;
import java.util.*;

class Tovar{

        int [] IDData = new int [50];
        String [] NameData = new String [50];
        int [] PriseData = new int [50];
        int [] AmntData = new int [50];


    public static int findIndex(int[] IDData, int IDin) {
        // проходим по циклу от первого элемента до "последнего"
        for (int i = 0; i < IDData.length; i++) {
            // если число найдено - цикл прерывается и возвращается номер позиции
            if (IDin == IDData[i]) {
                return i;
            }
        }
        //если в массиве нет нужного элемента - возвращаем ноль
        return 50;

      }
    public static void RewriteSL(int [] IDData,String [] NameData,int [] PriseData,int [] AmntData, int n) throws IOException{
        FileOutputStream foutS= new FileOutputStream("/home/nikita/IdeaProjects/Text operations/shoplist");
        BufferedWriter bws = new BufferedWriter(new OutputStreamWriter(foutS));
        for (int m=0;m<n;m++){
            bws.write(IDData[m]+";"+NameData[m]+";"+PriseData[m]+";"+AmntData[m]);

            if(m+1!=n)bws.newLine();
            else bws.write(";");
        }
        bws.close();
    }
    public static  void WriteList(){

        try {
            FileInputStream fis = new FileInputStream("/home/nikita/IdeaProjects/Text operations/shoplist");
            BufferedReader br = new BufferedReader(new InputStreamReader(fis));
            String line;
            do {
                line = br.readLine();
                System.out.println(line);
            } while (!(line.endsWith(";")));

            br.close();

        }catch (IOException q){};
    }

    public static Tovar GetList() throws IOException{


            FileInputStream fis = new FileInputStream("/home/nikita/IdeaProjects/Text operations/shoplist");
            BufferedReader br = new BufferedReader(new InputStreamReader(fis));

            String line;
            Tovar tovar = new Tovar();
            int n = 0;
            do {
                    line = br.readLine();
                    System.out.println(line);
                    String[] parts = line.split(";");

                    tovar.IDData[n] = new Integer(parts[0]);

                    tovar.NameData[n] = parts[1];

                    tovar.PriseData[n] = new Integer(parts[2]);

                    tovar.AmntData[n] = new Integer(parts[3]);

                    n++;
            } while (!(line.endsWith(";")));

            br.close();
            return tovar;

}
    public static int GetN(Tovar tovar) throws IOException{

        FileInputStream fis = new FileInputStream("/home/nikita/IdeaProjects/Text operations/shoplist");
        BufferedReader br = new BufferedReader(new InputStreamReader(fis));
        String line;
        int n = 0;
        do {
            line = br.readLine();
            n++;
        }while (!(line.endsWith(";")));
        return n;
    }
    public static void Sale(Tovar tovar,int n) throws IOException{

        FileOutputStream foutR= new FileOutputStream("/home/nikita/IdeaProjects/Text operations/result",true);
        BufferedWriter bwr = new BufferedWriter(new OutputStreamWriter(foutR));

        Scanner input = new Scanner(System.in);
        int IDin, Amntin, INdex;
        System.out.println("Введите ID товара:");
        IDin=input.nextInt();
        System.out.println("Введите количество товара:");
        Amntin=input.nextInt();

        INdex = tovar.findIndex(tovar.IDData,IDin);

        if (INdex == 50) System.out.println("Товар не найден!");
        if(tovar.AmntData[INdex] < Amntin ) {System.out.println("Товара не хватает!");}
        else { tovar.AmntData[INdex]= tovar.AmntData[INdex] - Amntin;
            bwr.write(tovar.NameData[INdex]+" "+Amntin*tovar.PriseData[INdex]);
            bwr.newLine();
            bwr.close();
        }
        tovar.RewriteSL(tovar.IDData,tovar.NameData,tovar.PriseData,tovar.AmntData,n);

    }
}
