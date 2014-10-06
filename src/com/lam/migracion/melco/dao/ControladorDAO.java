/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lam.migracion.melco.dao;

import java.util.List;

/**
 *
 * @author JoséAntonio
 */
public abstract class ControladorDAO<T, t> {

    public abstract boolean create(T object);

    public abstract void edit(T Object);

    public abstract List<T> findEntities();

    public abstract List<T> findEntities(long tiempo);

    public abstract T find();

    public abstract T find(t id);

    public abstract T find(int id);

    public abstract boolean remove(t object);
}
