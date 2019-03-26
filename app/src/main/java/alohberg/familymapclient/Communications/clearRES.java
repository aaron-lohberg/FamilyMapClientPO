package alohberg.familymapclient.Communications;

/**
 * A response from the clear service
 * Contains a message
 * Success: Clear succeeded.
 * Failure: Description of the error
 */
public class clearRES extends superResponse {
    /**
     * Error messages
     */
    private String message;

    /**
     * Main clear result object constructor (sets message)
     * @param message  this is the result string message for what happened in the clear service
     */
    public clearRES(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
