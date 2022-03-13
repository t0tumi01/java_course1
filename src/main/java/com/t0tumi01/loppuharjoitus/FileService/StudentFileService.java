package com.t0tumi01.loppuharjoitus.FileService;

import com.t0tumi01.loppuharjoitus.DataModel.Student;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

@Service
public class StudentFileService {
    public void writeStudentsToFile(List<Student> students) {
        try {
            FileWriter fw = new FileWriter(new File("students.txt"), false);
            for(Student s : students) {
                fw.write(s.getFirstName() + "," + s.getLastName() + "," + s.getAge() + "," + s.getAddress1() + "," + s.getAddress2() + "," + s.getPhone() + System.lineSeparator());
            }
            fw.close();
        }
        catch (Exception e) {
        }
    }

    public List<Student> readStudentsFromFile() {
        List<Student> students = new ArrayList<>();
        try {
            Scanner sc = new Scanner(new File("students.txt"));
            while (sc.hasNextLine()) {
                String s[] = sc.nextLine().split(",");
                if (s.length == 6) {
                    students.add(new Student(s[0],s[1],Integer.parseInt(s[2]),s[3],s[4],s[5]));
                }
            }
        }
        catch (Exception e) {
        }

        return students;
    }
}
