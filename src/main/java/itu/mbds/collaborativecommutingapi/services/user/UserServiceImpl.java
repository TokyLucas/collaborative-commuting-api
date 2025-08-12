package itu.mbds.collaborativecommutingapi.services.user;

import itu.mbds.collaborativecommutingapi.dtos.user.UserDTO;
import itu.mbds.collaborativecommutingapi.dtos.user.UserRequestDTO;
import itu.mbds.collaborativecommutingapi.entities.User;
import itu.mbds.collaborativecommutingapi.exceptions.EntityNotFoundException;
import itu.mbds.collaborativecommutingapi.mappers.UserMapper;
import itu.mbds.collaborativecommutingapi.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements IUserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @Override
    public User getUserByEmail(String email) {
        Optional<User> user = userRepository.findByEmail(email);
        return user.orElse(null);
    }

    @Override
    public List<UserDTO> getAll() {
        return List.of();
    }

    @Override
    public UserDTO getUserById(String id) {
        Optional<User> user = userRepository.findById(id);
        return user.map(userMapper::toUserDTO).orElse(null);
    }

    @Override
    public UserDTO save(UserRequestDTO userRequestDTO) {
        return userMapper.toUserDTO(userRepository.save(userMapper.toUser(userRequestDTO)));
    }

    @Override
    public UserDTO update(String id, UserRequestDTO userDTO) {
        Optional<User> user = userRepository.findById(id);
        if (user.isEmpty())
            throw new EntityNotFoundException("User id: " + id + " not found");
        User userExistant = user.get();
        userExistant.setFirstName(userDTO.getFirstName());
        userExistant.setLastName(userDTO.getLastName());
        userExistant.setEmail(userDTO.getEmail());
        if(userDTO.getPassword() != null) {
            userExistant.setPassword(userDTO.getPassword());
        }
        userExistant.setBirthDate(userDTO.getBirthDate());
        userExistant.setGender(userDTO.getGender());
        userExistant.setType(userDTO.getType());

        return userMapper.toUserDTO(userRepository.save(userExistant));
    }

    @Override
    public String updateProfilePicture(String id, String profilePicturePath) {
        Optional<User> user = userRepository.findById(id);
        if (user.isEmpty())
            throw new EntityNotFoundException("User id: " + id + " not found");
        User userExistant = user.get();
        String oldProfilePicture = userExistant.getProfilePicture();
        userExistant.setProfilePicture(profilePicturePath);
        userRepository.save(userExistant);
        return oldProfilePicture;
    }
}
