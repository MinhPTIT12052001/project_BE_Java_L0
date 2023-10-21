package ManagerStudent.validator;

import ManagerStudent.model.Student;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import static ManagerStudent.constant.Constant.*;
import static ManagerStudent.manager.ManagerStudent.studentArray;

public class Validator {


    public Validator(){


    }
    public static boolean isValidName(String name) {
        return name != null && name.length() > MIN_NAME && name.length() <= MAX_NAME;
    }
    public static boolean isValidDob(Date date) {
        try {
            Date minDate = new SimpleDateFormat("dd/MM/yyyy").parse("01/01/1900");
            Date currentDate = new Date();
            if (date.before(minDate) || date.after(currentDate)) {
                return false;
            }
            return true;
        } catch (ParseException e) {
            return false;
        }
    }
    public static boolean isValidAddress(String address) {
        return address == null || address.length() <= MAX_ADDRESS_LENGTH;
    }
    public static boolean isValidHeight(double height) {
        return height >= MIN_HEIGHT && height <= MAX_HEIGHT;
    }
    public static boolean isValidWeight(double weight) {
        return weight >= MIN_WEIGHT && weight <= MAX_WEIGHT;
    }
    public static boolean isValidStudentCode(String studentCode) {
        // regex represent 10-integer-sequence
        String reg = "^\\d{10}$";
        Set<String> studentCodes = new HashSet<>();
        for (Student student : studentArray) {
            if (student != null) {
                studentCodes.add(student.getStudentCode());
            }
        }
        if (studentCode == null || studentCode.equals("") || !studentCode.matches(reg) || studentCodes.contains(studentCode)) {
            return false;
        }
        return true;
    }
    public static boolean isValidSchoolName(String schoolName) {
        return schoolName != null && schoolName.length() > MIN_SCHOOL_NAME_LENGTH && schoolName.length() <= MAX_SCHOOL_NAME_LENGTH;
    }
    public static boolean isValidStartYear(int startYear) {
        return startYear >= MIN_START_YEAR && startYear <MAX_START_YEAR;
    }
    public static boolean isValidScore(double GPA) {
        return GPA >= MIN_GPA && GPA <= MAX_GPA;
    }
}
