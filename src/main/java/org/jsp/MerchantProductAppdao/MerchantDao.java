package org.jsp.MerchantProductAppdao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.MerchantProductAppDto.Merchant;
import org.MerchantProductAppDto.Product;

public class MerchantDao {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
    EntityManager em=emf.createEntityManager();
    public Merchant saveMerchant(Merchant m) {
        EntityTransaction etran=em.getTransaction();
        etran.begin();
        em.persist(m);
        etran.commit();
        return m;
    }
    public Merchant updateMerchant(Merchant m) {
        EntityTransaction etran=em.getTransaction();
        etran.begin();
        Merchant mdb=em.find(Merchant.class, m.getId());
        if(mdb!=null) {
            mdb.setName(m.getName());
            mdb.setGst_num(m.getGst_num());
            mdb.setEmail(m.getEmail());
            mdb.setPhone(m.getPhone());
            mdb.setPassword(m.getPassword());
            etran.commit();
            return mdb;

        }
        else {
            return null;
        }
    }



    public Merchant findMerchantById(int mid) {

        return em.find(Merchant.class, mid);
    }
    public Merchant findMerchantByEmailAndPassword(String em2, String ps) {
        Query q=em.createQuery("select m from Merchant m where m.email=?1 and m.password=?2");
        q.setParameter(1, em2);
        q.setParameter(2, ps);
        try {
            Merchant mdb=(Merchant)q.getSingleResult();
            return mdb;
        }catch(NoResultException e) {
            return null;
        }

    }
    public Merchant verifyMerchantByPhoneAndPassword(long ph,String ps) {
        Query q=em.createQuery("select m from Merchant m where m.phone=?1 and m.password=?2");
        q.setParameter(1,ph);
        q.setParameter(2, ps);

        try {
            Merchant mdb=(Merchant)q.getSingleResult();
            return mdb;
        }catch(NoResultException e) {
            return null;
        }

    }
    public Merchant Delete(int mid) {
        Merchant d= em.find(Merchant.class, mid);
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
