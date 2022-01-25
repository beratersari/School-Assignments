public class Director extends Artist{
    private String agent;

    public String getAgent() {
        return agent;
    }

    public Director(String name, String surname, String country, String uniqeId, String agent) {
        super(name, surname, country, uniqeId);
        this.agent = agent;
    }
}
