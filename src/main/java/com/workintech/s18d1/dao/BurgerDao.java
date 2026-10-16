package com.workintech.s18d1.dao;

import com.workintech.s18d1.entity.BreadType;
import com.workintech.s18d1.entity.Burger;

import java.util.List;

public interface BurgerDao {
    Burger save(Burger burger);
    Burger update(Burger burger);
    Burger remove(long id);
    List<Burger> findAll();
    Burger findById(long id);
    List<Burger> findByPrice(double price);
    List<Burger> findByContent(String name);
    List<Burger> findByBreadType(BreadType breadType);
}
