package com.switchfullywork.funiversity.service;

import com.switchfullywork.funiversity.domain.professor.ProfessorDTO;
import com.switchfullywork.funiversity.domain.professor.ProfessorMapper;
import com.switchfullywork.funiversity.repository.ProfessorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfessorService {

    private final ProfessorRepository professorRepository;
    private final ProfessorMapper professorMapper;


    public ProfessorService(ProfessorRepository professorRepository, ProfessorMapper professorMapper) {
        this.professorRepository = professorRepository;
        this.professorMapper = professorMapper;
    }

    public List<ProfessorDTO> findAll() {
        return professorMapper.toDto(professorRepository.findAll());
    }

    public ProfessorDTO findById(Long id) {
        return professorMapper.toDto(professorRepository.getById(id));
    }

    public void save(ProfessorDTO personDto) {
        professorRepository.save(professorMapper.toProfessor(personDto));
    }

    public void update(ProfessorDTO professorDTO, Long id){
        professorRepository.update(professorMapper.toProfessor(professorDTO), id);
    }

    public void delete(Long id){
        professorRepository.delete(id);
    }
}
