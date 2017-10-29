package com.gaorui.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by Administrator on 2017/10/26 0026.
 */
@Entity
public class Person {
    private Integer personid;
    private String phone;
    private String job;

    @Id
    @Column(name = "personid")
    public Integer getPersonid() {
        return personid;
    }

    public void setPersonid(Integer personid) {
        this.personid = personid;
    }

    @Basic
    @Column(name = "phone")
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Basic
    @Column(name = "job")
    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person person = (Person) o;

        if (personid != null ? !personid.equals(person.personid) : person.personid != null) return false;
        if (phone != null ? !phone.equals(person.phone) : person.phone != null) return false;
        if (job != null ? !job.equals(person.job) : person.job != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = personid != null ? personid.hashCode() : 0;
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + (job != null ? job.hashCode() : 0);
        return result;
    }
}
