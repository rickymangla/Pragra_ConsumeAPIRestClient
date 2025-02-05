package com.example.practiceconsumeapiwebclient.service;

import com.example.practiceconsumeapiwebclient.model.Student;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
public class ClassService {

    private final RestClient restClient;

    public ClassService(RestClient restClient) {
        this.restClient = restClient;
    }

    public Student getStudent(Integer id) {
        return restClient.get()
                .uri("/student/getStudent/" + id)
                .retrieve()
                .body(Student.class);
    }
}
