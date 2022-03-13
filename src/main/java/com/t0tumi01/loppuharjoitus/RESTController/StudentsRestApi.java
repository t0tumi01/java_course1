package com.t0tumi01.loppuharjoitus.RESTController;

import com.t0tumi01.loppuharjoitus.DataModel.Student;
import com.t0tumi01.loppuharjoitus.DataService.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
public class StudentsRestApi {
    @Autowired
    StudentService studentService;

    //Get all students
    @GetMapping("students")
    public List<Student> getStudents() {
        return studentService.getStudents();
    }

    //Get one student (params: id)
    @GetMapping("student/{id}")
    public Student getStudent(@PathVariable int id) {
        Student s = studentService.getStudent(id);
        if (s == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        else return s;
    }

    //Add one student
    //Body JSON example:
    //{
    //    "firstName":"Mikko",
    //        "lastName":"Makkonen",
    //        "age":40,
    //        "address1": "Makkosenkuja 2",
    //        "address2": "666 HellSinki",
    //        "phone":"555443322"
    //}
    @PostMapping("student")
    public String addStudent(@RequestBody Student student) {
        return studentService.addStudent(student);
    }

    //Edit student (params: id)
    //Body JSON as in addStudent
    @PutMapping("student/{id}")
    public String editStudent(@PathVariable int id, @RequestBody Student student) {
        return studentService.editStudent(id, student);
    }

    //Delete student
    @DeleteMapping("student/{id}")
    public String deleteStudent(@PathVariable int id) {
        return studentService.deleteStudent(id);
    }
}
