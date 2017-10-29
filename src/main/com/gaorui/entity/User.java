package com.gaorui.entity;

import javax.persistence.*;

/**
 * Created by Administrator on 2017/10/24 0024.
 */
@Entity
@Table(name = "user")
public class User {
    private String id;
    private String loginid;
    private String password;

    @Id
    @Column(name = "userid")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Basic
    @Column(name = "loginid")
    public String getLoginid() {
        return loginid;
    }

    public void setLoginid(String loginid) {
        this.loginid = loginid;
    }

    @Basic
    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (id != null ? !id.equals(user.id) : user.id != null) return false;
        if (loginid != null ? !loginid.equals(user.loginid) : user.loginid != null) return false;
        if (password != null ? !password.equals(user.password) : user.password != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (loginid != null ? loginid.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        return result;
    }
}
