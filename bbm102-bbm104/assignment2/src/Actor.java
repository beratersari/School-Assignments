public class Actor extends Performer{
    private String height;

    public String getHeight() {
        return height;
    }

    public Actor(String name, String surname, String country, String uniqeId, String height) {
        super(name, surname, country, uniqeId);
        this.height = height;
    }
}
