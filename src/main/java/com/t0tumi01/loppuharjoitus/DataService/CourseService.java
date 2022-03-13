package com.t0tumi01.loppuharjoitus.DataService;

import com.t0tumi01.loppuharjoitus.DataModel.ClassRoomCourse;
import com.t0tumi01.loppuharjoitus.DataModel.Course;
import com.t0tumi01.loppuharjoitus.DataModel.OnlineCourse;
import com.t0tumi01.loppuharjoitus.FileService.CourseFileService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseService {
    private List<Course> courses = new ArrayList<>();

    //Constructor
    public CourseService() {
        //Get students from file
        CourseFileService fs = new CourseFileService();
        courses = fs.readCoursesFromFile();
    }

    //Get all courses
    public List<Course> getCourses() {
        return new ArrayList<>(courses);
    }

    //Get one course
    //id = object array id
    public Course getCourse(int id) {
        Course s;
        if (id < courses.size()) {
            if (courses.get(id) instanceof ClassRoomCourse) {
                s = new ClassRoomCourse();
            }
            else {
                s = new OnlineCourse();
            }
            s = courses.get(id);
        }
        else s = null;

        return s;
    }

    //Add course
    //course = Course object
    public String addCourse(Course course) {
        courses.add(course);
        //Write courses to file
        CourseFileService fs = new CourseFileService();
        fs.writeCoursesToFile(courses);
        return "Course added OK";
    }

    //Edit course
    //id = object array id
    //course = course object
    public String editCourse(int id, Course course) {
        if (id < courses.size()) {
            courses.set(id, course);
            //Write courses to file
            CourseFileService fs = new CourseFileService();
            fs.writeCoursesToFile(courses);
            return "Course edited OK";
        }
        else return "Course ID does not exist";
    }

    //Delete course
    //id = object array id
    public String deleteCourse(int id) {
        if (id < courses.size()) {
            courses.remove(id);
            //Write students to file
            CourseFileService fs = new CourseFileService();
            fs.writeCoursesToFile(courses);
            return "Courses deleted OK";
        }
        else return "Course ID does not exist";
    }
}