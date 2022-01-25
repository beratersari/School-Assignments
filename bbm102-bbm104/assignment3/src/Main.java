import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

public class Main {
    public static int real_size_of_table = 0;
    public static ArrayList<AllSoliders> allSoliders=new ArrayList<>();

    public static void main(String[] args) throws IOException {


        BufferedWriter output_txt=new BufferedWriter(new FileWriter(args[2]));
        output_txt=new BufferedWriter(new FileWriter(args[2]));



        String[][] table = new String[0][];
        HashMap<String ,AllSoliders> soldiresMap=new HashMap<>();


        File file = new File(args[0]);    //creates a new file instance
        FileReader fr = new FileReader(file);   //reads the file
        BufferedReader br = new BufferedReader(fr);  //creates a buffering character input stream
        StringBuffer sb = new StringBuffer();    //constructs a string buffer with no characters
        String line;

        // bu while dongusuyle boardi okuyup yerine taslari koyuyorum

        while ((line = br.readLine()) != null) {
            if (line.equals("BOARD")) {
                String[] tableSize = br.readLine().split("x");
                real_size_of_table = Integer.parseInt(tableSize[0]);
                table = new String[real_size_of_table][real_size_of_table];
                table = Methods.create_a_table(real_size_of_table);
            } else if (line.equals("CALLIANCE")) {
                while (true) {
                    String[] current_position = br.readLine().split(" ");
                    if (current_position[0].equals("ELF")) {
                        Elf elf=new Elf(current_position[0], current_position[1]);
                        Main.allSoliders.add(elf);
                        Constants.calliancesIDs.add(current_position[1]);
                        Methods.edit_table(table, current_position);
                        soldiresMap.put(current_position[1],elf);
                    } else if (current_position[0].equals("HUMAN")) {
                        Human human=new Human(current_position[0], current_position[1]);
                        Main.allSoliders.add(human);
                        Constants.calliancesIDs.add(current_position[1]);
                        Methods.edit_table(table, current_position);
                        soldiresMap.put(current_position[1],human);
                    } else if (current_position[0].equals("DWARF")) {
                        Dwarf dwarf=new Dwarf(current_position[0], current_position[1]);
                        Main.allSoliders.add(dwarf);
                        Constants.calliancesIDs.add(current_position[1]);
                        Methods.edit_table(table, current_position);
                        soldiresMap.put(current_position[1],dwarf);
                    } else if (current_position[0].equals("ZORDE")) {
                        while (true) {
                            try {
                                current_position = br.readLine().split(" ");
                                if (current_position[0].equals("GOBLIN")) {
                                    Goblin goblin=new Goblin(current_position[0], current_position[1]);
                                    Main.allSoliders.add(goblin);
                                    Methods.edit_table(table, current_position);
                                    soldiresMap.put(current_position[1],goblin);
                                    Constants.zordesIDs.add(current_position[1]);
                                } else if (current_position[0].equals("TROLL")) {
                                    Troll troll=new Troll(current_position[0], current_position[1]);
                                    Main.allSoliders.add(troll);
                                    Methods.edit_table(table, current_position);
                                    soldiresMap.put(current_position[1],troll);
                                    Constants.zordesIDs.add(current_position[1]);
                                } else if (current_position[0].equals("ORK")) {
                                    Ork ork=new Ork(current_position[0], current_position[1]);
                                    Main.allSoliders.add(ork);
                                    Methods.edit_table(table, current_position);
                                    soldiresMap.put(current_position[1],ork);
                                    Constants.zordesIDs.add(current_position[1]);
                                }
                            }catch (Exception e){
                                break;
                            }
                        }
                        break;
                    }
                }
            }
        }


        fr.close();
        file = new File(args[1]);    //creates a new file instance
        fr = new FileReader(file);   //reads the file
        br = new BufferedReader(fr);  //creates a buffering character input stream



        Methods.print_Table(table,Main.real_size_of_table,output_txt);
        Methods.print_current_heal(soldiresMap,output_txt);

        // bu donguyle komutlari okuyup hizlica uyguluyorum
        boolean whileControl=false;
        while ((line = br.readLine()) != null){
            String[] currentLine= line.split(" ");
            soldiresMap.get(currentLine[0]).move(soldiresMap, table, currentLine[1].split(";"), currentLine[0], soldiresMap,output_txt);
            if(soldiresMap.size()==1){
                output_txt.write("\n");
                for(AllSoliders temp: soldiresMap.values()){
                    if (temp instanceof Calliance){
                        output_txt.write("Game Finished\n");
                        output_txt.write("Calliance Wins\n");
                        whileControl=true;

                    }else if( temp instanceof Zorde){
                        output_txt.write("Game Finished\n");
                        output_txt.write("Zorde Wins\n");
                        whileControl=true;
                    }
                }
            }
            if(whileControl){
                break;
            }
        }
        output_txt.close();
    }
}
