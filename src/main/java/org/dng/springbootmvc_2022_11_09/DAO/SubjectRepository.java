package org.dng.springbootmvc_2022_11_09.DAO;

import org.dng.springbootmvc_2022_11_09.model.Subject;
import org.springframework.data.repository.CrudRepository;

public interface SubjectRepository extends CrudRepository<Subject, Long> {

}
