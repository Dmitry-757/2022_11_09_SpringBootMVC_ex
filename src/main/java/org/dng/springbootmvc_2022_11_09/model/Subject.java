package org.dng.springbootmvc_2022_11_09.model;



import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name="subjects_table")
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    public Subject() {
    }

    public Subject(String name) {
        this.name = name;
    }

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Subject subject = (Subject) o;
        return name.equals(subject.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
