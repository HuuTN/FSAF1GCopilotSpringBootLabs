package com.example.serviceImpl;

import org.springframework.stereotype.Service;

import com.example.dto.UserDTO;
import com.example.entity.User;
import com.example.repository.UserRepository;
import com.example.service.UserService;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDTO createUser(UserDTO UserDto) {
        User user = new User();
        user.setName(UserDto.getName());
        user.setEmail(UserDto.getEmail());
        user.setUserRole(UserDto.getUserRole());
        userRepository.save(user);
        return new UserDTO(user.getName(), user.getEmail(), user.getUserRole());
    }

    @Override
    public Page<UserDTO> getAllUsers(Pageable pageable) {
        Page<User> userPage = userRepository.findAll(pageable);
        List<UserDTO> UserDtos = userPage.getContent().stream()
                .map(user -> new UserDTO(user.getName(), user.getEmail(), user.getUserRole()))
                .collect(Collectors.toList());
        return new PageImpl<>(UserDtos, pageable, userPage.getTotalElements());
    }

    @Override
    public UserDTO getUserById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("User with id " + id + " not found"));
        return new UserDTO(user.getName(), user.getEmail(), user.getUserRole());
    }

    @Override
    public UserDTO updateUser(Long id, UserDTO UserDto) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("User with id " + id + " not found"));
        user.setName(UserDto.getName());
        user.setEmail(UserDto.getEmail());
        user.setUserRole(UserDto.getUserRole());
        userRepository.save(user);
        return new UserDTO(user.getName(), user.getEmail(), user.getUserRole());
    }

    @Override
    public void deleteUser(Long id) {
        if (!userRepository.existsById(id)) {
            throw new EntityNotFoundException("User with id " + id + " not found");
        }
        userRepository.deleteById(id);
    }
}
