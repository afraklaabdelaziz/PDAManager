package com.example.pdamanager.Repositories;

import com.example.pdamanager.Entities.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

public class UserRepositoryImpl implements InterfaceRepository<User> {
 private EntityManager entityManager;
    @Override
    public User findByEmail(String email) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("PDAManager");
        entityManager = entityManagerFactory.createEntityManager();
        Query query = entityManager.createQuery("select user from User user where user.email = :x");
        query.setParameter("x",email);
        return (User) query.getResultList();
    }
}
