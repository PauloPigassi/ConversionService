package com.example.demo.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.example.demo.model.entity.UserTransaction;

@Embeddable
public class UserGroupId implements Serializable {

	private static final long serialVersionUID = 1L;

	@ManyToOne
	@JoinColumn(name = "user_code")
	private UserTransaction userTransaction;
	
	@ManyToOne
	@JoinColumn(name = "group_id")
	private Group group;

	public UserTransaction getUserTransaction() {
		return userTransaction;
	}

	public void setUserTransaction(UserTransaction userTransaction) {
		this.userTransaction = userTransaction;
	}

	public Group getGroup() {
		return group;
	}

	public void setGroup(Group group) {
		this.group = group;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		return Objects.hash(group, userTransaction);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserGroupId other = (UserGroupId) obj;
		return Objects.equals(group, other.group) && Objects.equals(userTransaction, other.userTransaction);
	}

	
	
}