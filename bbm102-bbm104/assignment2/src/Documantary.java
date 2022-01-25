import java.util.ArrayList;

public class Documantary extends Film{
    private String releaseDate;

    public String getReleaseDate() {
        return releaseDate;
    }

    public Documantary(String filmId, String filmTitle, String language, String runtime, String country, ArrayList<String> directorsOfFilm, ArrayList<String> cast, String releaseDate) {
        super(filmId, filmTitle, language, runtime, country, directorsOfFilm, cast);
        this.releaseDate = releaseDate;
    }

    public Documantary() {

    }
}
