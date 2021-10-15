package com.switchfullywork.funiversity.domain.course;

import com.switchfullywork.funiversity.domain.professor.Professor;
import com.switchfullywork.funiversity.domain.professor.ProfessorDTO;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CourseMapper {

    public List<CourseDTO> toDto(List<Course> courseList){
        return courseList.stream().map(this::toDto).collect(Collectors.toList());
    }

    public CourseDTO toDto(Course course){
        return new CourseDTO(course.getId(), course.getName(), course.getAmountOfStudyPoints(), course.getProfessor());
    }

    public Course toCourse(CourseDTO courseDTO) {
        return new Course(courseDTO.getId(), courseDTO.getName(), courseDTO.getAmountOfStudyPoints(), courseDTO.getProfessor());
    }
}
