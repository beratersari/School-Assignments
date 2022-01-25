import java.io.BufferedWriter;
import java.io.IOException;
import java.util.*;

public class Methods {

    private static int[][] directions = new int[][]{{-1,-1}, {-1,0}, {-1,1},  {0,1}, {1,1},  {1,0},  {1,-1},  {0, -1}};
    private static int[][] x2directions = new int[][]{{-1,-1}, {-1,0}, {-1,1},  {0,1}, {1,1},  {1,0},  {1,-1},  {0, -1},{-2,-2}, {-2,-1}, {-2,0}, {-2,1}, {-2,2}, {2,-2}, {2,-1},{2,0},{2,1},{2,2},{0,-2},{0,2},{-1,-2},{-1,2},{1,-2},{1,2}};

    // table olusturuyorum
    public static String[][] create_a_table (int a){
        String[][] table = new String[a+2][a+2];
        for (int i = 0; i < a+2; i++) {
            for (int j = 0; j < a+2; j++) {
                if (j == 0) { table[i][j] = "*"; }
                else if (j == a + 1) { table[i][j] = "*"; }
                else if (i == 0) { table[i][j] = "**"; }
                else if (i == a + 1) { table[i][j] = "**"; }
                else{ table[i][j]="  ";}
            }
        }
        return table;
    }

    // tahtayi bastiriyorum

    public static void print_Table (String[][] table, int real_size_of_table, BufferedWriter output_txt) throws IOException {
        for (int i = 0; i < real_size_of_table+2; i++) {
            for (int j = 0; j < real_size_of_table+2; j++) {
                output_txt.write(table[i][j]);
            }
            output_txt.write("\n");
        }
    }

    //tahtada degisiklik yapiyorum


    public static void edit_table(String[][] table, String[] current_position){
        int x=Integer.parseInt(current_position[2]);
        int y=Integer.parseInt(current_position[3]);
        table[y+1][x+1]=current_position[1];
    }
    //tahtadaki bir tasin konumunu buluyorum

    public static ArrayList<Integer> find_index(String[][] table, String element){
        ArrayList<Integer> position = new ArrayList<>();
        for (int i = 0 ; i < table.length; i++)
            for(int j = 0 ; j < table.length ; j++)
            {
                if (table[i][j].equals(element))
                {
                    position.add(i);
                    position.add(j);
                }

            }
        return position;
    }
    //tahtadaki bir askerin cevresindeki askerleri buluyorum


    public static ArrayList<String> getSurroundings(String[][] matrix, int x, int y){
        ArrayList<String> res = new ArrayList<String>();
        for (int[] direction : directions) {
            try {
                int cx = x + direction[0];
                int cy = y + direction[1];
                if (cy >= 0 && cy < matrix.length)
                    if (cx >= 0 && cx < matrix[cy].length)
                        res.add(matrix[cy][cx]);
            }catch (IndexOutOfBoundsException e){
                ;
            }
        }
        return res;
    }

    //tahtadaki bir askerin 2 kat daha uzak cevresindeki askerleri buluyorum
    public static ArrayList<String> getSurroundingsx2(String[][] matrix, int x, int y){
        ArrayList<String> res = new ArrayList<String>();
        for (int[] direction : x2directions) {
            try {
                int cx = x + direction[0];
                int cy = y + direction[1];
                if (cy >= 0 && cy < matrix.length)
                    if (cx >= 0 && cx < matrix[cy].length)
                        res.add(matrix[cy][cx]);
            }catch (IndexOutOfBoundsException e){
                ;
            }
        }
        return res;
    }
    // tablodaki taslarin guncel canlarini yazdiriyor

    public static void print_current_heal(HashMap<String,AllSoliders> soldiresMap,BufferedWriter output_txt) throws IOException {
        output_txt.write("\n");
        ArrayList<AllSoliders> allSolidersArrayList=new ArrayList<>();
        for (AllSoliders temp: soldiresMap.values()){
            allSolidersArrayList.add(temp);
        }

        Collections.sort(allSolidersArrayList, Comparator.comparing(AllSoliders::getId));
        for(AllSoliders temp: allSolidersArrayList){
            output_txt.write(temp.getId()+"\t"+temp.getHP()+"\t("+temp.getMaxHP()+")"+"\n");
        }
        output_txt.write("\n");
    }
    public static void controlHP(String[][] table, HashMap<String,AllSoliders> solidersHashMap){
        for(int i=0;i<table.length;i++){
            for(int j=0;j<table.length;j++){
                if(solidersHashMap.get(table[i][j])!=null){
                    if (solidersHashMap.get(table[i][j]).getHP()>0){
                        ;
                    }else{
                        solidersHashMap.remove(table[i][j]);
                        table[i][j]="  ";
                    }
                }
            }
        }
    }



}

