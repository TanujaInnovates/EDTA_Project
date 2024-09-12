package com.example.Export.controller;

import com.example.Export.Service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Path;
import java.util.List;

//@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/files")
public class FileUploadController {

    @Autowired
    private FileService fileService;

    @PostMapping("/upload")
    public ResponseEntity<?> uploadFiles(@RequestParam("files") List<MultipartFile> files) {
        try {
            if (files.isEmpty()) {
                return ResponseEntity.badRequest().body("No files uploaded");
            }

            // Save files to the service
            fileService.saveFiles(files);

            // Retrieve the names of the uploaded files
            List<String> fileNames = fileService.getAllFileNames();

            return ResponseEntity.ok(fileNames);
        } catch (IOException e) {
            return ResponseEntity.status(500).body("Failed to upload files: " + e.getMessage());
        }
    }

		@GetMapping("/list")
		
		public ResponseEntity<List<String>> listFiles() {
		
		    try {
		
		        List<String> fileNames = fileService.getAllFileNames();
		
		        return ResponseEntity.ok(fileNames);
		
		    } catch (Exception e) {
		
		        return ResponseEntity.status(500).body(null);
		
		    }
		
		}

    @GetMapping("/download/{fileName}")
    public ResponseEntity<Resource> downloadFile(@PathVariable String fileName) {
        try {
            // Retrieve the file path from the service
            Path filePath = fileService.getFile(fileName);

            // Create a resource from the file path
            Resource resource = new UrlResource(filePath.toUri());

            // Check if the resource exists and is readable
            if (!resource.exists() || !resource.isReadable()) {
                return ResponseEntity.status(404).body(null);
            }

            // Return the file as an attachment
            return ResponseEntity.ok()
                    .contentType(MediaType.APPLICATION_OCTET_STREAM)
                    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + fileName + "\"")
                    .body(resource);
        } catch (MalformedURLException e) {
            return ResponseEntity.status(500).body(null);
        }
    }
    @DeleteMapping("/delete/{fileName}")

    public ResponseEntity<String> deleteFile(@PathVariable String fileName) throws IOException {

        fileService.deleteFile(fileName);

		return ResponseEntity.ok("File deleted successfully");

    }



    private String getFileExtension(String fileName) {

        if (fileName != null && fileName.contains(".")) {

            return fileName.substring(fileName.lastIndexOf('.') + 1);

        }

        return "";

    }

    }







      






