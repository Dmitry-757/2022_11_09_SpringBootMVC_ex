package org.dng.springbootmvc_2022_11_09;

import org.dng.springbootmvc_2022_11_09.DAO.GroupRepository;
import org.dng.springbootmvc_2022_11_09.model.Group;
import org.dng.springbootmvc_2022_11_09.model.Student;
import org.dng.springbootmvc_2022_11_09.DAO.StudentsRepository;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ClassStartsAfterApp {
    private final StudentsRepository studentRepository;

    private final GroupRepository groupRepository;

    public ClassStartsAfterApp(StudentsRepository studentRepository, GroupRepository groupRepository) {
        this.studentRepository = studentRepository;
        this.groupRepository = groupRepository;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void doSomethingAfterStartup() {
        //System.out.println("app has just started up");

        Group gr1 = new Group("Group1");
        groupRepository.save(gr1);
        Group gr2 = new Group("Group2");
        groupRepository.save(gr2);


//        Student student = new Student("firstName", "seconfName", 12345678, "e-mail@gmail.com");
        Student st1 = new Student(gr1,"firstName", "seconfName", 12345678, "e-mail1@gmail.com");
        Student st2 = new Student(gr1,"firstName2", "seconfName2", 87654321, "e-mail2@gmail.com");
        Student st3 = new Student(gr2,"firstName3", "seconfName3", 10000003, "e-mail3@gmail.com");
        studentRepository.saveAll(List.of(
                st1,
                st2,
                st3
                )
        );


    }

}
