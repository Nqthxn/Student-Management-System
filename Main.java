import java.util.Scanner;
import java.util.ArrayList;

public class Main{
    private static Scanner input = new Scanner(System.in);

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
    }
}