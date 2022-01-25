import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String args[]){
        try{
            //Dosya okuma işlemi açıldı
            BufferedWriter output_txt=new BufferedWriter(new FileWriter("output.txt"));
            output_txt=new BufferedWriter(new FileWriter("output.txt"));
            File author= new File(args[0]);
            BufferedReader br= new BufferedReader(new FileReader(author));

            // Yazarlar Listesinin kaç satır olduğunu buldum arrayliste eklemek için
            int a = 0;
            while (br.readLine() != null) a++;
            br.close();
            author= new File(args[0]);
            br= new BufferedReader(new FileReader(author));



            // Arrayin içine yazarları ekledim
            ArrayList<Author> last_yazarlar=new ArrayList<>();
            int i=0;

            // For döngüsü ile yazarları Array list içine atarak bir classta tanımladım.

            for (i=0; i<a;i++) {
                String[] array2 = br.readLine().split(" ");
                int length = array2.length;
                if (length > 10) {
                    last_yazarlar.add(new Author(array2[1], array2[2], array2[3], array2[4], array2[5], array2[6], array2[7], array2[8], array2[9], array2[10]));
                } else if (length > 9) {
                    last_yazarlar.add(new Author(array2[1], array2[2], array2[3], array2[4], array2[5], array2[6], array2[7], array2[8], array2[9]));
                } else if (length > 8) {
                    last_yazarlar.add(new Author(array2[1], array2[2], array2[3], array2[4], array2[5], array2[6], array2[7], array2[8]));
                } else if (length > 7) {
                    last_yazarlar.add(new Author(array2[1], array2[2], array2[3], array2[4], array2[5], array2[6], array2[7]));
                } else if (length > 6) {
                    last_yazarlar.add(new Author(array2[1], array2[2], array2[3], array2[4], array2[5], array2[6]));
                } else if (length > 5) {
                    last_yazarlar.add(new Author(array2[1], array2[2], array2[3], array2[4], array2[5]));
                }else if (length>1){
                    last_yazarlar.add(new Author(array2[1]));
                }
            }
            BufferedReader reader = new BufferedReader(new FileReader(args[1]));
            int lines = 0;
            while (reader.readLine() != null) lines++;
            reader.close();

            File komutlar= new File(args[1]);
            BufferedReader kom= new BufferedReader(new FileReader(komutlar));

            ArrayList<Article> article= new ArrayList<>();
            int j=0;
            for (i=0; i<lines;i++) {
                String[] array2 = kom.readLine().split(" ");
                if(array2[0].equals("read")){
                    // Makaleleri classa tanımlamak için array oluşturup for döngüsü ile tanımladım
                    BufferedReader reader1 = new BufferedReader(new FileReader(array2[1]));
                    int lines1 = 0;
                    while (reader1.readLine() != null) lines1++;
                    reader1.close();

                    File makale= new File(array2[1]);
                    BufferedReader br1= new BufferedReader(new FileReader(makale));

                    for (j=0; j<lines1;j++) {
                        String[] makaleler = br1.readLine().split(" ");
                        article.add(new Article(makaleler[1],makaleler[2],makaleler[3],makaleler[4]));
                    }
                }else if (array2[0].equals("sortedAll")){
                    output_txt.write("******************************SortedAll Successful*****************************\n");
                    for(Author temp: last_yazarlar){
                        String[] siralimakale = new String[5];
                        int counter211=0;
                        for (counter211=0;counter211<5;counter211++){
                            siralimakale[counter211]=(temp.arraylist().get(counter211));

                        }
                        Arrays.sort(siralimakale);
                        int counter105=0;
                        for (String temp1: siralimakale){
                            if (temp1.equals("?"))
                                break;
                            if (counter105==0)
                                temp.setArticle1(temp1);
                            else if (counter105==1)
                                temp.setArticle2(temp1);
                            else if (counter105==2)
                                temp.setArticle3(temp1);
                            else if (counter105==3)
                                temp.setArticle4(temp1);
                            else if (counter105==4)
                                temp.setArticle5(temp1);
                            counter105++;


                        }
                    }
                }else if (array2[0].equals("list")){
                    output_txt.write("--------------------------------------List-------------------------------------\n");
                    for(Author temp: last_yazarlar){
                        if (temp.getName()==null){
                            output_txt.write("Author:"+temp.getId()+"\n");

                        }else {
                            output_txt.write("Author:" + temp.getId() + "   " + temp.getName() + "   " + temp.getUniversity() + "   " + temp.getDepartment() + "   " + temp.getEmail()+"\n");
                        }
                        int counter101=1;
                        int counter102=1;
                        for (String temp2: temp.arraylist()){
                            if (counter101==1 && temp2.equals("?")){
                                output_txt.write(" \n");
                                counter101++;
                                continue;
                            }
                            if (temp2.equals("?")){
                                continue;
                            }
                            for (Article temp3: article){
                                if(temp2.equals(temp3.getPaperid())){
                                    output_txt.write(temp3.getAllarticle()+"\n");
                                }

                            }
                            counter102++;
                            if (!(temp2.equals("?"))&& counter102==6){
                                output_txt.write("\n");
                            }
                        }
                    }
                    output_txt.write("--------------------------------------End--------------------------------------\n");
                }else if (array2[0].equals("completeAll")){
                    output_txt.write("*****************************completeAll Successful****************************\n");
                    for(Author temp: last_yazarlar){
                        if (Metodlar.makalesayisi(temp.arraylist())>4){
                            continue;
                        }else if (Metodlar.makalesayisi(temp.arraylist())>3){
                            for (Article temp3: article){
                                if(temp3.getPaperid().substring(0,3).equals(temp.getId()) && !(temp.arraylist().contains(temp3.getPaperid()))){
                                    temp.setArticle5(temp3.getPaperid());
                                }
                            }
                        }else if (Metodlar.makalesayisi(temp.arraylist())>2){
                            ArrayList<String> kontrollistesi= new ArrayList<>();
                            for (Article temp3: article){
                                if(temp3.getPaperid().substring(0,3).equals(temp.getId()) && !(temp.arraylist().contains(temp3.getPaperid()))){
                                    kontrollistesi.add(temp3.getPaperid());
                                }
                            if ((kontrollistesi.size() > 1)){
                                temp.setArticle4(kontrollistesi.get(0));
                                temp.setArticle5(kontrollistesi.get(1));
                                }
                            else if ((kontrollistesi.size()==1)){
                                temp.setArticle4(kontrollistesi.get(0));
                            }
                        }
                            }else if (Metodlar.makalesayisi(temp.arraylist())>1){
                            ArrayList<String> kontrollistesi1= new ArrayList<>();
                            for (Article temp3: article){
                                if(temp3.getPaperid().substring(0,3).equals(temp.getId()) && !(temp.arraylist().contains(temp3.getPaperid()))){
                                    kontrollistesi1.add(temp3.getPaperid());
                                }
                                int counter10=1;
                                for (String eleman: kontrollistesi1){
                                    if (counter10==1){
                                        temp.setArticle3(eleman);
                                    }
                                    else if (counter10==2){
                                        temp.setArticle4(eleman);
                                    }
                                    else if (counter10==3){
                                        temp.setArticle5(eleman);
                                    }
                                    counter10++;
                                }
                            }
                        }else if (Metodlar.makalesayisi(temp.arraylist())>0){
                            ArrayList<String> kontrollistesi2= new ArrayList<>();
                            for (Article temp3: article){
                                if(temp3.getPaperid().substring(0,3).equals(temp.getId()) && !(temp.arraylist().contains(temp3.getPaperid()))){
                                    kontrollistesi2.add(temp3.getPaperid());
                                }
                                int counter11=1;
                                for (String eleman: kontrollistesi2){
                                    if (counter11==1){
                                        temp.setArticle2(eleman);
                                    }
                                    else if (counter11==2){
                                        temp.setArticle3(eleman);
                                    }
                                    else if (counter11==3){
                                        temp.setArticle4(eleman);
                                    }else if (counter11==4){
                                        temp.setArticle5(eleman);
                                    }
                                    counter11++;
                                }
                            }
                }else if (Metodlar.makalesayisi(temp.arraylist())==0){
                            ArrayList<String> kontrollistesi3= new ArrayList<>();
                            for (Article temp3: article){
                                if(temp3.getPaperid().substring(0,3).equals(temp.getId()) && !(temp.arraylist().contains(temp3.getPaperid()))){
                                    kontrollistesi3.add(temp3.getPaperid());
                                }
                                int counter12=1;
                                for (String eleman: kontrollistesi3){
                                    if (counter12==1){
                                        temp.setArticle1(eleman);

                                    }
                                    else if (counter12==2){
                                        temp.setArticle2(eleman);
                                    }
                                    else if (counter12==3){
                                        temp.setArticle3(eleman);
                                    }else if (counter12==4){
                                        temp.setArticle4(eleman);
                                    }else if (counter12==5){
                                        temp.setArticle5(eleman);
                                    }
                                    counter12++;

                                }
                            }
                        }
            }
                } else if (array2[0].equals("del")){
                    output_txt.write("*********************************del Successful********************************\n");
                    for (Author temp10: last_yazarlar){
                        if (temp10.getId().equals(array2[1])){
                            last_yazarlar.remove(temp10);
                            break;
                        }
                    }
                }
            }output_txt.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
