package alohberg.familymapclient.AsynchTasks;

import android.os.AsyncTask;

import alohberg.familymapclient.AsynchUtility.asynchCallback;
import alohberg.familymapclient.AsynchUtility.requestAsynch;
import alohberg.familymapclient.AsynchUtility.responseAsynch;
import alohberg.familymapclient.Communications.regREQ;
import alohberg.familymapclient.Communications.regRES;
import alohberg.familymapclient.Utility.Model;
import alohberg.familymapclient.Utility.ServerProxy;

import static alohberg.familymapclient.AsynchUtility.enumTasks.REGISTER;

public class registerAsynch extends AsyncTask<requestAsynch, Void, responseAsynch> {
    private asynchCallback callback;

    public registerAsynch(asynchCallback newCallback){
        callback = newCallback;
    }

    @Override
    protected responseAsynch doInBackground(requestAsynch... asynchRequests){
        // get our static proxy instance
        ServerProxy sProxy  = ServerProxy.getInstance();

        //Set the connection variables for our proxy
        sProxy.setServerHost(asynchRequests[0].getServerHost());
        System.out.println(asynchRequests[0].getServerHost());
        sProxy.setServerPort(asynchRequests[0].getServerPort());
        System.out.println(asynchRequests[0].getServerPort());

        //grab our register request so we can pass it into the server proxy login method
        regREQ regRequest = (regREQ)asynchRequests[0].getRequest();

        //get our register Response while trying to login through the server proxy
        regRES regResponse = sProxy.register(regRequest);

        //Check if we got an invalid registration
        if(regResponse.getErrorMessage() != null){
            return new responseAsynch(regResponse, REGISTER);
        }

        //check if we had some error registering (no auth token created)
        if(regResponse.getAuthToken() == null){
            return new responseAsynch(new regRES("AuthToken is null!"), REGISTER);
        }

        Model.getInstance().setAuthToken(regResponse.getAuthToken());

        return new responseAsynch(regResponse, REGISTER);
    }


    @Override
    protected void onPostExecute(responseAsynch asynchResponse){
        regRES regResponse = (regRES) asynchResponse.getResponse();

        if(regResponse.getErrorMessage() != null){
            callback.onComplete(asynchResponse);
            return;
        }

        Model.getInstance().setUserID(regResponse.getPersonID());


        personsAsynch asynchPerson = new personsAsynch(callback);
        asynchPerson.execute();

    }
}
