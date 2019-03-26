package alohberg.familymapclient.Communications;

/**
 * Result of a fill service request
 * On success returns message: "Successfully added X persons and Y events to the database."
 * On failure returns error message with description of error.
 */
public class fillRES extends superResponse {
    /**
     * Error message if needed
     */
    private String message;

    /**
     * This is the main constructor of the fill service result
     * @param message this is the success message or the error message depending on response
     */
    public fillRES(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}
