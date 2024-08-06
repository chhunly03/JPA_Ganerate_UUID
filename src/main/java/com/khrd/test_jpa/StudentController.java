package com.khrd.test_jpa;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("")
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("getAllStudent")
    public List<Students>GetAllStudent(){
        return studentService.getAllStudent();
    }

    @PostMapping("createStudent")
    public Students createStudent(@RequestBody StudentRequest studentRequest){
        return studentService.createStudent(studentRequest);
    }

    @GetMapping("/{id}")
    public Optional<Students> getStudentById(@PathVariable UUID id){
        return studentService.getStudentById(id);
    }

    @PutMapping("/{id}")
    public Students editeStudentInfo(@PathVariable UUID id, @RequestBody StudentRequest studentRequest){
        return studentService.editeStudentInfo(id,studentRequest);
    }
}
