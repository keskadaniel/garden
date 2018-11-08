package com.keskadaniel.garden.models.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.keskadaniel.garden.models.UserEntity;

@Repository
public interface UserRepository extends CrudRepository<UserEntity, Integer> {
				boolean existsByUsername(String username);
				Optional<UserEntity>findByEmailAndPassword(String email, String password);
}
