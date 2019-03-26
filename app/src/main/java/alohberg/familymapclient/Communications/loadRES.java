package alohberg.familymapclient.Communications;
/**
 * Result of a load service request
 * On success returns messsage: Successfull added X users, Y persons, and Z events to the DB"
 * On failure returns description of the error.
 */
public class loadRES extends superResponse {
    /**
     * Error message if needed
     */
    private String message;

    /**
     * Response object from the load service
     * @param message On success it's a string confirming objects were added to DB or error message on failure
     */
    public loadRES(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
