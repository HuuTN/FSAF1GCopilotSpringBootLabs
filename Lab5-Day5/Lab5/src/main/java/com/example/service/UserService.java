package com.example.service;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.dto.UserDTO;

public interface UserService {
    UserDTO createUser(UserDTO UserDTO);
    Page<UserDTO> getAllUsers(Pageable pageable);
    UserDTO getUserById(Long id);
    UserDTO updateUser(Long id, UserDTO UserDTO);
    void deleteUser(Long id);
}
