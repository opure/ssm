package com.oneler.mybatis.models;

public class User {
    private Integer id;

    private String username;

    private Integer userage;

    private String useraddress;

    
    
    public User(Integer id, String username, Integer userage) {
        super();
        this.id = id;
        this.username = username;
        this.userage = userage;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public Integer getUserage() {
        return userage;
    }

    public void setUserage(Integer userage) {
        this.userage = userage;
    }

    public String getUseraddress() {
        return useraddress;
    }

    public void setUseraddress(String useraddress) {
        this.useraddress = useraddress == null ? null : useraddress.trim();
    }
}