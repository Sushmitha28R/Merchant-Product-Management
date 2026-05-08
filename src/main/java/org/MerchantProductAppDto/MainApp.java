package org.MerchantProductAppDto;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

    public class MainApp {
        public static void main(String[] args) {
            EntityManagerFactory emf=Persistence.createEntityManagerFactory("dev");
            EntityManager em=emf.createEntityManager();
            EntityTransaction etran = em.getTransaction();
            System.out.println(emf);
        }
    }



