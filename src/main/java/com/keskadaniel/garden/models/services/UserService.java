package com.keskadaniel.garden.models.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;

import com.keskadaniel.garden.models.UserEntity;
import com.keskadaniel.garden.models.forms.LoginForm;
import com.keskadaniel.garden.models.forms.RegisterForm;
import com.keskadaniel.garden.models.repositories.UserRepository;

@Service
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS, value = "session")
public class UserService {

	@Autowired
	UserRepository userRepository;
	
	private UserEntity userData;
	private boolean isLogin;
	
	public boolean isUserExistByUsername(String username) {
		return userRepository.existsByUsername(username);
	}
	
	public boolean registerUser (RegisterForm registerForm) {
		UserEntity newUser = new UserEntity();
		newUser.setName(registerForm.getName());
		newUser.setUsername(registerForm.getUsername());
		newUser.setPassword(registerForm.getPassword());
		newUser.setEmail(registerForm.getEmail());
		
		userRepository.save(newUser);
		return true;

	}
	
	public boolean loginUser (LoginForm loginForm) {
		Optional<UserEntity> loggedUser = userRepository.findByEmailAndPassword(loginForm.getEmail(), loginForm.getPassword());
	
		   if(loggedUser.isPresent()){
	            isLogin = true;
	            userData = loggedUser.get();
		   }
	            
	            return loggedUser.isPresent();
	        }
		
	
	
	public void logOut() {
		
		isLogin=false;
		userData = null;
		
			}
	
	
	   public UserEntity getUserData() {
	        return userData;
	    }

	    public boolean isLogin() {
	        return isLogin;
	    }

	    public Iterable<UserEntity> getAllUsers() {
	        return userRepository.findAll();
	    }

	    public void deleteUser(int userId) {

	        userRepository.deleteById(userId);
	    }
	
	    
	
		
	}
	
	
	

