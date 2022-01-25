import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;

public class Methods {

    //buy gorevi icin ayri bir method tanimladim bu method ilgili satiri tab ile ayiriyor
    //alinacak esyalari virgul ile ayiriyor ve almaya basliyor eger ilgili token yeterse sayisini azaltip queuedan cikariyor
    //sonra tekrar ekliyor, eger token tam olarak yeterse tokeni queuedan cikariyor
    //eger ilk buldugumuz token satin almak icin yetmezse basa donup ilgili urunle ilgili yeni token arayip ona da ayni islemleri uyguluyor
    public static void buy(String[]currentline2, String[] currentline, Queue queue, ArrayList<Stack<Items>> stackArrayList){
        for(int i=1; i<currentline2.length;i++){
            String[] currentline3= currentline[i].split(",");
            int control=Integer.parseInt(currentline3[1]);
            for(int u=0; u<queue.getItems().size();u++){
                if(queue.getItems().get(u).getName().equals(currentline3[0])){
                    int newTokenNumber= queue.getItems().get(u).getNumberofItem()-control;
                    for(Stack<Items> temp5: stackArrayList){
                        if(temp5.getName().equals(currentline3[0])){
                            for(int k=0;k<Integer.parseInt(currentline3[1]);k++){
                                temp5.peek();
                            }
                            break;
                        }
                    }
                    if (newTokenNumber>0){
                        String id= queue.getItems().get(u).getId();
                        String name=queue.getItems().get(u).getName();
                        queue.dequeue(queue.getItems().get(u));
                        queue.enqueue(new Tokens(id,name,newTokenNumber));
                    }else if (newTokenNumber==0){
                        queue.dequeue(queue.getItems().get(u));
                    }else{
                        queue.dequeue(queue.getItems().get(u));
                        u=0;
                        boolean control1=true;
                        while (control1){
                            for(int t=0;t<queue.getItems().size();t++){
                                if(queue.getItems().get(t).getName().equals(currentline3[0])){
                                    newTokenNumber+=queue.getItems().get(t).getNumberofItem();
                                }
                                if(newTokenNumber>0){
                                    String id1=queue.getItems().get(t).getId();
                                    String name1=queue.getItems().get(t).getName();
                                    queue.dequeue(queue.getItems().get(t));
                                    queue.enqueue(new Tokens(id1,name1,newTokenNumber));
                                    control1=false;
                                    break;
                                }else if(newTokenNumber==0){
                                    queue.dequeue(queue.getItems().get(t));
                                    control1=false;
                                    break;
                                }
                            }
                        }
                    }
                    break;
                }
            }
        }
    }


    //bu fonksiyon mevcut satiri alip virgul ile ayiriyor ve elemanlari ilgili stackin icine tek tek koyuyor
    public static void put(String[] currentline, ArrayList<Stack<Items>> stackArrayList) {
        for (int i = 1; i < currentline.length; i++) {
            String[] currentline1 = currentline[i].split(",");
            for (Stack<Items> temp1 : stackArrayList) {
                if (temp1.getName().equals(currentline1[0])) {
                    for (int j = 1; j < currentline1.length; j++) {
                        temp1.push(new Items(currentline1[j], temp1.getName()));
                    }
                }
            }
        }
    }


    // dosya okurken surekli ayni uc satiri yazmamak icin bir fonksiyon yazmak istedim
    public static BufferedReader readTxtFile(String name) throws FileNotFoundException {
        File file = new File(name);    //creates a new file instance
        FileReader fr = new FileReader(file);   //reads the file
        BufferedReader br = new BufferedReader(fr);  //creates a buffering character input stream
        return br;
    }
}
