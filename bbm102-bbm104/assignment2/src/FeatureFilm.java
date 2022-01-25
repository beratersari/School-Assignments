import java.util.ArrayList;

public class FeatureFilm extends Film{
    private String releaseDate;
    private String budget;
    private ArrayList<String> writersOfMovie;
    private ArrayList<String> filmGenre;

    public String getReleaseDate() {
        return releaseDate;
    }


    public ArrayList<String> getWritersOfMovie() {
        return writersOfMovie;
    }

    public ArrayList<String> getFilmGenre() {
        return filmGenre;
    }

    public FeatureFilm(String filmId, String filmTitle, String language, String runtime, String country, ArrayList<String> directorsOfFilm, ArrayList<String> cast, String releaseDate, String budget, ArrayList<String> writersOfMovie, ArrayList<String> filmGenre) {
        super(filmId, filmTitle, language, runtime, country, directorsOfFilm, cast);
        this.releaseDate = releaseDate;
        this.budget = budget;
        this.writersOfMovie = writersOfMovie;
        this.filmGenre = filmGenre;
    }

    public FeatureFilm() {

    }
}
