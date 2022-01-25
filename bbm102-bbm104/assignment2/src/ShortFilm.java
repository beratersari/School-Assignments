import java.util.ArrayList;

public class ShortFilm extends Film{
    private String releaseDate;
    private ArrayList<String> writers;
    private ArrayList<String> genre;

    public String getReleaseDate() {
        return releaseDate;
    }

    public ArrayList<String> getWriters() {
        return writers;
    }

    public ArrayList<String> getGenre() {
        return genre;
    }

// film suresi 40 dakikadan fazla olmalı

    public ShortFilm(String filmId, String filmTitle, String language, String runtime, String country, ArrayList<String> directorsOfFilm, ArrayList<String> cast, String releaseDate, ArrayList<String> writers, ArrayList<String> genre) {
        super(filmId, filmTitle, language, runtime, country, directorsOfFilm, cast);
        this.releaseDate = releaseDate;
        this.writers = writers;
        this.genre = genre;
    }

    public ShortFilm() {

    }
}
