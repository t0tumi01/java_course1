package com.t0tumi01.loppuharjoitus.DataModel;

public class Student {
    private int id;
    private String firstName;
    private String lastName;
    private int age;
    private String address1;
    private String address2;
    private String phone;

    private static int idCounter = 0;

    public Student(String firstName, String lastName, int age, String address1, String address2, String phone) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.address1 = address1;
        this.address2 = address2;
        this.phone = phone;
        this.id = idCounter++;
    }

    public Student() {
        this("", "", 0, "", "", "");
    }

    public int getId() { return id; }
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public int getAge() { return age; }
    public String getAddress1() {
        return address1;
    }
    public String getAddress2() {
        return address2;
    }
    public String getPhone() {
        return phone;
    }
}
