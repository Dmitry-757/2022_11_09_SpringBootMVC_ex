package org.dng.springbootmvc_2022_11_09.DAO;

import javax.persistence.*;

@Entity
@Table(name = "student_table")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(nullable = false, length = 100)
    private String firstName;
    @Column(nullable = false, length = 100)
    private String lastName;
    @Column(nullable = false)
    private long INN;
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
}
