


import java.io.*;
import java.util.*;


public class Prodaz {
    String [] ProdName = new String[50];
    int [] ProdAmnt = new int[50];

    public static void MakeProdaz(Prodaz prodaz,Tovar tovar, int IDs,int n, int Amntin){

        prodaz.ProdName[IDs]= tovar.NameData[n];
        prodaz.ProdAmnt[IDs]= Amntin;

    }
    public static void ShowProdaz(Tovar tovar,Prodaz prodaz) throws IOException{
        Scanner input= new Scanner(System.in);

        FileInputStream fis = new FileInputStream("/home/nikita/IdeaProjects/Text operations/result");
        BufferedReader br = new BufferedReader(new InputStreamReader(fis));

        String line;
        String IDs;
        System.out.println("Введите интересующий ID продажи");
        IDs = input.nextLine();
        int IDS= Integer.parseInt(IDs);
        try {
            do {
        line = br.readLine();
                if(line == null){
                    int chose;
                    System.out.println("Продолжить поиск по продажам? 1/0");
                    chose = input.nextInt();
                    if(chose == 1) ShowProdaz(tovar, prodaz);
                    Menu.SHMenu(tovar,prodaz);
                }

                String[] parts = line.split(" ");
        if (parts[0].equals(IDs)) System.out.println(prodaz.ProdName[IDS] + " " + prodaz.ProdAmnt[IDS]);
                } while (line != null);
            }catch (IOException j){};
        br.close();
        /*int chose;
        System.out.println("Продолжить поиск по продажам? 1/0");
        chose = input.nextInt();
        if(chose == 1) ShowProdaz(prodaz);*/
    }

}
