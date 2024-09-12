package com.example.Export.controller;

import com.example.Export.Model.userModel;
import com.example.Export.Service.userService;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
//@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true")  // Correct CORS settings
public class userController {

    @Autowired
    private userService userService;

//    @Autowired
//    private PasswordEncoder passwordEncoder;

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody userModel user) {
        if (user.getUsername() == null || user.getPassword() == null) {
            return ResponseEntity.badRequest().body("Username and password are required");
        }
        // Save the user and return success message
        userService.saveUser(user);
        return ResponseEntity.ok("User registered successfully");
    }

//    @PostMapping("/login")
//    public ResponseEntity<String> loginUser(@RequestBody userModel loginRequest) {
//      //  Optional<userModel> user = userService.findByUsername(loginRequest.getUsername());
//
//        // Check if user exists and the password matches
//      //  if (user.isPresent() && passwordEncoder.matches(loginRequest.getPassword(), user.get().getPassword())) {
//            return ResponseEntity.ok("Login successful");
////        } else {
////            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
////        }
//    }
    @PostMapping("/login")
    public ResponseEntity<String> loginUser(@RequestBody userModel loginRequest) {
//        Optional<userModel> user = userService.findByUsername(loginRequest.getUsername());
//
//        // Check if user exists
//        if (user.isPresent()) {
//            // Validate the password
//            if (passwordEncoder.matches(loginRequest.getPassword(), user.get().getPassword())) {
                // Return success message
                return ResponseEntity.ok("Login successful");
//            } else {
                // Invalid password
//                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid password");
//            }
//        } else {
            // User not found
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
//        }
    }
}
