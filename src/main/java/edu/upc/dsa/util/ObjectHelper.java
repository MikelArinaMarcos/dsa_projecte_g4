package edu.upc.dsa.util;

import java.lang.reflect.*;

public class ObjectHelper {
    public static String[] getFields(Object entity) {

        Class theClass = entity.getClass();

        Field[] fields = theClass.getDeclaredFields();

        String[] sFields = new String[fields.length];
        int i=0;

        for (Field f: fields) sFields[i++]=f.getName();

        return sFields;

    }


    public static void setter(Object object, String property, Object value) {
        // Method // invoke
        Class clase = null;
        Field field = null;

        try{
            clase = object.getClass();
            //System.out.println("Clase: "+ clase.toString());
            Method[] methods = clase.getDeclaredMethods(); //Array de metodos que imoplican getters/setters
            for (Method m: methods){ //Buscamos todos los metodos de la clase (getter, setters etc)
                if (m.getName().equals("set"+property.substring(0,1).toUpperCase()+property.substring(1))){ //si el metodo m es igual que setName(ponemos la primera en mayus) hace cosas
                    m.invoke(object, value); //employee.setName("pepito")
                }
            }
        }
        catch (Exception e){
            System.out.println ("-!-!-!-!-!ERROR!-!-!-!-!-!");
            e.printStackTrace();
        }

    }

    public static Object getter(Object object, String property)  {
        // Method // invoke
        Class clase = null;
        Field field = null;
        Object value = null;
        try {
            clase = object.getClass();
            System.out.println(clase.toString());
            Method[] methods = clase.getDeclaredMethods();
            for (Method m: methods){
                if (m.getName().equals("get"+property.substring(0,1).toUpperCase()+property.substring(1))){
                    value = m.invoke(object);
                    return value;
                }
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return value;
    }
}
