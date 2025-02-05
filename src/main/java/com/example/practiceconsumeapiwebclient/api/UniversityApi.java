package com.example.practiceconsumeapiwebclient.api;

import com.example.practiceconsumeapiwebclient.client.StudentClient;
import com.example.practiceconsumeapiwebclient.model.Student;
import com.example.practiceconsumeapiwebclient.service.UniversityService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/university")
public class UniversityApi {

    private final UniversityService universityService;
    private final StudentClient studentClient;

    public UniversityApi(UniversityService universityService, StudentClient studentClient) {
        this.universityService = universityService;
        this.studentClient = studentClient;
    }

    @GetMapping("/student/{id}")
    public ResponseEntity<Student> getStudent(@PathVariable(name = "id") Integer id) {
        ResponseEntity<Student> responseEntity = null;
        try {
            responseEntity = ResponseEntity.status(HttpStatusCode.valueOf(200))
                    .body(universityService.getStudentById(id));
        } catch (Exception e) {
            Student stu = new Student();
            responseEntity = ResponseEntity.status(404)
                    .body(stu);
        }
        return responseEntity;
        //   return universityService.getStudentById(id);
    }

    @PostMapping("/addStudent")
    public ResponseEntity<Student> addStudent(@RequestBody Student student) {
        ResponseEntity<Student> responseEntity = null;
        try {
            responseEntity = ResponseEntity.status(HttpStatusCode.valueOf(201))
                    .body(universityService.addStudent(student));
        } catch (Exception e) {
            responseEntity = ResponseEntity.status(HttpStatusCode.valueOf(501))
                    .body(null);
        }
        return responseEntity;

        //return universityService.addStudent(student);
    }

    @DeleteMapping("/deleteStudent/{id}")
    public String deleteStudent(@PathVariable(name = "id") Integer id) {
        return universityService.deleteStudent(id);
    }

    @GetMapping("/getStudent/{id}")
    public Student getStudentById(@PathVariable(name = "id") Integer id) {
        return studentClient.getStudentById(id);
    }

    @PostMapping("/addStu")
    public Student addStu(@RequestBody Student student) {
        return studentClient.addStudent(student);
    }
}
