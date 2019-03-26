package alohberg.familymapclient.AsynchUtility;

import alohberg.familymapclient.Communications.superRequest;

public class requestAsynch {

    //Server host or domain we want to connect to
    private String serverHost;

    //The port the server is running on
    private String serverPort;

    //The request body
    private superRequest request;

    public requestAsynch(String newServerHost, String newServerPort, superRequest newRequest){
        serverHost = newServerHost;
        serverPort = newServerPort;
        request = newRequest;
    }

    //simple return of the request
    public superRequest getRequest(){
        return request;
    }

    //getter for the port
    public String getServerPort(){
        return serverPort;
    }

    //getter for the host
    public String getServerHost(){
        return serverHost;
    }
}
