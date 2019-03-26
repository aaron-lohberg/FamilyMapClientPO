package alohberg.familymapclient.Activities;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.Toast;
import alohberg.familymapclient.AsynchUtility.asynchCallback;
import alohberg.familymapclient.AsynchUtility.responseAsynch;
import alohberg.familymapclient.Communications.eventRES;
import alohberg.familymapclient.Communications.loginRES;
import alohberg.familymapclient.Communications.personRES;
import alohberg.familymapclient.Communications.regRES;
import alohberg.familymapclient.Fragments.LoginFragment;
import alohberg.familymapclient.Fragments.MapFragment;
import alohberg.familymapclient.R;
import alohberg.familymapclient.Utility.Model;

import static alohberg.familymapclient.AsynchUtility.enumTasks.LOGIN;

public class MainActivity extends AppCompatActivity implements asynchCallback {

    private static final Model theModel = Model.getInstance();

    private FragmentManager fragmentManager = getSupportFragmentManager();

    private Fragment fragment;

    private Menu menu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if(fragment == null){
            fragment = new LoginFragment(this);
            fragmentManager.beginTransaction().add(R.id.main_frag_container, fragment).commit();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu newMenu){
        menu = newMenu;
        return true;
    }

    @Override
    public void onComplete(responseAsynch asynchResponse){
        boolean successful = checkResponse(asynchResponse);
        if(successful){
            return;
        }

        //Maybe do the menu here?

        if(!theModel.checkLoggedIn()){
            showToast("Error while logging in!");
            ((LoginFragment) fragment).swapButtonsEnabled(true);
            return;
        }

        //fragmentManager.beginTransaction().remove(fragment).commit();
        //fragment = MapFragment.newInstance();
        //fragmentManager.beginTransaction().add(R.id.main_frag_container, fragment).commit();

        theModel.setFirstNameLastName(theModel.getUserID());
        String firstName = theModel.getInstance().getFirstName();
        String lastName = theModel.getInstance().getLastName();
        String message = "Welcome " + firstName + " " + lastName;
        showToast(message);
    }

    private boolean checkResponse(responseAsynch asynchResponse){
        String errorMessage = null;

        switch(asynchResponse.getTask()){
            case LOGIN:
                if(((loginRES)asynchResponse.getResponse()).getMessage() != null){
                    errorMessage = ((loginRES)asynchResponse.getResponse()).getMessage();
                }
                break;
            case REGISTER:
                if(((regRES)asynchResponse.getResponse()).getErrorMessage() != null){
                    errorMessage = ((regRES)asynchResponse.getResponse()).getErrorMessage();
                }
                break;
            case PERSON:
                if(((personRES)asynchResponse.getResponse()).getMessage() != null){
                    errorMessage = ((personRES)asynchResponse.getResponse()).getMessage();
                }
                break;
            case EVENT:
                if(((eventRES)asynchResponse.getResponse()).getMessage() != null){
                    errorMessage = ((eventRES)asynchResponse.getResponse()).getMessage();
                }
                break;
        }
        if(errorMessage != null){
            showToast(errorMessage);
            ((LoginFragment)fragment).swapButtonsEnabled(true);
            return true;
        }
        return false;
    }

    @Override
    public void showToast(String message){
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }
}
