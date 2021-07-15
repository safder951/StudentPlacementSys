package com.example.studentplacementsys;

public class Studentlist {
    String StudentName;
    String StudentSkill;
    String StudentNumber;
    String StudentAddress;

    public Studentlist(String StudentName, String StudentSkill, String StudentNumber,String StudentAddress) {
        this.StudentName = StudentName;
        this.StudentSkill = StudentSkill;
        this.StudentNumber = StudentNumber;
        this.StudentAddress = StudentAddress;
    }

    public String getStudentName() {
        return StudentName;
    }

    public String getStudentSkill() { return StudentSkill; }

    public String getStudentNumber() {
        return StudentNumber;
    }

    public String getStudentAddress() {
        return StudentAddress;
    }
}
