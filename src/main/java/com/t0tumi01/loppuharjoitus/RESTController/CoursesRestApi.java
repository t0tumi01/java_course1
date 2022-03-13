package com.t0tumi01.loppuharjoitus.RESTController;

import com.t0tumi01.loppuharjoitus.DataModel.ClassRoomCourse;
import com.t0tumi01.loppuharjoitus.DataModel.Course;
import com.t0tumi01.loppuharjoitus.DataModel.OnlineCourse;
import com.t0tumi01.loppuharjoitus.DataService.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
public class CoursesRestApi {
    @Autowired
    CourseService courseService;

    //Get all courses
    @GetMapping("courses")
    public List<Course> getCourses() {
        return courseService.getCourses();
    }

    //Get one course (params: id)
    @GetMapping("course/{id}")
    public Course getCourse(@PathVariable int id) {
        Course s = courseService.getCourse(id);
        if (s == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        else return s;
    }

    //Add online course
    //Body JSON example:
    //{
    //    "code":"C01A11",
    //    "name":"Matematiikka",
    //    "length":12,
    //    "teacher": "Taina Tepponen"
    //}
    @PostMapping("course/online")
    public String addOnlineCourse(@RequestBody OnlineCourse course) {
        return courseService.addCourse(course);
    }

    //Add class room course
    //Body JSON example:
    //{
    //    "code":"C02A10",
    //    "name":"Elektroniikka",
    //    "length":18,
    //    "teacher": "Tuomo Mattila",
    //    "defaultClass" : "12A101"
    //}
    @PostMapping("course/classRoom")
    public String addClassRoomCourse(@RequestBody ClassRoomCourse course) {
        return courseService.addCourse(course);
    }

    //Edit online course (params: id)
    //Body JSON as in addOnlineCourse
    @PutMapping("course/online/{id}")
    public String editOnlineCourse(@PathVariable int id, @RequestBody OnlineCourse course) {
        return courseService.editCourse(id, course);
    }

    //Edit class room course (params: id)
    //Body JSON as in addClassRoomCourse
    @PutMapping("course/classRoom/{id}")
    public String editClassRoomCourse(@PathVariable int id, @RequestBody ClassRoomCourse course) {
        return courseService.editCourse(id, course);
    }

    //Delete student
    @DeleteMapping("course/{id}")
    public String deleteCourse(@PathVariable int id) {
        return courseService.deleteCourse(id);
    }
}