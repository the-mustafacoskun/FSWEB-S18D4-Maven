package com.workintech.s18d1.dao;

import com.workintech.s18d1.entity.BreadType;
import com.workintech.s18d1.entity.Burger;
import com.workintech.s18d1.exceptions.BurgerException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class BurgerDaoImpl implements BurgerDao {

    EntityManager entityManager;
    @Autowired
    public BurgerDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public Burger save(Burger burger) {
//        if(burger == null ){
//            throw new BurgerException("Burger cannot be null", HttpStatus.BAD_REQUEST);
//        }else{
//            TypedQuery query = entityManager.createQuery("SELECT b FROM Burger b WHERE b.name=:name", Burger.class);
//            query.setParameter("name", burger.getName());
//            if(query.getResultList().isEmpty()){
//                entityManager.persist(burger);
//            }else{
//                throw new BurgerException("This product already exist", HttpStatus.BAD_REQUEST);
//            }
//            return burger;
//        }
        entityManager.persist(burger);
        return burger;

    }

    @Override
    @Transactional
    public Burger update(Burger burger) {
        if(burger == null ){
            throw new BurgerException("Burger cannot be null", HttpStatus.BAD_REQUEST);
        }
        entityManager.merge(burger);

        return burger;
    }

    @Override
    @Transactional
    public Burger remove(long id) {
        if(id <= 0){
            throw new BurgerException("Burger id must be greater than zero", HttpStatus.BAD_REQUEST);
        }
        Burger burger = entityManager.find(Burger.class, id);
        if(burger == null){
            throw new BurgerException("Burger not found", HttpStatus.NOT_FOUND);
        }
        entityManager.remove(burger);
        return burger;
    }

    @Override
    public List<Burger> findAll() {
        TypedQuery query = entityManager.createQuery("SELECT b FROM Burger b", Burger.class);
        return query.getResultList();
    }

    @Override
    public Burger findById(long id) {
        if(id <= 0){
            throw new BurgerException("Burger id must be greater than zero", HttpStatus.BAD_REQUEST);
        }
        Burger burger = entityManager.find(Burger.class, id);
        if(burger == null){
            throw new BurgerException("Burger not found", HttpStatus.NOT_FOUND);
        }
        return burger;
    }

    @Override
    public List<Burger> findByPrice(double price) {
        if(price <= 0){
            throw new BurgerException("Price must be greater than zero", HttpStatus.BAD_REQUEST);
        }
        TypedQuery query = entityManager.createQuery("SELECT b FROM Burger b WHERE b.price>price ORDER BY b.price DESC", Burger.class);
        query.setParameter("price", price);
        return query.getResultList();
    }

    @Override
    public List<Burger> findByContent(String name) {
        if(name == null || name.isEmpty()){
            throw new BurgerException("Burger content name cannot be null", HttpStatus.BAD_REQUEST);
        }
        TypedQuery query = entityManager.createQuery("SELECT b FROM Burger b WHERE b.name=:name", Burger.class);
        query.setParameter("name", name);
        return query.getResultList();
    }

    @Override
    public List<Burger> findByBreadType(BreadType breadType) {
        TypedQuery query = entityManager.createQuery("SELECT b FROM Burger b WHERE b.breadType=:breadType", Burger.class);
        query.setParameter("breadType", breadType);
        return query.getResultList();
    }
}
