package com.brainacad.studyproject.data.dao;

import java.util.Collection;

/**
 * Created by ${UArabei}.
 */
public interface CrudDao<E> {

    E get(int id);

    int add(E entity);

    boolean delete(int id);

    boolean update(E entity);

    Collection<E> getAll();

}
