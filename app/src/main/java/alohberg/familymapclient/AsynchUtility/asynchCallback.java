package alohberg.familymapclient.AsynchUtility;

public interface asynchCallback {

    //This is what should be done once the response comes back
    void onComplete(responseAsynch asynchResponse);

    //The message will be displayed as text in a Toast
    void showToast(String message);
}
