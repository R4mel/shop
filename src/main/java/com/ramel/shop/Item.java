package com.ramel.shop;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@ToString
@Getter
@NoArgsConstructor
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Integer price;

    @Column
    private String title;

    public Item(Long id, Integer price, String title) {
        this.id = id;
        this.price = price;
        this.title = title;
    }
}
