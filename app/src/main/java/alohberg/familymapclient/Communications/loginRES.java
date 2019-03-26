package alohberg.familymapclient.Communications;

public class loginRES extends superResponse {

    private String authToken;

    private String userName;

    private String personID;

    private String message;

    public loginRES(String thisLoginToken, String userName, String personID) {
        this.authToken = thisLoginToken;
        this.userName = userName;
        this.personID = personID;
    }

    public loginRES(String possibleError) {
        this.message = possibleError;
    }

    public String getUserName() {
        return userName;
    }

    public String getMessage() {
        return message;
    }

    public String getPersonID() {
        return personID;
    }

    public String getAuthToken() {
        return authToken;
    }
}
