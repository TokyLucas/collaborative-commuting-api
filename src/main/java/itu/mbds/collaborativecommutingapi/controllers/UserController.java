package itu.mbds.collaborativecommutingapi.controllers;

import itu.mbds.collaborativecommutingapi.dtos.user.UserDTO;
import itu.mbds.collaborativecommutingapi.dtos.user.UserRequestDTO;
import itu.mbds.collaborativecommutingapi.services.jwt.IJwtService;
import itu.mbds.collaborativecommutingapi.services.user.IUserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private final IUserService userService;
    private final PasswordEncoder encoder;

    @Autowired
    public UserController(IUserService userService, PasswordEncoder encoder) {
        this.userService = userService;
        this.encoder = encoder;
    }

    @GetMapping("/profile/{id}")
    @PreAuthorize("#id == authentication.principal.id")
    public ResponseEntity<UserDTO> getUserById(@PathVariable String id) {
        UserDTO user = userService.getUserById(id);
        return ResponseEntity.ok(user);
    }

    @PutMapping("/profile/{id}")
    @PreAuthorize("#id == authentication.principal.id")
    public ResponseEntity<UserDTO> updateUser(@PathVariable String id, @Valid @RequestBody UserRequestDTO userDTO) {
        userDTO.setPassword(encoder.encode(userDTO.getPassword()));
        userService.update(id, userDTO);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
    }

}
