package service;

import dto.UserDTO;
import repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDTO createUser(UserDTO user) {
        return userRepository.save(user);
    }

    @Override
    public UserDTO updateUser(Long id, UserDTO user) {
        if (!userRepository.existsById(id)) {
            throw new NoSuchElementException("User not found");
        }
        user.setId(id);
        return userRepository.save(user);
    }

    @Override
    public UserDTO getUser(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new NoSuchElementException("User not found"));
    }

    @Override
    public List<UserDTO> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public void deleteUser(Long id) {
        if (!userRepository.existsById(id)) {
            throw new NoSuchElementException("User not found");
        }
        userRepository.deleteById(id);
    }
}
