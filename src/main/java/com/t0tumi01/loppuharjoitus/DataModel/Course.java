package com.t0tumi01.loppuharjoitus.DataModel;

public abstract class Course {
    private int id;
    private String code;
    private String name;
    private int length;
    private String teacher;

    private static int idCounter = 0;

    public Course(String code, String name, int length, String teacher) {
        this.code = code;
        this.name = name;
        this.length = length;
        this.teacher = teacher;
        this.id = idCounter++;
    }

    public int getId() {
        return id;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public int getLength() {
        return length;
    }

    public String getTeacher() {
        return teacher;
    }
}