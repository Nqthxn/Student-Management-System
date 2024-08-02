public class Student {
    private String id;
    private String name;
    private int age;
    private char gender;
    private String course = "None";
    private String grade = "None";

    public Student(String studentID, String studentName, int studentAge, char studentGender){
        this.id = studentID;
        this.name = studentName;
        this.age = studentAge;
        this.gender = studentGender;
    }
}
