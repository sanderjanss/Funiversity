package com.switchfullywork.funiversity.api;

import com.switchfullywork.funiversity.domain.professor.Professor;
import com.switchfullywork.funiversity.domain.professor.ProfessorDTO;
import com.switchfullywork.funiversity.service.ProfessorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping(path = "/professors")
public class ProfessorController {

    public static final Logger logger = LoggerFactory.getLogger(ProfessorController.class);

    private final ProfessorService professorService;

    public ProfessorController(ProfessorService professorService) {
        this.professorService = professorService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ProfessorDTO> findAll(){
        return professorService.findAll();
    }

    @GetMapping(path = "/{id}", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public ProfessorDTO findById(@PathVariable("id") Long id){
        return professorService.findById(id);
    }

    @PostMapping(produces = "application/json", consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public void saveProfessor(@RequestBody ProfessorDTO professorDTO){
        logger.info("Professor saved");
        professorService.save(professorDTO);
    }

    @PutMapping(path = "/{id}", produces = "application/json", consumes = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public void updateProfessor(@RequestBody ProfessorDTO professorDTO, @PathVariable("id") Long id){
        logger.info("Professor updated");
        professorService.update(professorDTO, id);
    }

    @DeleteMapping(path = "{id}", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public void deleteProfessor(@PathVariable("id")Long id){
        logger.info("Professor deleted");
        professorService.delete(id);
    }


}
