package com.example.pdamanager.Repositories;

import com.example.pdamanager.Entities.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

public class UserRepositoryImpl implements InterfaceRepository<User> {
EntityManager entityManager ;
    @Override
    public User findByEmail(String email) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("PDAManager");
        entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Query query =entityManager.createQuery("select u from User u where u.email = :email",User.class);
        query.setParameter("email",email);
        entityManager.getTransaction().commit();
        return (User) query.getSingleResult();
    }
}
