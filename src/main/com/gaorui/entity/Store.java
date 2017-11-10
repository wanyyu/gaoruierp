package com.gaorui.entity;

import javax.persistence.*;

/**
 * Created by Administrator on 2017/11/2 0002.
 */
@Entity
public class Store {
    private String storeid;
    private int num;
    private Merch merch;
    private String other;

    @Id
    @Column(name = "storeid")
    public String getStoreid() {
        return storeid;
    }

    public void setStoreid(String storeid) {
        this.storeid = storeid;
    }

    @Basic
    @Column(name = "other")
    public String getOther() {
        return other;
    }

    public void setOther(String other) {
        this.other = other;
    }

    @Basic
    @Column(name = "num")
    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Store store = (Store) o;

        if (num != store.num) return false;
        if (storeid != null ? !storeid.equals(store.storeid) : store.storeid != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = storeid != null ? storeid.hashCode() : 0;
        result = 31 * result + num;
        return result;
    }

    @OneToOne
    @JoinColumn(name = "merchid", referencedColumnName = "merchid", nullable = false)
    public Merch getMerch() {
        return merch;
    }

    public void setMerch(Merch merch) {
        this.merch = merch;
    }


}
