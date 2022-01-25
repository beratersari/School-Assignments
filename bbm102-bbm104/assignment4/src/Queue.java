import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Queue {
    private ArrayList<Tokens> items=new ArrayList<>();
    private String name;

    public Queue(){
        this("queue");
    }

    public ArrayList<Tokens> getItems() {
        return items;
    }

    public Queue(String queueName){
        name=queueName;
    }

    public void enqueue(Tokens item){
        boolean control=false;
        if(items.size()==0){
            items.add(item);
        }else{
            for(int i=0; i< items.size();i++){
                if(control){
                    break;
                }
                if(items.get(i).getNumberofItem()< item.getNumberofItem()){
                    items.add(i,item);
                    break;
                    }

                else if (i==items.size()-1){
                    items.add(item);
                    break;

                }else if(items.get(i).getNumberofItem()== item.getNumberofItem()){

                    for(int j=i; j<items.size();j++){
                        if(j==items.size()-1){
                            control=true;
                            if(item.getNumberofItem()>items.get(j).getNumberofItem())
                                items.add(j,item);
                            else
                                items.add(item);
                            break;
                        }else if( item.getNumberofItem()!=items.get(j).getNumberofItem()){
                            control=true;
                            items.add(j,item);
                            break;

                        }
                    }
                }
            }
        }
    }


    public void dequeue(Tokens tokens){
        items.remove(tokens);

    }
    public void print() throws IOException {
        Main.output_txt.write("Token Box:"+"\n");
        for(int i=items.size()-1;i>-1;i--){
            Main.output_txt.write(items.get(i).getId()+" " +items.get(i).getName()+" "+items.get(i).getNumberofItem()+"\n");
        }
    }




}
