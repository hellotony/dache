package com.example.demo.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author luogeng.szq
 * @version $$Id:University.java, v0.1 2018/1/3 下午3:10 Exp$$
 **/
@Entity
public class University implements Serializable {
    private static final long serialVersionUID = 7267901035283473933L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String area;

    @Column
    private String department;

    @Column
    private String name;

    @Column
    private String remark;

    @Column(name = "school_level")
    private String schoolLevel;

    @Column(name = "school_type")
    private String schoolType;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getSchoolLevel() {
        return schoolLevel;
    }

    public void setSchoolLevel(String schoolLevel) {
        this.schoolLevel = schoolLevel;
    }

    public String getSchoolType() {
        return schoolType;
    }

    public void setSchoolType(String schoolType) {
        this.schoolType = schoolType;
    }

    @Override
    public String toString() {
        return "University{" +
            "id=" + id +
            ", area='" + area + '\'' +
            ", department='" + department + '\'' +
            ", name='" + name + '\'' +
            ", remark='" + remark + '\'' +
            ", schoolLevel='" + schoolLevel + '\'' +
            ", schoolType='" + schoolType + '\'' +
            '}';
    }
}
