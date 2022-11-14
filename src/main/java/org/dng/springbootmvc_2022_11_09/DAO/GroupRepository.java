package org.dng.springbootmvc_2022_11_09.DAO;

import org.dng.springbootmvc_2022_11_09.model.Group;
import org.springframework.data.repository.CrudRepository;

public interface GroupRepository extends CrudRepository<Group, Long> {
}
