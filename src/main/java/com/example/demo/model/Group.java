package com.example.demo.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import com.example.demo.model.Permission;

@Entity
@Table(name = "tbGroup")
public class Group implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long groupId;

	private String name;

	@ManyToMany
	@JoinTable(name = "group_permission", joinColumns = @JoinColumn(name = "group_id"), inverseJoinColumns = @JoinColumn(name = "permission_id"))
	private List<Permission> permissions;

	public Long getGroupId() {
		return groupId;
	}

	public void setGroupId(Long groupId) {
		this.groupId = groupId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Permission> getPermissions() {
		return permissions;
	}

	public void setPermissions(List<Permission> permissions) {
		this.permissions = permissions;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}


}