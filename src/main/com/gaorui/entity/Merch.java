package com.gaorui.entity;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by Administrator on 2017/10/26 0026.
 */
@Entity
public class Merch {
    private String merchid;
    private String name;
    private Float cost;
    private Integer num;
    private String others;
    private Set<Proffer> proffer;

    @Id
    @Column(name = "merchid")
    public String getMerchid() {
        return merchid;
    }

    public void setMerchid(String merchid) {
        this.merchid = merchid;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "cost")
    public Float getCost() {
        return cost;
    }

    public void setCost(Float cost) {
        this.cost = cost;
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
    @Column(name = "others")
    public String getOthers() {
        return others;
    }

    public void setOthers(String others) {
        this.others = others;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Merch merch = (Merch) o;

        if (merchid != null ? !merchid.equals(merch.merchid) : merch.merchid != null) return false;
        if (name != null ? !name.equals(merch.name) : merch.name != null) return false;
        if (cost != null ? !cost.equals(merch.cost) : merch.cost != null) return false;
        if (num != null ? !num.equals(merch.num) : merch.num != null) return false;
        if (others != null ? !others.equals(merch.others) : merch.others != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = merchid != null ? merchid.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (cost != null ? cost.hashCode() : 0);
        result = 31 * result + (num != null ? num.hashCode() : 0);
        result = 31 * result + (others != null ? others.hashCode() : 0);
        return result;
    }

    @OneToMany
    public Set<Proffer> getProffer() {
        return proffer;
    }

    public void setProffer(Set<Proffer> proffer) {
        this.proffer = proffer;
    }
}
