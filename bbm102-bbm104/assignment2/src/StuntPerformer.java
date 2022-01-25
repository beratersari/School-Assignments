import java.util.ArrayList;

public class StuntPerformer extends Performer{
    private String height;
    private ArrayList<String> realActorsId;

    public String getHeight() {
        return height;
    }

    public StuntPerformer(String name, String surname, String country, String uniqeId, String height, ArrayList<String> realActorsId) {
        super(name, surname, country, uniqeId);
        this.height = height;
        this.realActorsId = realActorsId;
    }
}
