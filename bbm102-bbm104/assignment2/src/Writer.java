public class Writer extends Artist{
    private String writingType;

    public String getWritingType() {
        return writingType;
    }

    public Writer(String name, String surname, String country, String uniqeId, String writingType) {
        super(name, surname, country, uniqeId);
        this.writingType = writingType;
    }
}
