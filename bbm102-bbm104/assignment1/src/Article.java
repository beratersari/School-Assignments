public class Article {
    private String paperid;
    private String artname;
    private String publisherName;
    private String publishYear;

    public String getAllarticle(){
        return "+"+paperid+"\t"+ artname+"\t"+publisherName+"\t"+publishYear;
    }

    public String getPaperid() {
        return paperid;
    }

    public void setPaperid(String paperid) {
        this.paperid = paperid;
    }

    public String getArtname() {
        return artname;
    }

    public void setArtname(String artname) {
        this.artname = artname;
    }

    public String getPublisherName() {
        return publisherName;
    }

    public void setPublisherName(String publisherName) {
        this.publisherName = publisherName;
    }

    public String getPublishYear() {
        return publishYear;
    }

    public void setPublishYear(String publishYear) {
        this.publishYear = publishYear;
    }

    public Article(String paperid, String artname, String publisherName, String publishYear) {
        this.paperid = paperid;
        this.artname = artname;
        this.publisherName = publisherName;
        this.publishYear = publishYear;
    }
}
