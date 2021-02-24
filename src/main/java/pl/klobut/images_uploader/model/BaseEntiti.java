package pl.klobut.images_uploader.model;

import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
// Choose your inheritance strategy:
//@Inheritance(strategy=InheritanceType.JOINED)
//@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@Inheritance(strategy= InheritanceType.TABLE_PER_CLASS)
public abstract class BaseEntiti {
    @Id
    @GeneratedValue
    private Long id;
}
