package com.example.practiceconsumeapiwebclient.service;

import com.example.practiceconsumeapiwebclient.model.Student;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.time.Duration;

@Service
public class UniversityService {

    private final RestClient restClient;

//    @Autowired
//    private ClassService classService;

    public UniversityService(RestClient restClient) {
        this.restClient = restClient;
    }

    public Student getStudentById(Integer id) {
        return restClient.get()
                .uri("/student/getStudent/" + id)
                .retrieve()
                .body(Student.class);
    }

//    public Student getStudent(Integer id) {
//        return classService.getStudent(id);
//    }

    public Student addStudent(Student student) {
        return restClient.post()
                .uri("/student/addStudent")
                .contentType(MediaType.APPLICATION_JSON)
                .body(student)
                .retrieve()
                .body(Student.class);
    }

    public String deleteStudent(Integer id) {
        return restClient.delete()
                .uri("/student/deleteStudent/" + id)
                .retrieve()
                .body(String.class);
    }


}
