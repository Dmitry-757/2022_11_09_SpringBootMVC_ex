package org.dng.springbootmvc_2022_11_09.DAO.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "student_table")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Basic
    @Column(nullable = false, length = 100)
    private String firstName;
    @Basic
    @Column(nullable = false, length = 100)
    private String lastName;
    @Basic
    @Column(nullable = false)
    private long INN;
    @Basic
    @Column(nullable = false, length = 50)
    private String eMail;

    public Student() {
    }

    public Student(String firstName, String lastName, long INN, String eMail) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.INN = INN;
        this.eMail = eMail;
    }

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public long getINN() {
        return INN;
    }

    public void setINN(long INN) {
        this.INN = INN;
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return INN == student.INN && firstName.equals(student.firstName) && lastName.equals(student.lastName) && eMail.equals(student.eMail);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, INN, eMail);
    }
}