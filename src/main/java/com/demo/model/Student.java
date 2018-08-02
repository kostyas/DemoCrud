package com.demo.model;

import org.hibernate.annotations.Type;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.joda.time.LocalDate;

import java.util.Objects;

@Entity
@Table(name = "student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Size(min = 3, max = 50)
    @Column(name = "NAME", nullable = false)
    private String name;

    @NotNull
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @Column(name = "ENTERING_DATE", nullable = false)
    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentLocalDate")
    private LocalDate localDate;


    @NotNull
    @Column(name = "nationality", nullable = false)
    private String nationality;

    @NotEmpty
    @Column(name = "CODE", unique = true, nullable = false)
    private String code;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getLocalDate() {
        return localDate;
    }

    public void setLocalDate(LocalDate localDate) {
        this.localDate = localDate;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student)) return false;
        Student student = (Student) o;
        return getId() == student.getId() &&
                Objects.equals(getName(), student.getName()) &&
                Objects.equals(getLocalDate(), student.getLocalDate()) &&
                Objects.equals(getNationality(), student.getNationality()) &&
                Objects.equals(getCode(), student.getCode());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getLocalDate(), getNationality(), getCode());
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", localDate=" + localDate +
                ", nationality='" + nationality + '\'' +
                ", code='" + code + '\'' +
                '}';
    }
}
