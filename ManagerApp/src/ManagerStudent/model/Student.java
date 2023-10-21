package ManagerStudent.model;

import java.util.Date;

public class Student extends Person {
    private String studentCode;
    private String school;
    private Integer startYear;
    private Double GPA;
    public Rank rank;

    public Student(String name, Date dateOfBirth, String address, Double height, Double weight, String studentCode,
                   String school, Integer startYear, Double GPA){
        super( name, dateOfBirth, address, height, weight);
        this.studentCode = studentCode;
        this.school = school;
        this.startYear = startYear;
        this.GPA = GPA;
        this.rank = calculateRankPerformance();
    }

    public String getStudentCode() {
        return studentCode;
    }

    public void setStudentCode(String studentCode) {
        this.studentCode = studentCode;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public Integer getYear() {
        return startYear;
    }

    public void setYear(int year) {
        this.startYear = startYear;
    }

    public Double getGPA() {
        return GPA;
    }

    public void setGPA(double GPA) {

        this.GPA = GPA;
        this.rank = calculateRankPerformance();
    }
    public Rank getRank() {
        return rank;
    }
    public void setRank(Rank rank) {
        this.rank = rank;
    }
    @Override
    public String toString(){
        return super.toString() + "\n" + "StudentCode: " + studentCode + "\n" + "School: " + school + "\n" + "Start Year: " + startYear +
                "\n" + "GPA: " + GPA + "\n" + "Rank: " + rank;
    }
    public Rank calculateRankPerformance(){
        if (this.GPA < 3.0) {
            return Rank.POOR;
        } else if (this.GPA < 5.0) {
            return Rank.WEAK;
        } else if (this.GPA < 6.5) {
            return Rank.AVERAGE;
        } else if (this.GPA < 7.5) {
            return Rank.GOOD;
        } else if (this.GPA < 9.0) {
            return Rank.VERY_GOOD;
        } else {
            return Rank.EXCELLENT;
        }
    }
}
