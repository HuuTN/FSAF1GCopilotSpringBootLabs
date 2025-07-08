package repository;

import dto.UserDTO;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class InMemoryUserRepository implements UserRepository {
    private final Map<Long, UserDTO> users = new ConcurrentHashMap<>();
    private long idCounter = 1;

    @Override
    public UserDTO save(UserDTO user) {
        if (user.getId() == null) {
            user.setId(idCounter++);
        }
        users.put(user.getId(), user);
        return user;
    }

    @Override
    public Optional<UserDTO> findById(Long id) {
        return Optional.ofNullable(users.get(id));
    }

    @Override
    public List<UserDTO> findAll() {
        return new ArrayList<>(users.values());
    }

    @Override
    public void deleteById(Long id) {
        users.remove(id);
    }

    @Override
    public boolean existsById(Long id) {
        return users.containsKey(id);
    }
}
