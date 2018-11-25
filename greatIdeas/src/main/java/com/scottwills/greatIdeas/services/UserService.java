package com.scottwills.greatIdeas.services;

import java.util.Optional;


import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;

import com.scottwills.greatIdeas.models.User;
import com.scottwills.greatIdeas.repositories.UserRepository;

@Service
public class UserService {
	private UserRepository userRepo;
	
	public UserService(UserRepository userRepo) {
		this.userRepo = userRepo;
	}
	
    public User registerUser(User user) {
        String hashed = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
        user.setPassword(hashed);
        return userRepo.save(user);
    }
    
    public boolean authenticateUser(String email, String password) {
        User user = userRepo.findByEmail(email);
        if(user == null) {
            return false;
        } else {
            if(BCrypt.checkpw(password, user.getPassword())) {
                return true;
            } else {
                return false;
            }
        }
    }
    public User findByEmail(String email) {
        return userRepo.findByEmail(email);
    }
    
 	public User findUserById(Long id) {
 		Optional<User> user = userRepo.findById(id);
 		if(user.isPresent()) {
 			return user.get();
 		} else {
 			return null;
 		}
 	}
}
