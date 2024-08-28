package com.ramel.shop;

import lombok.Getter;

@Getter
public class Test2 {
    private String name;
    private Integer age;

    public void agePlus() {
        this.age++;
    }

    public void setAge(Integer a) {
        if (a > 0 && a <= 100)
            this.age = a;
    }
}
