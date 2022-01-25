import java.util.ArrayList;

public class TvSeries extends Film{
    private String startDate;
    private String endDate;
    private String numberOfSeason;
    private String numberOfEpisode;
    private ArrayList<String> serieGenre;
    private ArrayList<String> writers;


    public TvSeries(String filmId, String filmTitle, String language, String runtime, String country, ArrayList<String> directorsOfFilm, ArrayList<String> cast, String startDate, String endDate, String numberOfSeason, String numberOfEpisode, ArrayList<String> serieGenre, ArrayList<String> writers) {
        super(filmId, filmTitle, language, runtime, country, directorsOfFilm, cast);
        this.startDate = startDate;
        this.endDate = endDate;
        this.numberOfSeason = numberOfSeason;
        this.numberOfEpisode = numberOfEpisode;
        this.serieGenre = serieGenre;
        this.writers = writers;
    }

    public TvSeries() {

    }

    public String getStartDate() {
        return startDate;
    }


    public String getEndDate() {
        return endDate;
    }


    public String getNumberOfSeason() {
        return numberOfSeason;
    }


    public String getNumberOfEpisode() {
        return numberOfEpisode;
    }


    public ArrayList<String> getSerieGenre() {
        return serieGenre;
    }


    public ArrayList<String> getWriters() {
        return writers;
    }

}
