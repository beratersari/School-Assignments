import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class Ork extends Zorde{
    int HP=Constants.orkHP;
    int maxHP=Constants.orkHP;


    public Ork(String name, String id) {
        super(name, id);
    }

    @Override
    public int getMaxHP() {
        return maxHP;
    }

    @Override
    public int getHP() {
        return HP;
    }

    @Override
    public void decreaseHP(int yenilenhasar) {
        this.HP=this.HP-yenilenhasar;
        if(this.HP<0){
            this.HP=0;
        }
    }

    @Override
    public void healFriends() {
        this.HP=this.HP+10;
        if (this.HP>this.maxHP){
            this.HP=this.maxHP;
        }
    }
    // komut dosyasinda bu asker hareket ettiginde bu metodla hareket ediyor

    public void move(HashMap<String, AllSoliders> hash, String[][] table, String[] move, String solider, HashMap<String, AllSoliders> solidersHashMap, BufferedWriter output_txt) throws IOException {
        ArrayList<Integer> position_of_element= Methods.find_index(table,solider);
        if (move.length / 2 == Constants.orkMaxMove){
            int x = Integer.parseInt(move[0]);
            int y = Integer.parseInt(move[1]);
            try {
                position_of_element.set(0, position_of_element.get(0) + y);
                position_of_element.set(1, position_of_element.get(1) + x);
                if (Constants.zordesIDs.contains(table[position_of_element.get(0)][position_of_element.get(1)])) {
                    healOrk(table, solider, position_of_element, solidersHashMap,y,x);
                    solidersHashMap.get(solider).healFriends();
                    ;
                }
                if (table[position_of_element.get(0)][position_of_element.get(1)].equals("*") || table[position_of_element.get(0)][position_of_element.get(1)].equals("**")) {
                    throw new MyException();
                }
                if(Constants.calliancesIDs.contains((table[position_of_element.get(0)][position_of_element.get(1)]))){
                    healOrk(table, solider, position_of_element, solidersHashMap,y,x);
                    solidersHashMap.get(solider).healFriends();
                    solidersHashMap.get(table[position_of_element.get(0)][position_of_element.get(1)]).decreaseHP(Constants.orkAP);
                    if(getHP()>solidersHashMap.get(table[position_of_element.get(0)][position_of_element.get(1)]).getHP()){
                        this.HP=this.HP-solidersHashMap.get(table[position_of_element.get(0)][position_of_element.get(1)]).getHP();
                        solidersHashMap.remove(table[position_of_element.get(0)][position_of_element.get(1)]);
                        table[position_of_element.get(0) - y][position_of_element.get(1) - x] = "  ";
                        table[position_of_element.get(0)][position_of_element.get(1)] = solider;
                    }else if(solidersHashMap.get(table[position_of_element.get(0)][position_of_element.get(1)]).getHP()>getHP()){
                        solidersHashMap.get(table[position_of_element.get(0)][position_of_element.get(1)]).decreaseHP(this.HP);
                        solidersHashMap.remove(solider);
                        table[position_of_element.get(0) - y][position_of_element.get(1) - x] = "  ";
                    }else{
                        solidersHashMap.remove(solider);
                        solidersHashMap.remove(table[position_of_element.get(0)][position_of_element.get(1)]);
                        table[position_of_element.get(0) - y][position_of_element.get(1) - x] = "  ";
                        table[position_of_element.get(0) ][position_of_element.get(1)] = "  ";
                    }
                    Methods.controlHP(table,solidersHashMap);
                    Methods.print_Table(table, Main.real_size_of_table,output_txt);
                    Methods.print_current_heal(solidersHashMap,output_txt);
                }else {
                    attackOrk(table, solider, position_of_element, solidersHashMap);
                    healOrk(table, solider, position_of_element, solidersHashMap,y,x);
                    solidersHashMap.get(solider).healFriends();
                    table[position_of_element.get(0) - y][position_of_element.get(1) - x] = "  ";
                    table[position_of_element.get(0)][position_of_element.get(1)] = solider;
                    Methods.controlHP(table,solidersHashMap);
                    Methods.print_Table(table, Main.real_size_of_table,output_txt);
                    Methods.print_current_heal(solidersHashMap,output_txt);
                }
            } catch (MyException e) {
                output_txt.write("Error : Game board boundaries are exceeded. Input line ignored.\n\n");
            }
            Methods.controlHP(table,solidersHashMap);

        }else{
            output_txt.write("Error : Move sequence contains wrong number of move steps. Input line ignored.\n\n");
        }
    }

    // hareket ederken menziline dusman girerse bu metodla saldiriyor bunu move methodunun icinde kullandim
    public static void attackOrk(String[][] table,String solider,ArrayList<Integer> position_of_element,HashMap<String,AllSoliders> solidersHashMap){
        for(String temp: Methods.getSurroundings(table,position_of_element.get(1),position_of_element.get(0))){
            if (Constants.calliancesIDs.contains(temp)){
                solidersHashMap.get(temp).decreaseHP(Constants.orkAP);
            }
        }
    }

    // hareket ederken menziline arkadasi girerse bu metodla iyilestiriyor bunu move methodunun icinde kullandim
    public static void healOrk(String[][] table,String solider,ArrayList<Integer> position_of_element,HashMap<String,AllSoliders> solidersHashMap,int y,int x){
        for(String temp: Methods.getSurroundings(table,position_of_element.get(1)-x,position_of_element.get(0)-y)){
            if(Constants.zordesIDs.contains(temp)){
                solidersHashMap.get(temp).healFriends();
            }
        }
    }
}
