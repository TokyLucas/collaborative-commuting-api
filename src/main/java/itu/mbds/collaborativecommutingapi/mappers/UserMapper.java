package itu.mbds.collaborativecommutingapi.mappers;

import itu.mbds.collaborativecommutingapi.dtos.user.UserDTO;
import itu.mbds.collaborativecommutingapi.dtos.user.UserRequestDTO;
import itu.mbds.collaborativecommutingapi.entities.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    public User toUser(UserDTO userDTO) {
        User user = new User();
        user.setId(userDTO.getId());
        user.setFirstName(userDTO.getFirstName());
        user.setLastName(userDTO.getLastName());
        user.setEmail(userDTO.getEmail());
        user.setBirthDate(userDTO.getBirthDate());
        user.setGender(userDTO.getGender());
        userDTO.setType(user.getType());
        user.setCreatedAt(userDTO.getCreatedAt());
        user.setUpdateAt(userDTO.getUpdateAt());
        return user;
    }

    public User toUser(UserRequestDTO userDTO) {
        User user = new User();
        user.setFirstName(userDTO.getFirstName());
        user.setLastName(userDTO.getLastName());
        user.setEmail(userDTO.getEmail());
        user.setPassword(userDTO.getPassword());
        user.setBirthDate(userDTO.getBirthDate());
        user.setGender(userDTO.getGender());
        user.setType(userDTO.getType());
        return user;
    }

    public UserDTO toUserDTO(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setFirstName(user.getFirstName());
        userDTO.setLastName(user.getLastName());
        userDTO.setEmail(user.getEmail());
        userDTO.setBirthDate(user.getBirthDate());
        userDTO.setGender(user.getGender());
        userDTO.setType(user.getType());
        userDTO.setCreatedAt(user.getCreatedAt());
        userDTO.setUpdateAt(user.getUpdateAt());
        return userDTO;
    }
}
