package ManagerStudent.manager;

import ManagerStudent.model.Rank;
import ManagerStudent.model.Student;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class ManagerStudent {
    public int count = 0;
    public Scanner scanner = new Scanner(System.in);
    public static Student[] students = new Student[100];
    //Convert from Array to Arraylist.
    public static ArrayList<Student> studentArray = convertToArraylist(students);
    //public int count = 0;
    public ManagerStudent(){
//        Date dob1 = new Date(2003, 6, 12);
//        Student student1 = new Student("Minh", dob1, "Thai Binh", 176.0, 70.0, "1234567890", "ABC School", 2021, 3.5);
//
//        Date dob2 = new Date(2002, 5, 10);
//        Student student2 = new Student("Linh", dob2, "Thai Binh", 168.0, 55.0, "1234567891", "XYZ School", 2020, 6.8);
//
//        Date dob3 = new Date(2001, 4, 8);
//        Student student3 = new Student("Phuong", dob3, "Thai Binh", 180.0, 80.0, "1234567892", "DEF School", 2019, 8.2);
//
//        students[count++] = student1;
//        students[count++] = student2;
//        students[count++] = student3;

    }
    InputStudent inputStudent = new InputStudent();
    public void showStudentList() {
        if (studentArray.size() == 0) {
            System.out.println("There are no students in the list.");
            System.out.println("Please add student in list!!");
            return;
        }
        System.out.println("List of student:");
        for(Student student : studentArray){
            if(student != null){
                System.out.println(student);
                System.out.println("-------------------------------------------------");
            }
        }
    }

    public void CreatStudent(){
        System.out.println("Enter new student's information: ");
        String name = inputStudent.inputName();
        Date dob = inputStudent.inputDob();
        String address = inputStudent.inputAddress();
        Double height = inputStudent.inputHeight();
        Double weight = inputStudent.inputWeight();
        String studentCode = inputStudent.inputStudentCode();
        String schoolName = inputStudent.inputSchoolName();
        Integer startYear = inputStudent.inputStartYear();
        Double gpa = inputStudent.inputGPA();

        Student st = new Student(name,dob,address,height,weight,studentCode,schoolName,startYear,gpa);
        System.out.println(st);
        /*for (int i = 0; i < students.length; i++) {
            if (students[i] == null) {
                students[i] = st;
                count++;
                break;
            }
        }*/
        studentArray.add(st);
        //System.out.println("Count: " + count);
    }
    public int searchById(int id){
        for(int i = 0; i < studentArray.size(); i++){
            if(studentArray.get(i) != null && studentArray.get(i).getId() == id) {
                return i;
            }
        }
        return -1;
    }
    public void readStudent(){
        System.out.println("Enter student ID: ");
        int id = this.scanner.nextInt();
        scanner.nextLine();
        int student = searchById(id);
        if(student == -1) {
            System.out.println("No matching data found.");
        }else {
            System.out.println(studentArray.get(student));
        }
    }
    public void updateStudent() {
        System.out.println("---- Update student by Id ----");

        while (true){
            System.out.println("Enter student ID to update: ");
            int id = this.scanner.nextInt();
            scanner.nextLine();
            int st = this.searchById(id);
            if(st == -1){
                System.out.println("Student not found!!");
            }
            else {
                System.out.println("Enter new student's information:");

                try {
                    System.out.println(String.format("%20s", " ").replaceAll(" ", "-"));
                    System.out.println("1. Name");
                    System.out.println("2. Date Of Birth");
                    System.out.println("3. Address");
                    System.out.println("4. Height");
                    System.out.println("5. Weight");
                    System.out.println("6. Student Code");
                    System.out.println("7. School");
                    System.out.println("8. Start Year");
                    System.out.println("9. GPA");
                    System.out.println("Enter Your Choice: ");
                    int choice = this.scanner.nextInt();

                    if (choice == 1) {
                        String name = inputStudent.inputName();
                        studentArray.get(st).setName(name);
                    } else if (choice == 2) {
                        Date dob = inputStudent.inputDob();
                        studentArray.get(st).setDateOfBirth(dob);
                    } else if (choice == 3) {
                        String address = inputStudent.inputAddress();
                        studentArray.get(st).setAddress(address);
                    } else if (choice == 4) {
                        Double height = inputStudent.inputHeight();
                        studentArray.get(st).setHeight(height);
                    } else if (choice == 5) {
                        Double weight = inputStudent.inputWeight();
                        studentArray.get(st).setWeight(weight);
                    } else if (choice == 6) {
                        String studentCode = inputStudent.inputStudentCode();
                        studentArray.get(st).setStudentCode(studentCode);
                    } else if (choice == 7) {
                        String schoolName = inputStudent.inputSchoolName();
                        studentArray.get(st).setSchool(schoolName);
                    } else if (choice == 8) {
                        Integer startYear = inputStudent.inputStartYear();
                        studentArray.get(st).setYear(startYear);
                    } else if (choice == 9) {
                        Double gpa = inputStudent.inputGPA();
                        studentArray.get(st).setGPA(gpa);
                    }
                    System.out.println("Student information after updating: " + studentArray.get(st));
                    return;
                }
                catch (IllegalArgumentException e){
                    System.out.println("Invalid input data");
                }
            }
        }
    }

    public void deleteStudent() {
        System.out.println("----- Delete student by ID -----");
        while (true) {
            System.out.println("Enter student ID to delete: ");
            int id = scanner.nextInt();
            scanner.nextLine();
            int index = -1;
            for (int i = 0; i < studentArray.size(); i++) {
                if (studentArray.get(i) != null && studentArray.get(i).getId() == id) {
                    index = i;
                    break;
                }
            }
            if (index == -1) {
                System.out.println("Student not found!!");
            } else {
                System.out.println("Deleted student: " + studentArray.get(index));
                studentArray.remove(index);

                // Move elements after the deleted student
                for (int i = index; i < studentArray.size() - 1; i++) {
                    Student currentStudent = studentArray.get(i);
                    studentArray.set(i, studentArray.get(i + 1));
                    studentArray.set(i + 1, currentStudent);
                }
            }
            return;
        }
    }
    public void showRankPercents() {
        //ArrayList<Student> studentArray = new ArrayList<>(Arrays.asList(students).subList(0, count));
        //ArrayList<Student> studentArray = convertToArraylist(students);
        System.out.println("----- Show student's academic percentage -----");
        if (studentArray.isEmpty()) {
            System.out.println("List student is empty. Add new students!!");
        } else {
            int countPoor = 0;
            int countWeak = 0;
            int countAverage = 0;
            int countGood = 0;
            int countVeryGood = 0;
            int countExcellent = 0;

            Iterator<Student> iterator = studentArray.iterator();
            while (iterator.hasNext()) {
                Student student = iterator.next();
                if (student != null) {
                    Rank rank = student.getRank();
                    if (rank != null) {
                        switch (rank) {
                            case POOR:
                                ++countPoor;
                                break;
                            case WEAK:
                                ++countWeak;
                                break;
                            case AVERAGE:
                                ++countAverage;
                                break;
                            case GOOD:
                                ++countGood;
                                break;
                            case VERY_GOOD:
                                ++countVeryGood;
                                break;
                            default:
                                ++countExcellent;
                                break;
                        }
                    }
                }
            }
            int numStudents = studentArray.size();
            System.out.println("Number student : " + numStudents);

            ArrayList<String> rankPercents = new ArrayList<>();
            if (countPoor != 0) {
                double percent = (double) countPoor / (double) numStudents * 100.0;
                rankPercents.add(String.format("%.2f", percent) + "% POOR");
            }
            if (countWeak != 0) {
                double percent = (double) countWeak / (double) numStudents * 100.0;
                rankPercents.add(String.format("%.2f", percent) + "% WEAK");
            }
            if (countAverage != 0) {
                double percent = (double) countAverage / (double) numStudents * 100.0;
                rankPercents.add(String.format("%.2f", percent) + "% AVERAGE");
            }
            if (countGood != 0) {
                double percent = (double) countGood / (double) numStudents * 100.0;
                rankPercents.add(String.format("%.2f", percent) + "% GOOD");
            }
            if (countVeryGood != 0) {
                double percent = (double) countVeryGood / (double) numStudents * 100.0;
                rankPercents.add(String.format("%.2f", percent) + "% VERY GOOD");
            }
            if (countExcellent != 0) {
                double percent = (double) countExcellent / (double) numStudents * 100.0;
                rankPercents.add(String.format("%.2f", percent) + "% EXCELLENT");
            }

            System.out.println("----- Show student's academic percentage by rank -----");
            int n = rankPercents.size();
            for (int i = 0; i < n - 1; ++i) {
                for (int j = 0; j < n - i - 1; ++j) {
                    String s1 = rankPercents.get(j);
                    String s2 = rankPercents.get(j + 1);
                    double percent1 = Double.parseDouble(s1.substring(0, s1.indexOf("%")));
                    double percent2 = Double.parseDouble(s2.substring(0, s2.indexOf("%")));
                    if (percent1 < percent2) {
                        String temp = rankPercents.get(j);
                        rankPercents.set(j, rankPercents.get(j + 1));
                        rankPercents.set(j + 1, temp);
                    }
                }
            }
            for (String rankPercent : rankPercents) {
                System.out.println(rankPercent);
            }
        }
    }
    public void showAverageScorePercentage(){

       // studentArray.addAll(Arrays.asList(students).subList(0,count));
        //ArrayList<Student> studentArray = convertToArraylist(students);
        System.out.println("------Show the average score percentage of the students in the list------");
        if(studentArray.isEmpty()){
            System.out.println("List student is empty. Add new students!!");
        }
        else{
            Map<Double,Integer> scoreCount = new HashMap<>();
            for (Student student : studentArray){
                double averageScore = student.getGPA();
                scoreCount.put(averageScore,scoreCount.getOrDefault(averageScore,0) + 1);
            }
            for (Map.Entry<Double,Integer> entry : scoreCount.entrySet()){
                double score = entry.getKey();
                int count = entry.getValue();
                double percent = (double) count / (double) studentArray.size() * 100.0;
                System.out.println(score + ": " +  String.format("%2f",percent) + "%");
            }
        }
    }
    public void showStudentsByGrade(){
        //studentArray.addAll(Arrays.asList(students).subList(0,count));
        //ArrayList<Student> studentArray = convertToArraylist(students);
        System.out.println("----- Show the list of students according to their academic ----- ");
        if(studentArray.isEmpty()){
            System.out.println("List student is empty. Add new student!!");
        }else{
            System.out.println("Enter student's academic: ");
            String academic = this.scanner.next();
            boolean found = false;
            for(Student student : studentArray){
                if(academic.equalsIgnoreCase(student.getRank().toString())){
                    System.out.println(student);
                    found = true;
                }
            }
            if(!found){
                System.out.println("No student with academic: " + academic);
            }
        }
    }
    public void writeToFile(String path) throws IOException {
        //studentArray.addAll(Arrays.asList(students).subList(0,count));
        //ArrayList<Student> studentArray = convertToArraylist(students);
        FileWriter fw = new FileWriter(path);
        BufferedWriter bw = new BufferedWriter(fw);
        for(Student student : studentArray){
            bw.write(student.toString());
            bw.write("\n");
        }
        bw.flush();
    }
    public static ArrayList<Student> convertToArraylist(Student[] students) {
        ArrayList<Student> studentArray = new ArrayList<>();
        for (Student student : students) {
            if(student != null){
                studentArray.add(student);
            }
        }
        return studentArray;
    }

}

