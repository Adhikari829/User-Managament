package org.jp.repository;

import java.util.Optional;

import org.jp.entity.UserEntity;
import org.jp.entity.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepo extends JpaRepository<UserEntity, Long> {

	UserRole save(Optional<UserEntity> user);
    // Custom query methods can be added here if needed
	Optional<UserEntity> findByuserEmail(String userEmail);

public interface UserRepo extends JpaRepository<UserEntity, Long>{
	
	Optional<UserEntity> findByuserEmail(String userEmail);


}
