package service;

import dto.UserDTO;
import java.util.List;

public interface UserService {
    UserDTO createUser(UserDTO user);
    UserDTO updateUser(Long id, UserDTO user);
    UserDTO getUser(Long id);
    List<UserDTO> getAllUsers();
    void deleteUser(Long id);
}
