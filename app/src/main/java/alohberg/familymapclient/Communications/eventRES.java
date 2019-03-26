package alohberg.familymapclient.Communications;

import alohberg.familymapclient.BaseObjects.event;

import java.util.List;

public class eventRES extends superResponse {

    private List<event> data;

    private String message;

    private event Event;

    public eventRES(List<event> retEvents) {
        this.data = retEvents;
    }

    public eventRES(event retEvent) {
        this.Event = retEvent;
    }

    public eventRES(String message) {
        this.message = message;
    }

    public List<event> getData() {
        return data;
    }

    public String getMessage() {
        return message;
    }

    public List<event> getFamilyEvents() {
        return data;
    }
    public event getSingleEvent(){
        return Event;
    }
}
