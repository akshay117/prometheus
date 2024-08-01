package com.prometheus.in.student;

import com.prometheus.in.entity.Student;
import com.prometheus.in.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
@Service
public class StudentService {
    private final StudentRepository studentRepository;
    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }
    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

    public Student putStudents(@RequestBody Student student){
        return studentRepository.save(student);
    }

    public void addNewStudent(Student student) {
        System.out.println(student);
    }
}
