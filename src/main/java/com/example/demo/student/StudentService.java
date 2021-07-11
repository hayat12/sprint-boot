package com.example.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

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

  public void ddNewStudent(Student student) {
    Optional<Student> studentOptional = studentRepository.findStudentByEmail(student.getEmail());
    if (studentOptional.isPresent()){
      throw new IllegalStateException("Email exist");
    }
    studentRepository.save(student);
  }

  public void deleteStudent(Long studentId) {
    boolean exsit = studentRepository.existsById(studentId);
    if (!exsit){
      throw new IllegalStateException("Student with id "+studentId+" not exist");
    }
    studentRepository.deleteById(studentId);
  }

  @Transactional
  public void updateStudent(Long studentId, String name, String email) {

    Student student = studentRepository.findById(studentId).orElseThrow(()->new IllegalStateException(("Student with Id "+studentId+" does not exist")));
    if (name!=null && name.length() > 0 && !Objects.equals(student.getName(), name)){
      student.setName((name));
    }
    if (email!=null && email.length() > 0 && !Objects.equals(student.getName(), name)){
      Optional<Student> studentOptional = studentRepository.findStudentByEmail(email);
      if (studentOptional.isPresent()){
        throw new IllegalStateException(("Email "+email+"has taken already"));
      }
      student.setEmail(email);
    }
  }
}
