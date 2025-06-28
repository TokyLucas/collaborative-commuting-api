package itu.mbds.collaborativecommutingapi.dtos.user;

import com.fasterxml.jackson.annotation.JsonFormat;
import itu.mbds.collaborativecommutingapi.enums.Gender;
import itu.mbds.collaborativecommutingapi.enums.UserType;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.Date;

@Data
@Getter @Setter @AllArgsConstructor @NoArgsConstructor @Builder
public class UserRequestDTO {
    @NotBlank(message = "Le nom est obligatoire")
    private String lastName;

    @NotBlank(message = "Le prénom est obligatoire")
    private String firstName;

    @NotNull(message = "La date de naissance est obligatoire")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date birthDate;

    @NotNull(message = "Le sexe est obligatoire")
    private Gender gender;

    @NotBlank(message = "L'email est obligatoire")
    @Email(message = "L'email doit être valide")
    private String email;

    @NotBlank(message = "Le mot de passe est obligatoire")
    @Size(min = 8, message = "Le mot de passe doit contenir au moins 8 caractères")
    private String password;

    @NotNull(message = "Le type est obligatoire")
    private UserType type;
}
