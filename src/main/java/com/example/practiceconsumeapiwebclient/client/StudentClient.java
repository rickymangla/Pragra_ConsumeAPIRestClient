package com.example.practiceconsumeapiwebclient.client;

import com.example.practiceconsumeapiwebclient.model.Student;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "StudentClient", url = "http://localhost:8081/student")
public interface StudentClient {

    @GetMapping("/getStudent/{id}")
    Student getStudentById(@PathVariable(name = "id") Integer id);

    @PostMapping("/addStudent")
    Student addStudent(@RequestBody Student student);
}
