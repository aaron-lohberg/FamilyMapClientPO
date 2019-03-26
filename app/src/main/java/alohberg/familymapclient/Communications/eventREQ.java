package alohberg.familymapclient.Communications;


/**
 * Requests all the events for all family members of the current user.
 * Requires an auth token
 * No body required
 * HTTP Method: GET
 *
 */
public class eventREQ extends superRequest {
    /**
     * Auth token for the transaction
     */
    private String authorizationToken;
    private String ID;

    public String getThisToken() {
        return authorizationToken;
    }
    public String getUser(){
        return ID;
    }

    public eventREQ(String authorizationToken, String usersName) {
        this.authorizationToken = authorizationToken;
        this.ID = usersName;
    }
    public eventREQ(String authorizationToken) {
        this.authorizationToken = authorizationToken;
    }
}
