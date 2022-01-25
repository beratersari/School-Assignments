public class ChildActor extends Performer{
    private String age;

    public String getAge() {
        return age;
    }

    public ChildActor(String name, String surname, String country, String uniqeId, String age) {
        super(name, surname, country, uniqeId);
        this.age = age;
    }
}
