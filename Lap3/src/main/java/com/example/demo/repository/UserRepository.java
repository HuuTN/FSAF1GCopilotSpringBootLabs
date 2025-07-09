package com.example.demo.repository;

import com.example.demo.dto.UserDTO;
import java.util.*;

public interface UserRepository {
    UserDTO save(UserDTO user);
    Optional<UserDTO> findById(Long id);
    List<UserDTO> findAll();
    void deleteById(Long id);
    boolean existsById(Long id);
}
