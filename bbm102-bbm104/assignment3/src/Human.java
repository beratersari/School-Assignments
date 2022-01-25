import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class Human extends Calliance {
    int HP=Constants.humanHP;
    int maxHP=Constants.humanHP;

    @Override
    public int getMaxHP() {
        return maxHP;
    }

    public Human(String name, String Id) {
        super(name, Id);
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

    // komut dosyasinda bu asker hareket ettiginde bu metodla hareket ediyor

    public void move(HashMap<String, AllSoliders> hash, String[][] table, String[] move, String solider, HashMap<String, AllSoliders> solidersHashMap, BufferedWriter output_txt) throws IOException {
        ArrayList<Integer> position_of_element= Methods.find_index(table,solider);
        int ilkkonumY=position_of_element.get(0);
        int ilkonumX=position_of_element.get(1);

        if (move.length / 2 == Constants.humanMaxMove) {
            for(int i=0;i< move.length;i+=2) {
                try {
                    int x = Integer.parseInt(move[i]);
                    int y = Integer.parseInt(move[i + 1]);
                    position_of_element.set(0, position_of_element.get(0) + y);
                    position_of_element.set(1, position_of_element.get(1) + x);
                    if (Constants.calliancesIDs.contains(table[position_of_element.get(0)][position_of_element.get(1)])) {
                        if (i != 0) {
                            Methods.controlHP(table, solidersHashMap);
                            Methods.print_Table(table, Main.real_size_of_table, output_txt);
                            Methods.print_current_heal(solidersHashMap, output_txt);
                        }
                        break;
                    }
                    if (table[position_of_element.get(0)][position_of_element.get(1)].equals("*") || table[position_of_element.get(0)][position_of_element.get(1)].equals("**")) {
                        if (i == 0)
                            throw new MyException();
                        else {
                            table[ilkkonumY][ilkonumX] = "  ";
                            table[position_of_element.get(0) - y][position_of_element.get(1) - x] = solider;
                            Methods.controlHP(table, solidersHashMap);
                            Methods.print_Table(table, Main.real_size_of_table, output_txt);
                            Methods.print_current_heal(solidersHashMap, output_txt);
                            throw new MyException();

                        }
                    }
                    if (Constants.zordesIDs.contains((table[position_of_element.get(0)][position_of_element.get(1)]))) {
                        solidersHashMap.get(table[position_of_element.get(0)][position_of_element.get(1)]).decreaseHP(Constants.humanAP);
                        if (getHP() > solidersHashMap.get(table[position_of_element.get(0)][position_of_element.get(1)]).getHP()) {
                            this.HP = this.HP - solidersHashMap.get(table[position_of_element.get(0)][position_of_element.get(1)]).getHP();
                            solidersHashMap.remove(table[position_of_element.get(0)][position_of_element.get(1)]);
                            table[ilkkonumY][ilkonumX] = "  ";
                            table[position_of_element.get(0)][position_of_element.get(1)] = solider;
                            Methods.controlHP(table, solidersHashMap);
                            Methods.print_Table(table, Main.real_size_of_table, output_txt);
                            Methods.print_current_heal(solidersHashMap, output_txt);
                            break;
                        } else if (solidersHashMap.get(table[position_of_element.get(0)][position_of_element.get(1)]).getHP() > getHP()) {
                            solidersHashMap.get(table[position_of_element.get(0)][position_of_element.get(1)]).decreaseHP(this.HP);
                            solidersHashMap.remove(solider);
                            table[ilkkonumY][ilkonumX] = "  ";
                            Methods.controlHP(table, solidersHashMap);
                            Methods.print_Table(table, Main.real_size_of_table, output_txt);
                            Methods.print_current_heal(solidersHashMap, output_txt);
                            break;
                        } else {
                            solidersHashMap.remove(solider);
                            solidersHashMap.remove(table[position_of_element.get(0)][position_of_element.get(1)]);
                            table[ilkkonumY][ilkonumX] = "  ";
                            table[position_of_element.get(0)][position_of_element.get(1)] = "  ";
                            Methods.controlHP(table, solidersHashMap);
                            Methods.print_Table(table, Main.real_size_of_table, output_txt);
                            Methods.print_current_heal(solidersHashMap, output_txt);
                            break;
                        }
                    } else if (i == 4) {
                        attackHuman(table, solider, position_of_element, solidersHashMap);
                        table[ilkkonumY][ilkonumX] = "  ";
                        table[position_of_element.get(0)][position_of_element.get(1)] = solider;
                        Methods.controlHP(table, solidersHashMap);
                        Methods.print_Table(table, Main.real_size_of_table, output_txt);
                        Methods.print_current_heal(solidersHashMap, output_txt);
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


    public static void attackHuman(String[][] table,String solider,ArrayList<Integer> position_of_element,HashMap<String,AllSoliders> solidersHashMap){
        for(String temp: Methods.getSurroundings(table,position_of_element.get(1),position_of_element.get(0))){
            if (Constants.zordesIDs.contains(temp)){
                solidersHashMap.get(temp).decreaseHP(Constants.humanAP);
            }
        }
    }
}
