package lab3_20250708.src.main.java.com.example.usermanagement.service;

import com.example.usermanagement.dto.UserDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserService {
    Page<UserDTO> getAllUsers(Pageable pageable);
    UserDTO getUserById(Long id);
    UserDTO createUser(UserDTO userDTO);
} 