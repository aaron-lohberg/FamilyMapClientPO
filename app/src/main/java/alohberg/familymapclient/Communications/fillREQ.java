package alohberg.familymapclient.Communications;

public class fillREQ extends superRequest {

    private String userName;

    private int generations;

    public fillREQ(String userName) {
        this.userName = userName;
        generations = 4;
    }

    public fillREQ(String userName, int generations) {
        this.userName = userName;
        this.generations = generations;
    }

    public String getUserName() {
        return userName;
    }

    public int getGenerations() {
        return generations;
    }


}
