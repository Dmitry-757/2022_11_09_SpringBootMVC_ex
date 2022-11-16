package org.dng.springbootmvc_2022_11_09.Service;

import org.dng.springbootmvc_2022_11_09.DAO.GroupRepository;
import org.dng.springbootmvc_2022_11_09.DAO.StudentsRepository;
import org.dng.springbootmvc_2022_11_09.model.Group;
import org.dng.springbootmvc_2022_11_09.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Service
public class GroupService {
    private final GroupRepository groupRepository;
    private final StudentsRepository studentsRepository;

    @Autowired
    public GroupService(GroupRepository groupRepository, StudentsRepository studentsRepository) {
        this.groupRepository = groupRepository;
        this.studentsRepository = studentsRepository;
    }



    public List<Group> getAll() {
        return (List<Group>) groupRepository.findAll();
    }

    public Optional<Group> getById(long id) {
        return groupRepository.findById(id);
    }


    public void saveOrUpdate(Group item) {
        if (item.getId() != null) {
            Optional<Group> optionalItem = groupRepository.findById(item.getId());
            if (optionalItem.isPresent()) {
                Group editedItem = optionalItem.get();

                if (!editedItem.equals(item)) {
                    editedItem.setName(item.getName());
                    groupRepository.save(editedItem);
                }
            }
        } else {
            groupRepository.save(item);
        }
    }

    public void delete(Long id) {
//        Group group = groupRepository.findById(id).get();
//        Iterator<Student> iter = studentsRepository.findAll().iterator();
//        Student item;
//        while(iter.hasNext()){
//            item = iter.next();
//            if(group.equals(item.getGroup())){
//                item.setGroup(null);
//                studentsRepository.save(item);
//            }
//        }

//        List<Student> stList = studentsRepository.findStudentsByGroupe(groupRepository.findById(id).get());

        int i = studentsRepository.clearGroupInStudentByGroup(id);
//        groupRepository.findById(id).ifPresent(group ->{studentsRepository.findStudentsByGroup(group).forEach(s ->{s.setGroup(null); studentsRepository.save(s);});});
//        studentsRepository.findStudentsByGroup(group).forEach(s ->{s.setGroup(null); studentsRepository.save(s);});

        groupRepository.findById(id).ifPresent(groupRepository::delete);
//        studentsRepository.deleteById(id);
    }

}
