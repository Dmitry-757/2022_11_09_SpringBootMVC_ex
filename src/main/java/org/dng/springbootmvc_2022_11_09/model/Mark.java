package org.dng.springbootmvc_2022_11_09.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "marks_table")
public class Mark {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;


    @ManyToOne
    @JoinColumn(name = "student_id", nullable = false)
//    @NotEmpty(message = "Student must be selected!")
    @NotNull(message = "Student must be selected!")
    private Student student;

    @ManyToOne
    @JoinColumn(name = "subject_id", nullable = false)
//    @NotEmpty(message = "Subject must be selected!")
    @NotNull(message = "Subject must be selected!")
    private Subject subject;

    @Basic
    @Column(nullable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
//    @NotEmpty(message = "Date must be selected!")
    @NotNull(message = "Date must be selected!")
    @PastOrPresent(message = "date must be past or present!")
    private LocalDate date;
    @Basic
    @Column(nullable = false, length = 2)
    //@NotEmpty(message = "Mark must be selected!")

    @Min(value = 1, message = "min mark is 1!")
    @Max(value = 5, message = "max mark is 5!")
    private short mark;

    public short getMark() {
        return mark;
    }

    public void setMark(short mark) {
        this.mark = mark;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }


    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
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
        Mark mark1 = (Mark) o;
        return mark == mark1.mark  && student.equals(mark1.student) && subject.equals(mark1.subject) && date.equals(mark1.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, student, subject, date, mark);
    }
}
