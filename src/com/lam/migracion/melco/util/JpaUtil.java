/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lam.migracion.melco.util;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

/**
 *
 * @author Antonio
 */
public class JpaUtil {

    private JpaUtil() {
    }

    public static JpaUtil getInstance() {
        return JpaUtilHolder.INSTANCE;
    }

    private static class JpaUtilHolder {

        private static final JpaUtil INSTANCE = new JpaUtil();
    }

    public EntityManager createEntityManagerBiostar() {
        return Persistence.createEntityManagerFactory("BioStarPU").createEntityManager();
    }

    public EntityManager createEntityManagerMitsubishi() {
        return Persistence.createEntityManagerFactory("MelcoPU").createEntityManager();
    }

    public void closeEntityManager(EntityManager em) {
        if (em != null) {
            em.close();
        }
    }

    public void rollbackEntityManager(EntityManager em) {
        if (em != null) {
            em.getTransaction().rollback();
        }
    }
}
