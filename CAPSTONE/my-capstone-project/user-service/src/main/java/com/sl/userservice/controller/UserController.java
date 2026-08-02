package com.sl.userservice.controller;

import com.sl.userservice.model.User;
import com.sl.userservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/login")
    public ResponseEntity<Map<String, Object>> login(@RequestBody Map<String, String> request) {

        String username = request.get("username");
        String password = request.get("password");
        Map<String, Object> response = new HashMap<>();

        Optional<User> userOpt = userRepository.findByUsername(username);
        if (userOpt.isPresent() && userOpt.get().getPassword().equals(password)) {
            User user = userOpt.get();
            response.put("authenticated", true);
            response.put("error", null);
            response.put("user", user);
            return ResponseEntity.ok(response);
        }

        response.put("authenticated", false);
        response.put("error", "Invalid username or password");
        return ResponseEntity.ok(response);
    }


    @PostMapping("/register")
    public ResponseEntity<Map<String, Object>> register(@RequestBody User user) {
        Map<String, Object> response = new HashMap<>();

        if (user.getUsername() == null || user.getUsername().length() < 3) {
            response.put("registered", false);
            response.put("error", "Username must be at least 3 characters long");
            return ResponseEntity.ok(response);
        }

        if (userRepository.findByUsername(user.getUsername()).isPresent()) {
            response.put("registered", false);
            response.put("error", "Username already exists");
            return ResponseEntity.ok(response);
        }

        User savedUser = userRepository.save(user);
        response.put("registered", true);
        response.put("error", null);
        response.put("user", savedUser);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/profile/{username}")
    public ResponseEntity<User> getProfile(@PathVariable String username) {
        return userRepository.findByUsername(username)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/profile")
    public ResponseEntity<Map<String, Object>> updateProfile(@RequestBody User user) {
        Map<String, Object> response = new HashMap<>();
        Optional<User> existingOpt = userRepository.findByUsername(user.getUsername());

        if (existingOpt.isPresent()) {
            User existing = existingOpt.get();
            if (user.getName() != null) existing.setName(user.getName());
            if (user.getEmail() != null) existing.setEmail(user.getEmail());
            if (user.getContact() != null) existing.setContact(user.getContact());
            if (user.getAddress() != null) existing.setAddress(user.getAddress());

            userRepository.save(existing);
            response.put("updated", true);
            response.put("error", "");
            response.put("user", existing);
            return ResponseEntity.ok(response);
        }

        response.put("updated", false);
        response.put("error", "User not found");
        return ResponseEntity.ok(response);
    }

}
