package com.switchfullywork.funiversity.service;

import com.switchfullywork.funiversity.domain.course.Course;
import com.switchfullywork.funiversity.domain.course.CourseDTO;
import com.switchfullywork.funiversity.domain.course.CourseMapper;
import com.switchfullywork.funiversity.repository.CourseRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {

    private final CourseRepository courseRepository;
    private final CourseMapper courseMapper;

    public CourseService(CourseRepository courseRepository, CourseMapper courseMapper) {
        this.courseRepository = courseRepository;
        this.courseMapper = courseMapper;
    }

    public List<Course> findAll(Long amountStudyPoints){
        return courseRepository.findAll(amountStudyPoints);
    }

    public void save(CourseDTO courseDTO){
        courseRepository.save(courseMapper.toCourse(courseDTO));
    }
}
