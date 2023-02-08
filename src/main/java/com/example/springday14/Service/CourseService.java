package com.example.springday14.Service;

import com.example.springday14.Exception.ApiException;
import com.example.springday14.Model.Course;
import com.example.springday14.Model.Student;
import com.example.springday14.Model.Teacher;
import com.example.springday14.Repository.CourseRepository;
import com.example.springday14.Repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseService {
    private final CourseRepository courseRepository;
    private final TeacherRepository teacherRepository;
    // ADD
    public void addCourse(Course course){
        courseRepository.save(course);
    }

    // Display
    public List<Course> getCourse(){
        return  courseRepository.findAll();
    }

    // update
    public void updateCourse(Integer id, Course course) {
        Course newCourse = courseRepository.findCourseById(id);
        if (newCourse == null) {
            throw new ApiException("course not found!!");
        }
       courseRepository.save(course);
    }

    // delete

    public void deleteCourse(Integer id) {
        Course course = courseRepository.findCourseById(id);
        if (course==null) {
            throw new ApiException("Id is not found");
        }
        courseRepository.delete(course);
    }

    public void assignCourse(Integer teacher_id , Integer course_id){

        Teacher teacher = teacherRepository.findTeacherById(teacher_id);
        Course course = courseRepository.findCourseById(course_id);

        if (teacher==null ||course==null ) {
            throw new ApiException("Id is not found");
        }
        course.setTeacher(teacher);
        courseRepository.save(course);

    }

    public String getTeacherName(Integer course_id){

        Course course = courseRepository.findCourseById(course_id);
        Teacher teacher = teacherRepository.findTeacherById(course.getTeacher().getId());
        if (teacher==null ||course==null ) {
            throw new ApiException("Id is not found");
        }
        else return teacher.getName();
    }

    public List<Student> getAllStudent(Integer Course_id){
        Course course = courseRepository.findCourseById(Course_id);
        if (course==null) {
            throw new ApiException("Id is not found");
        }
        return course.getStudents();
    }

}
