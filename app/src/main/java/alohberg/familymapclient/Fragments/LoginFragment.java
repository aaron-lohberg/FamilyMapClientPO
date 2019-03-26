package alohberg.familymapclient.Fragments;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import alohberg.familymapclient.AsynchTasks.loginAsynch;
import alohberg.familymapclient.AsynchTasks.registerAsynch;
import alohberg.familymapclient.AsynchUtility.asynchCallback;
import alohberg.familymapclient.AsynchUtility.requestAsynch;
import alohberg.familymapclient.Communications.loginREQ;
import alohberg.familymapclient.Communications.regREQ;
import alohberg.familymapclient.R;

public class LoginFragment extends Fragment {
    //asynchronous callback from our asynch tasks
    private asynchCallback callbacks;

    //server host input
    private EditText serverHost;

    //server port input
    private EditText serverPort;

    //email input
    private EditText email;

    //gender input
    private String gender = "";

    //gender radio button input
    private RadioGroup radioGroup;

    //button to login
    private Button loginButton;

    //username input
    private EditText username;

    //password input
    private EditText password;

    //first-name input
    private EditText firstName;

    //last-name input
    private EditText lastName;

    //button for registering
    private Button registerButton;

    public LoginFragment() {
        //Empty constructor
    }

    @SuppressLint("ValidFragment")
    public LoginFragment( asynchCallback aCallback )
    {
        callbacks = aCallback;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_login, container, false);

        setupComponents(view);

        serverHost.setText("10.0.2.2");
        serverPort.setText("8080");
        loginButton.setEnabled(false);
        registerButton.setEnabled(false);
        setupListeners();
        setupTextWatchers();
        checkEditTextFields();

        return view;
    }

    //Attaches our java variables to the activity components
    public void setupComponents(View view){
        serverHost = view.findViewById(R.id.input_server_host);
        serverPort = view.findViewById(R.id.input_server_port);
        username = view.findViewById(R.id.input_username);
        password = view.findViewById(R.id.input_password);
        firstName = view.findViewById(R.id.input_first_name);
        lastName = view.findViewById(R.id.input_last_name);
        email = view.findViewById(R.id.input_email);
        radioGroup = view.findViewById(R.id.login_radio_group);
        loginButton = view.findViewById(R.id.login_button);
        registerButton = view.findViewById(R.id.register_button);
    }

    //set up all our event listeners for the buttons and radio buttons
    public void setupListeners(){
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId)
            {
                // Set gender value based on the id selected
                switch(checkedId)
                {
                    case R.id.radio_female:
                        gender = "f";
                        break;
                    case R.id.radio_male:
                        gender = "m";
                        break;
                    default:
                }

                checkEditTextFields();
            }
        });

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Disable login and register buttons once the login button is clicked

                // Create an async request
                requestAsynch request = new requestAsynch(serverHost.getText().toString(), serverPort.getText().toString(),
                        new loginREQ( username.getText().toString(),
                                password.getText().toString()));

                // Setup and start the task
                loginAsynch asynchronousLogin = new loginAsynch(callbacks);
                asynchronousLogin.execute(request);
            }
        });

        registerButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                // Disable login and register buttons once the register button is clicked

                // Create an async request
                requestAsynch request = new requestAsynch(serverHost.getText().toString(), serverPort.getText().toString(),
                        new regREQ( username.getText().toString(),
                                password.getText().toString(),
                                email.getText().toString(),
                                firstName.getText().toString(),
                                lastName.getText().toString(),
                                gender ));

                // Setup and start the task
                registerAsynch asynchronousRegister = new registerAsynch(callbacks);
                asynchronousRegister.execute(request);
            }
        });
    }

    public void setupTextWatchers(){
        TextWatcher textWatcher = new TextWatcher(){
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after){

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count){
                checkEditTextFields();
            }

            @Override
            public void afterTextChanged(Editable s){

            }
        };

        //Putting the text watcher on all of the different text elements
        serverHost.addTextChangedListener(textWatcher);
        serverPort.addTextChangedListener(textWatcher);
        username.addTextChangedListener(textWatcher);
        firstName.addTextChangedListener(textWatcher);
        lastName.addTextChangedListener(textWatcher);
        email.addTextChangedListener(textWatcher);
        password.addTextChangedListener(textWatcher);
    }

    public void checkEditTextFields(){
        if(serverHost.getText().toString().equals("") || serverPort.getText().toString().equals("") || username.getText().toString().equals("") || password.getText().toString().equals("")){
            loginButton.setEnabled(false);
            registerButton.setEnabled(false);
            return;
        }

        if(firstName.getText().toString().equals("") || lastName.getText().toString().equals("") || email.getText().toString().equals("") || gender.equals("")){
            loginButton.setEnabled(true);
            registerButton.setEnabled(false);
            return;
        }

        swapButtonsEnabled(true);
    }

    public void swapButtonsEnabled(boolean buttonControl){
        loginButton.setEnabled(buttonControl);
        registerButton.setEnabled(buttonControl);
    }

    public void showToast(String message){
        Toast.makeText(getActivity(), message, Toast.LENGTH_LONG).show();
    }
}
