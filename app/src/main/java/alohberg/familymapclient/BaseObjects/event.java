package alohberg.familymapclient.BaseObjects;

import java.util.UUID;

/**Class to represent event objects from the event table
 *
 * */
public class event {
    /**
     * Unique String representing the ID of the event (primary key in DB) REQUIRED
     */
    private String eventID;

    /**
     * The owner of the current event REQUIRED
     */
    private String descendant;

    /**
     * Unique string, ID of the current owner of the event REQUIRED
     */
    private String personID;

    /**
     * Exact latitude of the event's occurrence REQUIRED
     */
    private String latitude;

    /**
     * Exact longitude of the event's occurrence REQUIRED
     */
    private String longitude;

    /**
     * Country where the event occurred (as a string) REQUIRED
     */
    private String country;

    /**
     * City where the event occurred REQUIRED
     */
    private String city;

    /**
     * Type of event, IE: Baptism, Birth, Death.  REQUIRED
     */
    private String eventType;

    /**
     * Year the event occured.  REQUIRED
     */
    private int year;


    /**This is the main constructor for the event class
     *
     * @param eventID   this is the unique identifier for each event
     * @param descendant  who the event belongs to
     * @param personID   the unique person id of the event
     * @param latitude   latitude for where the event occurred
     * @param longitude  longitude for where the event occurred
     * @param country   country for where the event occurred
     * @param city   city where the event occurred
     * @param eventType  type of event that it was, like birth, death, baptism
     * @param year   year the event occurred
     */
    public event(String eventID, String descendant, String personID, String latitude, String longitude, String country, String city, String eventType, int year) {
        this.eventID = eventID;
        this.descendant = descendant;
        this.personID = personID;
        this.latitude = latitude;
        this.longitude = longitude;
        this.country = country;
        this.city = city;
        this.eventType = eventType;
        this.year = year;
    }

    public event(String descendant, String personID, String latitude, String longitude, String country, String city, String eventType, int year) {
        this.eventID = UUID.randomUUID().toString();
        this.descendant = descendant;
        this.personID = personID;
        this.latitude = latitude;
        this.longitude = longitude;
        this.country = country;
        this.city = city;
        this.eventType = eventType;
        this.year = year;
    }

    public void setEventID(String eventID) {
        this.eventID = eventID;
    }

    public void setDescendant(String descendant) {
        this.descendant = descendant;
    }

    public void setPersonID(String personID) {
        this.personID = personID;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getEventID() {
        return eventID;
    }

    public String getDescendant() {
        return descendant;
    }

    public String getPersonID() {
        return personID;
    }

    public String getLatitude() {
        return latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public String getCountry() {
        return country;
    }

    public String getCity() {
        return city;
    }

    public String getEventType() {
        return eventType;
    }

    public int getYear() {
        return year;
    }

    public event() {
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }
        if(this == o){
            return true;
        }
        if (o instanceof event) {
            event oEvent = (event) o;
            if (oEvent.getEventID().equals(getEventID()) &&
                    oEvent.getDescendant().equals(getDescendant()) &&
                    oEvent.getPersonID().equals(getPersonID()) &&
                    oEvent.getLatitude().equals((getLatitude())) &&
                    oEvent.getLongitude().equals((getLongitude())) &&
                    oEvent.getCountry().equals(getCountry()) &&
                    oEvent.getCity().equals(getCity()) &&
                    oEvent.getEventType().equals(getEventType()) &&
                    oEvent.getYear() == getYear()){
                return true;
            }
        }
        return false;
    }
}
