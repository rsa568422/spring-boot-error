package com.bolsadeideas.springboot.error.app.services.impl;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.bolsadeideas.springboot.error.app.models.domain.User;
import com.bolsadeideas.springboot.error.app.services.UserService;

@Service
public class UserServiceImpl implements UserService {

	private List<User> list;

	public UserServiceImpl() {
		this.list = Arrays.asList(new User(1, "Andrés", "Guzmán"),
								  new User(2, "Roberto", "Sánchez"),
								  new User(3, "Pepa", "García"),
								  new User(4, "Lalo", "Mena"),
								  new User(5, "Luci", "Fernández"),
								  new User(6, "Pato", "González"),
								  new User(7, "Paco", "Rodríguez"));
	}

	@Override
	public List<User> list() {
		return this.list;
	}

	@Override
	public User findById(Integer id) {
		return this.findByIdOptional(id).orElse(null);
	}

	@Override
	public Optional<User> findByIdOptional(Integer id) {
		return this.list
				   .stream()
				   .filter(user -> user.getId().equals(id))
				   .findFirst();
	}

}
