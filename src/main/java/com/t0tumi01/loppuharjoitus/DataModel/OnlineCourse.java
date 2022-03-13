package com.t0tumi01.loppuharjoitus.DataModel;

public class OnlineCourse extends Course {
    public OnlineCourse(String code, String name, int length, String teacher) {
        super(code, name, length, teacher);
    }

    public OnlineCourse() {
        this("", "", 0, "");
    }
}
