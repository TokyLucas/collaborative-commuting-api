package itu.mbds.collaborativecommutingapi.controllers;

import itu.mbds.collaborativecommutingapi.dtos.car.CarDTO;
import itu.mbds.collaborativecommutingapi.dtos.user.UserDTO;
import itu.mbds.collaborativecommutingapi.dtos.user.UserRequestDTO;
import itu.mbds.collaborativecommutingapi.entities.User;
import itu.mbds.collaborativecommutingapi.exceptions.EntityNotFoundException;
import itu.mbds.collaborativecommutingapi.security.CustomUserDetails;
import itu.mbds.collaborativecommutingapi.services.car.ICarService;
import itu.mbds.collaborativecommutingapi.services.file.IFileService;
import itu.mbds.collaborativecommutingapi.services.user.IUserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private final IUserService userService;
    private final ICarService carService;
    private final IFileService fileService;
    private final PasswordEncoder encoder;

    @Value(value = "${public.user.profile-dir}")
    private String PROFILE_PIC_UPLOAD_DIR;

    @Autowired
    public UserController(IUserService userService, ICarService carService, IFileService fileService, PasswordEncoder encoder) {
        this.userService = userService;
        this.carService = carService;
        this.fileService = fileService;
        this.encoder = encoder;
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable String id) {
        UserDTO user = userService.getUserById(id);
        return ResponseEntity.ok(user);
    }

    @GetMapping("/me")
    public ResponseEntity<UserDTO> profile(@AuthenticationPrincipal CustomUserDetails userDetails) {
        UserDTO user = userService.getUserById(userDetails.getId());
        return ResponseEntity.ok(user);
    }

    @PutMapping("/profile/{id}")
    @PreAuthorize("#id == authentication.principal.id")
    public ResponseEntity<?> updateUser(@PathVariable String id, @Valid @RequestBody UserRequestDTO userDTO) {
        User emailUser = userService.getUserByEmail(userDTO.getEmail());
        if ( emailUser != null && !Objects.equals(emailUser.getId(), id)) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(Map.of("message", "Email déja utilisé"));
        }
        if(userDTO.getPassword() != null) {
            userDTO.setPassword(encoder.encode(userDTO.getPassword()));
        }
        userService.update(id, userDTO);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
    }

    @PatchMapping("/profile/picture/{id}")
    @PreAuthorize("#id == authentication.principal.id")
    public ResponseEntity<?> updateUserProfilePicture(@PathVariable String id, @RequestParam("profile-picture") MultipartFile profilePicture) {
        try {
            String filePath = fileService.upload(PROFILE_PIC_UPLOAD_DIR, profilePicture);
            String oldProfilePicture = userService.updateProfilePicture(id ,filePath);

            if(oldProfilePicture != null) fileService.delete(oldProfilePicture);

            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Map.of("message", e.getMessage()));
        }
    }

    @GetMapping("/{userId}/cars")
    public ResponseEntity<?> getAllUserCar(@PathVariable String userId) {
        List<CarDTO> cars = carService.getAllByUserId(userId);
        return ResponseEntity.ok(cars);
    }

    @GetMapping("/{userId}/cars/{carId}")
    public ResponseEntity<?> getUserCar(@PathVariable String userId, @PathVariable String carId) {
        CarDTO car = carService.getByUserId(userId, carId);
        return ResponseEntity.ok(car);
    }

    @GetMapping
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<List<UserDTO>> getAllUsers() {
        return ResponseEntity.ok(userService.getAll());
    }

    @GetMapping("/{idCar}/car")
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<CarDTO> getById(@PathVariable String id) {
        return ResponseEntity.ok(carService.getById(id));
    }
}
