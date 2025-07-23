package com.project.sms.exception;

import com.project.sms.controller.StudentController;
import com.project.sms.service.StudentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@WebMvcTest(controllers = StudentController.class)
@Import(GlobalExceptionHandler.class)
class GlobalExceptionHandlerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private StudentService studentService;

    @Test
    void duplicateEmail_returns409() throws Exception {

        when(studentService.createStudent(any()))
                .thenThrow(new IllegalArgumentException("Student with this email already exists."));

        String body = """
                { "name":"Aarav","gender":"male","emailId":"dup@abc.com","age":12 }
                """;

        mvc.perform(post("/api/students/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content(body))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.message")
                        .value("Student with this email already exists."));
    }
}
