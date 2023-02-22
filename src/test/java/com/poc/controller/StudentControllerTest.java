package com.poc.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.poc.dto.StudentDTO;
import com.poc.service.StudentService;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
public class StudentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private StudentService studentService;

    private static ObjectMapper mapper = new ObjectMapper();

    @Test
    public void testGetExample() throws Exception {
        List<StudentDTO> students = new ArrayList<>();
        StudentDTO student = new StudentDTO();
        student.setId(1);
        student.setName("Arun");
        students.add(student);
        Mockito.when(studentService.getStudents()).thenReturn(students);
        mockMvc.perform(get("/students/get")).andExpect(status().isOk()).andExpect(jsonPath("$", Matchers.hasSize(1)))
                .andExpect(jsonPath("$[0].name", Matchers.equalTo("Arun")));
    }

    @Test
    public void testPostExample() throws Exception {
        StudentDTO student = new StudentDTO();
        student.setId(1);
        student.setName("Arun");
        Mockito.when(studentService.saveStudent(ArgumentMatchers.any())).thenReturn(student);
        String json = mapper.writeValueAsString(student);
        mockMvc.perform(post("/students/post").contentType(MediaType.APPLICATION_JSON).characterEncoding("utf-8")
                        .content(json).accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
                .andExpect(jsonPath("$.id", Matchers.equalTo(1)))
                .andExpect(jsonPath("$.name", Matchers.equalTo("Arun")));
    }

    @Test
    public void testPutExample() throws Exception {
        StudentDTO student = new StudentDTO();
        student.setId(2);
        student.setName("John");
        Mockito.when(studentService.updateStudent(ArgumentMatchers.any())).thenReturn(student);
        String json = mapper.writeValueAsString(student);
        mockMvc.perform(put("/students/put").contentType(MediaType.APPLICATION_JSON).characterEncoding("utf-8")
                        .content(json).accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
                .andExpect(jsonPath("$.id", Matchers.equalTo(2)))
                .andExpect(jsonPath("$.name", Matchers.equalTo("John")));
    }

    @Test
    public void testDeleteExample() throws Exception {
        Mockito.when(studentService.deleteStudent(ArgumentMatchers.anyString())).thenReturn("Student is deleted");
        MvcResult requestResult = mockMvc.perform(delete("/students/delete").param("id", "1"))
                .andExpect(status().isOk()).andExpect(status().isOk()).andReturn();
        String result = requestResult.getResponse().getContentAsString();
        assertEquals(result, "Student is deleted");
    }

}
