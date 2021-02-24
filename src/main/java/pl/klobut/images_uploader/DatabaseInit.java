package pl.klobut.images_uploader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;
import org.springframework.security.crypto.password.PasswordEncoder;
import pl.klobut.images_uploader.model.User;
import pl.klobut.images_uploader.repo.UserRepo;

@Configuration
public class DatabaseInit {
    @Autowired
    private UserRepo userRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @EventListener(ApplicationReadyEvent.class)
    public void saveUser() {
        User admin = new User("admin", passwordEncoder.encode("AdminJan"), "ADMIN");
        User user = new User("user", passwordEncoder.encode("UserJan"), "USER");
        userRepo.save(admin);
        userRepo.save(user);

    }

}
