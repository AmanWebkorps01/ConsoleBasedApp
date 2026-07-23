import java.util.*;

public class User {

    private String name;
    private String email;
    private List<String> mobile_no;

    public User() {
    }

    public User(String email, List<String> mobile_no, String name) {
        this.email = email;
        this.mobile_no = mobile_no;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<String> getMobile_no() {
        return mobile_no;
    }

    public void setMobile_no(List<String> mobile_no) {
        this.mobile_no = mobile_no;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", mobile_no=" + mobile_no +
                '}';
    }
}
