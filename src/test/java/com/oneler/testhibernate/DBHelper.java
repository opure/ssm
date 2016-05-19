package com.oneler.testhibernate;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.commons.io.filefilter.AndFileFilter;
import org.apache.ibatis.annotations.Update;

public class DBHelper {
    public static final String url = "jdbc:mysql://120.76.79.85:3306/vshop";
    public static final String name = "com.mysql.jdbc.Driver";
    public static final String user = "root";
    public static final String password = "z5link321";

    public Connection conn = null;
    public PreparedStatement pst = null;
    public ResultSet rSet = null;

    public DBHelper(String sql) throws ClassNotFoundException {
        try {
            Class.forName(name);//指定连接类型
            conn = DriverManager.getConnection(url, user, password);//获取连接
            System.out.println(conn);
            pst = conn.prepareStatement(sql);//准备执行语句
             rSet =  pst.executeQuery();
             int i=1;
             while (rSet.next()) {  
                 String uid = rSet.getString(1);  
                 String ufname = rSet.getString(2);  
                String query = "update recipet_sitenavigation set id ="+i+" where recipetid="+ufname + " AND sitenavigationid ="+uid;     
                System.out.println(query);
                pst = conn.prepareStatement(query);
                 int f = pst.executeUpdate();
                 System.out.println(f);
                   i++;   
                    System.out.println(uid + "\t" + ufname + "\t" );  
                }//显示数据  
            } catch (SQLException e) {  
                e.printStackTrace();  
            }  
        }  
            
    public void close() {
        try {
            this.conn.close();
            this.pst.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) throws ReflectiveOperationException {
        System.out.println(new DBHelper("select *from recipet_sitenavigation"));
    }
}
