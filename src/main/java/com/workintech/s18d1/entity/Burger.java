package com.workintech.s18d1.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Burger {
    @Id
    private long id;
    @Column(name="name")
    private String name;
    @Column(name="price")
    private double price;
    @Column(name="is_vegan")
    private boolean isVegan;
    @Column(name="bread_type")
    private BreadType breadType;
    @Column (name="contents")
    private String contents;

    public void setIsVegan(boolean isVegan) {
        this.isVegan = isVegan;
    }

    public boolean getIsVegan() {
        return this.isVegan;
    }

}
