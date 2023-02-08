package com.example.springday14.Repository;

import com.example.springday14.Model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Integer> {
    Student findStudentById(Integer id);

}
