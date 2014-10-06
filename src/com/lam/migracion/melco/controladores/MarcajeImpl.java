/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lam.migracion.melco.controladores;

import com.lam.migracion.melco.dao.ControladorDAO;
import com.lam.migracion.melco.entidades.Marcaje;
import com.lam.migracion.melco.entidades.MarcajePK;
import com.lam.migracion.melco.util.JpaUtil;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

/**
 *
 * @author JoséAntonio
 */
public class MarcajeImpl extends ControladorDAO<Marcaje, Marcaje> implements Serializable {

    public MarcajeImpl() {
        this.emf = JpaUtil.getInstance().createEntityManagerMitsubishi().getEntityManagerFactory();
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    @Override
    public boolean create(Marcaje marcaje) {
        if (marcaje.getMarcajePK() == null) {
            marcaje.setMarcajePK(new MarcajePK());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(marcaje);
            em.getTransaction().commit();
            System.out.println("Marcaje: " + marcaje.getUsuario() + " | " + marcaje.getReferencia());
            return true;
        } catch (Exception ex) {
            return false;
        } finally {
            JpaUtil.getInstance().closeEntityManager(em);
        }
    }

    @Override
    public void edit(Marcaje marcaje) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.merge(marcaje);
            em.getTransaction().commit();
        } catch (Exception ex) {
            JpaUtil.getInstance().rollbackEntityManager(em);
        } finally {
            JpaUtil.getInstance().closeEntityManager(em);
        }
    }

    @Override
    public List<Marcaje> findEntities() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Marcaje find(Marcaje id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Marcaje find(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean remove(Marcaje object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Marcaje find() {
        EntityManager em = null;
        try {
            em = getEntityManager();
            Query q = em.createNamedQuery("Marcaje.findAll").setMaxResults(1);
            return (Marcaje) q.getSingleResult();
        } catch (Exception e) {
            return null;
        } finally {
            JpaUtil.getInstance().closeEntityManager(em);
        }
    }

    @Override
    public List<Marcaje> findEntities(long tiempo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
