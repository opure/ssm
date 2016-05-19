package com.oneler.annotation.orm;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public abstract class BaseOrm<T> {
    public void save(T t) {
        Class<? extends Object> clazz = t.getClass();
        StringBuffer sql = new StringBuffer();
        sql.append("insert into ");
        Table table = clazz.getAnnotation(Table.class);
        if (table!=null) {
            sql.append(table.tableName());
        } else {
            sql.append(clazz.getName().substring(clazz.getName().lastIndexOf(".")+1));
        }
        sql.append(" (");
        Field[] fields = clazz.getDeclaredFields();
        String temp="";
        StringBuffer stringBuffer = new StringBuffer();
        for (Field field: fields) {
            Column column = field.getAnnotation(Column.class);
            String firstLetter = field.getName().substring(0, 1).toUpperCase();
            String getMethodName ="get"+firstLetter+field.getName().substring(1);
            try {
                Method getMethod = clazz.getMethod(getMethodName,new Class[]{});
                Object value = getMethod.invoke(t, new Object[]{});
                if (field.getType().getName().equals(String.class.getName())) {
                    stringBuffer.append(temp+"'"+value+"'");
                } else {
                    stringBuffer.append(temp+value);
                }
            } catch (Exception e) {
                // TODO: handle exception
            }
            
            if(column !=null) {
                sql.append(temp+column.name());
            } else {
               sql.append(temp+field.getName());
            }
            temp= ",";
        }
        sql.append(")values(");
        sql.append(stringBuffer);
        sql.append(")");
       System.out.println(sql.toString()); 
    }
}
