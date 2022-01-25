import java.io.*;
import java.util.ArrayList;

public class Main {
    public static BufferedWriter output_txt;

    public static void main(String[] args) throws IOException {
        output_txt=new BufferedWriter(new FileWriter(args[4]));

        // asagidaki kod blogunda bir queue olusturup tokens.txt dosyasini okuyarak bu queue"nun icine tokenlari ekliyorum
        Queue queue=new Queue();
        String line;
        BufferedReader br=Methods.readTxtFile(args[2]);
        while (( line = br.readLine()) != null){
            String[] currentLine=line.split(" ");
            queue.enqueue(new Tokens(currentLine[0],currentLine[1],Integer.parseInt(currentLine[2])));
        }


        // bu kod blogunda tum itemlari bir arrayliste ekliyorum daha sonra buranin uzerinde gezinerek ayri ayri stacklere dolduruyorum
        ArrayList<Items> itemsArrayList=new ArrayList<>();
        br=Methods.readTxtFile(args[1]);
        while (( line = br.readLine()) != null){
            String[] currentLine=line.split(" ");
            itemsArrayList.add(new Items(currentLine[0],currentLine[1]));
        }


        // asagidaki kod blogunda yukarida olusturdugum arraylistin icinde gezinerek part.txt dosyasindaki eleman isimleriyle stack
        // olusturarak o stacklarin icine ilgili elemanlari dolduruyorum
        ArrayList<Stack<Items>> stackArrayList=new ArrayList<>();
        br=Methods.readTxtFile(args[0]);
        while (( line = br.readLine()) != null){
            Stack<Items> stack1=new Stack<>(line);
            for(Items temp: itemsArrayList){
                if(temp.getName().equals(line))
                    stack1.push(temp);
            }
            stackArrayList.add(stack1);
        }


        //asagidaki kod blogunda tasks.txt dosyasini okuyup buy ve put gorevlerini yapiyorum
        //bu gorevler icin methods classinda iki ayri fonksiyon olusturdum onlarin nasil calistigini
        //fonksiyonun uzerindeki yorum satirlariyla belirttim
        br=Methods.readTxtFile(args[3]);
        while (( line = br.readLine()) != null){
            String[] currentline=line.split("\t");
            if(currentline[0].equals("PUT") ){
                Methods.put(currentline,stackArrayList);

            }else if(currentline[0].equals("BUY")){
                String[] currentline2=line.split("\t");
                Methods.buy(currentline2, currentline, queue, stackArrayList);
            }
        }


        // sonucu yazdiriyorum
        for(Stack<Items> temp: stackArrayList){
            temp.print();
        }
        queue.print();
        output_txt.close();












    }
}
