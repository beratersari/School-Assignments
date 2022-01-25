public class Person {
    private String name;
    private String surname;
    private String country;
    private String uniqeId;

    public Person() {

    }
    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getCountry() {
        return country;
    }

    public String getUniqeId() {
        return uniqeId;
    }


    public Person(String name, String surname, String country, String uniqeId) {
        this.name = name;
        this.surname = surname;
        this.country = country;
        this.uniqeId = uniqeId;
    }

}
