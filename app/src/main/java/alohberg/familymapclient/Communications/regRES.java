package alohberg.familymapclient.Communications;

public class regRES extends superResponse {

    private String authToken;

    private String userName;

    private String personID;

    private String message;

    public regRES(String newUserAuth, String userName, String personID) {
        this.authToken = newUserAuth;
        this.userName = userName;
        this.personID = personID;
    }

    public regRES(String error){
        this.message = error;
        this.authToken = null;
        this.userName = null;
        this.personID = null;
    }

    public String getPersonID() {
        return personID;
    }

    public String getUserName() {
        return userName;
    }

    public String getErrorMessage() {
        return message;
    }

    public String getAuthToken() {
        return authToken;
    }
}
