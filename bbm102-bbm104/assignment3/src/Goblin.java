import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class Goblin extends Zorde {
    int HP=Constants.goblinHP;
    int maxHP=Constants.goblinHP;

    public Goblin(String name, String id) {
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

        if (move.length / 2 == Constants.goblinMaxMove) {
            for(int i=0;i< move.length;i+=2) {
                try {
                    int x = Integer.parseInt(move[i]);
                    int y = Integer.parseInt(move[i + 1]);
                    position_of_element.set(0, position_of_element.get(0) + y);
                    position_of_element.set(1, position_of_element.get(1) + x);
                    if (Constants.zordesIDs.contains(table[position_of_element.get(0)][position_of_element.get(1)])) {
                        if(i!=0){
                            Methods.controlHP(table,solidersHashMap);
                            Methods.print_Table(table, Main.real_size_of_table,output_txt);
                            Methods.print_current_heal(solidersHashMap,output_txt);
                        }
                        break;
                    }
                    if (table[position_of_element.get(0)][position_of_element.get(1)].equals("*") || table[position_of_element.get(0)][position_of_element.get(1)].equals("**")) {
                        throw new MyException();
                    }
                    if(Constants.calliancesIDs.contains((table[position_of_element.get(0)][position_of_element.get(1)]))){
                        solidersHashMap.get(table[position_of_element.get(0)][position_of_element.get(1)]).decreaseHP(Constants.goblinAP);
                        if(getHP()>solidersHashMap.get(table[position_of_element.get(0)][position_of_element.get(1)]).getHP()){
                            this.HP=this.HP-solidersHashMap.get(table[position_of_element.get(0)][position_of_element.get(1)]).getHP();
                            solidersHashMap.remove(table[position_of_element.get(0)][position_of_element.get(1)]);
                            table[position_of_element.get(0) - y][position_of_element.get(1) - x] = "  ";
                            table[position_of_element.get(0)][position_of_element.get(1)] = solider;
                            Methods.controlHP(table,solidersHashMap);
                            Methods.print_Table(table, Main.real_size_of_table,output_txt);
                            Methods.print_current_heal(solidersHashMap,output_txt);
                            break;
                        }else if(solidersHashMap.get(table[position_of_element.get(0)][position_of_element.get(1)]).getHP()>getHP()){
                            solidersHashMap.get(table[position_of_element.get(0)][position_of_element.get(1)]).decreaseHP(this.HP);
                            solidersHashMap.remove(solider);
                            table[position_of_element.get(0) - y][position_of_element.get(1) - x] = "  ";
                            Methods.controlHP(table,solidersHashMap);
                            Methods.print_Table(table, Main.real_size_of_table,output_txt);
                            Methods.print_current_heal(solidersHashMap,output_txt);
                            break;
                        }else{
                            solidersHashMap.remove(solider);
                            solidersHashMap.remove(table[position_of_element.get(0)][position_of_element.get(1)]);
                            table[position_of_element.get(0) - y][position_of_element.get(1) - x] = "  ";
                            table[position_of_element.get(0) ][position_of_element.get(1)] = "  ";
                            Methods.controlHP(table,solidersHashMap);
                            Methods.print_Table(table, Main.real_size_of_table,output_txt);
                            Methods.print_current_heal(solidersHashMap,output_txt);
                            break;
                        }
                    }else {
                        attackGoblin(table, solider, position_of_element, solidersHashMap);
                        table[position_of_element.get(0) - y][position_of_element.get(1) - x] = "  ";
                        table[position_of_element.get(0)][position_of_element.get(1)] = solider;

                        if(i==6) {
                            Methods.controlHP(table,solidersHashMap);
                            Methods.print_Table(table, Main.real_size_of_table,output_txt);
                            Methods.print_current_heal(solidersHashMap,output_txt);
                        }
                    }
                } catch (MyException e) {
                    output_txt.write("Error : Game board boundaries are exceeded. Input line ignored.\n\n");
                    break;
                }
                Methods.controlHP(table,solidersHashMap);
                }


        }else{
            output_txt.write("Error : Move sequence contains wrong number of move steps. Input line ignored.\n\n");
        }
    }

    // hareket ederken menziline dusman girerse bu metodla saldiriyor bunu move methodunun icinde kullandim


    public static void attackGoblin(String[][] table,String solider,ArrayList<Integer> position_of_element,HashMap<String,AllSoliders> solidersHashMap){
        for(String temp: Methods.getSurroundings(table,position_of_element.get(1),position_of_element.get(0))){
            if (Constants.calliancesIDs.contains(temp)){
                solidersHashMap.get(temp).decreaseHP(Constants.goblinAP);
            }
        }
    }
}
