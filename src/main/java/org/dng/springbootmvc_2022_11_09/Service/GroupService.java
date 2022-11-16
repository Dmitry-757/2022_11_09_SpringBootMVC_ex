package org.dng.springbootmvc_2022_11_09.Service;

import org.dng.springbootmvc_2022_11_09.DAO.GroupRepository;
import org.dng.springbootmvc_2022_11_09.model.Group;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GroupService {
    private final GroupRepository groupRepository;
    @Autowired
    public GroupService(GroupRepository groupRepository) {
        this.groupRepository = groupRepository;
    }


    public List<Group> getAll() {
        return (List<Group>) groupRepository.findAll();
    }

    public Optional<Group> getById(long id){
        return groupRepository.findById(id);
    }


    public void saveOrUpdate(Group item) {
        Optional<Group> optionalItem = groupRepository.findById(item.getId());
        if (optionalItem.isPresent()) {
            Group editedItem = optionalItem.get();

            if(!editedItem.equals(item)){
                editedItem.setName(item.getName());
                groupRepository.save(editedItem);
            }
        }else {
            groupRepository.save(item);
        }
    }

    public void delete(Long id) {
        groupRepository.findById(id).ifPresent(groupRepository::delete);
//        studentsRepository.deleteById(id);
    }

}
