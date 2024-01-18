package edu.upc.dsa.bbdd;

import java.util.HashMap;
import java.util.List;

public interface Sesion<E> {


    void save(Object entity);
    void close();
    void clean();

    Object get(Class theClass, String pk, Object value);
    /*Object get(Class theClass, String mail);*/
    void update(Object object, String mail);
    //void delete(Object object);
    List<Object> findAll(Class theClass);
    List<Object> findAll(Class theClass, HashMap params);
    List<Object> query(String query, Class theClass, HashMap params);
    public List<Object> findByParams(Object entity, HashMap params);
    public int delete(Object object,String pk,Object value);
}
