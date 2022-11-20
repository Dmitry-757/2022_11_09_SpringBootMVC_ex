package org.dng.springbootmvc_2022_11_09;

import org.dng.springbootmvc_2022_11_09.DAO.GroupRepository;
import org.dng.springbootmvc_2022_11_09.DAO.SubjectRepository;
import org.dng.springbootmvc_2022_11_09.model.Group;
import org.dng.springbootmvc_2022_11_09.model.Student;
import org.dng.springbootmvc_2022_11_09.DAO.StudentsRepository;
import org.dng.springbootmvc_2022_11_09.model.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ClassStartsAfterApp {
    private final StudentsRepository studentRepository;

    private final GroupRepository groupRepository;
    private final SubjectRepository subjectRepository;

    @Autowired
    public ClassStartsAfterApp(StudentsRepository studentRepository, GroupRepository groupRepository, SubjectRepository subjectRepository) {
        this.studentRepository = studentRepository;
        this.groupRepository = groupRepository;
        this.subjectRepository = subjectRepository;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void doSomethingAfterStartup() {
        //System.out.println("app has just started up");

        Group gr1 = new Group("java-113");
        Group gr2 = new Group("c#-121");
        groupRepository.saveAll(List.of(gr1,
                gr2,
                new Group("mraketing")
        ));


//        Student student = new Student("firstName", "seconfName", 12345678, "e-mail@gmail.com");
        Student st1 = new Student(gr1,"Ivan", "Petrov", 12345678, "e-mail1@gmail.com");
        Student st2 = new Student(gr1,"Vanja", "Pupkin", 87654321, "e-mail2@gmail.com");
        Student st3 = new Student(gr2,"Kolja", "Loshadkin", 10000003, "e-mail3@gmail.com");
        studentRepository.saveAll(List.of(
                st1,
                st2,
                st3
                )
        );

        subjectRepository.saveAll(List.of(
                new Subject("Linear Algebra"),
                new Subject("Discrete maths"),
                new Subject("Marksizm-Leninizm")
        ));

    }

}
