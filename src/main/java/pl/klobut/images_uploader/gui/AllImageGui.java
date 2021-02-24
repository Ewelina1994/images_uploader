package pl.klobut.images_uploader.gui;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import pl.klobut.images_uploader.model.Image;
import pl.klobut.images_uploader.repo.ImageRepo;

import java.util.List;

@Route("gallery")
public class AllImageGui extends VerticalLayout
{
    private List<Image> imageList;
    private ImageRepo imageRepo;

    public AllImageGui(ImageRepo imageRepo) {
        this.imageRepo=imageRepo;
        this.imageList = imageRepo.findAll();
        displayAllImages();
    }

    private void displayAllImages() {
        imageList.stream().forEach(img->{
            com.vaadin.flow.component.html.Image image = new com.vaadin.flow.component.html.Image(img.imageUrl, "I can't find");
            add(image);
        });
    }
}
