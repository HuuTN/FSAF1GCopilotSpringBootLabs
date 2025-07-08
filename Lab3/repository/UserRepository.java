package repository;

import dto.UserDTO;
import java.util.List;
import java.util.Optional;

public interface UserRepository {
    UserDTO save(UserDTO user);
    Optional<UserDTO> findById(Long id);
    List<UserDTO> findAll();
    void deleteById(Long id);
    boolean existsById(Long id);
}
