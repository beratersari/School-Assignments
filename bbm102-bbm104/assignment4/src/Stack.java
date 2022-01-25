import java.io.IOException;
import java.util.ArrayList;
import java.util.EmptyStackException;

public class Stack<T> {
    Node<T> firstNode;
    Node<T> lastNode;
    private String name;

    public String getName() {
        return name;
    }

    public Stack(){
        this("stack");
    }

    public Stack(String stackname){
        name=stackname;
        firstNode=null;
        lastNode=null;
    }


    public boolean isEmpty(){
        return firstNode==null;
    }

    public void  push(T item){
        if(isEmpty()){
            firstNode=lastNode=new Node<T>((Items) item);
        }
        else
            lastNode=lastNode.nextNode=new Node<T>((Items) item);
    }

    public Items peek(){
        if (isEmpty()){
            throw new EmptyStackException();
        }
        Items removedItem=firstNode.data;
        if(firstNode==lastNode){
            firstNode=null;
            lastNode=null;
        }
        else {
            Node<T> current= firstNode;
            while (current.nextNode != lastNode)
                current=current.nextNode;
            lastNode=current;
            current.nextNode=null;

        }
        return removedItem;

    }
    public void print() throws IOException {
        ArrayList<Items> items=new ArrayList<>();
        if(isEmpty()){
            Main.output_txt.write(name+":"+"\n");
            Main.output_txt.write(""+"\n");
            Main.output_txt.write("---------------"+"\n");
            return;
        }
        Main.output_txt.write(name+":"+"\n");
        Node<T> current=firstNode;
        while (current!=null){
            items.add(current.data);
            current=current.nextNode;
        }
        for(int i= items.size()-1;i>-1;i--){
            Main.output_txt.write(items.get(i).getId()+"\n");
        }
        Main.output_txt.write("---------------"+"\n");
    }


}
