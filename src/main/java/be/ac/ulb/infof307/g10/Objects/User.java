package be.ac.ulb.infof307.g10.Objects;

import javax.persistence.*;
import java.io.Serializable;

@Entity
//@Table(name="T_USERS")
public class User implements Serializable {

    private static final long serialVersionUID = -0L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Basic(optional = false)
//	@Column(name = "USER_ID")
	private Integer userId;

	@Basic(optional = true)
//	@Column(name = "USER_NAME")
	private String userName;

	@Basic(optional = true)
//	@Column(name = "USER_PASSWD")
	private Integer userPwd;

	// DO NOT DELETE ; NEEDED BY JPA !!!!!!!!!!!!
	public User(){
	}

    public User(String userName, Integer userPwd) {
        this.userName = userName;
        this.userPwd = userPwd;
    }


    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(Integer userPwd) {
        this.userPwd = userPwd;
    }
}

