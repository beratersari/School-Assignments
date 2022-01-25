import java.util.ArrayList;

public class Metodlar {
    public static int makalesayisi(ArrayList<String> liste){
        int counter=0;
        for (Object temp: liste){
            if (!(temp=="?")){
                counter++;
            }
        }
        return counter;
    }

}
