package itu.mbds.collaborativecommutingapi.controllers;

import itu.mbds.collaborativecommutingapi.enums.Gender;
import itu.mbds.collaborativecommutingapi.enums.UserType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/enums")
public class EnumController {

    @GetMapping("/genders")
    public Gender[] getGenders() {
        return Gender.values();
    }

    @GetMapping("/usertypes")
    public UserType[] getUserTypes() {
        return UserType.values();
    }
}