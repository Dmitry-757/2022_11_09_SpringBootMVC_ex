package org.dng.springbootmvc_2022_11_09;

import org.dng.springbootmvc_2022_11_09.DAO.Student;
import org.dng.springbootmvc_2022_11_09.DAO.StudentsRepository;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ClassStartsAfterApp {
    private final StudentsRepository studentRepository;

    public ClassStartsAfterApp(StudentsRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void doSomethingAfterStartup() {
        //System.out.println("app has just started up");

        Student student = new Student("firstName", "seconfName", 12345678, "e-mail@gmail.com");

        studentRepository.saveAll(List.of(
                new Student("firstName", "seconfName", 12345678, "e-mail@gmail.com"),
                new Student("firstName2", "seconfName2", 12345678, "e-mail2@gmail.com")
                )
        );
    }

}
