package com.example.springday14.Controller;

import com.example.springday14.Model.Student;
import com.example.springday14.Service.StudentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/Student")
@RequiredArgsConstructor
public class StudentController {

      final private StudentService studentService;
    @GetMapping("/display")
    public ResponseEntity getAlLstudents(){
        List<Student> students = studentService.getStudent();
        return ResponseEntity.status(200).body(students);
    }

    //Add
    @PostMapping("/add")
    public ResponseEntity addStudents(@Valid @RequestBody Student student){
        studentService.addStudent(student);
        return ResponseEntity.status(200).body("student Added");
    }

    //update
    @PutMapping("/update/{id}")
    public ResponseEntity updateStudent(@Valid @RequestBody Student student, @PathVariable Integer id) {
        studentService.updateStudent(id, student);
        return ResponseEntity.status(200).body("student is updated ");
    }

    //delete
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deletestudent(@PathVariable Integer id){
        studentService.deleteStudent(id);
        return ResponseEntity.status(200).body("Student is deleted ");
    }

    @PutMapping("/assignStudent/{course_id}/{Student_id}")
    public ResponseEntity assignStudent(@PathVariable Integer course_id,@PathVariable Integer Student_id){
        studentService.assignStudentToCourse(Student_id,course_id);
        return ResponseEntity.status(200).body("Course is assigned ");
    }

    // change major
    @PutMapping("/changeMajor/{student_id}/{major}")
    public ResponseEntity assignStudent(@PathVariable String major,@PathVariable Integer student_id){
        studentService.changeMajor(student_id,major);
        return ResponseEntity.status(200).body("major have been changed is assigned ");
    }


}
