package ro.emanuel.events.pojo;

public class Volunteer {
    private int id;
    private String name;
    private String contactInfo;
    private int eventId;

    public Volunteer() {
    }

    public Volunteer(int id, String name, String contactInfo, int eventId) {
        this.id = id;
        this.name = name;
        this.contactInfo = contactInfo;
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

    public String getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(String contactInfo) {
        this.contactInfo = contactInfo;
    }

    public int getEventId() {
        return eventId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }
}
