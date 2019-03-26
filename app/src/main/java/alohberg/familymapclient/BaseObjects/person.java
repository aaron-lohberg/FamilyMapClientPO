package alohberg.familymapclient.BaseObjects;

import java.util.UUID;

/**
 *  This is the person class that will represent a person object
 */
public class person {
    /**
     * Unique identifier of the person as a String  REQUIRED
     */
    private String personID;

    /**
     * Name of the user who has the person as a family member  REQUIRED
     */
    private String descendant;

    /** Person's first name.  REQUIRED
     *
     */
    private String firstName;

    /**
     * Person's last name.  REQUIRED
     */
    private String lastName;

    /**
     * Persons gender, "f" or "m".  REQUIRED
     */
    private String gender;

    /**
     * Person's father. Optional
     */
    private String father;

    /**
     * Person's mother. Optional
     */
    private String mother;

    /**
     * Person's spouse. Optional
     */
    private String spouse;

    /**
     * This is the master constructor for person object, has every param
     * @param personID  unique idea of the person
     * @param descendant  username of the person who has this person associated with them
     * @param firstName  first name of the person
     * @param lastName  last name of the person
     * @param gender  gender "f" or "m" of the person
     * @param father  their father's id, not required
     * @param mother  their mother's id, not required
     * @param spouse  their spouse's id, not required
     */
    public person(String personID, String descendant, String firstName, String lastName, String gender, String father, String mother, String spouse) {
        this.personID = personID;
        this.descendant = descendant;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.father = father;
        this.mother = mother;
        this.spouse = spouse;
    }

    public person(String descendant, String firstName, String lastName, String gender, String father, String mother, String spouse) {
        this.personID = UUID.randomUUID().toString();
        this.descendant = descendant;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.father = father;
        this.mother = mother;
        this.spouse = spouse;
    }

    public person(String descendant, String firstName, String lastName, String gender) {
        this.personID = UUID.randomUUID().toString();
        this.descendant = descendant;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
    }

    public person(String personID, String descendant, String firstName, String lastName, String gender) {
        this.personID = personID;
        this.descendant = descendant;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
    }

    public void setPersonID(String personID) {
        this.personID = personID;
    }

    public void setDescendant(String descendant) {
        this.descendant = descendant;
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

    public void setFather(String father) {
        this.father = father;
    }

    public void setMother(String mother) {
        this.mother = mother;
    }

    public void setSpouse(String spouse) {
        this.spouse = spouse;
    }

    public String getPersonID() {
        return personID;
    }

    public String getDescendant() {
        return descendant;
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

    public String getFather() {
        return father;
    }

    public String getMother() {
        return mother;
    }

    public String getSpouse() {
        return spouse;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }
        if(this == o){
            return true;
        }
        if (o instanceof person) {
            person oPerson = (person) o;
            if (oPerson.getPersonID().equals(getPersonID()) &&
                    oPerson.getDescendant().equals(getDescendant()) &&
                    oPerson.getFirstName().equals(getFirstName()) &&
                    oPerson.getLastName().equals(getLastName()) &&
                    oPerson.getGender().equals(getGender()) &&
                    oPerson.getFather().equals(getFather()) &&
                    oPerson.getMother().equals(getMother()) &&
                    oPerson.getSpouse().equals(getSpouse())){
                return true;
            }
        }
        return false;
    }
}
