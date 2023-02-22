package com.poc.service;

import com.poc.dto.StudentDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    @Override
    public List<StudentDTO> getStudents() {
        try {
            log.info("----- getStudents");
            List<StudentDTO> students = new ArrayList<>();
            StudentDTO student = new StudentDTO();
            students.add(student);
            return students;
        } catch (Exception e) {
            log.error("Error getStudents : {} : {}", e.getMessage(), e);
            throw e;
        }
    }

    @Override
    public StudentDTO saveStudent(StudentDTO student) {
        try {
            log.info("----- saveStudent");
            student.setId(1);
            student.setName("Arun");
            return student;
        } catch (Exception e) {
            log.error("Error saveStudent : {} : {}", e.getMessage(), e);
            throw e;
        }
    }

    @Override
    public StudentDTO updateStudent(StudentDTO student) {
        try {
            log.info("----- updateStudent");
            student.setId(2);
            student.setName("John");
            return student;
        } catch (Exception e) {
            log.error("Error updateStudent : {} : {}", e.getMessage(), e);
            throw e;
        }
    }

    @Override
    public String deleteStudent(String studentId) {
        try {
            log.info("----- deleteStudent");
            return "Student is deleted";
        } catch (Exception e) {
            log.error("Error deleteStudent : {} : {}", e.getMessage(), e);
            throw e;
        }
    }

}
