package com.ramel.shop;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.ToString;

@Entity
@ToString
@Getter
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Integer price;

    @Column
    private String title;
}
