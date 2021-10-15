package com.switchfullywork.funiversity.repository;

import com.switchfullywork.funiversity.domain.professor.Professor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class ProfessorRepository {

    private final ConcurrentHashMap<Long, Professor> professorByIdMap;

    public ProfessorRepository() {
        professorByIdMap = new ConcurrentHashMap<>();
        professorByIdMap.put(1L, new Professor(1L, "Sander", "Janssens"));
    }

    public Professor getById(Long id) throws IllegalArgumentException{
        var foundProfessor = professorByIdMap.get(id);
        if(foundProfessor == null) {
            throw new IllegalArgumentException("No Professor could be found for id " + id);
        }
        return foundProfessor;
    }

    public List<Professor> findAll() {
        return new ArrayList<>(professorByIdMap.values());
    }

    public void save(Professor professor){
        professorByIdMap.put(professor.getId(), professor);
    }

    public void update(Professor professor, Long id){
        if(professorByIdMap.containsKey(id)){
            professorByIdMap.put(id, professor);
        }
    }

    public void delete(Long id){
        professorByIdMap.remove(id);
    }
}
