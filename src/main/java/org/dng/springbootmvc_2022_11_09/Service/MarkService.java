package org.dng.springbootmvc_2022_11_09.Service;

import org.dng.springbootmvc_2022_11_09.DAO.MarkRepository;
import org.dng.springbootmvc_2022_11_09.model.Mark;
import org.dng.springbootmvc_2022_11_09.model.Student;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MarkService {
    private final MarkRepository repository;

    public MarkService(MarkRepository repository) {
        this.repository = repository;
    }

    public List<Mark> getAll() {
        return (List<Mark>) repository.findAll();
    }

    public Optional<Mark> getById(long id) {
        return repository.findById(id);
    }

    public void saveOrUpdate(Mark item) {
        if (item.getId() != null) {
            Optional<Mark> optionalItem = repository.findById(item.getId());
            if (optionalItem.isPresent()) {
                Mark editedItem = optionalItem.get();

                if (!editedItem.equals(item)) {
                    editedItem.setStudent(item.getStudent());
                    editedItem.setSubject(item.getSubject());
                    editedItem.setDate(item.getDate());
                    editedItem.setMark(item.getMark());
                    repository.save(editedItem);
                }
            }
        } else {
            repository.save(item);
        }

    }

    public void delete(long id) {
//        int i = studentsRepository.clearGroupInStudentByGroup(id);
//        groupRepository.findById(id).ifPresent(group ->{studentsRepository.findStudentsByGroup(group).forEach(s ->{s.setGroup(null); studentsRepository.save(s);});});
//        studentsRepository.findStudentsByGroup(group).forEach(s ->{s.setGroup(null); studentsRepository.save(s);});

        repository.findById(id).ifPresent(repository::delete);

    }
}
