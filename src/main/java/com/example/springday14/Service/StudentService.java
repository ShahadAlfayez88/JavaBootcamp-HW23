package com.example.springday14.Service;

import com.example.springday14.Exception.ApiException;

import com.example.springday14.Model.Course;
import com.example.springday14.Model.Student;
import com.example.springday14.Repository.CourseRepository;
import com.example.springday14.Repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;
   private final CourseRepository courseRepository;

    // ADD
    public void addStudent(Student student){
        studentRepository.save(student);
    }

    // Display
    public List<Student> getStudent(){
        return  studentRepository.findAll();
    }

    // update
    public void updateStudent(Integer id, Student student) {
        Student newStudent = studentRepository.findStudentById(id);
        if (newStudent == null) {
            throw new ApiException("course not found!!");
        }
        studentRepository.save(newStudent);
    }

    // delete

    public void deleteStudent(Integer id) {
        Student student = studentRepository.findStudentById(id);
        if (student==null) {
            throw new ApiException("Id is not found");
        }
        studentRepository.delete(student);
    }

    public void assignStudentToCourse(Integer Student_id, Integer Course_id){
        Course course = courseRepository.findCourseById(Course_id);
        Student student = studentRepository.findStudentById(Student_id);

        if (student==null ||course==null ) {
            throw new ApiException("Id is not found");
        }
        for (int i = 0 ; i<student.getCourses().size();i++){
            if(student.getCourses().get(i)==course){
                throw new ApiException("Course Already Assigned!!");
            }
        }
        course.getStudents().add(student);
        student.getCourses().add(course);
        courseRepository.save(course);
        studentRepository.save(student);
    }

    // change major

    public void changeMajor(Integer Student_id, String major){
        //هنا وصلت للطالب
        Student currentStudent = studentRepository.findStudentById(Student_id);
        if (currentStudent==null) {
            throw new ApiException("Id is not found");
        }
        for (int i = 0 ; i<currentStudent.getCourses().size();i++){
            Course course = currentStudent.getCourses().get(i);
            course.getStudents().remove(currentStudent);
            currentStudent.getCourses().clear();
        }

        currentStudent.setMajor(major);
        studentRepository.save(currentStudent);

    }

}
