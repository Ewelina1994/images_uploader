package pl.klobut.images_uploader.gui;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;
import pl.klobut.images_uploader.ImageUploader;

import java.util.ArrayList;
import java.util.List;

@Route("upload")
public class UploadGui extends VerticalLayout {
    private TextField path;
    private Button uploadBtn;
    private Label labelImage;
    private List<Image> images;

    private ImageUploader imageUploader;

    @Autowired
    public UploadGui(ImageUploader imageUploader) {
        this.imageUploader=imageUploader;
        path= new TextField("Path to Image");
        uploadBtn = new Button("Upload");
        labelImage= new Label();
        images= new ArrayList<>();
        add(path);
        add(uploadBtn);
        uploadBtn.addClickListener(clickEvent ->
        {
            String imageUrl = imageUploader.uploadImage(path.getValue());
            Image image = new Image(imageUrl, "brak obrazka");
            images.add(image);
            add(image);
        });
    }
}
