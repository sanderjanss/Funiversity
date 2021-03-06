package com.switchfullywork.funiversity.repository;

import com.switchfullywork.funiversity.domain.course.Course;
import com.switchfullywork.funiversity.domain.professor.Professor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class CourseRepository {

    private final ConcurrentHashMap<Long, Course> courseByIdDatabase;

    public CourseRepository() {
        this.courseByIdDatabase = new ConcurrentHashMap<>();
        courseByIdDatabase.put(1L, new Course(1L, "Java", 3, new Professor(1L, "Sander", "Janssens")));
        courseByIdDatabase.put(2L, new Course(2L, "PHP", 2, new Professor(1L, "Sander", "Janssens")));
    }

    public List<Course> findAll(Optional<Long> amountStudyPoints){
        if(amountStudyPoints.isPresent()){
            List<Course> lijst = new ArrayList<>();
            for (Course course : courseByIdDatabase.values()) {
                if(course.getAmountOfStudyPoints() == amountStudyPoints.get()){
                    lijst.add(course);
                }
            }
            return lijst;
        }
        return new ArrayList<>(courseByIdDatabase.values());
    }

    public void save(Course course){
        courseByIdDatabase.put(course.getId(), course);
    }
}
