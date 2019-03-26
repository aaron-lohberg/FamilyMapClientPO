package alohberg.familymapclient.AsynchTasks;

import android.os.AsyncTask;

import alohberg.familymapclient.AsynchUtility.asynchCallback;
import alohberg.familymapclient.AsynchUtility.requestAsynch;
import alohberg.familymapclient.AsynchUtility.responseAsynch;
import alohberg.familymapclient.Communications.personRES;
import alohberg.familymapclient.Utility.Model;
import alohberg.familymapclient.Utility.ServerProxy;
import static alohberg.familymapclient.AsynchUtility.enumTasks.PERSON;

public class personsAsynch extends AsyncTask<requestAsynch, Void, responseAsynch>  {
        private asynchCallback callback;

        public personsAsynch(asynchCallback newCallback){
            callback = newCallback;
        }

        @Override
        protected responseAsynch doInBackground(requestAsynch... asynchRequests){
            // get our static proxy instance
            ServerProxy sProxy  = ServerProxy.getInstance();

            if(!Model.getInstance().checkLoggedIn()){
                return new responseAsynch(new personRES("You're Not Logged In!"), PERSON);
            }
            //get our personResponse with the data from our server proxy
            personRES personResponse = sProxy.getPeople();

            return new responseAsynch(personResponse, PERSON);
        }

    @Override
    protected void onPostExecute(responseAsynch asynchResponse){
        personRES personResponse = (personRES) asynchResponse.getResponse();

        if(personResponse == null){
            callback.onComplete(new responseAsynch(new personRES("Person Task returned null"), PERSON));
            return;
        }

        if(personResponse.getMessage() != null){
            callback.onComplete(asynchResponse);
            return;
        }

        Model.getInstance().setPersonList(personResponse.getAllRelatedPersons());

        eventAsynch asynchEvents = new eventAsynch(callback);
        asynchEvents.execute();
    }
}
