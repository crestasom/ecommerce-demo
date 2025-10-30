package com.crestasom.ecommerce_demo.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.crestasom.ecommerce_demo.entity.User;

@Repository
public class UserRepository {
    private final List<User> users = new ArrayList<>();
    private long nextId = 1;

    public List<User> findAll() {
        return users;
    }

	public User findById(Long id) {
		for (User u : users) {
			if (u.getId() == id) {
				return u;
			}
		}
		return null;
//        return users.stream().filter(user -> user.getId().equals(id)).findFirst();
    }

    public User save(User user) {
        if (user.getId() == null) {
            user.setId(nextId++);
        }
		users.removeIf(u -> u.getId().equals(user.getId()));
        users.add(user);
        return user;
    }

    public void deleteById(Long id) {
        users.removeIf(user -> user.getId().equals(id));
    }
}
