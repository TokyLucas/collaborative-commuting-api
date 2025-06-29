package itu.mbds.collaborativecommutingapi.controllers;

import itu.mbds.collaborativecommutingapi.dtos.user.UserDTO;
import itu.mbds.collaborativecommutingapi.dtos.user.UserSignInDTO;
import itu.mbds.collaborativecommutingapi.dtos.user.UserRequestDTO;
import itu.mbds.collaborativecommutingapi.entities.User;
import itu.mbds.collaborativecommutingapi.services.jwt.IJwtService;
import itu.mbds.collaborativecommutingapi.services.user.IUserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final IUserService userService;
    private final PasswordEncoder encoder;
    private final IJwtService jwtService;

    @Autowired
    public AuthController(IUserService userService, PasswordEncoder encoder, IJwtService jwtService) {
        this.userService = userService;
        this.encoder = encoder;
        this.jwtService = jwtService;
    }

    @PostMapping("/signup")
    public ResponseEntity<?> signUp(@Valid @RequestBody UserRequestDTO userRequestDTO) {
        if (userService.getUserByEmail(userRequestDTO.getEmail()) != null) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(Map.of("message", "Email déja utilisé"));
        }

        userRequestDTO.setPassword(encoder.encode(userRequestDTO.getPassword()));
        UserDTO createdUser = userService.save(userRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);
    }

    @PostMapping("/signin")
    public ResponseEntity<?> signIn(@Valid @RequestBody UserSignInDTO userSignInDTO) {
        User user = userService.getUserByEmail(userSignInDTO.getEmail());

        if (user == null)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("message", "Aucun compte lié à cet Email"));
        if (!encoder.matches(userSignInDTO.getPassword(), user.getPassword()))
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(Map.of("message", "Mot de passe incorrect"));

        String token = jwtService.generateToken(user.getEmail());
        UserDTO userDTO = userService.getUserById(user.getId());
        return ResponseEntity.ok(Map.of(
            "token", token, "user", userDTO
        ));
    }

    @GetMapping("/test")
    @PreAuthorize("hasRole('PASSAGER')")
    public ResponseEntity<?> test() {
        return ResponseEntity.ok(Map.of("message", "Hello World!"));
    }
}