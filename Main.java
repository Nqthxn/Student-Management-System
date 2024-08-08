import java.util.Scanner;
import java.util.ArrayList;
import java.util.Iterator;

public class Main{
    private static Scanner input = new Scanner(System.in);
    private static ArrayList<Students> newStudent = new ArrayList<>();
    public static void main(String[] args){
        startSystem();
    }
    public static void startSystem(){
        System.out.println("========== [ STUDENT MANAGEMENT SYSTEM ] ==========");
        String[] options = {"Add a new student", "View student details", "Update student information",
                            "Delete a student", "Add a new course", "Exit"};
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
            case 4:
                checkID(4);
                break;
            case 5:
                checkID(5);
                break;
            case 6:
                checkID(6);
                break;
            default:
                System.out.println("Invalid Choice. Please Try Again.\n");
                startSystem();
                break;
        }
    }
    public static void addStudent(){
        System.out.println("---------- New Student ----------");
        System.out.print("Enter Student ID : ");
        String id = input.nextLine();
        
        System.out.print("Enter Student Name : ");
        String name = input.nextLine();
        name = name.toUpperCase();

        System.out.print("Enter Student Age : ");
        int age = input.nextInt();
        input.nextLine();

        System.out.print("Enter Student Gender (M / F) : ");
        char gender = input.next().charAt(0);
        gender = Character.toUpperCase(gender);
        input.nextLine();

        newStudent.add(new Students(id, name, age, gender));
        System.out.println("Student added successfully!\n");

        continuePrompt(input);
    }
    public static void studentDetails(Students student){
        System.out.println("---------- Student Details ----------");
        System.out.println(student);
        System.out.println();
        continuePrompt(input);
        
    }
    public static void updateInfo(Students student){
        System.out.println("---------- Update Student Information ----------\n");

        System.out.println("Name : " + student.getName());
        System.out.println("Age : " + student.getAge());
        System.out.println("Gender : " + student.getGender());
        System.out.println("Course : " + student.getCourse());
        System.out.println("Grade : " + student.getGrade());
        System.out.println();

        System.out.print("Enter new name (or press Enter to keep unchanged) : ");
        String newName = input.nextLine();
        newName = newName.toUpperCase();


        System.out.print("Enter new age (or press Enter to keep unchanged) : ");
        int newAge = input.nextInt();
        input.nextLine();


        System.out.print("Enter new Gender (M / F) (or press Enter to keep unchanged) : ");
        char newGender = input.next().charAt(0);
        newGender = Character.toUpperCase(newGender);
        input.nextLine();

        if(!newName.trim().isEmpty() && newAge > 0 && (newGender == 'M' || newGender == 'F')){
            student.updateInfo(newName, newAge, newGender);
            System.out.println("Student information updated successfully!\n");
            continuePrompt(input);
        }else{
            System.out.println("Error. Something went wrong. Please Try Again.");
            startSystem();
        }
    }
    public static void checkID(int option){

        if(newStudent.isEmpty()){
            System.out.println("No students found in the system. Please add a student to continue.\n");
            startSystem();
            return;
        }

        System.out.print("Enter Student ID : ");
        String id = input.nextLine();
        System.out.println();
    
        boolean studentFound = false;

        for(Students student : newStudent){
            if(student.getId().equals(id)){
                studentFound = true;
                switch(option){
                    case 1:
                        addStudent();
                        break;
                    case 2:
                        studentDetails(student);
                        break;
                    case 3:
                        updateInfo(student);
                        break;
                    case 4:
                        deleteStudent(id);
                        break;
                    case 5:
                        addCourse(student);
                        break;
                    default:
                        System.out.println("Invalid Student ID. Please Try Again.\n");
                        startSystem();

                }
            }
        }
        if(!studentFound){
            System.out.println("Invalid Student ID. Please Try Again.\n");
            startSystem();
        }
    }
    public static void continuePrompt(Scanner input){
        System.out.print("Press Enter To Continue...  ");
        input.nextLine();
        System.out.println();
        startSystem();
    }
    public static void deleteStudent(String id){
        Iterator<Students> iterator = newStudent.iterator();
        boolean studentRemoved = false;

        while(iterator.hasNext()){
            Students student = iterator.next();
            if(student.getId().equals(id)){
                iterator.remove();
                System.out.println("Student ID " + id + " has been successfully deleted.\n");
                studentRemoved = true;
                break;
            }
        }
        if(!studentRemoved){
            System.out.println("Student with ID " + id + " not found.");
        }
        continuePrompt(input);
    }
    public static void addCourse(Students student){
        System.out.println("---------- Add New Course ----------");
        System.out.print("Enter Course ID : ");
        String courseId = input.nextLine();
        
        System.out.print("Enter Course Name : ");
        String courseName = input.nextLine();

        System.out.print("Enter Instructor's Name : ");
        String name = input.nextLine();

        student.addCourse(courseId, courseName, name);
        System.out.println("Course added successfully!\n");
        continuePrompt(input);
    }

}