package com.example.Export.Service;

import com.example.Export.Model.userModel;
import com.example.Export.repo.userRepo;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class userService {

    @Autowired
    private userRepo userRepository;

//    @Autowired
//    private PasswordEncoder passwordEncoder;

    // Save the user with the encoded password
    public userModel saveUser(userModel user) {
//        if (user.getPassword() != null) {
//            user.setPassword(passwordEncoder.encode(user.getPassword()));  // Encode password
//        }
        return userRepository.save(user);
    }

    // Find user by username
    public Optional<userModel> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}
