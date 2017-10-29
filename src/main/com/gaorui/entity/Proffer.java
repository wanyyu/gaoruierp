package com.gaorui.entity;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by Administrator on 2017/10/26 0026.
 */
@Entity
public class Proffer {
    private String profferid;
    private String name;
    private String other;
    private Set<Person> person;

    @Id
    @Column(name = "profferid")
    public String getProfferid() {
        return profferid;
    }

    public void setProfferid(String profferid) {
        this.profferid = profferid;
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

        Proffer proffer = (Proffer) o;

        if (profferid != null ? !profferid.equals(proffer.profferid) : proffer.profferid != null) return false;
        if (name != null ? !name.equals(proffer.name) : proffer.name != null) return false;
        if (other != null ? !other.equals(proffer.other) : proffer.other != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = profferid != null ? profferid.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (other != null ? other.hashCode() : 0);
        return result;
    }

    @OneToMany
    public Set<Person> getPerson() {
        return person;
    }

    public void setPerson(Set<Person> person) {
        this.person = person;
    }
}
