package timski.proekt.backend.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import timski.proekt.backend.Model.User;

public interface UserRepository extends JpaRepository<User, Long> {

    String findUserByUsername(String username);
}
