package alohberg.familymapclient.BaseObjects;

import java.util.UUID;

/**This is the auth token class it will hold the auth token and user associated to it
 *
 */
public class authToken {
    /**
     * Unique string representing an authentification token REQUIRED
     */
    private String uniqueToken;

    /**
     * Unique username of the individual who owns the auth token REQUIRED
     */
    private String userName;

    /**Main constructor for auth token object
     * @param uniqueToken  this will be a unique generated string
     * @param userName  this is the username of the user that the token is for.
     */
    public authToken(String uniqueToken, String userName) {
        this.uniqueToken = uniqueToken;
        this.userName = userName;
    }

    public authToken(String userName){
        this.userName = userName;
        this.uniqueToken = UUID.randomUUID().toString();
    }

    public void setUniqueToken(String uniqueToken) {
        this.uniqueToken = uniqueToken;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUniqueToken() {
        return uniqueToken;
    }

    public String getUserName() {
        return userName;
    }
}
