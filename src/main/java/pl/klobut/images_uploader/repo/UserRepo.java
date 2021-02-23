package pl.klobut.images_uploader.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.klobut.images_uploader.model.User;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {
    User findByLogin(String name);
}
