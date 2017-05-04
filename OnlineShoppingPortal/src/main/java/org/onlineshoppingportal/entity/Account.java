package org.onlineshoppingportal.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "Accounts")
public class Account implements Serializable{
	private static final long serialVersionUID = 1L;
	public static final String ROLE_USER = "USER";
    public static final String ROLE_ADMIN = "ADMIN";
    private Long userId;
    private String userName;
    private String password;
    private String confirmPassword;
    private boolean active;
    private Set<Role> roles;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	@Transient
	public String getConfirmPassword() {
		return confirmPassword;
	}
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	@ManyToMany(fetch=FetchType.EAGER)
    @JoinTable(name = "User_Role",
    		   joinColumns = @JoinColumn(name = "User_Id"),
    		   inverseJoinColumns = @JoinColumn(name = "Role_Id"))
	public Set<Role> getRoles() {
		return roles;
	}
	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
	@Column(name = "User_Name", length = 20, nullable = false)
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    @Column(name = "Password", length = 255, nullable = false)
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    @Column(name = "Active", length = 1, nullable = false)
    public boolean isActive() {
        return active;
    }
    public void setActive(boolean active) {
        this.active = active;
    }
}
