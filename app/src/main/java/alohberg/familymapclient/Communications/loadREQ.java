package alohberg.familymapclient.Communications;
import alohberg.familymapclient.BaseObjects.event;
import alohberg.familymapclient.BaseObjects.person;
import alohberg.familymapclient.BaseObjects.user;

import java.util.List;

/**
 * Requests for load service to clear DB, then sends in Body 3 arrays:
 * users: Array of user Objects to be added
 * persons: Array of person objects to be added
 * events: Array of event objects to be added
 *
 * HTTP Method: POST
 * No auth token required
 */
public class loadREQ extends superRequest {
    /**
     * All the users to be loaded in
     */
    private List<user> users;

    /**
     * All the persons to be loaded in
     */
    private List<person> persons;

    /**
     * All the events to be loaded in
     */
    private List<event> events;

    /**
     * Main constructor for a load request, requires user array, person array and event array to use in service
     * @param users array of the user objects to be added to DB in load service
     * @param persons array of the person objects to be added to DB in person service
     * @param events array of event objects to be added to DB in array service
     */
    public loadREQ(List<user> users, List<person> persons, List<event>  events) {
        this.users = users;
        this.persons = persons;
        this.events = events;
    }

    public void setUsers(List<user> users) {
        this.users = users;
    }

    public void setEvents(List<event> events) {
        this.events = events;
    }

    public void setPersons(List<person> persons) {
        this.persons = persons;
    }

    public List<event> getEvents() {
        return events;
    }

    public List<person> getPersons() {
        return persons;
    }

    public List<user> getUsers() {
        return users;
    }
}
