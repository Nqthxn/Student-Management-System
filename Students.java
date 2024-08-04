public class Students {
    private String id;
    private String name;
    private int age;
    private char gender;
    private String course = "None";
    private String grade = "None";

    public Students(String studentID, String studentName, int studentAge, char studentGender){
        this.id = studentID;
        this.name = studentName;
        this.age = studentAge;
        this.gender = studentGender;
    }

    public String getId(){
        return id;
    }


    public String toString(){
        return "Student ID : " + id + "\nName : " + name + "\nAge : " + age + "\nGender : " + gender + "\nEnrolled Courses : " + course + "\nGrades : " + grade;
    }
}
