package com.example.springday14.Repository;

import com.example.springday14.Model.Course;
import com.example.springday14.Model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course, Integer> {
    Course findCourseById(Integer id) ;

    Course findCourseByStudents(Student student);



}
