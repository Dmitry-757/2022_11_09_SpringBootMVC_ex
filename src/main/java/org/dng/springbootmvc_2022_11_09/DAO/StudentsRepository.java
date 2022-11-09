package org.dng.springbootmvc_2022_11_09.DAO;

import org.springframework.data.repository.CrudRepository;

public interface StudentsRepository extends CrudRepository<Student, Long> {
}
