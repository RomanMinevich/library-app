package mate.academy.spring.dao;

import java.util.List;
import java.util.Optional;
import mate.academy.spring.entity.User;

public interface UserDao {

    void add(User user);

    User get(Long id);

    Optional<User> findByUsername(String username);

    List<User> listUsers();
}
