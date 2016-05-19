package com.oneler.annotation.orm;

@Table(tableName = "user")
public class User {
    private int userId;
    private String userName;
    @Column(name="id",isPrimaryKey=true)
    public int getUserId() {
        return userId;
    }
    public void setUserId(int userId) {
        this.userId = userId;
    }
    @Column(name="username")
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    

}
