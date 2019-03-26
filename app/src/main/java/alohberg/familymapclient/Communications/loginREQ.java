package alohberg.familymapclient.Communications;

/**
 * Requests for a user to log in
 * Request body has userName and Password
 * HTTP Method: POST
 * No Auth Token required
 */
public class loginREQ extends superRequest {

    /**
     * Main constructor for login req
     * @param userName this is users username
     * @param pwd  users password
     */
    public loginREQ(String userName, String pwd) {
        this.userName = userName;
        this.password = pwd;
    }/**
     * Username of the user to verify
     */
    private String userName;

    public String getPwd() {
        return password;
    }

    public String getUserName() {
        return userName;
    }

    /**
     * Password of the user to verify
     */
    private String password;


}
