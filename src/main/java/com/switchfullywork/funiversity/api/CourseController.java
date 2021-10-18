package com.switchfullywork.funiversity.api;

import com.switchfullywork.funiversity.domain.course.Course;
import com.switchfullywork.funiversity.domain.course.CourseDTO;
import com.switchfullywork.funiversity.service.CourseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/courses")
public class CourseController {

    public static final Logger logger = LoggerFactory.getLogger(CourseController.class);

    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping(produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public List<Course> findAll(@RequestParam(value = "amountSP") Long amountStudyPoints){
        return courseService.findAll(amountStudyPoints);
    }

    @GetMapping(produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public List<Course> findAll(){
        return courseService.findAll();
    }

    @PostMapping(produces = "application/json", consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public void saveCourse(@RequestBody CourseDTO courseDTO){
        logger.info("Course saved");
        courseService.save(courseDTO);
    }
}
