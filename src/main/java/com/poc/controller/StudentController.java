package com.poc.controller;

import com.poc.dto.StudentDTO;
import com.poc.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "students")
public class StudentController {

    private final StudentService studentService;

    @GetMapping("/get")
    public List<StudentDTO> getStudents() {
        return studentService.getStudents();
    }

    @PostMapping("/post")
    public StudentDTO saveStudent(@RequestBody StudentDTO student) {
        return studentService.saveStudent(student);
    }

    @PutMapping("/put")
    public StudentDTO putStudent(@RequestBody StudentDTO student) {
        return studentService.updateStudent(student);
    }

    @DeleteMapping("/delete")
    public String deleteStudent(@RequestParam("id") String studentId) {
        return studentService.deleteStudent(studentId);
    }

}
