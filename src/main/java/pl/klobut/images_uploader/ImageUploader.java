package pl.klobut.images_uploader;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import pl.klobut.images_uploader.model.Image;
import pl.klobut.images_uploader.repo.ImageRepo;

import java.io.File;
import java.io.IOException;
import java.util.Map;

@Service
public class ImageUploader {
    private Cloudinary cloudinary;
    @Value("{cloudNameValue}")
    String cloudNameValue;
    @Value("{apiKeyValue}")
    String apiKeyValue;
    @Value("{apiSecretValue}")
    String apiSecretValue;
    private ImageRepo imageRepo;

    @Autowired
    public ImageUploader(ImageRepo imageRepo, @Value("${cloudNameValue}") String cloudNameValue,
                         @Value("${apiKeyValue}") String apiKeyValue,
                         @Value("${apiSecretValue}") String apiSecretValue) {
        this.imageRepo = imageRepo;
        cloudinary = new Cloudinary(ObjectUtils.asMap(
                "cloud_name", cloudNameValue,
                "api_key", apiKeyValue,
                "api_secret", apiSecretValue));
    }

    public String uploadImage(String path) {
        File file = new File(path);
        Map uploadResult = null;
        try {
            uploadResult = cloudinary.uploader().upload(file, ObjectUtils.emptyMap());
            imageRepo.save(new Image());

        } catch (IOException e) {
            e.printStackTrace();
        }
        return uploadResult.get("url").toString();
    }

}
