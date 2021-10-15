package com.switchfullywork.funiversity.domain.professor;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProfessorMapper {

    public List<ProfessorDTO> toDto(List<Professor> professorList) {
        return professorList.stream().map(this::toDto).collect(Collectors.toList());
    }
    public ProfessorDTO toDto(Professor professor) {
        ProfessorDTO professorDTO = new ProfessorDTO(professor.getId(), professor.getFirstName(), professor.getLastName());
        return professorDTO;
    }

    //CHEK THIS
    public Professor toProfessor(ProfessorDTO professorDTO) {
        return new Professor(professorDTO.getId(), professorDTO.getFirstName(), professorDTO.getLastName());
    }
}
