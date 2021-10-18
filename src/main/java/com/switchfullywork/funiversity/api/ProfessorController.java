package com.switchfullywork.funiversity.api;

import com.switchfullywork.funiversity.domain.professor.ProfessorDTO;
import com.switchfullywork.funiversity.service.ProfessorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<ProfessorDTO> saveProfessor(@RequestBody ProfessorDTO professorDTO){
        professorService.save(professorDTO);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-type", "application/json");
        logger.info("Professor saved");
        return new ResponseEntity<>(professorDTO, headers, HttpStatus.CREATED);
    }

    @PutMapping(path = "/{id}", produces = "application/json", consumes = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public void updateProfessor(@RequestBody ProfessorDTO professorDTO, @PathVariable("id") Long id){
            professorService.update(professorDTO, id);
            logger.info("Professor updated");
    }

    @DeleteMapping(path = "{id}", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public void deleteProfessor(@PathVariable("id")Long id){
            professorService.delete(id);
            logger.info("Professor deleted");
    }


}
