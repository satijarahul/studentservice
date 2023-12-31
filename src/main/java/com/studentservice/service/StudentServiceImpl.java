package com.studentservice.service;

import com.studentservice.Dto.StudentDto;
import com.studentservice.modal.StudentEntity;
import com.studentservice.repository.StudentServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentServiceRepository studentServiceRepository;

    @Override
    public void saveStudent(StudentDto studentDto) {
        StudentEntity e = new StudentEntity();
        e.setFirstName(studentDto.getFirstName());
        e.setLastName(studentDto.getLastName());
        if(studentDto.getEmail()!=null)
        e.setEmail(studentDto.getEmail());
        e.setPhoneNumber(studentDto.getPhoneNumber());
        studentServiceRepository.saveAndFlush(e);

    }

    @Override
    public List<StudentDto> getListOfStudent() {
        List<StudentDto> dtoList  = new ArrayList<>();
        List<StudentEntity> list = studentServiceRepository.findAll();
        list.forEach(e->{
            StudentDto dto = new StudentDto(e.getFirstName(), e.getLastName(),e.getEmail(),e.getPhoneNumber());
            dtoList.add(dto);
        });
        return dtoList;
    }
}
