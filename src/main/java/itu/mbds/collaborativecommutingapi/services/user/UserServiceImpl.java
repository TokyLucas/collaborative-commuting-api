package itu.mbds.collaborativecommutingapi.services.user;

import itu.mbds.collaborativecommutingapi.dtos.user.UserDTO;
import itu.mbds.collaborativecommutingapi.dtos.user.UserSignUpDTO;
import itu.mbds.collaborativecommutingapi.entities.User;
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
    public User save(UserSignUpDTO userSignUpDTO) {
        return userRepository.save(userMapper.toUser(userSignUpDTO));
    }
}
