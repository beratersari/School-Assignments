public class Tokens {
    private String id;
    private String name;
    private int numberofItem;

    public Tokens(String id, String name, int numberofItem) {
        this.id = id;
        this.name = name;
        this.numberofItem = numberofItem;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getNumberofItem() {
        return numberofItem;
    }
}
