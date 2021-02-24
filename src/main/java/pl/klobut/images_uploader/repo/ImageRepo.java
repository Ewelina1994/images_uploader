package pl.klobut.images_uploader.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.klobut.images_uploader.model.Image;

@Repository
public interface ImageRepo extends JpaRepository<Image, Long> {
}
