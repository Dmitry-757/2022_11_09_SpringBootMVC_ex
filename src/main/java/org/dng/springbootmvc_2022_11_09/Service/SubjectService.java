package org.dng.springbootmvc_2022_11_09.Service;

import org.dng.springbootmvc_2022_11_09.DAO.MarkRepository;
import org.dng.springbootmvc_2022_11_09.DAO.SubjectRepository;
import org.dng.springbootmvc_2022_11_09.model.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SubjectService {
    private final SubjectRepository repository;

    private final MarkRepository markRepository;

    @Autowired
    public SubjectService(SubjectRepository subjectRepository, MarkRepository markRepository) {
        this.repository = subjectRepository;
        this.markRepository = markRepository;
    }

    public List<Subject> getAll() {
        return (List<Subject>) repository.findAll();
    }

    public Optional<Subject> getById(Long id) {
        return repository.findById(id);
    }

    public void saveOrUpdate(Subject item) {
        if (item.getId() != null) {
            Optional<Subject> optionalItem = repository.findById(item.getId());
            if (optionalItem.isPresent()) {
                Subject editedItem = optionalItem.get();

                if (!editedItem.equals(item)) {
                    editedItem.setName(item.getName());
                    repository.save(editedItem);
                }
            }
        } else {
            repository.save(item);
        }

    }

    public void delete(long id) {
        if (!markRepository.existsById(id)) {
            repository.findById(id).ifPresent(repository::delete);
        }
    }
}
