package ManagerStudent.manager;

import ManagerStudent.validator.Validator;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class InputStudent {
    public Scanner scanner;


    public InputStudent(){
        this.scanner = new Scanner(System.in);
    }
    public String inputName() {
        while (true) {
            System.out.println("Enter student name (<100 characters):");
            String name = this.scanner.nextLine();

            if (Validator.isValidName(name)) {
                return name;
            }
            System.out.println("Invalid name!!!");
        }
    }
    public Date inputDob() {
        while(true) {
            System.out.println("Enter a new date of birth (dd/MM/yyyy) :");
            String date_str = this.scanner.nextLine();
            SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
            format.setLenient(false);
            try {
                Date date = format.parse(date_str);
                if (Validator.isValidDob(date)) {
                    return date;
                }
                System.err.println("Invalid date of birth!!!");
            } catch (ParseException var4) {
                System.err.println("Enter the wrong date format, or invalid date of birth");
            }
        }
    }
    public String inputAddress() {
        while (true) {
            System.out.println("Enter student address (<300 characters): ");
            String address = this.scanner.nextLine();
            if (Validator.isValidAddress(address)) {
                return address;
            }
            System.out.println("valid Address!");
        }
    }
    public Double inputHeight() {
        while (true) {
            System.out.println("Enter student height 50.0 - 300.0 (cm): ");
            try {
                double height = this.scanner.nextDouble();
                if (Validator.isValidHeight(height)) {
                    return height;
                }
                System.out.println("Invalid height");
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter a number.");
                this.scanner.next();
            }
        }
    }

    public Double inputWeight() {
        while (true) {
            System.out.println("Enter student weight 5.0 - 1000.0 (kg): ");
            try {
                double weight = this.scanner.nextDouble();
                this.scanner.nextLine();
                if (Validator.isValidWeight(weight)) {
                    return weight;
                }
                System.out.println("Invalid weight");
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter a number.");
                this.scanner.next();
            }
        }
    }
    public String inputStudentCode(){
        while(true){
            System.out.println("Enter Student Code (10 characters, not null): ");
            String StudentCode = this.scanner.nextLine();

            if(Validator.isValidStudentCode(StudentCode)){
                return StudentCode;
            }
            System.out.println("Invalid StudentCode");
        }
    }
    public String inputSchoolName() {
        while (true) {
            System.out.println("Enter school name: ");
            String schoolName = this.scanner.nextLine();

            if (Validator.isValidSchoolName(schoolName)) {
                return schoolName;
            }
            System.out.println("Invalid school name");
        }
    }
    public Integer inputStartYear() {
        while (true) {
            System.out.println("Enter start year (yyyy): ");
            try {
                int startYear = this.scanner.nextInt();
                if (Validator.isValidStartYear(startYear)) {
                    return startYear;
                }
                System.out.println("Invalid start year");
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter an integer.");
                this.scanner.next();
            }
        }
    }
    public Double inputGPA() {
        while (true) {
            System.out.println("Enter Score (0.0-10.0): ");
            try {
                double GPA = this.scanner.nextDouble();
                this.scanner.nextLine();
                if (Validator.isValidScore(GPA)) {
                    return GPA;
                }
                System.out.println("Invalid GPA");
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter a number.");
                this.scanner.next();
            }
        }
    }
}
