package com.example.Export.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Export.Model.FileResponse;

@Repository
public interface fileuploadRepo extends JpaRepository <FileResponse, Long> {
	
}
