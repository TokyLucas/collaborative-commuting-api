package itu.mbds.collaborativecommutingapi.entities;

import jakarta.validation.constraints.Min;
import lombok.*;
import org.hibernate.validator.constraints.Range;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "cars")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class Car {
    @Id
    private String id;

    private String brand;

    private String model;

    private String color;

    @Min(value = 1)
    private Integer nbPlaces;

    private String user;

    @CreatedDate
    private Date createdAt;

    @LastModifiedDate
    private Date updateAt;

}
