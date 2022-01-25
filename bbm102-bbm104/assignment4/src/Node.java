public class Node<T>  {
    public Items data;
    public Node<T> nextNode;

    Node(Items object){
        this(object,null);

    }
    Node(Items object, Node<T> node){
        data=object;
        nextNode=node;

    }



}
