//package com.example.demo.security;
//
//import java.util.Collection;
//
//import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//
//import com.example.demo.model.entity.UserTransaction;
//
//
//public class SystemUser extends User implements UserDetails {
//
//	private static final long serialVersionUID = 1L;
//
//	private UserTransaction userTransaction;
//
//	public SystemUser(UserTransaction user, String string) {
//		super();
//		this.userTransaction = userTransaction;
//	}
//
//	public UserTransaction getUser() {
//		return userTransaction;
//	}
//
//	@Override
//	public Collection<? extends GrantedAuthority> getAuthorities() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public String getUsername() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public boolean isAccountNonExpired() {
//		// TODO Auto-generated method stub
//		return true;
//	}
//
//	@Override
//	public boolean isAccountNonLocked() {
//		// TODO Auto-generated method stub
//		return true;
//	}
//
//	@Override
//	public boolean isCredentialsNonExpired() {
//		// TODO Auto-generated method stub
//		return true;
//	}
//
//	@Override
//	public boolean isEnabled() {
//		// TODO Auto-generated method stub
//		return true;
//	}
//
//}