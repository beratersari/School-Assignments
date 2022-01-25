import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

public class Metodlar {
    // bu fonksiyon bulundugum komut satirini yazdiriyor ve bir bosluk birakiyor
    public static void satiryazdirma(String[] satir,BufferedWriter output_txt) throws IOException {
        for (String temp:satir){
            output_txt.write(temp+"\t");
            output_txt.write(" ");

        }
        output_txt.write(" "+"\n");
        output_txt.write(" "+"\n");

    }
    // bu fonksiyon bir array listin icindeki elemanlari virgullu sekilde yazdiriyor
    public static void arraylistyazdirma(ArrayList<String> arraylist,BufferedWriter output_txt) throws IOException {
        int counter=0;
        for (counter=0;counter<arraylist.size();counter++){
            if (counter==arraylist.size()-1){
                output_txt.write(arraylist.get(counter)+"\n");
                break;
            }
            output_txt.write(arraylist.get(counter)+", ");
        }
    }
    // bu fonksiyonu writer director veya genre birden fazla oldugu icin onlari bir array list icine atip objemi tanimlarken bu arraylisti ozellik olarak eklemek icin kullandim
    public static ArrayList<String> ActorDuzenleme(String[] satir,int index){
        ArrayList<String> Arrayimarraylist = new ArrayList<>();
        String konum=satir[index];
        String[] arrayim = konum.split(",");
        Collections.addAll(Arrayimarraylist, arrayim);
        return Arrayimarraylist;
    }
    // bu yazdirma isini birden fazla kullandigim icin bir fonksiyona alayim dedim
    public static void filmratedsuccesfullyazdir(User user,Film film,String[] satir,BufferedWriter output_txt) throws IOException {
        user.filmoyla(film.getFilmId(), film.getFilmTitle(), satir[3]);
        film.filmrating(satir[3]);
        output_txt.write(satir[0] + "\t" + satir[1] + "\t" + satir[2] + "\t" + satir[3]+"\n");
        output_txt.write(" "+"\n");
        output_txt.write("Film rated successfully."+"\n");
        output_txt.write("Film type: " + film.getFilmtype()+"\n");
        output_txt.write("Film title: " + film.getFilmTitle()+"\n");
        output_txt.write(" "+"\n");
        output_txt.write("-----------------------------------------------------------------------------------------------------"+"\n");
    }
    // bu yazdirma isini birden fazla kullandigim icin bir fonksiyona alayim dedim
    public static void filmratedcommandfailed(String[] satir,BufferedWriter output_txt) throws IOException {
        output_txt.write(satir[0] + "\t" + satir[1] + "\t" + satir[2] + "\t" + satir[3]+"\n");
        output_txt.write(" "+"\n");
        output_txt.write("Command Failed"+"\n");
        output_txt.write("User ID: " + satir[1]+"\n");
        output_txt.write("Film ID: " + satir[2]+"\n");
        output_txt.write(" "+"\n");
        output_txt.write("-----------------------------------------------------------------------------------------------------"+"\n");
    }
    // bu yazdirma isini birden fazla kullandigim icin bir fonksiyona alayim dedim
    public static void filmaddedAndcommandfailed(String[] satir, String addOrfail, BufferedWriter output_txt) throws IOException {
        if (addOrfail.equals("fail"))
            output_txt.write("Command Failed"+"\n");
        else{
            output_txt.write("Film added successfully."+"\n");
        }
        output_txt.write("Film ID: " + satir[2]+"\n");
        output_txt.write("Film title: " + satir[3]+"\n");
        output_txt.write(" "+"\n");
        output_txt.write("-----------------------------------------------------------------------------------------------------"+"\n");
    }
    // ratingte aradaki noktayi virgule cevirmek icin bir fonksiyon
    public static String noktayivirgulecevirme(Double ortalama){
        String ortalamaoy=String.format("%.1f",ortalama);
        String sifir="0";
        char a = ortalamaoy.charAt(2);
        char sifir1=sifir.charAt(0);
        if (sifir1==a){
            ortalamaoy=ortalamaoy.substring(0,1);
        }
        String[] rakamlar= ortalamaoy.split("\\.");
        String sonsayi="";
        for (String temp:rakamlar){
            sonsayi=sonsayi+temp;
        }
        int sonsayi1=Integer.parseInt(sonsayi);
        NumberFormat nf = NumberFormat.getNumberInstance(Locale.US);
        DecimalFormat formatter = (DecimalFormat) nf;
        formatter.applyPattern("#,#");
        return formatter.format(sonsayi1);
    }


}
