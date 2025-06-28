package itu.mbds.collaborativecommutingapi.services.user;

import itu.mbds.collaborativecommutingapi.dtos.user.UserDTO;
import itu.mbds.collaborativecommutingapi.dtos.user.UserSignUpDTO;
import itu.mbds.collaborativecommutingapi.entities.User;

import java.util.List;

public interface IUserService {
    User getUserByEmail(String email);
    List<UserDTO> getAll();
    UserDTO getUserById(String id);
    User save(UserSignUpDTO user);
}
