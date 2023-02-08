package com.example.springday14.Service;

import com.example.springday14.DTO.AddressDTO;
import com.example.springday14.Exception.ApiException;
import com.example.springday14.Model.Address;
import com.example.springday14.Model.Teacher;
import com.example.springday14.Repository.AddressRepository;
import com.example.springday14.Repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AddressService {

    final private TeacherRepository teacherRepository;

    final private AddressRepository addressRepository;
    public void addTeacherAddress(AddressDTO dto){
        // find customer by id ;
        Teacher teacher = teacherRepository.findTeacherById(dto.getTeacher_id());
        if (teacher ==null){
            throw new ApiException("Teacher not found");
        }
        Address address = new Address(null,dto.getBuilding_number(),dto.getStreet(), dto.getArea(), teacher);
        addressRepository.save(address);
    }

    public void updateTeacherAddress(AddressDTO dto){
        // find customer by id ;
        Address address = addressRepository.findAddressById(dto.getTeacher_id());
        if (address ==null){
            throw new ApiException("Teacher not found");
        }
        Teacher teacher = teacherRepository.findTeacherById(dto.getTeacher_id());
        if (teacher ==null){
            throw new ApiException("Teacher not found");
        }
        address.setArea(dto.getArea());
        address.setStreet(dto.getStreet());
        address.setBuilding_number(dto.getBuilding_number());
        addressRepository.save(address);
    }

    public void deleteTeacherAddress(Integer id){
        Address address = addressRepository.findAddressById(id);
        if (address ==null){
            throw new ApiException("Teacher not found");
        }
        addressRepository.delete(address);
    }
}
