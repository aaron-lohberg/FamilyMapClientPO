package alohberg.familymapclient.AsynchTasks;

import android.os.AsyncTask;
import alohberg.familymapclient.AsynchUtility.asynchCallback;
import alohberg.familymapclient.AsynchUtility.requestAsynch;
import alohberg.familymapclient.AsynchUtility.responseAsynch;
import alohberg.familymapclient.Communications.eventRES;
import alohberg.familymapclient.Communications.personRES;
import alohberg.familymapclient.Utility.Model;
import alohberg.familymapclient.Utility.ServerProxy;
import static alohberg.familymapclient.AsynchUtility.enumTasks.EVENT;

public class eventAsynch extends AsyncTask<requestAsynch, Void, responseAsynch>  {
        private asynchCallback callback;

        public eventAsynch(asynchCallback newCallback){
            callback = newCallback;
        }

        @Override
        protected responseAsynch doInBackground(requestAsynch... asynchRequests){
            // get our static proxy instance
            ServerProxy sProxy  = ServerProxy.getInstance();

            if(!Model.getInstance().checkLoggedIn()){
                return new responseAsynch(new personRES("You're Not Logged In!"), EVENT);
            }

            //get our event response with the data from our server proxy
            eventRES eventResponse = sProxy.getEvents();

            return new responseAsynch(eventResponse, EVENT);
        }

        @Override
        protected void onPostExecute(responseAsynch asynchResponse){
            eventRES eventResponse = (eventRES)asynchResponse.getResponse();

            if(eventResponse == null){
                callback.onComplete(new responseAsynch(new personRES("Person Task returned null"), EVENT));
                return;
            }

            if(eventResponse.getMessage() != null){
                callback.onComplete(asynchResponse);
                return;
            }

            Model.getInstance().setEventList(eventResponse.getFamilyEvents());
            callback.onComplete(asynchResponse);
        }
}
