package com.example.demo.student;

import com.example.demo.exception.ApiRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@ComponentScan(basePackages = "com.example.demo")
@RequestMapping(path = "api/v1/student")
public class StudentController {
  private final StudentService studentService;

  @Autowired
  public StudentController(StudentService studentService) {
    this.studentService = studentService;
  }

  @GetMapping
  public List<Student> getStudents() {
    throw new ApiRequestException("ohh, new list ");
    //return studentService.getStudents();
  }

  @PostMapping
  public void registerStudent(@RequestBody Student student){
    studentService.ddNewStudent(student);
  }

  @DeleteMapping(path = "{studentId}")
  public void deleteStudent(@PathVariable("studentId") Long id){
    studentService.deleteStudent(id);
  }

  @PutMapping(path = "{studentId}")
  public void updateStuden(@PathVariable("studentId") Long studentId, @RequestBody Student student){
//    @RequestParam(required = false) String name,
//    @RequestParam(required = false) String email
    studentService.updateStudent(studentId, student.getName(), student.getEmail());
  }
}
