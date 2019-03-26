package alohberg.familymapclient.Communications;


/**
 * Requests to create a new user account through the register service
 * Request Body:
 * userName, password, email, firstName, lastName, gender
 * HTTP Method: POST
 * No Auth Token Required
 */
public class regREQ extends superRequest{

    private String userName;
    private String password;
    private String email;
    private String firstName;
    private String lastName;
    private String gender;
    private int variableCount;

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getGender() {
        return gender;
    }

    public void setUserName(String userName) {
        if(userName != null){
            variableCount++;
        }
        this.userName = userName;
    }

    public void setPassword(String password) {
        if(password != null){
            variableCount++;
        }
        this.password = password;
    }

    public void setEmail(String email) {
        if(email != null){
            variableCount++;
        }
        this.email = email;
    }

    public void setFirstName(String firstName) {
        if(firstName != null){
            variableCount++;
        }
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        if(lastName != null){
            variableCount++;
        }
        this.lastName = lastName;
    }

    public void setGender(String gender) {
        if(gender != null){
            variableCount++;
        }
        this.gender = gender;
    }

    public int getVariableCount() {
        return variableCount;
    }

    public boolean checkValidArgs(){
        this.variableCount = 0;
        setUserName(this.userName);
        setPassword(this.password);
        setEmail(this.email);
        setFirstName(this.firstName);
        setLastName(this.lastName);
        setGender(this.gender);

        if(variableCount == 6){
            return true;
        }
        return false;
    }

    public regREQ(String userName, String password, String email, String firstName, String lastName, String gender) {
        this.variableCount = 0;
        setUserName(userName);
        setPassword(password);
        setEmail(email);
        setFirstName(firstName);
        setLastName(lastName);
        setGender(gender);
    }
}
