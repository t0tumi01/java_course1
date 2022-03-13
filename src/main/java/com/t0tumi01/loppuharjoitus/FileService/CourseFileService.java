package com.t0tumi01.loppuharjoitus.FileService;

import com.t0tumi01.loppuharjoitus.DataModel.ClassRoomCourse;
import com.t0tumi01.loppuharjoitus.DataModel.Course;
import com.t0tumi01.loppuharjoitus.DataModel.OnlineCourse;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Service
public class CourseFileService {
    public void writeCoursesToFile(List<Course> courses) {
        try {
            FileWriter fw = new FileWriter(new File("courses.txt"), false);
            for(Course c : courses) {
                if (c instanceof ClassRoomCourse) {
                    fw.write(c.getCode() + "," + c.getName() + "," + c.getLength() + "," + c.getTeacher() + "," + ((ClassRoomCourse) c).getDefaultClass() + System.lineSeparator());
                }
                else {
                    fw.write(c.getCode() + "," + c.getName() + "," + c.getLength() + "," + c.getTeacher() + System.lineSeparator());
                }
            }
            fw.close();
        }
        catch (Exception e) {
        }
    }

    public List<Course> readCoursesFromFile() {
        List<Course> courses = new ArrayList<>();
        try {
            Scanner sc = new Scanner(new File("courses.txt"));
            while (sc.hasNextLine()) {
                String s[] = sc.nextLine().split(",");
                if (s.length == 4) {
                    courses.add(new OnlineCourse(s[0],s[1],Integer.parseInt(s[2]),s[3]));
                }
                else if (s.length == 5) {
                    courses.add(new ClassRoomCourse(s[0],s[1],Integer.parseInt(s[2]),s[3],s[4]));
                }
            }
        }
        catch (Exception e) {
        }
        return courses;
    }
}
