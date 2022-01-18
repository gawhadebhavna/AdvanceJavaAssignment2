package Pojo;

public class UserLogin {
    private String email;
    private String password;
    private int partyId;

    public UserLogin() {
    }

    @Override
    public String toString() {
        return "Login{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", partyId='" + partyId + '\'' +
                '}';
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getPartyId() {
        return partyId;
    }

    public void setPartyId(int partyId) {
        this.partyId = partyId;
    }

    public UserLogin(String email, String password, int partyId) {
        this.email = email;
        this.password = password;
        this.partyId = partyId;
    }
}
