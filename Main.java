import java.util.Scanner;
import java.util.ArrayList;

public class Main{
    private static Scanner input = new Scanner(System.in);
    private static ArrayList<Students> newStudent = new ArrayList<>();
    public static void main(String[] args){
        startSystem();
    }
    public static void startSystem(){
        System.out.println("========== [ STUDENT MANAGEMENT SYSTEM ] ==========");
        String[] options = {"Add a new student", "View student details", "Update student information",
                            "Delete a student", "Add a new course", "Enroll a student in a course", 
                            "View course details", "Assign grades", "Generate reports", "Exit"};
        for(int i = 0; i < options.length; i++){
            System.out.println((i + 1) + ". " + options[i]);
        }
        System.out.println("===================================================\n");
        System.out.print("Enter your choice : ");
        int choice = input.nextInt();
        input.nextLine();
        System.out.println();

        switch(choice){
            case 1:
                addStudent();
                break;
            case 2:
                checkID(2);
                break;
            case 3:
                checkID(3);;
                break;
        }
    }
    public static void addStudent(){
        System.out.println("---------- New Student ----------");
        System.out.print("Enter Student ID : ");
        String id = input.nextLine();
        
        System.out.print("Enter Student Name : ");
        String name = input.nextLine();

        System.out.print("Enter Student Age : ");
        int age = input.nextInt();
        input.nextLine();

        System.out.print("Enter Student Gender (M / F) : ");
        char gender = input.next().charAt(0);
        input.nextLine();

        newStudent.add(new Students(id, name, age, gender));
        System.out.println("Student added successfully!\n");

        System.out.print("Press Enter To Continue...  ");
        
        input.nextLine();
        System.out.println();
        startSystem();

    }
    public static void studentDetails(Students student){
        System.out.println("---------- Student Details ----------");
        System.out.println(student);
    }
    public static void updateInfo(){
        System.out.println("---------- Update Student Information ----------\n");
    }
    public static void checkID(int option){

        if(newStudent.isEmpty()){
            System.out.println("No students found in the system. Please add a student to continue");
            return;
        }

        System.out.print("Enter Student ID : ");
        String id = input.nextLine();
        System.out.println();

        for(Students student : newStudent){
            if(student.getId().equals(id)){
                switch(option){
                    case 1:
                        addStudent();
                        break;
                    case 2:
                        studentDetails(student);
                        break;
                    case 3:
                        updateInfo();
                        break;
                }
            }else{
                System.out.println("Invalid Student ID. Please Try Again.\n");
                startSystem();
            }
        }
    }
}