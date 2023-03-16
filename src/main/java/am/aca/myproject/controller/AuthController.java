package am.aca.myproject.controller;


import am.aca.myproject.configs.jwt.JwtUtils;
import am.aca.myproject.dto.JwtResponce;
import am.aca.myproject.dto.LoginRequest;
import am.aca.myproject.dto.MessageResponce;
import am.aca.myproject.dto.SignupRequest;
import am.aca.myproject.entity.song.ERole;
import am.aca.myproject.entity.song.Role;
import am.aca.myproject.entity.song.User;
import am.aca.myproject.repository.RoleRepository;
import am.aca.myproject.repository.UserRepository;
import am.aca.myproject.service.UserDetailsImpl;
import am.aca.myproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*", maxAge = 3600)
public class AuthController {


    @Autowired
    UserService userService;


    @PostMapping("/signin")
    public ResponseEntity<?> authUser(@RequestBody LoginRequest loginRequest) {
        return userService.authUser(loginRequest);
    }

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@RequestBody SignupRequest signupRequest) {
        return userService.registerUser(signupRequest);

    }
}
