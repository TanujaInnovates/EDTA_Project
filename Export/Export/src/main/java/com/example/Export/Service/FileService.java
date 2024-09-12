package com.example.Export.Service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FileService {

    @Value("${file.upload-dir}")  // The directory where files will be stored
    private String uploadDir;

    // Save files to the local file system
    public void saveFiles(List<MultipartFile> files) throws IOException {
        for (MultipartFile file : files) {
            saveFile(file);
        }
    }

    // Save a single file to the local file system
    public void saveFile(MultipartFile file) throws IOException {
        if (file.isEmpty()) {
            throw new IOException("Cannot save an empty file");
        }

        // Ensure the directory exists
        File dir = new File(uploadDir);
        if (!dir.exists()) {
            dir.mkdirs();
        }

        // Save the file locally
        Path path = Paths.get(uploadDir, file.getOriginalFilename());
        Files.write(path, file.getBytes());
    }

    // Get all file names stored in the local directory
    public List<String> getAllFileNames() {
        try {
            return Files.list(Paths.get(uploadDir))
                        .map(Path::getFileName)
                        .map(Path::toString)
                        .collect(Collectors.toList());
        } catch (IOException e) {
            throw new RuntimeException("Failed to read files from storage directory", e);
        }
    }

    // Retrieve a specific file by name
    public Path getFile(String fileName) {
        Path filePath = Paths.get(uploadDir, fileName);
        if (Files.exists(filePath)) {
            return filePath;
        } else {
            throw new RuntimeException("File not found: " + fileName);
        }
    }

	public void deleteFile(String fileName) throws IOException {
		Path filePath = Paths.get(uploadDir, fileName);

		 if (Files.exists(filePath)) {

		 Files.delete(filePath);

		 } else {

		 throw new IOException("File not found: " + fileName);

		 }
		// TODO Auto-generated method stub
		
	}

	
}



