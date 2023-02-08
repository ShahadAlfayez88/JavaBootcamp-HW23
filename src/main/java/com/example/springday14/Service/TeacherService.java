package com.example.springday14.Service;

import com.example.springday14.Exception.ApiException;
import com.example.springday14.Model.Teacher;
import com.example.springday14.Repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class TeacherService {
     final private TeacherRepository teacherRepository;

    //ADD
    public void addTeacher(Teacher teacher) {
        teacherRepository.save(teacher);
    }

   //DISPLAY
    public List<Teacher> getTeacher() {
        return teacherRepository.findAll();
    }

    //Update

    public void updateTeacher(Integer id, Teacher teacher) {
        Teacher newTeacher = teacherRepository.findTeacherById(id);
        if (newTeacher == null) {
            throw new ApiException("order not found!!");
        }
        teacherRepository.save(newTeacher);
    }

    // Delete
    public void deleteTeacher(Integer id) {
        Teacher teacher = teacherRepository.findTeacherById(id);
        if (!teacherRepository.existsById(id)) {
            throw new ApiException("Id is not found");
        }
        teacherRepository.delete(teacher);
    }

    // get teacher
    public Teacher getTeacherInfo(Integer id) {
        Teacher teacher = teacherRepository.findTeacherById(id);
        if (!teacherRepository.existsById(id)) {
            throw new ApiException("Id is not found");
        }
        return teacher;
    }


}
