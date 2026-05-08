package org.jsp.MerchantProductAppdao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.MerchantProductAppDto.Merchant;
import org.MerchantProductAppDto.Product;
public class ProductDao {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
    EntityManager em=emf.createEntityManager();
    public Product addProduct(int mid, Product p) {
        EntityTransaction etran=em.getTransaction();
        etran.begin();
        Merchant mdb=em.find(Merchant.class, mid);
        if(mdb!=null) {
            p.setM(mdb);
            mdb.getProds().add(p);
            em.persist(p);
            etran.commit();
            return p;
        }
        else {
            return null;
        }}
    public Product updateProduct(Product p) {

        EntityTransaction etran=em.getTransaction();
        etran.begin();
        Product mdb=em.find(Product.class, p.getId());
        if(mdb!=null) {

            mdb.setName(p.getName());
            mdb.setBrand(p.getBrand());
            mdb.setCategory(p.getCategory());
            mdb.setCost(p.getCost());
            etran.commit();
            return mdb;

        }
        else {
            return null;
        }
    }

    public Product addProduct(Product p) {
        EntityTransaction etran=em.getTransaction();
        etran.begin();
        em.persist(p);
        etran.commit();
        return p;
    }


    public Product FindProductById(int mid) {
        return em.find(Product.class, mid);
    }
    public Product FindProductByBrandAndCategory(String br, String ca) {

        Query q=em.createQuery("select m from Product m where m.brand=?1 and m.category=?2");
        q.setParameter(1, br);
        q.setParameter(2, ca);
        try {
            Product mdb=(Product)q.getSingleResult();
            return mdb;
        }catch(NoResultException e) {
            return null;
        }

    }
    public List<Product> findProductByMerchantId(int mid) {
        Query q = em.createQuery("select m.prods from Merchant m where m.id=?1");
        q.setParameter(1, mid);
        List<Product> lp=q.getResultList();
        return lp;
    }


    public Product Delete(int mid) {
        Product d= em.find(Product.class, mid);
        if(d!=null) {
            EntityTransaction etran=em.getTransaction();
            etran.begin();
            em.remove(d);
            etran.commit();
            return d;

      }
        else {
            return null;
        }
    }
}
