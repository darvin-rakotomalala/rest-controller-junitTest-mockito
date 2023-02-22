package com.poc.service;

import com.poc.dto.StudentDTO;

import java.util.List;

public interface StudentService {
    List<StudentDTO> getStudents();
    StudentDTO saveStudent(StudentDTO student);
    StudentDTO updateStudent(StudentDTO student);
    String deleteStudent(String studentId);
}
