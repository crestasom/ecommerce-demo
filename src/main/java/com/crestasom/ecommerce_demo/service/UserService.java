package com.crestasom.ecommerce_demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crestasom.ecommerce_demo.entity.User;
import com.crestasom.ecommerce_demo.repository.UserRepository;

@Service
public class UserService {

    @Autowired
	private UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

	public User getUserById(Long id) {
        return userRepository.findById(id);
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public User updateUser(Long id, User userDetails) {
		User user = userRepository.findById(id);
		if (user == null) {
			throw new RuntimeException("User not found");
		}
        user.setName(userDetails.getName());
        user.setEmail(userDetails.getEmail());
        return userRepository.save(user);
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
