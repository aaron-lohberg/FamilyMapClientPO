package alohberg.familymapclient.Utility;

import com.google.gson.Gson;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

import alohberg.familymapclient.Communications.eventREQ;
import alohberg.familymapclient.Communications.eventRES;
import alohberg.familymapclient.Communications.loginREQ;
import alohberg.familymapclient.Communications.loginRES;
import alohberg.familymapclient.Communications.personREQ;
import alohberg.familymapclient.Communications.personRES;
import alohberg.familymapclient.Communications.regREQ;
import alohberg.familymapclient.Communications.regRES;

public class ServerProxy {
    private static final ServerProxy anInstance = new ServerProxy();

    public static String serverHost = "";

    public static String serverPort = "";

    private ServerProxy(){

    }

    public static ServerProxy getInstance(){
        return anInstance;
    }

    public static void setServerHost(String newServerHost){
        ServerProxy.serverHost = newServerHost;
    }

    public static void setServerPort(String newServerPort){
        ServerProxy.serverPort = newServerPort;
    }

    protected String readString(InputStream is) throws IOException {
        //deserialize the data
        StringBuilder sb = new StringBuilder();
        InputStreamReader sr = new InputStreamReader(is);
        char[] buf = new char[1024];
        int len;
        while((len = sr.read(buf)) > 0) {
            sb.append(buf, 0, len);
        }
        return sb.toString();
    }

    protected void writeString(String str, OutputStream os) throws IOException {
        //serialize the data
        OutputStreamWriter sw = new OutputStreamWriter(os);
        sw.write(str);
        sw.flush();
    }

    public loginRES login(loginREQ loginRequest){
        loginRES loginResponse = null;
        try{
            //Create the URL and open the connection to it
            URL url = new URL("http://" + serverHost + ":" + serverPort + "/user/login");
            HttpURLConnection connection = (HttpURLConnection)url.openConnection();

            //The method of the request is POST
            connection.setRequestMethod("POST");

            //We want to send a request body
            connection.setDoOutput(true);

            //Indicate how we want to receive our response
            connection.addRequestProperty("Accept", "application/json");

            //Complete the connection to the server
            connection.connect();

            //Create a JSON string to be sent in the request body
            String requestData = new Gson().toJson(loginRequest);

            //Get the connections HTTP request body (output stream)
            OutputStream requestBody = connection.getOutputStream();

            //Write the json to the req body
            writeString(requestData, requestBody);

            //Close the body output stream
            requestBody.close();

            if(connection.getResponseCode() == HttpURLConnection.HTTP_OK){
                System.out.println("Login Successful.");
                InputStream responseBody = connection.getInputStream();

                String responseData = readString(responseBody);
                loginResponse = new Gson().fromJson(responseData, loginRES.class);
            }
            else{
                System.out.println(connection.getResponseMessage());
            }
        }
        catch(IOException ex){
            ex.printStackTrace();
        }
        return loginResponse;
    }

    public regRES register(regREQ registerRequest){
        regRES registerResponse = null;
        try{
            //Create the URL and open the connection to it
            URL url = new URL("http://" + serverHost + ":" + serverPort + "/user/register");
            HttpURLConnection connection = (HttpURLConnection)url.openConnection();

            //The method of the request is POST
            connection.setRequestMethod("POST");

            //We want to send a request body
            connection.setDoOutput(true);

            //Indicate how we want to receive our response
            connection.addRequestProperty("Accept", "application/json");

            //Complete the connection to the server
            connection.connect();

            //Create a JSON string to be sent in the request body
            String requestData = new Gson().toJson(registerRequest);

            //Get the connections HTTP request body (output stream)
            OutputStream requestBody = connection.getOutputStream();

            //Write the json to the req body
            writeString(requestData, requestBody);

            //Close the body output stream
            requestBody.close();

            if(connection.getResponseCode() == HttpURLConnection.HTTP_OK){
                System.out.println("Registration Successful.");
                InputStream responseBody = connection.getInputStream();

                String responseData = readString(responseBody);
                registerResponse = new Gson().fromJson(responseData, regRES.class);
            }
            else{
                System.out.println(connection.getResponseMessage());
            }
        }
        catch(IOException ex){
            ex.printStackTrace();
        }
        return registerResponse;
    }

    public eventRES getEvents(){
        eventRES eventResponse = null;
        try{
            //Create the URL and open the connection to it
            URL url = new URL("http://" + serverHost + ":" + serverPort + "/event");
            HttpURLConnection connection = (HttpURLConnection)url.openConnection();

            //The method of the request is POST
            connection.setRequestMethod("GET");

            //We want to send a request body
            connection.setDoOutput(false);

            //Make sure they have permission to get the events
            connection.addRequestProperty("Authorization", Model.getInstance().getAuthToken());

            //Indicate how we want to receive our response
            connection.addRequestProperty("Accept", "application/json");

            //Complete the connection to the server
            connection.connect();

            if(connection.getResponseCode() == HttpURLConnection.HTTP_OK){
                System.out.println("Get Events Successful.");

                InputStream responseBody = connection.getInputStream();

                String responseData = readString(responseBody);

                eventResponse = new Gson().fromJson(responseData, eventRES.class);

                System.out.println(responseData);
            }
            else{
                System.out.println("Error: " + connection.getResponseMessage());
            }
        }
        catch(IOException ex){
            ex.printStackTrace();
        }
        return eventResponse;
    }

    public personRES getPeople(){
        personRES personResponse = null;
        try{
            //Create the URL and open the connection to it
            URL url = new URL("http://" + serverHost + ":" + serverPort + "/person");
            HttpURLConnection connection = (HttpURLConnection)url.openConnection();

            //The method of the request is POST
            connection.setRequestMethod("GET");

            //We want to send a request body
            connection.setDoOutput(false);

            //Make sure they have permission to get the people
            connection.addRequestProperty("Authorization", Model.getInstance().getAuthToken());

            //Indicate how we want to receive our response
            connection.addRequestProperty("Accept", "application/json");

            //Complete the connection to the server
            connection.connect();

            if(connection.getResponseCode() == HttpURLConnection.HTTP_OK){
                System.out.println("Get People Successful.");

                InputStream responseBody = connection.getInputStream();

                String responseData = readString(responseBody);

                personResponse = new Gson().fromJson(responseData, personRES.class);

                System.out.println(responseData);
            }
            else{
                System.out.println("Error: " + connection.getResponseMessage());
            }
        }
        catch(IOException ex){
            ex.printStackTrace();
        }
        return personResponse;
    }
}
