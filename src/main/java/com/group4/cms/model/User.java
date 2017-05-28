package com.group4.cms.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.transaction.Transactional;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity
@Table(name = "user")
@Transactional
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "username")
	private String userName;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "enabled")
	private boolean isEnabled;
	
	@Column(name = "full_name")
	private String fullName;
	
	@ManyToMany(fetch = FetchType.EAGER)
	private List<UserRole> roles;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "bo_phan_id")
	private BoPhan boPhan;
	
	@ManyToOne()
	@LazyCollection(LazyCollectionOption.FALSE)
	@JoinColumn(name = "image_id")
	private FileWrapper profileImage;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String username) {
		this.userName = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isEnabled() {
		return isEnabled;
	}

	public void setEnabled(boolean isEnabled) {
		this.isEnabled = isEnabled;
	}

	public List<UserRole> getRoles() {
		return roles;
	}

	public void setRoles(List<UserRole> roles) {
		this.roles = roles;
	}

	public FileWrapper getProfileImage() {
		return profileImage;
	}

	public void setProfileImage(FileWrapper profileImage) {
		this.profileImage = profileImage;
	}

	public BoPhan getBoPhan() {
		return boPhan;
	}

	public void setBoPhan(BoPhan boPhan) {
		this.boPhan = boPhan;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	
	public List<Integer> getRoleIdList(){
		List<Integer> ids = new ArrayList<Integer>();
		if(this.roles.size() >0) {
			for(UserRole role : this.roles){
				ids.add(role.getId());
			}
		}
		return ids;
	}
	
	public Integer getBoPhanId(){
		return this.getBoPhan() != null ? this.getBoPhan().getId() : 0;
	}
}
