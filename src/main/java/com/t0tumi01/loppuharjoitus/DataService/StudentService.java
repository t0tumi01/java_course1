package com.t0tumi01.loppuharjoitus.DataService;

import com.t0tumi01.loppuharjoitus.DataModel.Student;
import com.t0tumi01.loppuharjoitus.FileService.StudentFileService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {
    private List<Student> students = new ArrayList<>();

    //Constructor
    public StudentService() {
        //Get students from file
        StudentFileService fs = new StudentFileService();
        students = fs.readStudentsFromFile();
    }

    //Get all students
    public List<Student> getStudents() {
        return new ArrayList<>(students);
    }

    //Get one student
    //id = object array id
    public Student getStudent(int id) {
        Student s = new Student();
        if (id < students.size()) {
            s = students.get(id);
        }
        else s = null;

        return s;
    }

    //Add student
    //student = student object
    public String addStudent(Student student) {
        students.add(student);
        //Write students to file
        StudentFileService fs = new StudentFileService();
        fs.writeStudentsToFile(students);
        return "Student added OK";
    }

    //Edit student
    //id = object array id
    //student = student object
    public String editStudent(int id, Student student) {
        if (id < students.size()) {
            students.set(id, student);
            //Write students to file
            StudentFileService fs = new StudentFileService();
            fs.writeStudentsToFile(students);
            return "Student edited OK";
        }
        else return "Student ID does not exist";
    }

    //Delete student
    //id = object array id
    public String deleteStudent(int id) {
        if (id < students.size()) {
            students.remove(id);
            //Write students to file
            StudentFileService fs = new StudentFileService();
            fs.writeStudentsToFile(students);
            return "Student deleted OK";
        }
        else return "Student ID does not exist";
    }
}