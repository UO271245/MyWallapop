package com.uniovi.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.uniovi.entities.User;

public interface UsersRepository extends CrudRepository<User, Long> {
	Page<User> findAll(Pageable pageable);
	User findByEmail(String email);
	@Query("SELECT r FROM User r WHERE ( LOWER ( r.name ) LIKE LOWER (?1) OR	LOWER ( r.lastName ) LIKE LOWER(?1))")
	Page<User> searchUserByNameAndLastname(Pageable pageable, String searchtext, User user);
}