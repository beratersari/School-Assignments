import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class Dwarf extends Calliance {
    int HP=Constants.dwarfHP;
    int maxHP=Constants.dwarfHP;

    public Dwarf(String name, String Id) {
        super(name, Id);
    }

    @Override
    public int getMaxHP() {
        return maxHP;
    }

    @Override
    public int getHP() {
        return HP;
    }

    // canini azaltiyor
    @Override
    public void decreaseHP(int yenilenhasar) {
        this.HP=this.HP-yenilenhasar;
        if(this.HP<0){
            this.HP=0;
        }
    }

    // komut dosyasinda bu asker hareket ettiginde bu metodla hareket ediyor
    public void move(HashMap<String,AllSoliders> hash, String[][] table, String[] move, String solider, HashMap<String,AllSoliders> solidersHashMap,BufferedWriter output_txt) throws IOException {
        ArrayList<Integer> position_of_element= Methods.find_index(table,solider);

        if (move.length / 2 == Constants.dwarfMaxMove) {
            for(int i=0;i< move.length;i+=2) {

                    try {

                    int x = Integer.parseInt(move[i]);
                    int y = Integer.parseInt(move[i + 1]);
                    position_of_element.set(0, position_of_element.get(0) + y);
                    position_of_element.set(1, position_of_element.get(1) + x);
                    if (Constants.calliancesIDs.contains(table[position_of_element.get(0)][position_of_element.get(1)])) {
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
                    if(Constants.zordesIDs.contains((table[position_of_element.get(0)][position_of_element.get(1)]))){
                        solidersHashMap.get(table[position_of_element.get(0)][position_of_element.get(1)]).decreaseHP(Constants.dwarfAP);
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
                        attackDwarf(table, solider, position_of_element, solidersHashMap);
                        table[position_of_element.get(0) - y][position_of_element.get(1) - x] = "  ";
                        table[position_of_element.get(0)][position_of_element.get(1)] = solider;
                        Methods.controlHP(table,solidersHashMap);
                        if(i==2){
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

    public static void attackDwarf(String[][] table,String solider,ArrayList<Integer> position_of_element,HashMap<String,AllSoliders> solidersHashMap){
        for(String temp: Methods.getSurroundings(table,position_of_element.get(1),position_of_element.get(0))){
            if (Constants.zordesIDs.contains(temp)){
                solidersHashMap.get(temp).decreaseHP(Constants.dwarfAP);
            }
        }
    }
}
