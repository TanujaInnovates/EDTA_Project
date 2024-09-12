package com.example.Export.repo;

import com.example.Export.Model.userModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface userRepo extends JpaRepository<userModel, Long> {
	  Optional<userModel> findByUsername(String username);
}
