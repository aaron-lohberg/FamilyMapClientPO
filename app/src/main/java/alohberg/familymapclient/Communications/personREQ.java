package alohberg.familymapclient.Communications;

/**
 * Requests all family members of current user based on current auth token
 * No request body
 * HTTP Method: GET
 * Auth Token is Required
 */
public class personREQ extends superRequest {
    /**
     * Necessary auth token for the HTTP transaction
     */
    private String requestAuthToken;

    private String personID;
    /**
     * Main constructor for person request object
     * @param requestAuthToken Auth token to verify permission to make request
     */
    public personREQ(String requestAuthToken) {
        this.requestAuthToken = requestAuthToken;
    }

    public personREQ(String requestAuthToken, String userName) {
        this.requestAuthToken = requestAuthToken;
        this.personID = userName;
    }

    public String getRequestAuthToken() {
        return requestAuthToken;
    }

    public String getID(){
        return personID;
    }
}
