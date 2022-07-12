package shop.applesong.homework.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import shop.applesong.homework.model.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
}