package com.example.springday14.Controller;

import com.example.springday14.DTO.AddressDTO;
import com.example.springday14.Model.Teacher;
import com.example.springday14.Service.AddressService;
import com.example.springday14.Service.TeacherService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/teacher")
@RequiredArgsConstructor
public class TeacherController {

    final private TeacherService teacherService;

    final private AddressService addressService;

    //display
    @GetMapping("/display")
    public ResponseEntity getAllTeachers(){
        List<Teacher> teachers = teacherService.getTeacher();
        return ResponseEntity.status(200).body(teachers);
    }

    // get teacher info

    @GetMapping("/getInfo/{id}")
    public ResponseEntity getTeacherInfo(@PathVariable Integer id){
        Teacher teacher = teacherService.getTeacherInfo(id);
        return ResponseEntity.status(200).body(teacher);
    }


    //Add
    @PostMapping("/add")
    public ResponseEntity addTeacher(@Valid @RequestBody Teacher teacher){
        teacherService.addTeacher(teacher);
        return ResponseEntity.status(200).body("teacher Added");
    }

    @PostMapping("/address/add")
    public ResponseEntity addTeacherAddress(@Valid @RequestBody AddressDTO addressDTO){
        addressService.addTeacherAddress(addressDTO);
        return ResponseEntity.status(200).body("Teacher Address Added");
    }
    //update
    @PutMapping("/update/{id}")
    public ResponseEntity updateTeacher(@Valid @RequestBody Teacher teacher, @PathVariable Integer id) {

        teacherService.updateTeacher(id, teacher);
        return ResponseEntity.status(200).body("Teacher is updated ");
    }

    //delete
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteTeacher(@PathVariable Integer id){
        teacherService.deleteTeacher(id);
        return ResponseEntity.status(200).body("Teacher is deleted ");
    }

    // update customer details

    @PutMapping("/address/update")
    public ResponseEntity updateTeacherAddress(@Valid @RequestBody AddressDTO addressDTO){
        addressService.updateTeacherAddress(addressDTO);
        return ResponseEntity.status(200).body("Teacher Address updated");

    }

    // delete  customer details

    @DeleteMapping("/address/delete/{id}")
    public ResponseEntity deleteTeacherAddress(@PathVariable Integer id){
        addressService.deleteTeacherAddress(id);
        return ResponseEntity.status(200).body("Teacher Address deleted");

    }

}
