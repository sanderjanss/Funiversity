package com.switchfullywork.funiversity.repository;

import com.switchfullywork.funiversity.domain.professor.Professor;
import com.switchfullywork.funiversity.exceptions.NoSuchProfessorException;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class ProfessorRepository {

    private final ConcurrentHashMap<Long, Professor> professorByIdDatabase;

    public ProfessorRepository() {
        professorByIdDatabase = new ConcurrentHashMap<>();
        professorByIdDatabase.put(1L, new Professor(1L, "Sander", "Janssens"));
    }

    public Professor getById(Long id) throws IllegalArgumentException{
        if(!professorByIdDatabase.containsKey(id)) {
            throw new NoSuchProfessorException("No Professor could be found for id " + id);
        }
        return professorByIdDatabase.get(id);
    }

    public List<Professor> findAll() {
        return new ArrayList<>(professorByIdDatabase.values());
    }

    public void save(Professor professor){
        professorByIdDatabase.put(professor.getId(), professor);
    }

    public void update(Professor professor, Long id){
        if (!professorByIdDatabase.containsKey(id)) {
            throw new NoSuchProfessorException("No Professor could be updated for id " + id);
        } else {
            professorByIdDatabase.put(id, professor);
        }
    }

    public void delete(Long id){
        if (!professorByIdDatabase.containsKey(id)) {
            throw new NoSuchProfessorException("No Professor could be deleted for id " + id);
        } else {
            professorByIdDatabase.remove(id);
        }
    }
}
