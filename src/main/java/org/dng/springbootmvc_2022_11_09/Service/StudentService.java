package org.dng.springbootmvc_2022_11_09.Service;

import org.dng.springbootmvc_2022_11_09.DAO.StudentsRepository;
import org.dng.springbootmvc_2022_11_09.DAO.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

//    можно вот так (поле не должно быть final ! - внедрение не получится так как оно происходит уже после создания)
//    @Autowired
//    private AlbumRepository albumRepository;

    //but if we want to have "final" field - we need to use constructor for initialization
    private final StudentsRepository studentsRepository;
    @Autowired
    public StudentService(StudentsRepository albumRepository) {
        this.studentsRepository = albumRepository;
    }

    public List<Student> getAll() {
        return (List<Student>) studentsRepository.findAll();
    }

    public Optional<Student> getById(long id){
        return studentsRepository.findById(id);
    }
    public void add(Student item) {
        System.out.println(item);
        studentsRepository.save(item);
    }


    public void update(Student item) {
        Optional<Student> optionalItem = studentsRepository.findById(item.getId());
        if (optionalItem.isPresent()) {
            Student editedItem = optionalItem.get();

            if(!editedItem.equals(item)){
                editedItem.setFirstName(item.getFirstName());
                editedItem.setLastName(item.getLastName());
                editedItem.setINN(item.getINN());
                editedItem.seteMail(item.geteMail());
                studentsRepository.save(editedItem);
            }
        }
    }

    public void delete(Long id) {
        studentsRepository.findById(id).ifPresent(studentsRepository::delete);
//        studentsRepository.deleteById(id);
    }

}
