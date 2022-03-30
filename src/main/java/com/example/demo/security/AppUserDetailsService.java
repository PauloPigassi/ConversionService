//package com.example.demo.security;
//
//import java.util.Optional;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.factory.PasswordEncoderFactories;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Service;
//
//import com.example.demo.model.entity.UserTransaction;
//import com.example.demo.repository.UserRepository;
//
//@Service
//public class AppUserDetailsService implements UserDetailsService{
//	
//	@Autowired
//	private UserRepository userRepository;
//	
//	BCryptPasswordEncoder encoder  = new BCryptPasswordEncoder();
//
//	@Override
//	public UserDetails loadUserByUsername(String username) {
//		Optional<UserTransaction> userOptional = userRepository.findByUsernameIgnoreCase(username);
//		UserTransaction userTransaction = userOptional.orElseThrow(() -> new UsernameNotFoundException("Incorrect Username or Password"));
//		
//		return new SystemUser(userTransaction, encoder.encode(userTransaction.getPassword()));
//	}
//
//	@Bean
//	public static PasswordEncoder passwordEncoder1() {
//	      return PasswordEncoderFactories.createDelegatingPasswordEncoder();
//	}
//	
//
//	 protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//	        auth.inMemoryAuthentication().withUser("pigassi")
//	            .password(this.passwordEncoder().encode("123"));
//	    }
//	 
//	@Bean
//	public PasswordEncoder passwordEncoder() {
//		return new BCryptPasswordEncoder();
//	}
////	private Collection<? extends GrantedAuthority> findPermissions(UserTransaction userTransaction) {
////		Set<SimpleGrantedAuthority> authorities = new HashSet<>();
////		
////		List<String> permissions = userRepository.findPermissions(userTransaction.getUserCode());
////		permissions.forEach(p -> authorities.add(new SimpleGrantedAuthority(p.toUpperCase())));
////		
////		return authorities;
////	}
//	}
//
//

