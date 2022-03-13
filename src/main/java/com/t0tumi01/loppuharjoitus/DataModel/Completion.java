package com.t0tumi01.loppuharjoitus.DataModel;

public class Completion {
    private int id;
    private int studentID;
    private int courseID;
    private String grade;
    private String finishedDate;

    private static int idCounter = 0;

    public Completion(int studentID, int courseID, String grade, String finishedDate) {
        this.studentID = studentID;
        this.courseID = courseID;
        this.grade = grade;
        this.finishedDate = finishedDate;
        this.id = idCounter++;
    }

    public Completion() {
        this(-1, -1, "NA", "");
    }

    public int getId() {
        return id;
    }
    public int getStudentID() {
        return studentID;
    }
    public int getCourseID() {
        return courseID;
    }
    public String getGrade() {
        return grade;
    }
    public String getFinishedDate() {
        return finishedDate;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public void setFinishedDate(String finishedDate) {
        this.finishedDate = finishedDate;
    }
}


