package ro.emanuel.events.pojo;

public class Sponsor {
    private int id;
    private String name;
    private String amount;
    private int eventId;

    
    public Sponsor() {}

    public Sponsor(int id, String name, String amount, int eventId) {
        this.id = id;
        this.name = name;
        this.amount = amount;
        this.eventId = eventId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public int getEventId() {
        return eventId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }
}
