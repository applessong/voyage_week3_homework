package shop.applesong.homework.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface HomeworkRepository extends JpaRepository<Homework, Long> {
    List<Homework> findAllByOrderByModifiedAtDesc();
    Optional<Homework> findByTitleAndContentsAndUsernameAndPasswordAndCreatedAt(String title, String contents, String username, String password, LocalDateTime createdAt);
}