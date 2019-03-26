package alohberg.familymapclient.AsynchUtility;

import alohberg.familymapclient.Communications.superResponse;

public class responseAsynch {
    //Our response body
    private superResponse response;

    //What task did we do
    private enumTasks task;

    //Correct Response Constructor
    public responseAsynch(superResponse newResponse, enumTasks finishedTask){
        response = newResponse;
        task = finishedTask;
    }

    //Default Constructor
    public responseAsynch(){

    }

    //getter for task
    public enumTasks getTask(){
        return task;
    }

    //setter for task
    public void setTask(enumTasks finishedTask){
        task = finishedTask;
    }

    //Getter for response
    public superResponse getResponse(){
        return response;
    }

    //Setter for response
    public void setResponse(superResponse newResponse){
        response = newResponse;
    }
}
