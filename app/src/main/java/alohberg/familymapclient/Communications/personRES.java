package alohberg.familymapclient.Communications;
import alohberg.familymapclient.BaseObjects.person;

import java.util.List;

public class personRES extends superResponse {

    private List<person> data;

    private person Person;

    private String message;

    public personRES(List<person> allRelatedPersons) {
        this.data = allRelatedPersons;
    }

    public personRES(String message) {
        this.message = message;
    }

    public personRES(person singlePerson) {
        this.Person = singlePerson;
    }

    public person getSinglePerson() {
        return Person;
    }

    public String getMessage() {
        return message;
    }

    public List<person> getAllRelatedPersons() {
        return data;
    }

}
