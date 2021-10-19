package com.switchfullywork.funiversity.api;

import com.switchfullywork.funiversity.domain.course.Course;
import com.switchfullywork.funiversity.domain.course.CourseDTO;
import com.switchfullywork.funiversity.service.CourseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/courses")
@Validated
public class CourseController {

    public static final Logger logger = LoggerFactory.getLogger(CourseController.class);

    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping(produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public List<Course> findAll(@RequestParam(value = "amountSP") Optional<Long> amountStudyPoints){

            return courseService.findAll(amountStudyPoints);

    }

    @PostMapping(produces = "application/json", consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public void saveCourse(@RequestBody @Valid CourseDTO courseDTO){
        courseService.save(courseDTO);
        logger.info("Course saved");
    }
}
