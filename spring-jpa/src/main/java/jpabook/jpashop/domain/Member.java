package jpabook.jpashop.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;

@Entity
@Getter
@Setter
public class Member {

    @Id
    @GeneratedValue
    private Long id;
    private String name;

    @Embedded
    private Address address;

    @OneToMany
    private List<Order> orders = new ArrayList<>();
}
