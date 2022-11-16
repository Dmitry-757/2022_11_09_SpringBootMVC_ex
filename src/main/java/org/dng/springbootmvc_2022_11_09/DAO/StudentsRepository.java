package org.dng.springbootmvc_2022_11_09.DAO;

import org.dng.springbootmvc_2022_11_09.model.Group;
import org.dng.springbootmvc_2022_11_09.model.Student;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface StudentsRepository extends CrudRepository<Student, Long> {
    List<Student> findStudentsByGroup(Group item);

    @Query("select s from Student s where s.group = ?1")
    List<Student> findStudentsByGroupe(Group group);

    @Transactional
    @Modifying
    @Query(value = "UPDATE student_table SET group_id=NULL WHERE group_id=?1", nativeQuery = true)
    int clearGroupInStudentByGroup(long id);

}
