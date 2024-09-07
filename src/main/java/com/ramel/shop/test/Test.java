package com.ramel.shop.test;

import jakarta.persistence.*;
import lombok.ToString;

import java.util.Date;

@Entity
@ToString
public class Test {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @Column
    public String title;

    @Column
    public Date date;
}
