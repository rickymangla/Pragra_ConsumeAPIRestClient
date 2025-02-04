package com.example.practiceconsumeapiwebclient.api;

import com.example.practiceconsumeapiwebclient.model.Student;
import com.example.practiceconsumeapiwebclient.service.UniversityService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/university")
public class UniversityApi {

    private final UniversityService universityService;

    public UniversityApi(UniversityService universityService) {
        this.universityService = universityService;
    }

    @GetMapping("/student/{id}")
    public Student getStudent(@PathVariable (name="id") Integer id) {
        return universityService.getStudentById(id);
    }

    @PostMapping("/addStudent")
    public Student addStudent(@RequestBody Student student) {
        return universityService.addStudent(student);
    }

    @DeleteMapping("/deleteStudent/{id}")
    public String deleteStudent(@PathVariable (name="id") Integer id) {
        return universityService.deleteStudent(id);
    }



}
