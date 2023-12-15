package edu.upc.dsa.bbdd;

import edu.upc.dsa.models.Usuario;
import edu.upc.dsa.util.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SesionImpl implements Sesion {
    private final Connection conn;

    public SesionImpl(Connection conn) {
        this.conn = conn;
    }
    public void save(Object entity) {

        String insertQuery = QueryHelper.createQueryINSERT(entity);

        System.out.println(insertQuery);

        PreparedStatement pstm = null;

        try {
            pstm = conn.prepareStatement(insertQuery);
            int i = 1;
            //System.out.println("Entramos al bucle que ahce cosas del save");
            for (String field: ObjectHelper.getFields(entity)) {
                pstm.setObject(i++, ObjectHelper.getter(entity, field));
            }
            System.out.println("!-!-!-!-!-!-!-! SENTENCIA!-!-!-!-!-!-!-!");
            System.out.println(pstm);
            pstm.executeQuery();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void close() {

    }

    @Override
    public void clean() {
        String query = "TRUNCATE TABLE usuario";
        try {
            PreparedStatement pstm = conn.prepareStatement(query);
            pstm.executeQuery(); //Aqui en teoria limpiamos Usuario
            /*query = "TRUNCATE TABLE deparment";
            pstm = conn.prepareStatement(query);
            pstm.executeQuery(); //Aqui limpiamos deparment*/
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Object get(Class theClass, String pk, Object value) {
        String selectQuery  = QueryHelper.createQuerySELECT(theClass, pk);
        ResultSet rs;
        PreparedStatement pstm = null;
        boolean empty = true;

        try {
            pstm = conn.prepareStatement(selectQuery);
            pstm.setObject(1, value);
            rs = pstm.executeQuery();

            ResultSetMetaData rsmd = rs.getMetaData();
            //
            int numberOfColumns = rsmd.getColumnCount();
            //
            Object o = theClass.newInstance();
            //
            Object valueColumn = null;
            while (rs.next()){
                for (int i=1; i<=numberOfColumns; i++){
                    String columnName = rsmd.getColumnName(i);
                    ObjectHelper.setter(o, columnName, rs.getObject(i));
                    System.out.println(columnName);
                    System.out.println(rs.getObject(i));
                    valueColumn = rs.getObject(i);

                }
            }
            return o;

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }

        return Usuario.class;
    }

/*
    @Override
    public Object get(Class theClass, String mail) { //Aqui el mateix que el save pero amb la query del select
        try {
            Object entity = theClass.newInstance();

        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
        return null;
    }*/
@Override
    public void update(Object object, int id) {
        String updateQuery  = QueryHelper.createQueryUPDATE(object);
        PreparedStatement ptsm = null;
        try {
            ptsm = conn.prepareStatement(updateQuery);
            int i = 1;
            for (String field : ObjectHelper.getFields(object)) {
                ptsm.setObject(i++, ObjectHelper.getter(object, field));
            }
            ptsm.setObject(i,id);
            ptsm.executeQuery();
            System.out.println("SENTENCIA UPDATE\n"+ptsm);
        }
        catch (Exception e) {
            e.printStackTrace();
        }

    }


@Override
    public int delete(Object object, HashMap params) {
        String deleteQuery = QueryHelper.createQueryDELETE(object,params);
        PreparedStatement pstm = null;
        try{
            pstm = conn.prepareStatement(deleteQuery);
            System.out.println("SENTENCIA DELETE:\n"+pstm);

            int i=1;
            for (Object value : params.values()) {
                pstm.setObject(i,value.toString());
                i++;
            }

            System.out.println("SENTENCIA DELETE:\n"+pstm);
            pstm.executeQuery();
            return 1;
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }
    /*Crea una lista de los objetos que pasamos como parametro (relamente pasamos una clase?)*/
    public List<Object> findAll(Class theClass) {
        String findQuery = QueryHelper.createQuerySELECTAll(theClass);
        System.out.println(findQuery);
        List<Object> listaObjeto = new ArrayList<Object>();
        PreparedStatement pstm = null;

        try {
            pstm = conn.prepareStatement(findQuery);
            pstm.setObject(1,1);
            System.out.println("!-!-!-!-!-!-!-! SENTENCIA !-!-!-!-!-!-!-!");
            System.out.println(pstm);
            pstm.executeQuery();
            ResultSet rs = pstm.getResultSet();
            while(rs.next()){
                Object o = theClass.getDeclaredConstructor().newInstance();
                for(int i = 1; i <= rs.getMetaData().getColumnCount(); i++){
                    ObjectHelper.setter(o,rs.getMetaData().getColumnName(i),rs.getObject(i));
                }
                listaObjeto.add(o);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return listaObjeto;
    }

    public List<Object> findAll(Class theClass, HashMap params) {
        return null;
    }

    public List<Object> query(String query, Class theClass, HashMap params) {
        return null;
    }

    public List<Object> findByParams(Object entity, HashMap params){
        String findQuery = QueryHelper.createQuerySELECTByParams(entity,params);
        PreparedStatement pstm = null;
        List<Object> objectList = new ArrayList<Object>();
        try {
            pstm = conn.prepareStatement(findQuery);
            int x = 1;
            for (Object value : params.values()) {
                pstm.setObject(x,value.toString());
                x++;
            }
            System.out.println("QUERY DEL findByParams\n" + pstm.toString());
            pstm.executeQuery();
            ResultSet rs = pstm.getResultSet();
            while (rs.next()){
                Object o = entity.getClass().newInstance();
                for(int i = 1; i<=rs.getMetaData().getColumnCount();i++){
                    ObjectHelper.setter(o,rs.getMetaData().getColumnName(i), rs.getObject(i));
                }
                objectList.add(o);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return objectList;
    }
}
