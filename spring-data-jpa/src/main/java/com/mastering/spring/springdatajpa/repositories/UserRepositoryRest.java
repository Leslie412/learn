package com.mastering.spring.springdatajpa.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.mastering.spring.springdatajpa.entities.User;

@RepositoryRestResource(collectionResourceRel = "users", path = "users")
public interface UserRepositoryRest extends PagingAndSortingRepository<User, Long> {
	@Query("select u from User u where u.name = :name")
	public List<User> findUsersByNameUsingNamedParameters(@Param("name") String name);
	
	@Query("select u from User u where u.name = ?1")
	public List<User> findUsersByNameUsingQuery(@Param("name") String name);
	
//	public User save(User user);
}
