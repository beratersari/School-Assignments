import java.io.BufferedWriter;
import java.io.IOException;
import java.util.HashMap;

public class AllSoliders {
    String name;
    String Id;
    int HP;
    int maxHP;

    public int getMaxHP() {
        return maxHP;
    }

    //bu metod ork iyilestirdiginde cevresinde olan dostlari iyilestirmek icin
    public void healFriends(){
        this.HP=this.HP+10;
        if (this.HP>this.maxHP){
            this.HP=this.maxHP;
        }
    }
    // bu metod asker hasar yediginde canini azaltmak icin

    public void decreaseHP(int yenilenhasar){
        System.out.println("Buraya girdim");
        this.HP=this.HP-yenilenhasar;
    }


    public int getHP() {
        return HP;
    }


    public AllSoliders(String name, String id) {
        this.name = name;
        Id = id;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return Id;
    }

    // daha kolay erismek icin bu metodu burda yazip alt classlarda override ettim

    public void move(HashMap<String, AllSoliders> hash, String[][] table, String[] move, String solider, HashMap<String, AllSoliders> solidersHashMap, BufferedWriter output_txt) throws IOException {
        ;
    }
}
