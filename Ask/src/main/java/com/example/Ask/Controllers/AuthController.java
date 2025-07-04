package com.example.Ask.Controllers;

import com.example.Ask.Entities.Role;
import com.example.Ask.Entities.User;
import com.example.Ask.Repositories.RoleRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import com.example.Ask.Service.UserService;
import org.springframework.web.bind.annotation.RestController;
import java.util.HashMap;
import java.util.Map;

@RestController
public class AuthController {


    private final BCryptPasswordEncoder passwordEncoder;
    RoleRepository roleRepository;
    UserService userService;
    public AuthController(RoleRepository roleRepository, BCryptPasswordEncoder passwordEncoder) {
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @PostConstruct
    public void setup() {
      Role role_user = new Role("ROLE_USER");
      Role role_admin = new Role("ROLE_ADMIN");
      Role role_doctor = new Role("ROLE_DOCTOR");
      Role role_shelter = new Role("ROLE_SHELTER");

      roleRepository.updateOrInsert(role_user);
      roleRepository.updateOrInsert(role_admin);
      roleRepository.updateOrInsert(role_doctor);
      roleRepository.updateOrInsert(role_shelter);

    }

    @GetMapping("/login")
    public Map<String, String> login() {
        Map<String, String> response = new HashMap<>();
        response.put("message", "Login endpoint (API)");
        return response;
    }
}
