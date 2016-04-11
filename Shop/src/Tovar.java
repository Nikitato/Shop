




import java.io.*;
import java.util.*;

class Tovar{

    int [] IDData = new int [50];
    String [] NameData = new String [50];
    int [] PriseData = new int [50];
    int [] AmntData = new int [50];


    public static int findIndex(int[] IDData, int IDin) {

        for (int i = 0; i < IDData.length; i++) {

            if (IDin == IDData[i]) {
                return i;
            }
        }
        return 50;
    }

    public void AddTovar(Tovar tovar,Prodaz prodaz,int N) throws IOException {
        Scanner input = new Scanner(System.in);
        int INdex;
        System.out.println("Введите ID товара, который вы добавляете:");
        int IDAdd = input.nextInt();
        INdex = findIndex(tovar.IDData, IDAdd);
        if (INdex == 50) {
            System.out.println("Товар не найден! Хотите добавить его на склад? 1/0");
            int chose = input.nextInt();
            if (chose == 0) {
                Menu.SHMenu(tovar, prodaz);
            }
            N++;
            tovar.IDData[N-1] = IDAdd;
            System.out.println("Введите название товара:");
            tovar.NameData[N-1] = input.next();
            System.out.println("Введите цену товара:");
            tovar.PriseData[N-1] = input.nextInt();
            System.out.println("Введите количество товара:");
            tovar.AmntData[N-1] = input.nextInt();
            RewriteSL(tovar,N);

        }
        else {
            System.out.println("Введите количество товара:");
            tovar.AmntData[INdex] = tovar.AmntData[INdex] + input.nextInt();
            RewriteSL(tovar,N);
        }

        Menu.SHMenu(tovar, prodaz);
    }

    public static void RewriteSL(Tovar tovar, int n) throws IOException{

        FileOutputStream foutS= new FileOutputStream("/home/nikita/IdeaProjects/Shop/shoplist");
        BufferedWriter bws = new BufferedWriter(new OutputStreamWriter(foutS));

        for (int m=0;m<n;m++){

            bws.write(tovar.IDData[m]+";"+tovar.NameData[m]+";"+tovar.PriseData[m]+";"+tovar.AmntData[m]);
            if(m+1!=n)bws.newLine();
            else bws.write(";");
        }
        bws.close();
    }
    public  void WriteList(){

        try {

            FileInputStream fis = new FileInputStream("/home/nikita/IdeaProjects/Shop/shoplist");
            BufferedReader br = new BufferedReader(new InputStreamReader(fis));
            String line;

            do {
                line = br.readLine();
                System.out.println(line);
                } while (!(line.endsWith(";")));

            br.close();

            }catch (IOException q){};
    }

    public Tovar GetList() throws IOException{


        FileInputStream fis = new FileInputStream("/home/nikita/IdeaProjects/Shop/shoplist");
        BufferedReader br = new BufferedReader(new InputStreamReader(fis));

        String line;
        Tovar tovar = new Tovar();
        int n = 0;

        do {
            line = br.readLine();

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
    public int GetN() throws IOException{

        FileInputStream fis = new FileInputStream("/home/nikita/IdeaProjects/Shop/shoplist");
        BufferedReader br = new BufferedReader(new InputStreamReader(fis));
        String line;
        int n = 0;

        do {
            line = br.readLine();
            n++;
            }while (!(line.endsWith(";")));

        return n;
    }
    public void Sale(Tovar tovar,int n, int IDs,Prodaz prodaz) throws IOException{


        Scanner input = new Scanner(System.in);
        int IDin, Amntin, INdex;
        int chose;

        System.out.println("Введите ID товара:");
        IDin=input.nextInt();
        INdex = findIndex(tovar.IDData,IDin);
        if (INdex == 50) {System.out.println("Товар не найден!"); Menu.SHMenu(tovar,prodaz);}


        System.out.println("Введите количество товара:");
        Amntin=input.nextInt();
        if(tovar.AmntData[INdex] < Amntin ) {System.out.println("Товара не хватает!"); Menu.SHMenu(tovar, prodaz);}
        else {
            tovar.AmntData[INdex]= tovar.AmntData[INdex] - Amntin;
            prodaz.MakeProdaz(prodaz,tovar,IDs,INdex,Amntin);
            prodaz.RewriteRes(prodaz,IDs);
            IDs++;

        }

        RewriteSL(tovar,n);


        System.out.println("Продолжить продажу? 1/0");
        chose = input.nextInt();
        if (chose == 1)Sale(tovar,n,IDs, prodaz);



    }
    public void WriteResutl() throws IOException{
        FileInputStream fis = new FileInputStream("/home/nikita/IdeaProjects/Shop/result");
        BufferedReader br = new BufferedReader(new InputStreamReader(fis));

        String line;
        do{
            line=br.readLine();
            System.out.println(line);
          }while (!(line.endsWith(";")));
        br.close();
    }

    /*{ tovar.AmntData[INdex]= tovar.AmntData[INdex] - Amntin;
            bwr.write(IDs+" "+Amntin*tovar.PriseData[INdex]);
            bwr.newLine();
            bwr.close();
            prodaz.MakeProdaz(prodaz,tovar,IDs,INdex,Amntin);
            IDs++;
        }*/
}
