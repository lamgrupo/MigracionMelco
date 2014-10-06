/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lam.migracion.melco.controladores;

import com.lam.migracion.melco.dao.ControladorDAO;
import com.lam.migracion.melco.entidades.EventLog;
import com.lam.migracion.melco.entidades.EventLogPK;
import com.lam.migracion.melco.util.JpaUtil;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

/**
 *
 * @author JoséAntonio
 */
public class EventoImpl extends ControladorDAO<EventLog, EventLogPK> implements Serializable {

    public EventoImpl() {
        this.emf = JpaUtil.getInstance().createEntityManagerBiostar().getEntityManagerFactory();
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    @Override
    public boolean create(EventLog eventLog) {
        if (eventLog.getEventLogPK() == null) {
            eventLog.setEventLogPK(new EventLogPK());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(eventLog);
            em.getTransaction().commit();
            return true;
        } catch (Exception ex) {
            JpaUtil.getInstance().rollbackEntityManager(em);
            return false;
        } finally {
            JpaUtil.getInstance().closeEntityManager(em);
        }
    }

    @Override
    public void edit(EventLog eventLog) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.merge(eventLog);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (em != null) {
                em.getTransaction().rollback();
            }
        } finally {
            JpaUtil.getInstance().closeEntityManager(em);
        }
    }

    @SuppressWarnings("CallToThreadDumpStack")
    @Override
    public boolean remove(EventLogPK idEvent) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            EventLog eventLog;
            try {
                eventLog = em.getReference(EventLog.class, idEvent);
                eventLog.getEventLogPK();
            } catch (Exception e) {
                return false;
            }
            em.remove(eventLog);
            em.getTransaction().commit();
            return true;
        } finally {
            JpaUtil.getInstance().closeEntityManager(em);
        }

    }

    @Override
    public List<EventLog> findEntities(long tiempo) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            Query q = em.createNamedQuery("EventLog.findAll");
            q.setParameter("tiempo", tiempo);
            return q.getResultList();
        } catch (Exception e) {
            return new ArrayList<>();
        } finally {
            JpaUtil.getInstance().closeEntityManager(em);
        }
    }

    @Override
    public EventLog find(EventLogPK id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(EventLog.class, id);
        } finally {
            em.close();
        }
    }

    @Override
    public EventLog find(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public EventLog find() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<EventLog> findEntities() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
