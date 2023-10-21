package ManagerStudent.main;

import ManagerStudent.manager.ManagerStudent;

import java.io.IOException;
import java.util.Scanner;

import static ManagerStudent.constant.Constant.*;

public class Main {

    public Main(){
    }
    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);
        ManagerStudent manager = new ManagerStudent();

        while (true){
            System.out.println("------------- Manager Student Menu -------------");
            System.out.println("0. Show student list.");
            System.out.println("1. Creat student.");
            System.out.println("2. Find student by ID.");
            System.out.println("3. Update student by ID.");
            System.out.println("4. Delete student by ID.");
            System.out.println("5. Show percentage of academic rank of the students by descending order.");
            System.out.println("6. Show percentage of average score of the students.");
            System.out.println("7. Show student list by input academic rank.");
            System.out.println("8. Exit.");

            System.out.println("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine();
            if(choice == END_PROGRAM){
                manager.writeToFile("data.txt");
                System.out.println("End program.");
                return;
            }
            switch (choice){
                case SHOW_STUDENT_LIST:
                    manager.showStudentList();
                    break;
                case CREATE_STUDENT:
                    manager.CreatStudent();
                    break;
                case READ_STUDENT:
                    manager.readStudent();
                    break;
                case UPDATE_STUDENT:
                    manager.updateStudent();
                    break;
                case DELETE_STUDENT:
                    manager.deleteStudent();
                    break;
                case SHOW_RANK_PERCENTS:
                    manager.showRankPercents();
                    break;
                case SHOW_AVERAGE_SCORE_PERCENTAGE:
                    manager.showAverageScorePercentage();
                    break;
                case SHOW_STUDENTS_BY_GRADE:
                    manager.showStudentsByGrade();
                    break;
            }
        }
    }
}
