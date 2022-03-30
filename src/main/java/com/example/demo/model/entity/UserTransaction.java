package com.example.demo.model.entity;

import javax.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "tbUser1")
public class UserTransaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userCode;

    @Column(nullable = false)
    private String name;
    
    private String username;
    
    private String password;
    
    

    public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public UserTransaction(){}

    public UserTransaction(String name){
        this.name = name;
    }

    

    public Long getUserCode() {
		return userCode;
	}

	public void setUserCode(Long userCode) {
		this.userCode = userCode;
	}

	public String getName() {
        return name;
    }

    public void setName(String nome) {
        this.name = nome;
    }

	@Override
	public int hashCode() {
		return Objects.hash(name, password, userCode, username);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserTransaction other = (UserTransaction) obj;
		return Objects.equals(name, other.name) && Objects.equals(password, other.password)
				&& Objects.equals(userCode, other.userCode) && Objects.equals(username, other.username);
	}

	@Override
	public String toString() {
		return "UserTransaction [userCode=" + userCode + ", name=" + name + ", username=" + username + ", password="
				+ password + "]";
	}

	public UserTransaction(Long userCode, String name, String username, String password) {
		super();
		this.userCode = userCode;
		this.name = name;
		this.username = username;
		this.password = password;
	}

}
