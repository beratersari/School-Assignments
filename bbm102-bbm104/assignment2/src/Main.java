import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
        public static void main(String[] args) throws IOException {
            try{
                // ALLTAKI KISIMDA PEOPLE TXT DOSYASINI OKUTUP CLASSLARA EKLEDIM

                BufferedWriter output_txt=new BufferedWriter(new FileWriter(args[3]));
                output_txt=new BufferedWriter(new FileWriter(args[3]));
            File people = new File(args[0]);
            BufferedReader br = new BufferedReader(new FileReader(people));
            // Yazarlar Listesinin kaç satır olduğunu buldum arrayliste eklemek için
            int satirsayisi = 0;
            while (br.readLine() != null) satirsayisi++;
            br.close();
            people = new File(args[0]);
            br = new BufferedReader(new FileReader(people));
            // Ileride kullanacagim arraylistleri olusturdum
            ArrayList<User> users = new ArrayList<>();
            ArrayList<Actor> actors = new ArrayList<>();
            ArrayList<ChildActor> childActors = new ArrayList<>();
            ArrayList<StuntPerformer> stuntPerformers = new ArrayList<>();
            ArrayList<Director> directors = new ArrayList<>();
            ArrayList<Writer> writers = new ArrayList<>();
            ArrayList<FeatureFilm> featureFilms = new ArrayList<>();
            ArrayList<ShortFilm> shortFilms = new ArrayList<>();
            ArrayList<Documantary> documantaries = new ArrayList<>();
            ArrayList<TvSeries> tvSeries = new ArrayList<>();
            ArrayList<String> tumArtistlerinidleri= new ArrayList<>();
            ArrayList<Artist> tumArtistler= new ArrayList<>();
            ArrayList<Film> tumFilmler=new ArrayList<>();
            ArrayList<String> tumfilmidleri=new ArrayList<>();
            ArrayList<String> directorsArraylist = new ArrayList<>() ;
            ArrayList<String> performersArraylist = new ArrayList<>() ;
            ArrayList<String> writersArraylist = new ArrayList<>() ;
            ArrayList<String> genreArraylist=new ArrayList<>() ;
            String yuzde;



            int i ;
            for (i = 0; i < satirsayisi; i++) {
                String[] satir = br.readLine().split("\t");
                // burdaki switch yapisi personlari uygun olan array listlere ekliyor
                switch (satir[0].substring(0, satir[0].length() - 1)) {
                    case "User" :
                        users.add(new User(satir[2], satir[3], satir[4], satir[1]));
                        break;
                    case "Actor":
                        actors.add(new Actor(satir[2], satir[3], satir[4], satir[1], satir[5]));
                        tumArtistlerinidleri.add(actors.get(actors.size()-1).getUniqeId());
                        tumArtistler.add(actors.get(actors.size()-1));
                        break;
                    case "ChildActor":
                        childActors.add(new ChildActor(satir[2], satir[3], satir[4], satir[1], satir[5]));
                        tumArtistlerinidleri.add(childActors.get(childActors.size()-1).getUniqeId());
                        tumArtistler.add(childActors.get(childActors.size()-1));
                        break;
                    case "StuntPerformer":
                        ArrayList<String> realactoridArraylist = new ArrayList<>();
                        String[] realactoridarray = satir[6].split(",");
                        Collections.addAll(realactoridArraylist, realactoridarray);
                        stuntPerformers.add(new StuntPerformer(satir[2], satir[3], satir[4], satir[1], satir[5], realactoridArraylist));
                        tumArtistlerinidleri.add(stuntPerformers.get(stuntPerformers.size()-1).getUniqeId());
                        tumArtistler.add(stuntPerformers.get(stuntPerformers.size()-1));
                        break;
                    case "Director":
                        directors.add(new Director(satir[2], satir[3], satir[4], satir[1], satir[5]));
                        tumArtistlerinidleri.add(directors.get(directors.size()-1).getUniqeId());
                        tumArtistler.add(directors.get(directors.size()-1));
                        break;
                    case "Writer":
                        writers.add(new Writer(satir[2], satir[3], satir[4], satir[1], satir[5]));
                        tumArtistlerinidleri.add(writers.get(writers.size()-1).getUniqeId());
                        tumArtistler.add(writers.get(writers.size()-1));
                        break;
                } }

                // burda films dosyasinin kac satir oldugunu buldum okurken o kadar sayida donmek icin
                File films = new File(args[1]);
                BufferedReader br1 = new BufferedReader(new FileReader(films));
                int filmssatirsayisi = 0;
                while (br1.readLine() != null) filmssatirsayisi++;
                br1.close();


                films = new File(args[1]);
                br1 = new BufferedReader(new FileReader(films));
                for (i = 0; i < filmssatirsayisi; i++) {
                    String[] satir = br1.readLine().split("\t");
                    // film ve dizi cesitlerini uygun arraylistlere ekledim
                    switch (satir[0].substring(0, satir[0].length() - 1)) {
                        case "FeatureFilm":
                            directorsArraylist = Metodlar.ActorDuzenleme(satir,4);
                            performersArraylist = Metodlar.ActorDuzenleme(satir,7);
                            writersArraylist = Metodlar.ActorDuzenleme(satir,10);
                            genreArraylist = Metodlar.ActorDuzenleme(satir,8);
                            featureFilms.add(new FeatureFilm(satir[1], satir[2], satir[3], satir[5], satir[6], directorsArraylist, performersArraylist, satir[9], satir[11], writersArraylist, genreArraylist));
                            tumFilmler.add(new Film(satir[1], satir[2], satir[3], satir[5], satir[6]));
                            tumfilmidleri.add(featureFilms.get(featureFilms.size()-1).getFilmId());
                            break;
                        case "ShortFilm":
                            if(Integer.parseInt(satir[5])>40){
                                System.out.println("Error, Short film must be shorter than 40 minutes");
                            }else {
                                directorsArraylist = Metodlar.ActorDuzenleme(satir, 4);
                                performersArraylist = Metodlar.ActorDuzenleme(satir, 7);
                                writersArraylist = Metodlar.ActorDuzenleme(satir, 10);
                                genreArraylist = Metodlar.ActorDuzenleme(satir, 8);
                                shortFilms.add(new ShortFilm(satir[1], satir[2], satir[3], satir[5], satir[6], directorsArraylist, performersArraylist, satir[9], writersArraylist, genreArraylist));
                                tumFilmler.add(new Film(satir[1], satir[2], satir[3], satir[5], satir[6]));
                                tumfilmidleri.add(shortFilms.get(shortFilms.size() - 1).getFilmId());
                            }
                            break;

                        case "Documentary":
                            directorsArraylist = Metodlar.ActorDuzenleme(satir,4);
                            performersArraylist = Metodlar.ActorDuzenleme(satir,7);
                            documantaries.add(new Documantary(satir[1], satir[2], satir[3], satir[5], satir[6], directorsArraylist, performersArraylist, satir[8]));
                            tumFilmler.add(new Film(satir[1], satir[2], satir[3], satir[5], satir[6]));
                            tumfilmidleri.add(documantaries.get(documantaries.size()-1).getFilmId());
                            break;
                        case "TVSeries":
                            directorsArraylist = Metodlar.ActorDuzenleme(satir,4);
                            performersArraylist = Metodlar.ActorDuzenleme(satir,7);
                            writersArraylist = Metodlar.ActorDuzenleme(satir,9);
                            genreArraylist = Metodlar.ActorDuzenleme(satir,8);
                            tvSeries.add(new TvSeries(satir[1], satir[2], satir[3], satir[5], satir[6], directorsArraylist, performersArraylist, satir[10], satir[11], satir[12], satir[13], genreArraylist, writersArraylist));
                            tumFilmler.add(new Film(satir[1], satir[2], satir[3], satir[5], satir[6]));
                            tumfilmidleri.add(tvSeries.get(tvSeries.size()-1).getFilmId());
                            break;
                         } }

                // commandsin kac satir oldugunu hesapladim
                File commands = new File(args[2]);
                BufferedReader br2 = new BufferedReader(new FileReader(commands));
                int commandssatirsayisi = 0;
                while (br2.readLine() != null) commandssatirsayisi++;
                br2.close();


                commands = new File(args[2]);
                br2 = new BufferedReader(new FileReader(commands));
                for(i=0;i<commandssatirsayisi;i++) {
                    String[] satir = br2.readLine().split("\t");
                    boolean userkonrol = false;
                    boolean filmkontrol = false;
                    User user = new User("null", "null", "null", "null");
                    Film film = new Film();
                    String oylananfilmidsi = "berat";
                    boolean kontrol ;
                    if (satir[0].equals("RATE")) {

                        if (Integer.parseInt(satir[3])>10 ||Integer.parseInt(satir[3])<0 ){
                            System.out.println("Error, rate must not be greater than 10 or equal to 0");
                        }else {
                            // alttaki for dongusunde userin olup olmadigini tespit etip boolean deger olan userkontrole atiyorum
                        for (User temp : users) {
                            if (temp.getUniqeId().equals(satir[1])) {
                                userkonrol = true;
                                user = temp;
                                break;
                            }
                        }
                        for (String temp : tumfilmidleri) {
                            for (FeatureFilm temp2 : featureFilms) {
                                if (temp2.getFilmId().equals(temp)) {
                                    film = temp2;
                                    film.setFilmtype("FeatureFilm");
                                }
                            }
                            for (ShortFilm temp2 : shortFilms) {
                                if (temp2.getFilmId().equals(temp)) {
                                    film = temp2;
                                    film.setFilmtype("ShortFilm");
                                }
                            }
                            for (Documantary temp2 : documantaries) {
                                if (temp2.getFilmId().equals(temp)) {
                                    film = temp2;
                                    film.setFilmtype("Documantary");
                                }
                            }
                            for (TvSeries temp2 : tvSeries) {
                                if (temp2.getFilmId().equals(temp)) {
                                    film = temp2;
                                    film.setFilmtype("TvSeries");
                                }
                            }

                            if (temp.equals(satir[2])) {
                                filmkontrol = true;
                                oylananfilmidsi = temp;
                                break;
                            }
                        }
                        if (user.getOylananfilminidsi().size() == 0) {
                            if (filmkontrol && userkonrol) {
                                Metodlar.filmratedsuccesfullyazdir(user,film,satir,output_txt);
                            } else {
                                Metodlar.filmratedcommandfailed(satir,output_txt);
                            }
                        } else if (filmkontrol && userkonrol) {
                            // burda userin filmi daha once oylayip oylamadigini kontrol edip boolean olan kontrol degiskenime atiyorum
                            kontrol = user.getOylananfilminidsi().contains(oylananfilmidsi);
                            if (kontrol) {
                                output_txt.write(satir[0] + "\t" + satir[1] + "\t" + satir[2] + "\t" + satir[3]+"\n");
                                output_txt.write(" "+"\n");
                                output_txt.write("This film was earlier rated"+"\n");
                                output_txt.write(" "+"\n");
                                output_txt.write("-----------------------------------------------------------------------------------------------------"+"\n");

                            } else {
                                Metodlar.filmratedsuccesfullyazdir(user,film,satir,output_txt);
                            }
                        } else {
                            Metodlar.filmratedcommandfailed(satir,output_txt);
                        }
                        }
                    } else if (satir[0].equals("ADD")) {
                        boolean kontrol1 = false;
                        ArrayList<String> yenieklenenidler = new ArrayList<>();
                        int a ;
                        for (a = 0; a < 1; a++) {
                            // alttaki if blogunda eger film var ise hata verip hata mesaji yazdirip komutu durduruyor
                            if (tumfilmidleri.contains(satir[2])) {
                                Metodlar.satiryazdirma(satir,output_txt);
                                Metodlar.filmaddedAndcommandfailed(satir,"fail",output_txt);
                                break;
                            }
                            directorsArraylist = Metodlar.ActorDuzenleme(satir,5);
                            performersArraylist = Metodlar.ActorDuzenleme(satir,8);
                            writersArraylist = Metodlar.ActorDuzenleme(satir,11);
                            yenieklenenidler.addAll(directorsArraylist);
                            yenieklenenidler.addAll(performersArraylist);
                            yenieklenenidler.addAll(writersArraylist);
                            //alttaki for dongusunde director performer ve writerlarin idsine sahip birinin olup olmadigini kontrol ediyorum
                            // eger yoksa kontrol1 false degeri donuyor ve devaminda hata mesaji yazdiriyor
                            for (String temp3 : yenieklenenidler) {
                                if (tumArtistlerinidleri.contains(temp3)) {
                                    kontrol1 = true;
                                } else {
                                    kontrol1 = false;
                                    break;
                                } }
                            if (!(kontrol1)) {
                                Metodlar.satiryazdirma(satir,output_txt);
                                Metodlar.filmaddedAndcommandfailed(satir,"fail",output_txt);
                                break;
                            }
                        }
                        if (kontrol1) {
                            directorsArraylist = Metodlar.ActorDuzenleme(satir,5);
                            performersArraylist = Metodlar.ActorDuzenleme(satir,8);
                            writersArraylist = Metodlar.ActorDuzenleme(satir,11);
                            genreArraylist = Metodlar.ActorDuzenleme(satir,9);
                            featureFilms.add(new FeatureFilm(satir[2], satir[3], satir[4], satir[6], satir[7], directorsArraylist, performersArraylist, satir[10], satir[12], writersArraylist, genreArraylist));
                            tumfilmidleri.add(featureFilms.get(featureFilms.size() - 1).getFilmId());
                            tumFilmler.add(new FeatureFilm(satir[2], satir[3], satir[4], satir[6], satir[7], directorsArraylist, performersArraylist, satir[10], satir[12], writersArraylist, genreArraylist));
                            Metodlar.satiryazdirma(satir,output_txt);
                            Metodlar.filmaddedAndcommandfailed(satir,"add",output_txt);
                        }

                    } else if (satir[0].equals("VIEWFILM")) {
                        String wievfilmturu = null;
                        FeatureFilm featurefilmim = new FeatureFilm();
                        ShortFilm shortfilmim = new ShortFilm();
                        Documantary documantaryim = new Documantary();
                        TvSeries tvseriesim = new TvSeries();
                        ArrayList<String> yazarlar = new ArrayList<>();
                        ArrayList<String> directorler = new ArrayList<>();
                        ArrayList<String> oyuncular = new ArrayList<>();
                        String nameSurname ;

                        // alttaki for dongusunde film turunu buluyorum ve girilen filmin hangisi oldugunu bulup bir degiskene atiyorum
                        for (String temp : tumfilmidleri) {
                            for (FeatureFilm temp2 : featureFilms) {
                                if (temp2.getFilmId().equals(satir[1])) {
                                    featurefilmim = temp2;
                                    featurefilmim.setFilmtype("FeatureFilm");
                                    wievfilmturu = "FeatureFilm";
                                    break;
                                }
                            }
                            for (ShortFilm temp2 : shortFilms) {
                                if (temp2.getFilmId().equals(satir[1])) {
                                    shortfilmim = temp2;
                                    shortfilmim.setFilmtype("ShortFilm");
                                    wievfilmturu = "ShortFilm";
                                    break;
                                }
                            }
                            for (Documantary temp2 : documantaries) {
                                if (temp2.getFilmId().equals(satir[1])) {
                                    documantaryim = temp2;
                                    documantaryim.setFilmtype("Documantary");
                                    wievfilmturu = "Documantary";
                                    break;
                                }
                            }
                            for (TvSeries temp2 : tvSeries) {
                                if (temp2.getFilmId().equals(satir[1])) {
                                    tvseriesim = temp2;
                                    tvseriesim.setFilmtype("TvSeries");
                                    wievfilmturu = "TvSeries";
                                    break;
                                }
                            }
                            break;
                        }
                        // eger o idde bir film yoksa wievfilmturu degiskeni null oluyor ve alttaki else
                        // yapisina giriyor eger buluyosa if yapisindan devam edip filmi yazdiriyor
                        if(wievfilmturu!=null) {
                            switch (wievfilmturu) {
                                case "ShortFilm":
                                    Metodlar.satiryazdirma(satir,output_txt);
                                    output_txt.write(shortfilmim.getFilmTitle() + " (" + shortfilmim.getReleaseDate().substring(shortfilmim.getReleaseDate().length() - 4) + ")"+"\n");
                                    Metodlar.arraylistyazdirma(shortfilmim.getGenre(),output_txt);
                                    for (String temp100 : shortfilmim.getWriters()) {
                                        for (Writer temp101 : writers) {
                                            if (temp101.getUniqeId().equals(temp100)) {
                                                nameSurname = temp101.getName() + " " + temp101.getSurname();
                                                yazarlar.add(nameSurname);
                                            }
                                        }
                                    }
                                    output_txt.write("Writers: ");
                                    Metodlar.arraylistyazdirma(yazarlar,output_txt);
                                    for (String temp100 : shortfilmim.getDirectorsOfFilm()) {
                                        for (Director temp101 : directors) {
                                            if (temp101.getUniqeId().equals(temp100)) {
                                                nameSurname = temp101.getName() + " " + temp101.getSurname();
                                                directorler.add(nameSurname);
                                            }
                                        }
                                    }
                                    output_txt.write("Directors: ");
                                    Metodlar.arraylistyazdirma(directorler,output_txt);
                                    for (String temp100 : shortfilmim.getCast()) {
                                        for (Artist temp101 : tumArtistler) {
                                            if (temp101.getUniqeId().equals(temp100)) {
                                                nameSurname = temp101.getName() + " " + temp101.getSurname();
                                                oyuncular.add(nameSurname);
                                            }
                                        }
                                    }
                                    output_txt.write("Stars: ");
                                    Metodlar.arraylistyazdirma(oyuncular,output_txt);
                                    yuzde = Metodlar.noktayivirgulecevirme(shortfilmim.filmratingortalama());
                                    if (yuzde.equals("0")) {
                                        output_txt.write("Awaiting for votes"+"\n");
                                    } else {
                                        output_txt.write("Ratings: " + yuzde + "/10 from " + shortfilmim.getFilminratingi().size() + " users"+"\n");
                                    }
                                    output_txt.write(" "+"\n");
                                    output_txt.write("-----------------------------------------------------------------------------------------------------"+"\n");
                                    break;
                                case "FeatureFilm":
                                    Metodlar.satiryazdirma(satir,output_txt);
                                    output_txt.write(featurefilmim.getFilmTitle() + " (" + featurefilmim.getReleaseDate().substring(featurefilmim.getReleaseDate().length() - 4) + ")"+"\n");
                                    Metodlar.arraylistyazdirma(featurefilmim.getFilmGenre(),output_txt);
                                    for (String temp100 : featurefilmim.getWritersOfMovie()) {
                                        for (Writer temp101 : writers) {
                                            if (temp101.getUniqeId().equals(temp100)) {
                                                nameSurname = temp101.getName() + " " + temp101.getSurname();
                                                yazarlar.add(nameSurname);
                                            }
                                        }
                                    }
                                    output_txt.write("Writers: ");
                                    Metodlar.arraylistyazdirma(yazarlar,output_txt);
                                    for (String temp100 : featurefilmim.getDirectorsOfFilm()) {
                                        for (Director temp101 : directors) {
                                            if (temp101.getUniqeId().equals(temp100)) {
                                                nameSurname = temp101.getName() + " " + temp101.getSurname();
                                                directorler.add(nameSurname);
                                            }
                                        }
                                    }
                                    output_txt.write("Directors: ");
                                    Metodlar.arraylistyazdirma(directorler,output_txt);
                                    for (String temp100 : featurefilmim.getCast()) {
                                        for (Artist temp101 : tumArtistler) {
                                            if (temp101.getUniqeId().equals(temp100)) {
                                                nameSurname = temp101.getName() + " " + temp101.getSurname();
                                                oyuncular.add(nameSurname);
                                            }
                                        }
                                    }
                                    output_txt.write("Stars: ");
                                    Metodlar.arraylistyazdirma(oyuncular,output_txt);
                                    yuzde = Metodlar.noktayivirgulecevirme(featurefilmim.filmratingortalama());
                                    if (yuzde.equals("0")) {
                                        output_txt.write("Awaiting for votes"+"\n");
                                    } else {
                                        output_txt.write("Ratings: " + yuzde + "/10 from " + featurefilmim.getFilminratingi().size() + " users"+"\n");
                                    }
                                    output_txt.write(" "+"\n");
                                    output_txt.write("-----------------------------------------------------------------------------------------------------"+"\n");
                                    break;
                                case "Documantary":
                                    ArrayList<String> directorler1 = new ArrayList<>();
                                    ArrayList<String> oyuncular1 = new ArrayList<>();
                                    Metodlar.satiryazdirma(satir,output_txt);
                                    output_txt.write(documantaryim.getFilmTitle() + " (" + documantaryim.getReleaseDate().substring(documantaryim.getReleaseDate().length() - 4) + ")"+"\n");
                                    output_txt.write(" "+"\n");
                                    output_txt.write("Directors: ");
                                    for (String temp100 : documantaryim.getDirectorsOfFilm()) {
                                        for (Director temp101 : directors) {
                                            if (temp101.getUniqeId().equals(temp100)) {
                                                nameSurname = temp101.getName() + " " + temp101.getSurname();
                                                directorler1.add(nameSurname);
                                            }
                                        }
                                    }
                                    Metodlar.arraylistyazdirma(directorler1,output_txt);
                                    for (String temp100 : documantaryim.getDirectorsOfFilm()) {
                                        for (Director temp101 : directors) {
                                            if (temp101.getUniqeId().equals(temp100)) {
                                                nameSurname = temp101.getName() + " " + temp101.getSurname();
                                                oyuncular1.add(nameSurname);
                                            }
                                        }
                                    }
                                    output_txt.write("Stars: ");
                                    Metodlar.arraylistyazdirma(oyuncular1,output_txt);
                                    yuzde = Metodlar.noktayivirgulecevirme(documantaryim.filmratingortalama());
                                    if (yuzde.equals("0")) {
                                        output_txt.write("Awaiting for votes"+"\n");
                                    } else {
                                        output_txt.write("Ratings: " + yuzde + "/10 from " + documantaryim.getFilminratingi().size() + " users"+"\n");
                                    }
                                    output_txt.write(" "+"\n");
                                    output_txt.write("-----------------------------------------------------------------------------------------------------"+"\n");
                                    break;
                                case "TvSeries":
                                    ArrayList<String> writerstv = new ArrayList<>();
                                    ArrayList<String> directorstv = new ArrayList<>();
                                    ArrayList<String> starstv = new ArrayList<>();
                                    Metodlar.satiryazdirma(satir,output_txt);
                                    output_txt.write(tvseriesim.getFilmTitle() + " " + "(" + tvseriesim.getStartDate().substring(tvseriesim.getStartDate().length() - 4) + "-" + tvseriesim.getEndDate().substring(tvseriesim.getEndDate().length() - 4, tvseriesim.getStartDate().length()) + ")"+"\n");
                                    output_txt.write(tvseriesim.getNumberOfSeason() + " seasons" + ", " + tvseriesim.getNumberOfEpisode() + " episodes"+"\n");
                                    Metodlar.arraylistyazdirma(tvseriesim.getSerieGenre(),output_txt);
                                    for (String temp100 : tvseriesim.getWriters()) {
                                        for (Writer temp101 : writers) {
                                            if (temp101.getUniqeId().equals(temp100)) {
                                                nameSurname = temp101.getName() + " " + temp101.getSurname();
                                                writerstv.add(nameSurname);
                                            }
                                        }
                                    }
                                    output_txt.write("Writers: ");
                                    Metodlar.arraylistyazdirma(writerstv,output_txt);
                                    for (String temp100 : tvseriesim.getDirectorsOfFilm()) {
                                        for (Director temp101 : directors) {
                                            if (temp101.getUniqeId().equals(temp100)) {
                                                nameSurname = temp101.getName() + " " + temp101.getSurname();
                                                directorstv.add(nameSurname);
                                            }
                                        }
                                    }
                                    output_txt.write("Directors: ");
                                    Metodlar.arraylistyazdirma(directorstv,output_txt);
                                    for (String temp100 : tvseriesim.getCast()) {
                                        for (Artist temp101 : tumArtistler) {
                                            if (temp101.getUniqeId().equals(temp100)) {
                                                nameSurname = temp101.getName() + " " + temp101.getSurname();
                                                starstv.add(nameSurname);
                                            }
                                        }
                                    }
                                    output_txt.write("Stars: ");
                                    Metodlar.arraylistyazdirma(starstv,output_txt);
                                    yuzde = Metodlar.noktayivirgulecevirme(tvseriesim.filmratingortalama());
                                    if (yuzde.equals("0")) {
                                        output_txt.write("Awaiting for votes"+"\n");
                                    } else {
                                        output_txt.write("Ratings: " + yuzde + "/10 from " + tvseriesim.getFilminratingi().size() + " users"+"\n");
                                    }
                                    output_txt.write(" "+"\n");
                                    output_txt.write("-----------------------------------------------------------------------------------------------------"+"\n");
                                    break;
                            }
                        }else{
                            Metodlar.satiryazdirma(satir,output_txt);
                            output_txt.write("Command Failed"+"\n");
                            output_txt.write("Film ID: "+satir[1]+"\n");
                            output_txt.write(" "+"\n");
                            output_txt.write("-----------------------------------------------------------------------------------------------------"+"\n");
                        }
                    } else if (satir[0].equals("LIST") && satir[1].equals("USER")) {
                        Metodlar.satiryazdirma(satir,output_txt);
                        User userim = new User();
                        // girilen user idsinin hangi usere ait oldugunu bulup bir degiskene atioyrum
                        for (User temp106 : users) {
                            if (temp106.getUniqeId().equals(satir[2])) {
                                userim = temp106;
                            }
                        }
                        //eger ismi null ise dogal olarak boyle bir user olmamis oluyor ve hata veriyor
                        if (userim.getName() == null) {
                            output_txt.write("Command Failed"+"\n");
                            output_txt.write("User id: " + satir[2]+"\n");
                            output_txt.write(" "+"\n");
                            output_txt.write("-----------------------------------------------------------------------------------------------------"+"\n");
                        } //alttaki blokta kullanici daha once oy kullanmamissa istenen ciktiyi veriyor
                        else if (userim.getOylananfilminidsi().size() == 0) {
                            output_txt.write("There is not any ratings so far"+"\n");
                            output_txt.write(" "+"\n");
                            output_txt.write("-----------------------------------------------------------------------------------------------------"+"\n");

                        } else {

                            // alttaki yapida kullaicinin oyladigi film sayisini bir degiskene atayip
                            // devaminda for dongusuyle o kadar sayida donerek gerekli seyleri yazdiriyorum
                            int counter103 = userim.getOylananfilminidsi().size();
                            int j ;
                            for (j = 0; j < counter103; j++) {
                                Film arananfilm = new Film();
                                for (String temp : tumfilmidleri) {
                                    for (FeatureFilm temp2 : featureFilms) {
                                        if (temp2.getFilmId().equals(userim.getOylananfilminidsi().get(j))) {
                                            arananfilm = temp2;
                                            arananfilm.setFilmtype("FeatureFilm");
                                            break;
                                        }
                                    }
                                    for (ShortFilm temp2 : shortFilms) {
                                        if (temp2.getFilmId().equals(userim.getOylananfilminidsi().get(j))) {
                                            arananfilm = temp2;
                                            arananfilm.setFilmtype("ShortFilm");
                                            break;
                                        }
                                    }
                                    for (Documantary temp2 : documantaries) {
                                        if (temp2.getFilmId().equals(userim.getOylananfilminidsi().get(j))) {
                                            arananfilm = temp2;
                                            arananfilm.setFilmtype("Documantary");
                                            break;
                                        }
                                    }
                                    for (TvSeries temp2 : tvSeries) {
                                        if (temp2.getFilmId().equals(userim.getOylananfilminidsi().get(j))) {
                                            arananfilm = temp2;
                                            arananfilm.setFilmtype("TvSeries");
                                            break;
                                        } } }
                                output_txt.write(arananfilm.getFilmTitle() + ": " + userim.getFilminoyu().get(j)+"\n");
                            }
                            output_txt.write(" "+"\n");
                            output_txt.write("-----------------------------------------------------------------------------------------------------"+"\n");
                        }




                    } else if (satir[0].equals("EDIT")) {

                        User userim = new User();


                        // verilen oyun uygun degerlerde olup olmadigini kontrol ediyor
                        if (Integer.parseInt(satir[4]) > 10 || Integer.parseInt(satir[4]) < 0) {
                            System.out.println("Error, rate must not be greater than 10 or equal to 0");
                        } else {
                            Metodlar.satiryazdirma(satir, output_txt);
                            // useri idden tespit edip bir degiskene atiyor
                            for (User temp106 : users) {
                                if (temp106.getUniqeId().equals(satir[2])) {
                                    userim = temp106;
                                }
                            }


                            // asagidaki kod blogu filmin hangi tur film oldugunu bulup arananfilm degiskenine atiyor
                            Film arananfilm = new Film();
                            for (String temp : tumfilmidleri) {
                                for (FeatureFilm temp2 : featureFilms) {
                                    if (temp2.getFilmId().equals(satir[3])) {
                                        arananfilm = temp2;
                                        arananfilm.setFilmtype("FeatureFilm");
                                        break;
                                    }
                                }
                                for (ShortFilm temp2 : shortFilms) {
                                    if (temp2.getFilmId().equals(satir[3])) {
                                        arananfilm = temp2;
                                        arananfilm.setFilmtype("ShortFilm");
                                        break;
                                    }
                                }
                                for (Documantary temp2 : documantaries) {
                                    if (temp2.getFilmId().equals(satir[3])) {
                                        arananfilm = temp2;
                                        arananfilm.setFilmtype("Documantary");
                                        break;
                                    }
                                }
                                for (TvSeries temp2 : tvSeries) {
                                    if (temp2.getFilmId().equals(satir[3])) {
                                        arananfilm = temp2;
                                        arananfilm.setFilmtype("TvSeries");
                                        break;
                                    }
                                }
                            }

                            // eger arananfilm yoksa ismi dogal olarak null oluyor null oldugu icin de hata donduruyorum
                            if (userim.getName() == null || arananfilm.getFilmId() == null || !(userim.getOylananfilminidsi().contains(satir[3]))) {
                                output_txt.write("Command Failed." + "\n");
                                output_txt.write("User Id: " + satir[2] + "\n");
                                output_txt.write("Film Id: " + satir[3] + "\n");
                            }

                            else {


                                // oylanan filmin hangi indexte oldugunu bulup kullanicinin verdigi oylar listesinden de
                                // ayni indexteki oyu degistiriyor
                                int j;
                                String eski_oy="null";
                                for (User tempu : users) {
                                    if (userim.getUniqeId().equals(tempu.getUniqeId())) {
                                        for (j = 0; j < tempu.getOylananfilminidsi().size(); j++) {
                                            if (tempu.getOylananfilminidsi().get(j).equals(satir[3])) {
                                                eski_oy=tempu.getFilminoyu().get(j);
                                                tempu.oyudegis(j, satir[4]);
                                            }
                                        }
                                    }
                                }

                                // bu asamada kalici olmasi icin film objesinin icindeki oyu degistiriyor
                                switch (arananfilm.getFilmtype()) {
                                    case "FeatureFilm":
                                        for (FeatureFilm tempf : featureFilms) {
                                            if (tempf.getFilmId().equals(satir[3])) {
                                                for (j = 0; j < tempf.getFilminratingi().size(); j++) {
                                                    if (tempf.getFilminratingi().get(j).equals(eski_oy)) {
                                                        tempf.filmratingduzenle(j, satir[4]);
                                                    }
                                                }
                                            }
                                        }
                                        break;
                                    case "ShortFilm":
                                        for (ShortFilm tempf : shortFilms) {
                                            if (tempf.getFilmId().equals(satir[3])) {
                                                for (j = 0; j < tempf.getFilminratingi().size(); j++) {
                                                    if (tempf.getFilminratingi().get(j).equals(eski_oy)) {
                                                        tempf.filmratingduzenle(j, satir[4]);
                                                    }
                                                }
                                            }
                                        }
                                        break;
                                    case "Documantary":
                                        for (Documantary tempf : documantaries) {
                                            if (tempf.getFilmId().equals(satir[3])) {
                                                for (j = 0; j < tempf.getFilminratingi().size(); j++) {
                                                    if (tempf.getFilminratingi().get(j).equals(eski_oy)) {
                                                        tempf.filmratingduzenle(j, satir[4]);
                                                    }
                                                }
                                            }
                                        }
                                        break;
                                    case "TvSeries":
                                        for (TvSeries tempf : tvSeries) {
                                            if (tempf.getFilmId().equals(satir[3])) {
                                                for (j = 0; j < tempf.getFilminratingi().size(); j++) {
                                                    if (tempf.getFilminratingi().get(j).equals(eski_oy)) {
                                                        tempf.filmratingduzenle(j, satir[4]);
                                                    }
                                                }
                                            }
                                        }
                                        break;
                                }
                                output_txt.write("New ratings done successfully" + "\n");
                                output_txt.write("Film Title: " + arananfilm.getFilmTitle() + "\n");
                                output_txt.write("Your rating: " + satir[4] + "\n");
                            }
                            output_txt.write(" " + "\n");
                            output_txt.write("-----------------------------------------------------------------------------------------------------" + "\n");
                        }
                    }
                        else if (satir[0].equals("REMOVE")){
                        Metodlar.satiryazdirma(satir,output_txt);
                        User userim = new User();

                        //userin olup olmadigini kontrol ediyor
                        for (User temp106 : users) {
                            if (temp106.getUniqeId().equals(satir[2])) {
                                userim = temp106;
                            } }

                        // alltaki kod blogunda iliskili filmi tespit ediyor


                        Film arananfilm = new Film();
                        for (String temp : tumfilmidleri) {
                            for (FeatureFilm temp2 : featureFilms) {
                                if (temp2.getFilmId().equals(satir[3])) {
                                    arananfilm = temp2;
                                    arananfilm.setFilmtype("FeatureFilm");
                                    break;
                                } }
                            for (ShortFilm temp2 : shortFilms) {
                                if (temp2.getFilmId().equals(satir[3])) {
                                    arananfilm = temp2;
                                    arananfilm.setFilmtype("ShortFilm");
                                    break;
                                } }
                            for (Documantary temp2 : documantaries) {
                                if (temp2.getFilmId().equals(satir[3])) {
                                    arananfilm = temp2;
                                    arananfilm.setFilmtype("Documantary");
                                    break;
                                } }
                            for (TvSeries temp2 : tvSeries) {
                                if (temp2.getFilmId().equals(satir[3])) {
                                    arananfilm = temp2;
                                    arananfilm.setFilmtype("TvSeries");
                                    break;
                                } } }

                        // eger yoksa hata mesaji
                        if (userim.getName()==null || arananfilm.getFilmId()==null || !(userim.getOylananfilminidsi().contains(satir[3]) )){
                            output_txt.write("Command Failed."+"\n");
                            output_txt.write("User Id: "+satir[2]+"\n");
                            output_txt.write("Film Id: "+satir[3]+"\n");
                        }else{
                            // eger varsa user objesini cekip o objenin verdigi oyu kaldiriyor
                            String verilenoy = null;
                            int j;
                            for (User tempu:users){
                                if (userim.getUniqeId().equals(tempu.getUniqeId())){
                                    for(j=0;j<tempu.getOylananfilminidsi().size();j++){
                                        if (tempu.getOylananfilminidsi().get(j).equals(satir[3])){
                                            verilenoy=tempu.getFilminoyu().get(j);
                                            tempu.removeVote(j);
                                        } } } }

                            // ayni sekilde film objesinden de verdigimiz oyu kaldiriyoruz
                            if (arananfilm.getFilmtype().equals("FeatureFilm")){
                                for(FeatureFilm tempf: featureFilms){

                                    if(tempf.getFilmId().equals(satir[3])){
                                        for(j=0;j<tempf.getFilminratingi().size();j++){
                                            if(tempf.getFilminratingi().get(j).equals(verilenoy)){
                                                tempf.filmratingikaldir(j);
                                            } } } }
                            }else if (arananfilm.getFilmtype().equals("ShortFilm")){
                                for(ShortFilm tempf: shortFilms) {
                                    if (tempf.getFilmId().equals(satir[3])) {
                                        for (j = 0; j < tempf.getFilminratingi().size(); j++) {
                                            if (tempf.getFilminratingi().get(j).equals(verilenoy)) {
                                                tempf.filmratingikaldir(j);
                                            } } } }
                            }else if (arananfilm.getFilmtype().equals("Documantary")){
                                for(Documantary tempf: documantaries){
                                    if(tempf.getFilmId().equals(satir[3])){
                                        for(j=0;j<tempf.getFilminratingi().size();j++){
                                            if(tempf.getFilminratingi().get(j).equals(verilenoy)){
                                                tempf.filmratingikaldir(j);
                                            } } } }
                            }else if (arananfilm.getFilmtype().equals("TvSeries")){
                                for(TvSeries tempf: tvSeries){
                                    if(tempf.getFilmId().equals(satir[3])){
                                        for(j=0;j<tempf.getFilminratingi().size();j++){
                                            if(tempf.getFilminratingi().get(j).equals(verilenoy)){
                                                tempf.filmratingikaldir(j);
                                            } } } } }
                            output_txt.write("Your film rating was removed successfully"+"\n");
                            output_txt.write("Film Title: "+arananfilm.getFilmTitle()+"\n");
                        }
                        output_txt.write(" "+"\n");
                        output_txt.write("-----------------------------------------------------------------------------------------------------"+"\n");
                    }else if (satir[0].equals("LIST")&& satir[1].equals("FILM")){
                        Metodlar.satiryazdirma(satir,output_txt);
                        int seriescounter=0;
                        // tum seriesleri yazdiriyor eger yoksa no result
                        for(TvSeries seriestemp: tvSeries){
                            output_txt.write(seriestemp.getFilmTitle()+" "+"("+seriestemp.getStartDate().substring(seriestemp.getStartDate().length()-4)+"-"+seriestemp.getEndDate().substring(seriestemp.getEndDate().length()-4,seriestemp.getStartDate().length())+")"+"\n");
                            output_txt.write(seriestemp.getNumberOfSeason()+" seasons"+", "+seriestemp.getNumberOfEpisode()+" episodes"+"\n");
                            output_txt.write(" "+"\n");
                            seriescounter++;
                        }
                        if(seriescounter==0){
                            output_txt.write("No result"+"\n");
                            output_txt.write(" "+"\n");
                        }
                        output_txt.write("-----------------------------------------------------------------------------------------------------"+"\n");
                    } else if (satir[1].equals("FILMS")&& satir[2].equals("BY")){

                            //alttaki if blogunda countrye gore filmleri yazdiriyor
                            if(satir[3].equals("COUNTRY")){
                            Metodlar.satiryazdirma(satir,output_txt);
                            int counterfilms=0;
                            for (Film temp :tumFilmler ){
                                if(temp.getCountry().equals(satir[4])){
                                    output_txt.write("Film title: "+temp.getFilmTitle()+"\n");
                                    output_txt.write(temp.getRuntime()+" min"+"\n");
                                    output_txt.write("Language: "+temp.getLanguage()+"\n");
                                    output_txt.write(" "+"\n");
                                    counterfilms++;
                                } }
                            if (counterfilms==0){
                                output_txt.write("No result"+"\n");
                                output_txt.write(" "+"\n");
                            }
                            output_txt.write("-----------------------------------------------------------------------------------------------------"+"\n");
                        }
                            //alttaki else blogunda rateinge gore filmleri siraliyor
                            else{
                            Metodlar.satiryazdirma(satir,output_txt);

                            // array listte oylari siraladim sonra siraya gore feature filmlere verilen oylar uzerinde
                                // gezip esitlik durumunda sirayla yazdirdim
                            ArrayList<Double> featurefilmssortedint=new ArrayList<>();
                            ArrayList<FeatureFilm> kullanilanlar= new ArrayList<>();
                            for (FeatureFilm temp:featureFilms){
                                featurefilmssortedint.add(temp.filmratingortalama());
                            }
                            featurefilmssortedint.sort(Collections.reverseOrder());
                            output_txt.write("FeatureFilm:"+"\n");
                            for (Double temp:featurefilmssortedint){
                                for(FeatureFilm temp1:featureFilms){
                                    if(temp1.filmratingortalama()==temp){
                                        if(!kullanilanlar.contains(temp1)){
                                            output_txt.write(temp1.getFilmTitle() + " (" + temp1.getReleaseDate().substring(temp1.getReleaseDate().length() - 4) + ")");
                                            yuzde= Metodlar.noktayivirgulecevirme(temp);
                                            output_txt.write(" Ratings "+yuzde+"/10 from "+temp1.getFilminratingi().size()+" users"+"\n");
                                            kullanilanlar.add(temp1);
                                        } } } }
                            output_txt.write(" "+"\n");

                            // tum film turleri icin feature filme yaptigim mantikla yaptim
                            ArrayList<Double> shortfilmint=new ArrayList<>();
                            ArrayList<ShortFilm> shortfilmkullanilanlar= new ArrayList<>();
                            for (ShortFilm temp:shortFilms){
                                shortfilmint.add(temp.filmratingortalama());
                            }
                            shortfilmint.sort(Collections.reverseOrder());
                            output_txt.write("ShortFilm:"+"\n");
                            for (Double temp:shortfilmint){
                                for(ShortFilm temp1:shortFilms){
                                    if(temp1.filmratingortalama()==temp){
                                        if(!shortfilmkullanilanlar.contains(temp1)){
                                            output_txt.write(temp1.getFilmTitle() + " (" + temp1.getReleaseDate().substring(temp1.getReleaseDate().length() - 4) + ")");
                                            yuzde= Metodlar.noktayivirgulecevirme(temp);
                                            output_txt.write(" Ratings "+yuzde+"/10 from "+temp1.getFilminratingi().size()+" users"+"\n");
                                            shortfilmkullanilanlar.add(temp1);
                                        } } } }
                            output_txt.write(" "+"\n");
                            ArrayList<Double> documantaryint=new ArrayList<>();
                            ArrayList<Documantary> documantarykullanilanlar= new ArrayList<>();
                            for (Documantary temp:documantaries){
                                documantaryint.add(temp.filmratingortalama());
                            }
                            documantaryint.sort(Collections.reverseOrder());
                            output_txt.write("Documentary:"+"\n");
                            for (Double temp:documantaryint){
                                for(Documantary temp1:documantaries){
                                    if(temp1.filmratingortalama()==temp){
                                        if(!documantarykullanilanlar.contains(temp1)){
                                            output_txt.write(temp1.getFilmTitle() + " (" + temp1.getReleaseDate().substring(temp1.getReleaseDate().length() - 4) + ")");
                                            yuzde= Metodlar.noktayivirgulecevirme(temp);
                                            output_txt.write(" Ratings "+yuzde+"/10 from "+temp1.getFilminratingi().size()+" users"+"\n");
                                            documantarykullanilanlar.add(temp1);
                                        } } } }
                            output_txt.write(" "+"\n");
                            ArrayList<Double> tvseriesint=new ArrayList<>();
                            ArrayList<TvSeries> tvserieskullanilanlar= new ArrayList<>();
                            for (TvSeries temp:tvSeries){
                                tvseriesint.add(temp.filmratingortalama());
                            }
                            tvseriesint.sort(Collections.reverseOrder());
                            output_txt.write("TvSeries:"+"\n");
                            for (Double temp:tvseriesint){
                                for(TvSeries temp1:tvSeries){
                                    if(temp1.filmratingortalama()==temp){
                                        if(!tvserieskullanilanlar.contains(temp1)){
                                            output_txt.write(temp1.getFilmTitle()+" "+"("+temp1.getStartDate().substring(temp1.getStartDate().length()-4)+"-"+temp1.getEndDate().substring(temp1.getEndDate().length()-4,temp1.getStartDate().length())+")");
                                            yuzde= Metodlar.noktayivirgulecevirme(temp);
                                            output_txt.write(" Ratings "+yuzde+"/10 from "+temp1.getFilminratingi().size()+" users"+"\n");
                                            tvserieskullanilanlar.add(temp1);
                                        } } } }
                            output_txt.write(" "+"\n");
                            output_txt.write("-----------------------------------------------------------------------------------------------------"+"\n");
                        }
                    } else if (satir[1].equals("FEATUREFILMS")&&satir[2].equals("BEFORE")){
                        Metodlar.satiryazdirma(satir,output_txt);

                        // belli bir yildan onceki feature filmleri yazdirdim
                        int filmcounter1=0;
                        for (FeatureFilm temp11111:featureFilms){
                            if(Integer.parseInt(temp11111.getReleaseDate().substring(temp11111.getReleaseDate().length()-4))<Integer.parseInt(satir[3])){
                                output_txt.write(temp11111.getFilmTitle() + " (" + temp11111.getReleaseDate().substring(temp11111.getReleaseDate().length() - 4) + ")"+"\n");
                                output_txt.write(temp11111.getRuntime()+" min"+"\n");
                                output_txt.write("Language: "+temp11111.getLanguage()+"\n");
                                output_txt.write(" "+"\n");
                                filmcounter1++;
                            } }
                        if(filmcounter1==0){
                            output_txt.write("No result"+"\n");
                            output_txt.write(" "+"\n");
                        }
                        output_txt.write("-----------------------------------------------------------------------------------------------------"+"\n");
                    }else if (satir[1].equals("FEATUREFILMS")&&satir[2].equals("AFTER")){
                        Metodlar.satiryazdirma(satir,output_txt);


                        // belli bir yildan sonraki feature filmleri siraliyor
                        int filmcounter=0;
                        for (FeatureFilm temp11111:featureFilms){
                            if(Integer.parseInt(temp11111.getReleaseDate().substring(temp11111.getReleaseDate().length()-4))>=Integer.parseInt(satir[3])){
                                output_txt.write("Film title: "+temp11111.getFilmTitle() + " (" + temp11111.getReleaseDate().substring(temp11111.getReleaseDate().length() - 4) + ")"+"\n");
                                output_txt.write(temp11111.getRuntime()+" min"+"\n");
                                output_txt.write("Language: "+temp11111.getLanguage()+"\n");
                                output_txt.write(" "+"\n");
                                filmcounter++;
                            } }
                        if(filmcounter==0){
                            output_txt.write("No result"+"\n");
                            output_txt.write(" "+"\n");
                        }
                        output_txt.write("-----------------------------------------------------------------------------------------------------"+"\n");
                    }
                    else if (satir[1].equals("ARTISTS")){
                        Metodlar.satiryazdirma(satir,output_txt);
                        // burda olusturdugum arraylistlerin ismi turkle basliyor fakat bunu bu komut geldiginde olusturup
                        ArrayList<Director> turkdirector=new ArrayList<>();
                        ArrayList<Writer> turkwriter=new ArrayList<>();
                        ArrayList<Actor> turkactor=new ArrayList<>();
                        ArrayList<ChildActor> turkchildactor=new ArrayList<>();
                        ArrayList<StuntPerformer> turkstuntperformer=new ArrayList<>();
                        for(Director temp1111:directors){
                            if(temp1111.getCountry().equals(satir[3])){
                                turkdirector.add(temp1111);
                            } }
                        for(Writer temp1111:writers){
                            if(temp1111.getCountry().equals(satir[3])){
                                turkwriter.add(temp1111);
                            } }
                        for(Actor temp1111:actors){
                            if(temp1111.getCountry().equals(satir[3])){
                                turkactor.add(temp1111);
                            } }
                        for(ChildActor temp1111:childActors){
                            if(temp1111.getCountry().equals(satir[3])){
                                turkchildactor.add(temp1111);
                            } }
                        for(StuntPerformer temp1111:stuntPerformers){
                            if(temp1111.getCountry().equals(satir[3])){
                                turkstuntperformer.add(temp1111);
                            } }

                        // assagidaki kod blogunda  yukarida tespit ettiklerini sirayla yazdiriyor eger yoksa ilk if bloguna girip
                        // no result yazdiriyor
                        output_txt.write("Directors:"+"\n");
                        if (turkdirector.size()==0){
                            output_txt.write("No result"+"\n");
                            output_txt.write(" "+"\n");
                        }else{
                            for(Director temp1111: turkdirector){
                                output_txt.write(temp1111.getName()+" "+temp1111.getSurname()+" "+temp1111.getAgent()+"\n");
                            }
                            output_txt.write(" "+"\n");
                        }
                        output_txt.write("Writers:"+"\n");
                        if (turkwriter.size()==0){
                           output_txt.write("No result"+"\n");
                           output_txt.write(" "+"\n");
                        }else{
                            for(Writer temp1111: turkwriter){
                                output_txt.write(temp1111.getName()+" "+temp1111.getSurname()+" "+temp1111.getWritingType()+"\n");
                            }
                            output_txt.write(" "+"\n");
                        }
                        output_txt.write("Actors:"+"\n");
                        if (turkactor.size()==0){
                            output_txt.write("No result"+"\n");
                            output_txt.write(" "+"\n");
                        }else{
                            for(Actor temp1111: turkactor){
                                output_txt.write(temp1111.getName()+" "+temp1111.getSurname()+" "+temp1111.getHeight()+" cm"+"\n");
                            }
                            output_txt.write(" "+"\n");
                        }
                        output_txt.write("ChildActors:"+"\n");
                        if (turkchildactor.size()==0){
                            output_txt.write("No result"+"\n");
                            output_txt.write(" "+"\n");
                        }else{
                            for(ChildActor temp1111: turkchildactor){
                                output_txt.write(temp1111.getName()+" "+temp1111.getSurname()+" "+temp1111.getAge()+"\n");
                            }
                            output_txt.write(" "+"\n");
                        }
                        output_txt.write("StuntPerformers:"+"\n");
                        if (turkstuntperformer.size()==0){
                            output_txt.write("No result"+"\n");
                            output_txt.write(" "+"\n");
                        }else{
                            for(StuntPerformer temp1111: turkstuntperformer){
                                output_txt.write(temp1111.getName()+" "+temp1111.getSurname()+" "+temp1111.getHeight()+" cm"+"\n");
                            }
                            output_txt.write(" "+"\n");
                        }
                        output_txt.write("-----------------------------------------------------------------------------------------------------"+"\n");
                    } }output_txt.close();
            }catch(Exception e) {
                e.printStackTrace();
            } }
}
