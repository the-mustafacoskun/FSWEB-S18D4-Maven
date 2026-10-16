package com.workintech.s18d1.controller;


import com.workintech.s18d1.dao.BurgerDaoImpl;
import com.workintech.s18d1.entity.BreadType;
import com.workintech.s18d1.entity.Burger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@Controller
@RequestMapping("/burgers")
public class BurgerController {
    private BurgerDaoImpl burgerDaoImpl;

    @Autowired
    public BurgerController(BurgerDaoImpl burgerDaoImpl) {
        this.burgerDaoImpl = burgerDaoImpl;
    }

    @GetMapping
    public List<Burger> getBurgers() {
        return burgerDaoImpl.findAll();
    }

    @GetMapping("/{id}")
    public Burger getBurgerById(@PathVariable long id) {
        return burgerDaoImpl.findById(id);
    }

    @PostMapping
    public Burger saveBurger(@RequestBody Burger burger) {
         burgerDaoImpl.save(burger);
         return burger;
    }

    @PutMapping("/{id}")
    public Burger updateBurger(@PathVariable long id, @RequestBody Burger burger) {
        return burgerDaoImpl.update(burger);
    }

    @DeleteMapping("/{id}")
    public Burger deleteBurger(@PathVariable long id) {
        burgerDaoImpl.remove(id);
        return burgerDaoImpl.findById(id);
    }

    @GetMapping("/findByPrice")
    public List<Burger> findByPrice(@RequestParam double price) {
        return burgerDaoImpl.findByPrice(price);
    }

    @GetMapping("/findByBreadType")
    public List<Burger> findByBreadType(@RequestParam BreadType breadType) {
        return burgerDaoImpl.findByBreadType(breadType);
    }

    @GetMapping("/findByContent")
    public List<Burger> findByContent(@RequestParam String content) {
        return burgerDaoImpl.findByContent(content);
    }


}
