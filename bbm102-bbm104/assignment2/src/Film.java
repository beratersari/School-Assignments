import java.util.ArrayList;

public class Film {
    private String filmId;
    private String filmTitle;
    private String language;
    private String runtime;
    private String country;

    public Film(String s, String s1, String s2, String s3, String s4) {
        filmId=s;
        filmTitle=s1;
        language=s2;
        runtime=s3;
        country=s4;
    }


    public ArrayList<String> getFilminratingi() {
        return filminratingi;
    }


    private ArrayList<String> directorsOfFilm=new ArrayList<>();
    private ArrayList<String> cast=new ArrayList<>();
    private String filmtype;
    private ArrayList<String> filminratingi= new ArrayList<>();
    // hangi filme oy kullanildiysa arrayliste o oyu ekliyorum
    public void filmrating(String rating){
        filminratingi.add(rating);
    }
    // arraylist icindeki oylarin ortalamasini buluyor
    public double filmratingortalama(){
        if (filminratingi.size()==0){
            return 0.0;
        }
        double toplam=0;
        double counter101=-1;
        double ortalama = 0;
        for(String temp105: filminratingi){
            counter101++;
            toplam=toplam+Integer.parseInt(temp105);
            if(filminratingi.size()-1==counter101){
                ortalama=toplam/(counter101+1);
            }
        }
        return ortalama;
    }
    // bu fonksiyonu edit rate komutunde kullanip oyun indexini bulup sonra o indexteki oyu yeni oyla degistiriyorum
    public void filmratingduzenle(int index, String yenioy){
        filminratingi.set(index,yenioy);
    }
    public void filmratingikaldir(int index){
        filminratingi.remove(index);
    }
    public void setFilmtype(String filmtype) {
        this.filmtype = filmtype;
    }
    public String getFilmtype() {
        return filmtype;
    }
    public Film(String filmId, String filmTitle, String language, String runtime, String country, ArrayList<String> directorsOfFilm, ArrayList<String> cast) {
        this.filmId = filmId;
        this.filmTitle = filmTitle;
        this.language = language;
        this.runtime = runtime;
        this.country = country;
        this.directorsOfFilm = directorsOfFilm;
        this.cast = cast;
    }
    public Film() { }
    public String getFilmId() {
        return filmId;
    }
    public String getFilmTitle() {
        return filmTitle;
    }
    public String getLanguage() {
        return language;
    }
    public String getRuntime() {
        return runtime;
    }
    public String getCountry() {
        return country;
    }
    public ArrayList<String> getDirectorsOfFilm() {
        return directorsOfFilm;
    }
    public ArrayList<String> getCast() {
        return cast;
    }

}
