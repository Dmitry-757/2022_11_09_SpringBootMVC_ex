package org.dng.springbootmvc_2022_11_09.DAO;

import org.dng.springbootmvc_2022_11_09.DAO.model.Student;
import org.springframework.data.repository.CrudRepository;

public interface StudentsRepository extends CrudRepository<Student, Long> {
}
