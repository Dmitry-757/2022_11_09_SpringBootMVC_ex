package org.dng.springbootmvc_2022_11_09.DAO;

import org.dng.springbootmvc_2022_11_09.model.Mark;
import org.springframework.data.repository.CrudRepository;

public interface MarkRepository extends CrudRepository<Mark, Long> {
}
