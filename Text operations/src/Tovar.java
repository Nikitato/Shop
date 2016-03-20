
import java.io.*;

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
        return 0;

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
}
