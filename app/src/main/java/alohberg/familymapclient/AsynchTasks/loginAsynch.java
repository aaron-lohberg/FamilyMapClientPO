package alohberg.familymapclient.AsynchTasks;

import android.os.AsyncTask;

import alohberg.familymapclient.AsynchUtility.asynchCallback;
import alohberg.familymapclient.AsynchUtility.requestAsynch;
import alohberg.familymapclient.AsynchUtility.responseAsynch;
import alohberg.familymapclient.Communications.loginREQ;
import alohberg.familymapclient.Communications.loginRES;
import alohberg.familymapclient.Utility.Model;
import alohberg.familymapclient.Utility.ServerProxy;
import static alohberg.familymapclient.AsynchUtility.enumTasks.LOGIN;

public class loginAsynch extends AsyncTask<requestAsynch, Void, responseAsynch> {
    private asynchCallback callback;

    public loginAsynch(asynchCallback newCallback){
        callback = newCallback;
    }

    @Override
    protected responseAsynch doInBackground(requestAsynch... asynchRequests){
        // get our static proxy instance
        ServerProxy sProxy  = ServerProxy.getInstance();

        //Set the connection variables for our proxy
        sProxy.setServerHost(asynchRequests[0].getServerHost());
        sProxy.setServerPort(asynchRequests[0].getServerPort());

        //grab our login request so we can pass it into the server proxy login method
        loginREQ loginRequest = (loginREQ)asynchRequests[0].getRequest();

        //get our loginresponse while trying to login through the server proxy
        loginRES loginResponse = sProxy.login(loginRequest);

        //Check if we got a valid login
        if(loginResponse.getMessage() != null){
            return new responseAsynch(loginResponse, LOGIN);
        }

        //check if we had some error logging in (no auth token created)
        if(loginResponse.getAuthToken() == null){
            return new responseAsynch(new loginRES("AuthToken is null!"), LOGIN);
        }

        //seems like we had a valid login so let's set it
        Model.getInstance().setAuthToken(loginResponse.getAuthToken());

        return new responseAsynch(loginResponse, LOGIN);
    }

    @Override
    protected void onPostExecute(responseAsynch asynchResponse){
        loginRES loginResponse = (loginRES) asynchResponse.getResponse();

        if(loginResponse.getMessage() != null){
            callback.onComplete(asynchResponse);
            return;
        }

        Model.getInstance().setUserID(loginResponse.getPersonID());

        personsAsynch asynchPerson = new personsAsynch(callback);
        asynchPerson.execute();
    }
}
