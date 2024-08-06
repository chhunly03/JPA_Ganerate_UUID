package com.khrd.test_jpa;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public interface StudentService {
    List<Students> getAllStudent();

    Students createStudent(StudentRequest studentRequest);

    Optional<Students>getStudentById(UUID id);

    Students editeStudentInfo(UUID id, StudentRequest studentRequest);
}
