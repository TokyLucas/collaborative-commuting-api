package itu.mbds.collaborativecommutingapi.dtos.car;

import itu.mbds.collaborativecommutingapi.entities.User;
import jakarta.validation.constraints.Min;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.DBRef;

import java.util.Date;

@Data
@Getter @Setter @AllArgsConstructor @NoArgsConstructor @Builder
public class CarDTO {
    private String id;

    private String brand;

    private String model;

    private String color;

    @Min(value = 1)
    private Integer nbPlaces;

    private String user;

    private Date createdAt;

    private Date updateAt;
}
