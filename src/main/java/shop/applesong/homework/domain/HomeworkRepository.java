package shop.applesong.homework.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface HomeworkRepository extends JpaRepository<Homework, Long> {
    List<Homework> findAllByOrderByModifiedAtDesc();
    Optional<Homework> findByTitleAndContentsAndUsernameAndPassword(String title, String contents, String username, String password);
}