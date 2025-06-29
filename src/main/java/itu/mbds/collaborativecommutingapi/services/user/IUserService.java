package itu.mbds.collaborativecommutingapi.services.user;

import itu.mbds.collaborativecommutingapi.dtos.user.UserDTO;
import itu.mbds.collaborativecommutingapi.dtos.user.UserRequestDTO;
import itu.mbds.collaborativecommutingapi.entities.User;

import java.util.List;

public interface IUserService {
    List<UserDTO> getAll();
    User getUserByEmail(String email);
    UserDTO getUserById(String id);
    UserDTO save(UserRequestDTO user);
    UserDTO update(String id, UserRequestDTO user);
    String updateProfilePicture(String id, String profilePicturePath);
}
