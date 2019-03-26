package alohberg.familymapclient.BaseObjects;

/**This is the user object that will represent each user on the server
 * */
public class user {
    /**
     * Unique userName of the user  REQUIRED
     */
    private String userName;

    /**
     * Password for the user.  REQUIRED
     */
    private String password;

    /**
     * Email for the user.  REQUIRED
     */
    private String email;

    /**
     * First name of the user.  REQUIRED
     */
    private String firstName;

    /**
     * Last name of the user.  REQUIRED
     */
    private String lastName;

    /**
     * Gender of the user, "f" or "m".  REQUIRED
     */
    private String gender;

    /**
     * Unique identifier of the user (created by the program)  REQUIRED
     */
    private String personID;

    /**The user constructor, it will probably only have one
     * @param userName
     * @param pwd
     * @param email
     * @param firstName
     * @param lastName
     * @param gender
     * @param personID
     * */
    public user(String personID, String userName, String pwd, String email, String firstName, String lastName, String gender) {
        this.userName = userName;
        this.password = pwd;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.personID = personID;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPwd(String pwd) {
        this.password = pwd;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setPersonID(String personID) {
        this.personID = personID;
    }

    public String getUserName() {
        return userName;
    }

    public String getPwd() {
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

    public String getPersonID() {
        return personID;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }
        if(this == o){
            return true;
        }
        if (o instanceof user) {
            user oUser = (user) o;
            if (oUser.getPersonID().equals(getPersonID()) &&
                    oUser.getUserName().equals(getUserName()) &&
                    oUser.getPwd().equals(getPwd()) &&
                    oUser.getFirstName().equals(getFirstName()) &&
                    oUser.getLastName().equals(getLastName()) &&
                    oUser.getEmail().equals(getEmail()) &&
                    oUser.getGender().equals(getGender())){
                return true;
            }
        }
        System.out.println("Hmm");

        return false;
    }
}
