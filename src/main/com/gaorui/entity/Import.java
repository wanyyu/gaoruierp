package com.gaorui.entity;

import org.hibernate.annotations.DynamicUpdate;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Administrator on 2017/10/26 0026.
 */
@Entity
@DynamicUpdate(true)
public class Import {
    private String importid;
    private Double price;
    private Integer num;
    private Double totalmoney;

    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date importdate;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date getdate;
    private Integer about;
    private String other;
    private Proffer proffer;
    private Merch merch;
    private User user;

    @Id
    @Column(name = "importid")
    public String getImportid() {
        return importid;
    }

    public void setImportid(String importid) {
        this.importid = importid;
    }

    @Basic
    @Column(name = "price")
    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
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
    @Column(name = "totalmoney")
    public Double getTotalmoney() {
        return totalmoney;
    }

    public void setTotalmoney(Double totalmoney) {
        this.totalmoney = totalmoney;
    }

    @Basic
    @Column(name = "importdate")
    public Date getImportdate() {
        return importdate;
    }

    public void setImportdate(Date importdate) {
        this.importdate = importdate;
    }

    @Basic
    @Column(name = "getdate")
    public Date getGetdate() {
        return getdate;
    }

    public void setGetdate(Date getdate) {
        this.getdate = getdate;
    }

    @Basic
    @Column(name = "about")
    public Integer getAbout() {
        return about;
    }

    public void setAbout(Integer about) {
        this.about = about;
    }

    @Basic
    @Column(name = "other")
    public String getOther() {
        return other;
    }

    public void setOther(String other) {
        this.other = other;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Import anImport = (Import) o;

        if (importid != null ? !importid.equals(anImport.importid) : anImport.importid != null) return false;
        if (price != null ? !price.equals(anImport.price) : anImport.price != null) return false;
        if (num != null ? !num.equals(anImport.num) : anImport.num != null) return false;
        if (totalmoney != null ? !totalmoney.equals(anImport.totalmoney) : anImport.totalmoney != null) return false;
        if (importdate != null ? !importdate.equals(anImport.importdate) : anImport.importdate != null) return false;
        if (getdate != null ? !getdate.equals(anImport.getdate) : anImport.getdate != null) return false;
        if (about != null ? !about.equals(anImport.about) : anImport.about != null) return false;
        if (other != null ? !other.equals(anImport.other) : anImport.other != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = importid != null ? importid.hashCode() : 0;
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + (num != null ? num.hashCode() : 0);
        result = 31 * result + (totalmoney != null ? totalmoney.hashCode() : 0);
        result = 31 * result + (importdate != null ? importdate.hashCode() : 0);
        result = 31 * result + (getdate != null ? getdate.hashCode() : 0);
        result = 31 * result + (about != null ? about.hashCode() : 0);
        result = 31 * result + (other != null ? other.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "profferid", referencedColumnName = "profferid", nullable = false)
    public Proffer getProffer() {
        return proffer;
    }

    public void setProffer(Proffer proffer) {
        this.proffer = proffer;
    }

    @ManyToOne
    @JoinColumn(name = "merchid", referencedColumnName = "merchid", nullable = false)
    public Merch getMerch() {
        return merch;
    }

    public void setMerch(Merch merch) {
        this.merch = merch;
    }

    @ManyToOne
    @JoinColumn(name = "userid", referencedColumnName = "userid", nullable = false)
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
