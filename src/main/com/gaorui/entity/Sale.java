package com.gaorui.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;

/**
 * Created by Administrator on 2017/11/3 0003.
 */
@Entity
public class Sale {
    private String saleid;
    private Integer num;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date date;
    private Merch merch;
    private Integer about;

    @Id
    @Column(name = "saleid")
    public String getSaleid() {
        return saleid;
    }

    public void setSaleid(String saleid) {
        this.saleid = saleid;
    }

    @Basic
    @Column(name = "num")
    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    @Basic
    @Column(name = "date")
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Basic
    @Column(name = "about")
    public Integer getAbout() {
        return about;
    }

    public void setAbout(Integer about) {
        this.about = about;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Sale sale = (Sale) o;

        if (saleid != null ? !saleid.equals(sale.saleid) : sale.saleid != null) return false;
        if (num != null ? !num.equals(sale.num) : sale.num != null) return false;
        if (date != null ? !date.equals(sale.date) : sale.date != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = saleid != null ? saleid.hashCode() : 0;
        result = 31 * result + (num != null ? num.hashCode() : 0);
        result = 31 * result + (date != null ? date.hashCode() : 0);
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
