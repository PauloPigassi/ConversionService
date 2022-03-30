package com.example.demo.model;

import java.util.Objects;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "user_group")
public class UserGroup {

	@EmbeddedId
	private UserGroupId userGroupId;

	public UserGroupId getUserGroupId() {
		return userGroupId;
	}

	public void setUserGroupId(UserGroupId userGroupId) {
		this.userGroupId = userGroupId;
	}

	@Override
	public int hashCode() {
		return Objects.hash(userGroupId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserGroup other = (UserGroup) obj;
		return Objects.equals(userGroupId, other.userGroupId);
	}


}