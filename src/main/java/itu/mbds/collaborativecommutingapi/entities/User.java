package itu.mbds.collaborativecommutingapi.entities;

import itu.mbds.collaborativecommutingapi.enums.Gender;
import itu.mbds.collaborativecommutingapi.enums.UserType;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.index.Indexed;


import java.util.Date;

@Document(collection = "users")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class User {
    @Id
    private String id;

    private String lastName;

    private String firstName;

    private Date birthDate;

    private Gender gender;

    @Indexed(unique = true)
    private String email;

    private String password;

    private String profilePicture;

    private UserType type;

    @CreatedDate
    private Date createdAt;

    @LastModifiedDate
    private Date updateAt;
}
