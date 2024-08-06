package com.khrd.test_jpa;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public List<Students> getAllStudent() {
        return studentRepository.findAll();
    }

    @Override
    public Students createStudent(StudentRequest studentRequest) {
        Students students = new Students();
        students.setUserName(studentRequest.getName());
        students.setScore(studentRequest.getScore());

        studentRepository.save(students);
        return students;
    }

    @Override
    public Optional<Students> getStudentById(UUID id) {
        return studentRepository.findById(id);
    }

    @Override
    public Students editeStudentInfo(UUID id, StudentRequest studentRequest) {
        Optional<Students> student = studentRepository.findById(id);
        if (student.isPresent()) {
            Students storeData = student.get();
            storeData.setUserName(studentRequest.getName());
            storeData.setScore(studentRequest.getScore());

            return studentRepository.save(storeData);
        } else {
            System.out.println("Student not found..!");
        }
        return null;
    }
}
