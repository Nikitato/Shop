


import java.io.*;
import java.util.*;


public class Prodaz {
    String [] ProdName = new String[50];
    int [] ProdAmnt = new int[50];
    int [] ProdID = new int [50];
    int [] ProdPrice = new int [50];

    public int  GetIDs (Prodaz prodaz) throws IOException{

        FileInputStream fis = new FileInputStream("/home/nikita/IdeaProjects/Shop/result");
        BufferedReader br = new BufferedReader(new InputStreamReader(fis));
        String line;
        int n = 0;

        do {
            line = br.readLine();
            n++;
            }while (!(line.endsWith(";")));
        if(line.equals(";")) return 0;

        return n;

    }

    public void MakeProdaz(Prodaz prodaz, Tovar tovar, int IDs, int n, int Amntin){

        prodaz.ProdID[IDs]= IDs;
        prodaz.ProdName[IDs]= tovar.NameData[n];
        prodaz.ProdAmnt[IDs]= Amntin;
        prodaz.ProdPrice[IDs] = tovar.PriseData[n] * Amntin;
    }
    public void ShowProdaz(Tovar tovar,Prodaz prodaz) throws IOException{
        Scanner input= new Scanner(System.in);

        FileInputStream fis = new FileInputStream("/home/nikita/IdeaProjects/Shop/result");
        BufferedReader br = new BufferedReader(new InputStreamReader(fis));

        String line;
        String IDs;
        System.out.println("Введите интересующий ID продажи");
        IDs = input.nextLine();
        int IDS= Integer.parseInt(IDs);
        try {
            do {
                line = br.readLine();
                if(line.equals(";")){
                    int chose;
                    System.out.println("Продолжить поиск по продажам? 1/0");
                    chose = input.nextInt();
                    if(chose == 1) ShowProdaz(tovar, prodaz);
                    Menu.SHMenu(tovar,prodaz);
                }

                String[] parts = line.split("  ");
        if (parts[0].equals(IDs)) System.out.println(prodaz.ProdName[IDS] + " " + prodaz.ProdAmnt[IDS]);
                } while (!(line.endsWith(";")));
            }catch (IOException j){};
        br.close();
    }

    public void RewriteRes(Prodaz prodaz, int n) throws IOException{

        FileOutputStream foutS= new FileOutputStream("/home/nikita/IdeaProjects/Shop/result");
        BufferedWriter bws = new BufferedWriter(new OutputStreamWriter(foutS));

        for (int m=0;m<=n;m++){

            bws.write(prodaz.ProdID[m]+"  "+prodaz.ProdPrice[m]);
            if(m!=n)bws.newLine();
            else bws.write(";");
        }
        bws.close();
    }

    /*public Prodaz GetList() throws IOException{


        FileInputStream fis = new FileInputStream("/home/nikita/IdeaProjects/Shop/result");
        BufferedReader br = new BufferedReader(new InputStreamReader(fis));

        String line;
        Prodaz prodaz = new Prodaz();
        int IDs = 0;

        do {
            line = br.readLine();
            if (line.endsWith(";")){return prodaz;}
            String[] parts = line.split("  ");

            ProdID[IDs] = new Integer(parts[0]);
            ProdPrice[IDs] = new Integer(parts[1]);

            IDs++;

        } while (!(line.endsWith(";")));

        br.close();
        return prodaz;

    }
    */

}
