package jpabook.jpashop.domain.item;

import lombok.Data;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("B")
@Data
public class Album extends Item {

    private String artist;
    private String etd;

}
