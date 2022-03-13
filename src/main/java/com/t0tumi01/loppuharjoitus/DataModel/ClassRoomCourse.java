package com.t0tumi01.loppuharjoitus.DataModel;

public class ClassRoomCourse extends Course{
    private String defaultClass;

    public ClassRoomCourse(String code, String name, int length, String teacher, String defaultClass) {
        super(code, name, length, teacher);
        this.defaultClass = defaultClass;
    }

    public ClassRoomCourse() {
        this("", "", 0, "", "");
    }

    public String getDefaultClass() {
        return defaultClass;
    }
}
