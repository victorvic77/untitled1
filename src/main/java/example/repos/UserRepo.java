package example.repos;

import example.domain.UserAll;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<UserAll, Long> {
    UserAll findByUsername(String username);
}
