package be.ac.ulb.infof307.g10.models;

import javax.persistence.*;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Entity
//@Table(name="T_USERS")
public class User implements Serializable {

    private static final long serialVersionUID = -0L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Basic(optional = false)
	private Integer id;

	@Basic(optional = false)
	private String username;

    @Basic(optional = false)
	private String password;

	@OneToOne
    private List userList;

	//NEEDED BY JPA
	public User(){
	}

    public User(String username, String password, List userList) {
        this.username = username;
        this.password = sha256(password);
        this.userList = userList;
    }

    public User(String username, String password) {
        this.username = username;
        this.password = sha256(password);
    }


    public User(User user) {
        this.id = user.id;
        this.username = user.username;
        this.password = user.password;
        this.userList = user.userList;
    }

    public static String sha256(String password) {
        MessageDigest digest;
        byte[] encodedHash = null;
        try {
            digest = MessageDigest.getInstance("SHA-256");
            encodedHash = digest.digest(password.getBytes(StandardCharsets.UTF_8));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        try {
            return new String(encodedHash, "UTF-8");
        } catch (UnsupportedEncodingException e) { // this exception never append because "UTF-8" is a correct encoding
            return "";
        }
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", userList=" + userList +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List getUserList() {
        return userList;
    }

    public void setUserList(List userList) {
        this.userList = userList;
    }


}
